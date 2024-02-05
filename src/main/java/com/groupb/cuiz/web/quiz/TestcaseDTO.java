package com.groupb.cuiz.web.quiz;

import java.util.List;

public class TestcaseDTO {
    private Integer testcase_No;
    private Integer quiz_No;
    private String quiz_Input;
    private String quiz_Output;
    private String testcase_Type;

    public Integer getTestcase_No() {
        return testcase_No;
    }

    public void setTestcase_No(Integer testcase_No) {
        this.testcase_No = testcase_No;
    }

    public Integer getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(Integer quiz_No) {
        this.quiz_No = quiz_No;
    }

    public String getQuiz_Input() {
        return quiz_Input;
    }

    public void setQuiz_Input(String quiz_Input) {
        this.quiz_Input = quiz_Input;
    }

    public String getQuiz_Output() {
        return quiz_Output;
    }

    public void setQuiz_Output(String quiz_Output) {
        this.quiz_Output = quiz_Output;
    }

    public String getTestcase_Type() {
        return testcase_Type;
    }

    public void setTestcase_Type(String testcase_Type) {
        this.testcase_Type = testcase_Type;
    }
}
