package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.MyTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

public class QuizServiceTest extends MyTest {

    @Autowired
    private QuizService quizService;

    @Test
    public void addQuiz() throws Exception {
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setQuiz_Title("test title");
        quizDTO.setQuiz_Contents("test contents");
        quizDTO.setQuiz_Level(1);
        quizDTO.setMember_Id("helloworld");

        String[] strs = {"1","2","3","4"};
        quizDTO.setQuiz_Inputs(strs);
        quizDTO.setQuiz_Outputs(strs);
        quizDTO.setQuiz_Example_Inputs(strs);
        quizDTO.setQuiz_Example_Outputs(strs);

        int result = quizService.addQuiz(quizDTO);

        assertEquals(2, result);
    }
}