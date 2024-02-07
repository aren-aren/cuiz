package com.groupb.cuiz.web.quiz;

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
    public String addQuiz(QuizDTO quizDTO, String[] example_inputs, String[] example_outputs, String[] inputs, String[] outputs, Model model) throws Exception {
        int result = quizService.addQuiz(quizDTO, example_inputs, example_outputs, inputs, outputs);

        if(result%10 == 0){
            model.addAttribute("msg", "문제 등록 실패");
            model.addAttribute("path", "./add");
        } else if (result/10 != (example_inputs.length + inputs.length)){
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

        MemberAnswerDTO answerDTO = new MemberAnswerDTO();
        List<String> inputList = new ArrayList<>(List.of(example_inputs));
        inputList.addAll(List.of(quiz_inputs));

        answerDTO.setExampleInputs(inputList);
        answerDTO.setMember_Source_Code(quiz_SampleCode);
        answerDTO.setMember_Id(memberDTO.getMember_ID());

        answerDTO = quizService.getSampleOutput(answerDTO);

        String[] outputs = new String[example_inputs.length + quiz_inputs.length];

        for (int i = 0; i < outputs.length; i++) {
            outputs[i] = answerDTO.getTestCaseResultDTOS().get(i).getResultMessage();
        }

        return String.join("###",outputs);
    }
}

