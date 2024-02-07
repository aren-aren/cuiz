package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/quiz/*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("add")
    public String addQuiz(){
        return "quiz/add";
    }

    @PostMapping("add")
    public String addQuiz(QuizDTO quizDTO, String[] example_inputs, String[] example_outputs, String[] quiz_inputs, String[] quiz_outputs, HttpSession session, Model model) throws Exception {
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
        quizDTO.setMember_Id(memberDTO.getMember_ID());

        System.out.println(Arrays.toString(example_inputs));
        System.out.println(Arrays.toString(quiz_outputs));

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


    @PostMapping("sampleRun")
    @ResponseBody
    public String sampleRun(String quiz_SampleCode, String[] example_inputs, String[] quiz_inputs, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

        System.out.println(quiz_SampleCode);
        System.out.println(Arrays.toString(example_inputs));
        System.out.println(Arrays.toString(quiz_inputs));

        MemberAnswerDTO answerDTO = new MemberAnswerDTO();
        answerDTO.setMember_Source_Code(quiz_SampleCode);
        answerDTO.setMember_Id(memberDTO.getMember_ID());

        answerDTO.setExampleInputs(List.of(example_inputs));
        answerDTO = quizService.getSampleOutput(answerDTO);
        String[] exOutputs = new String[example_inputs.length];
        for (int i = 0; i < example_inputs.length; i++) {
            exOutputs[i] = answerDTO.getTestCaseResultDTOS().get(i).getResultMessage();
        }

        answerDTO.setExampleInputs(List.of(quiz_inputs));
        answerDTO = quizService.getSampleOutput(answerDTO);
        String[] qOutputs = new String[quiz_inputs.length];
        for (int i = 0; i < quiz_inputs.length; i++) {
            qOutputs[i] = answerDTO.getTestCaseResultDTOS().get(i).getResultMessage();
        }

        return String.join(",",exOutputs) + "###" + String.join(",",qOutputs);
    }

    @GetMapping("list")
    public String getList(Pager pager, Model model){
        List<QuizDTO> quizList = quizService.getList(pager);
        model.addAttribute("list", quizList);

        return "quiz/list";
    }
}

