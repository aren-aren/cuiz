package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.MyTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuizServiceTest extends MyTest {

    @Autowired
    private QuizService quizService;

    @Test
    public void addQuizTest() throws Exception {
        String[] exinputs = {"1","2","3"};
        String[] inputs = {"123","231","321"};

        String sourceCode = "import java.util.Scanner;public class Main{public static void main(String[] args){Scanner scan = new Scanner(System.in);System.out.println(\"scan.nextInt()\");}}";
        MemberAnswerDTO answerDTO = new MemberAnswerDTO();
        List<String> inputList = new ArrayList<>(List.of(exinputs));
        inputList.addAll(List.of(inputs));

        answerDTO.setExampleInputs(inputList);
        answerDTO.setMember_Source_Code(sourceCode);
        answerDTO.setMember_Id("helloworld");

        answerDTO = quizService.getSampleOutput(answerDTO);

        String[] exOutputs = new String[exinputs.length];
        String[] outputs = new String[inputs.length];

        for (int i = 0; i < exOutputs.length; i++) {
            exOutputs[i] = answerDTO.getTestCaseResultDTOS().get(i).getResultMessage();
            outputs[i] = answerDTO.getTestCaseResultDTOS().get(i+exOutputs.length).getResultMessage();
        }

        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setQuiz_Title("그대로 출력하기");
        quizDTO.setMember_Id("helloworld");
        quizDTO.setQuiz_Contents("그대로 출력");
        quizDTO.setQuiz_Level(1);
        quizDTO.setQuiz_Point(0);
        quizDTO.setQuiz_Price(0);
        quizDTO.setQuiz_Type("basic io");

        int result = quizService.addQuiz(quizDTO, exinputs, exOutputs, inputs, outputs);

        assertEquals(result, 1 + inputs.length + exinputs.length);
    }
}