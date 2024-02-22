package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/quiz/*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    private final String DEFAULTSOURCECODE = "public class Main{\n\n" +
            "   public static void main(String[] args){\n" +
            "   /* 입력되는 Input에 대한 답을 출력해주세요 */\n" +
            "       System.out.println(\"hello, world\");\n" +
            "   }\n" +
            "}";

    @GetMapping("add")
    public String addQuiz(){
        return "quiz/add";
    }

    @PostMapping("add")
    public String addQuiz(QuizDTO quizDTO, String[] example_inputs, String[] example_outputs, String[] quiz_inputs, String[] quiz_outputs, HttpSession session, Model model) throws Exception {
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
        quizDTO.setMember_Id(memberDTO.getMember_ID());

        int result = quizService.addQuiz(quizDTO, example_inputs, example_outputs, quiz_inputs, quiz_outputs);

        if(result%10 == 0){
            model.addAttribute("msg", "문제 등록 실패");
            model.addAttribute("path", "./add");
        } else if (result/10 != (example_inputs.length + quiz_inputs.length)){
            model.addAttribute("msg", "일부 테스트케이스 등록 실패");
            model.addAttribute("path", "./list");
        } else{
            model.addAttribute("msg", "문제 등록 성공");
            model.addAttribute("path", "./list");
        }
        return "commons/result";
    }


    @ResponseBody
    @PostMapping("sampleRun")
    public SampleRunResult sampleRun(String quiz_SampleCode, String[] example_inputs, String[] quiz_inputs, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

        MemberAnswerDTO answerDTO = new MemberAnswerDTO();
        answerDTO.setSourcecode(quiz_SampleCode);
        answerDTO.setMember_Id(memberDTO.getMember_ID());

        List<String> exOutputs = quizService.getSampleOutput(answerDTO, List.of(example_inputs));
        List<String> qOutputs = quizService.getSampleOutput(answerDTO, List.of(quiz_inputs));

        return SampleRunResult.createResult(exOutputs,qOutputs);
    }

    @ResponseBody
    @GetMapping("checkRun")
    public List<TestcaseResult> sampleRun(MemberAnswerDTO checkDTO, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        checkDTO.setMember_Id(memberDTO.getMember_ID());

        return quizService.checkRun(checkDTO);
    }

    @GetMapping("list")
    public String getList(Pager pager, Model model, HttpSession session){
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        if(memberDTO != null){
            pager.setMember_Id(memberDTO.getMember_ID());
        }

        List<QuizListDTO> quizList = quizService.getList(pager);
        model.addAttribute("list", quizList);

        return "quiz/list";
    }

    @GetMapping("solve")
    public String solveQuiz(QuizDTO quizDTO, Model model, HttpSession session){
        quizDTO = quizService.getDetail(quizDTO, "EXAMPLE");
        model.addAttribute("dto", quizDTO);

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        MemberAnswerDTO answerDTO = new MemberAnswerDTO();
        answerDTO.setQuiz_No(quizDTO.getQuiz_No());
        answerDTO.setMember_Id(memberDTO.getMember_ID());

        answerDTO = quizService.getAnswer(answerDTO);
        if(answerDTO.getSourcecode() == null){
            answerDTO.setSourcecode(DEFAULTSOURCECODE);
        }

        model.addAttribute("answer", answerDTO);

        return "quiz/solve";
    }

    @ResponseBody
    @PostMapping("run")
    public MemberAnswerDTO runQuiz(@RequestBody MemberAnswerDTO answerDTO, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        answerDTO.setMember_Id(memberDTO.getMember_ID());

        answerDTO = quizService.runExampleQuiz(answerDTO);
        return answerDTO;
    }

    @ResponseBody
    @PostMapping("submit")
    public MemberAnswerDTO submitQuiz(@RequestBody MemberAnswerDTO answerDTO, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        answerDTO.setMember_Id(memberDTO.getMember_ID());

        answerDTO = quizService.submitQuiz(answerDTO, memberDTO);

        session.setAttribute("member", memberDTO);

        return answerDTO;
    }

    @ResponseBody
    @GetMapping("getTestcases")
    public List<TestcaseDTO> getTestcases(QuizDTO quizDTO){
        return quizService.getTestcases(quizDTO);
    }

    @GetMapping("update")
    public String updateQuiz(QuizDTO quizDTO, Model model) throws Exception {
        quizDTO = quizService.getDetail(quizDTO, null);
        model.addAttribute("dto", quizDTO);
        return "quiz/update";
    }

    @PostMapping("update/content")
    @ResponseBody
    public Boolean updateSourcecode(@RequestBody QuizDTO quizDTO){
        return quizService.updateQuiz(quizDTO);
    }

    @PostMapping("update/testcase")
    @ResponseBody
    public  Boolean updateTestcase(@RequestBody List<TestcaseDTO> testcaseDTOS) throws Exception {
        System.out.println("testcaseDTOS = " + testcaseDTOS);
        System.out.println("testcaseDTOS = " + testcaseDTOS);
        System.out.println("testcaseDTOS = " + testcaseDTOS);
        System.out.println("testcaseDTOS = " + testcaseDTOS);
        System.out.println("testcaseDTOS = " + testcaseDTOS);
        System.out.println("testcaseDTOS = " + testcaseDTOS);
        return quizService.updateTestcases(testcaseDTOS);
    }

    @PostMapping("delete/testcase")
    @ResponseBody
    public Boolean deleteTestcase(@RequestBody TestcaseDTO testcaseDTO){
        return quizService.deleteTestcase(testcaseDTO);
    }
}

