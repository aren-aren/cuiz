package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.support.util.file.FileManager;
import com.groupb.cuiz.support.util.pager.Pager;
import org.apache.commons.exec.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private FileManager fileManager;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private QuizDAO quizDAO;

    public int addQuiz(QuizDTO quizDTO, String[] example_inputs, String[] example_output, String[] quiz_inputs, String[] quiz_outputs) throws Exception {
        int result = 0;

        quizDTO.setQuiz_Point(0);
        quizDTO.setQuiz_Price(0);

        result += quizDAO.addQuiz(quizDTO);

        List<TestcaseDTO> testcaseDTOS = new ArrayList<>();
        for (int i = 0; i < example_inputs.length; i++) {
            TestcaseDTO testcaseDTO = new TestcaseDTO();
            testcaseDTO.setQuiz_No(quizDTO.getQuiz_No());
            testcaseDTO.setTestcase_Input(example_inputs[i]);
            testcaseDTO.setTestcase_Output(example_output[i]);
            testcaseDTO.setTestcase_Type("EXAMPLE");
            testcaseDTOS.add(testcaseDTO);
        }

        for (int i = 0; i < quiz_inputs.length; i++) {
            TestcaseDTO testcaseDTO = new TestcaseDTO();
            testcaseDTO.setQuiz_No(quizDTO.getQuiz_No());
            testcaseDTO.setTestcase_Input(quiz_inputs[i]);
            testcaseDTO.setTestcase_Output(quiz_outputs[i]);
            testcaseDTO.setTestcase_Type("QUIZ");
            testcaseDTOS.add(testcaseDTO);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("testcase", testcaseDTOS);

        result += quizDAO.addTestcase(map)*10;

        return result;
    }

    public List<String> getSampleOutput(MemberAnswerDTO quizSampleDTO) throws Exception {
        //문제 예제, 실제 input을 돌려보고 output을 얻는데 사용
        System.out.println("getSampleOutput start");
        List<String> inputs = quizSampleDTO.getExampleInputs();
        String sourceCode = quizSampleDTO.getMember_Source_Code();

        String realPath = servletContext.getRealPath("/resources/sourcecode/" +  quizSampleDTO.getMember_Id());
        String filename = "Main";
        String extension = ".java";

        fileManager.fileSaveByString(realPath, filename, sourceCode, extension);

        //컴파일
        if(!compileJava(realPath + "/" + filename + extension)){
            System.out.println("컴파일 에러");
            return List.of(new String[]{"컴파일 에러"});
        }

        TestcaseResultDTO resultDTO = new TestcaseResultDTO();
        for (int i = 0; i < inputs.size(); i++) {
            try {
                resultDTO = runSampleCode(realPath, filename, inputs.get(i));
            } catch (IOException e) {
                resultDTO = new TestcaseResultDTO();
                resultDTO.setResult(false);
                resultDTO.setResultMessage("런타임 에러");
            } finally {
                resultDTO.setTestcaseNum(i+1);
                if(quizSampleDTO.getTestCaseResultDTOS() == null){
                    quizSampleDTO.setTestCaseResultDTOS(new ArrayList<>());
                }
                quizSampleDTO.getTestCaseResultDTOS().add(resultDTO);
            }
        }
        System.out.println("getSampleOutput end");
        return quizSampleDTO.getTestCaseResultDTOS().stream()
                .map(TestcaseResultDTO::getResultMessage)
                .collect(Collectors.toList());
    }

    public TestcaseResultDTO runSampleCode(String realPath, String filename, String input) throws IOException {
        //getSampleOutput에서 input을 미리 돌려보고 output을 얻음
        TestcaseResultDTO testcaseResultDTO = new TestcaseResultDTO();
        String command = String.format("java -Dfile.encoding=UTF8 -cp %s %s", realPath, filename);
        String result = sendCommandToScript(command, input);

        testcaseResultDTO.setResultMessage(result);

        return testcaseResultDTO;
    }

    public MemberAnswerDTO checkAnswer(MemberAnswerDTO answer) throws Exception {
        //controller에서 호출된다 정답 제출때 사용

        //코드를 파일로 저장
        String realPath = servletContext.getRealPath(String.format("/resources/sourcecode/%s", answer.getMember_Id()));
        String filename = "Main";
        String extension = ".java";

        fileManager.fileSaveByString(realPath, filename, answer.getMember_Source_Code(), extension);

        //컴파일
        if(!compileJava(realPath + "\\" + filename + extension)){
            answer.setAnswerResult(false);
            answer.setResultMessage("컴파일 에러");
            return answer;
        }
        //DB에서 테스트 케이스를 가져옴
        String[] inputs = null;
        String[] outputs = null;

        TestcaseResultDTO resultDTO = new TestcaseResultDTO();
        for (int i = 0; i < inputs.length; i++) {
            try {
                resultDTO = runCode(realPath, filename, inputs[i], outputs[i]);
            } catch (IOException e) {
                resultDTO = new TestcaseResultDTO();
                resultDTO.setResult(false);
                resultDTO.setResultMessage("런타임 에러");
            } finally {
                resultDTO.setTestcaseNum(i+1);
                answer.getTestCaseResultDTOS().add(resultDTO);
            }
        }
        return answer;
    }

    /**
     * 자바 UTF-8 컴파일 명령어 생성 후
     * 생성된 컴파일 명령어로 컴파일 하고 결과를 리턴한다.
     * @param path
     * @return
     */
    public boolean compileJava(String path) {
        //자바파일을 컴파일
        String command = "javac -encoding UTF-8 " + path;
        try {
            sendCommandToScript(command, null);
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     *
     * @param path
     * @param filename
     * @param input
     * @param output
     * @return
     * @throws IOException
     */
    public TestcaseResultDTO runCode(String path, String filename, String input, String output) throws IOException {
        //코드를 실행해 테스트 케이스를 채점
        TestcaseResultDTO testcaseResultDTO = new TestcaseResultDTO();
        String command = String.format("java -Dfile.encoding=UTF8 -cp %s %s", path, filename);
        String result = sendCommandToScript(command, input);

        if(result.equals("timeout")){
            testcaseResultDTO.setResult(false);
            testcaseResultDTO.setResultMessage("시간초과");
        } else if(result.equals(output)){
            testcaseResultDTO.setResult(true);
            testcaseResultDTO.setResultMessage("정답입니다.");
        } else {
            testcaseResultDTO.setResult(false);
            testcaseResultDTO.setResultMessage("오답입니다.");
        }

        return testcaseResultDTO;
    }

    public String sendCommandToScript(String command, String input) throws IOException {
        //스크립트에 command를 보내고 출력값을 받아온다
        System.out.println("스크립트 실행 : command = " + command);
        //출력을 받을 outputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //command를 파싱
        CommandLine commandLine = CommandLine.parse(command);

        //Script와 연결해줄 객체
        DefaultExecutor executor = DefaultExecutor.builder().get();

        //input이 있으면 입력함
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if(input != null) {
            OutputStreamWriter ow = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(ow);

            bw.write(input);
            bw.flush();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(os.toByteArray());

        //연결후 데이터를 주고 받는 handler
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, OutputStream.nullOutputStream(), ins);

        //시간 제한
        ExecuteWatchdog watchdog = ExecuteWatchdog.builder().setTimeout(Duration.ofSeconds(10)).get();

        executor.setExitValues(new int[]{0,1});
        executor.setStreamHandler(streamHandler);
        executor.setWatchdog(watchdog);

        Integer exitVal = null;
        //command 보내기
        try{
            exitVal = executor.execute(commandLine);
        } catch (ExecuteException e){
            os.close();
            System.out.println("e.getMessage() = " + e.getMessage());
            if(watchdog.killedProcess()){
                return "timeout";
            }
            throw e;
        }
        os.close();

        System.out.println("result = " + outputStream.toString("UTF-8"));
        System.out.println("스크립트 종료--------------" + exitVal);
        return outputStream.toString("UTF-8");
    }


    public List<QuizDTO> getList(Pager pager) {
        Long totalCount = quizDAO.getTotalCount(pager);
        System.out.println("totalCount = " + totalCount);

        pager.makeRow();
        pager.makeNum(totalCount);


        return quizDAO.getList(pager);
    }

    public QuizDTO getDetail(QuizDTO quizDTO) {
        return quizDAO.getDetail(quizDTO);
    }
}
