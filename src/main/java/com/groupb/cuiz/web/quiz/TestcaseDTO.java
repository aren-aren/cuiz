package com.groupb.cuiz.web.quiz;

public class TestcaseDTO {
    private Integer testcase_No;
    private Integer quiz_No;
    private String testcase_Input;
    private String testcase_Output;
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

    public String getTestcase_Input() {
        return testcase_Input;
    }

    public void setTestcase_Input(String testcase_Input) {
        this.testcase_Input = testcase_Input;
    }

    public String getTestcase_Output() {
        return testcase_Output;
    }

    public void setTestcase_Output(String testcase_Output) {
        this.testcase_Output = testcase_Output;
    }

    public String getTestcase_Type() {
        return testcase_Type;
    }

    public void setTestcase_Type(String testcase_Type) {
        this.testcase_Type = testcase_Type;
    }
}
