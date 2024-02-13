package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.support.util.build.QuizSourceExecutor;
import com.groupb.cuiz.support.util.file.FileManager;
import com.groupb.cuiz.support.util.pager.Pager;
import org.apache.commons.exec.ExecuteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.*;

@Service
public class QuizService {
    @Autowired
    private FileManager fileManager;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private QuizDAO quizDAO;

    /**
     * DB의 QUIZ 테이블에 Quiz 정보를 넣고, 예제 input과 output, 실제 input과 output TESTCASE 테이블에 넣는다
     *
     * @param quizDTO
     * @param example_inputs
     * @param example_output
     * @param quiz_inputs
     * @param quiz_outputs
     * @return
     * @throws Exception
     */
    public int addQuiz(QuizDTO quizDTO, String[] example_inputs, String[] example_output, String[] quiz_inputs, String[] quiz_outputs) throws Exception {
        int result = 0;

        quizDTO.setQuiz_Point(0);
        quizDTO.setQuiz_Price(0);

        result += quizDAO.addQuiz(quizDTO);

        List<TestcaseDTO> testcaseDTOS = new ArrayList<>();
        addTestCasesToList(quizDTO, example_inputs, example_output, testcaseDTOS, "EXAMPLE"); //EXAMPLE Type의 TestcaseDTO를 List에 넣어줌
        addTestCasesToList(quizDTO, quiz_inputs, quiz_outputs, testcaseDTOS, "QUIZ"); //QUIZ Type의 TestcaseDTO를 List에 넣어줌

        Map<String, Object> map = new HashMap<>();
        map.put("testcase", testcaseDTOS);

        result += quizDAO.addTestcase(map) * 10;

        return result;
    }

    /**
     * inputs와 outputs에서 TestcaseDTO를 만들어 testcaseDTOs에 add 한다
     *
     * @param quizDTO
     * @param inputs
     * @param outputs
     * @param testcaseDTOS
     * @param testCaseType
     */
    private void addTestCasesToList(QuizDTO quizDTO, String[] inputs, String[] outputs, List<TestcaseDTO> testcaseDTOS, String testCaseType) {
        for (int i = 0; i < inputs.length; i++) {
            TestcaseDTO testcaseDTO = new TestcaseDTO();
            testcaseDTO.setQuiz_No(quizDTO.getQuiz_No());
            testcaseDTO.setTestcase_Input(inputs[i]);
            testcaseDTO.setTestcase_Output(outputs[i]);
            testcaseDTO.setTestcase_Type(testCaseType);
            testcaseDTOS.add(testcaseDTO);
        }
    }

    /**
     * 실행해보는 기능. quiz_No에 해당하는 테스트케이스들을 가져와서 정답을 맞춰본다.
     *
     * @param answerDTO
     * @return
     * @throws Exception
     */
    public MemberAnswerDTO runExampleQuiz(MemberAnswerDTO answerDTO) throws Exception {
        System.out.println("answerDTO = " + answerDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("dto", answerDTO);
        map.put("type", "EXAMPLE");

        List<TestcaseDTO> testcaseDTOS = quizDAO.getTestCases(map);

        return checkAnswer(answerDTO, testcaseDTOS);
    }

    /**
     * memberId를 기준으로 path를 만들어 해당 위치에 sourceCode를 java파일로 저장 <br>
     * java파일을 class파일로 컴파일 <br>
     * 컴파일된 파일을 실행 하여 inputs에 대한 outputs을 얻어 리턴한다
     *
     * @param memberId
     * @param sourceCode
     * @param inputs
     * @return
     */
    public List<String> quizSourceBuild(String memberId, String sourceCode, List<String> inputs) throws Exception {
        System.out.println("quizSourceBuild start");

        String realPath = servletContext.getRealPath("/resources/sourcecode/" + memberId);
        String filename = "Main";
        String extension = ".java";

        fileManager.fileSaveByString(realPath, filename, sourceCode, extension);

        //컴파일
        if (!QuizSourceExecutor.compileJava(realPath + "/" + filename + extension)) {
            System.out.println("컴파일 에러");
            return List.of("컴파일 에러");
        }

        List<String> results = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            try {
                results.add(QuizSourceExecutor.runCode(realPath, filename, inputs.get(i)));
            } catch (ExecuteException e) {
                results.add(e.getMessage());
            }
        }

        System.out.println("quizSourceBuild end");
        return results;
    }

    /**
     * input과 코드를 입력받아 컴파일, 실행 후 output을 구해준다
     *
     * @param quizSampleDTO
     * @param inputs
     * @return
     * @throws Exception
     */
    public List<String> getSampleOutput(MemberAnswerDTO quizSampleDTO, List<String> inputs) throws Exception {
        return quizSourceBuild(quizSampleDTO.getMember_Id(), quizSampleDTO.getMember_Source_Code(), inputs);
    }

    /**
     * 유저의 코드를 저장하고, 컴파일, 실행 후 채점하고 결과를 리턴한다
     *
     * @param answer
     * @param testcaseDTOS
     * @return
     * @throws Exception
     */
    public MemberAnswerDTO checkAnswer(MemberAnswerDTO answer, List<TestcaseDTO> testcaseDTOS) throws Exception {
        //DB에서 테스트 케이스를 가져옴
        List<String> inputs = new ArrayList<>();
        List<String> outputs = new ArrayList<>();

        for (TestcaseDTO testcaseDTO : testcaseDTOS) {
            inputs.add(testcaseDTO.getTestcase_Input());
            outputs.add(testcaseDTO.getTestcase_Output());
        }

        //코드 실행후 outputs를 얻어옴
        List<String> results = quizSourceBuild(answer.getMember_Id(), answer.getMember_Source_Code(), inputs);
        //코드 실행 결과와 정답을 비교하여 채점
        List<TestcaseResult> testcaseResults = getTestcaseResultDTOS(results, outputs);

        answer.setTestCaseResultDTOS(testcaseResults);

        return answer;
    }

    /**
     * result와 output을 비교하여 정답여부를 testcaseDTO에 저장후
     * DTO로 List를 만든후 List를 리턴
     * @param results
     * @param outputs
     * @return
     */
    private static List<TestcaseResult> getTestcaseResultDTOS(List<String> results, List<String> outputs) {
        List<TestcaseResult> testcaseResults = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            TestcaseResult testcaseResult = new TestcaseResult();
            if (results.get(i).equals("timeout")) {
                testcaseResult.setResult(false);
                testcaseResult.setResultMessage("시간초과");
            } else if (results.get(i).trim().equals(outputs.get(i).trim())) {
                testcaseResult.setResult(true);
                testcaseResult.setResultMessage("정답입니다.");
            } else {
                testcaseResult.setResult(false);
                testcaseResult.setResultMessage("오답입니다.");
            }
            testcaseResults.add(testcaseResult);
        }
        return testcaseResults;
    }

    /**
     * 페이지 정보(페이지, 검색어)를 받아와 해당 페이지의 문제들을 출력한다.
     *
     * @param pager
     * @return
     */
    public List<QuizDTO> getList(Pager pager) {
        Long totalCount = quizDAO.getTotalCount(pager);
        System.out.println("totalCount = " + totalCount);

        pager.makeRow();
        pager.makeNum(totalCount);


        return quizDAO.getList(pager);
    }

    /**
     * quiz_No로 해당 quiz정보를 받아온다
     *
     * @param quizDTO
     * @return
     */
    public QuizDTO getDetail(QuizDTO quizDTO) {
        return quizDAO.getDetail(quizDTO);
    }
}
