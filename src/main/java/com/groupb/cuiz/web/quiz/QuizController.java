package com.groupb.cuiz.web.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addQuiz(QuizDTO quizDTO, TestcaseDTO[] testcaseDTOS, Model model) throws Exception {
        int result = quizService.addQuiz(quizDTO, testcaseDTOS);
        if(result != 2){
            model.addAttribute("msg", "문제 등록 실패");
            model.addAttribute("path", "./add");
        } else {
            model.addAttribute("msg", "문제 등록 성공");
            model.addAttribute("path", "./list");
        }
        return "commons/result";
    }

}

