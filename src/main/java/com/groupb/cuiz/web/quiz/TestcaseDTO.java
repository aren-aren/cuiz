package com.groupb.cuiz.web.quiz;

public class TestcaseDTO {
    private Integer quiz_No;
    private String example_Input;
    private String example_Output;
    private String testcase_Input;
    private String testcase_Output;

    public Integer getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(Integer quiz_No) {
        this.quiz_No = quiz_No;
    }

    public String getExample_Input() {
        return example_Input;
    }

    public void setExample_Input(String example_Input) {
        this.example_Input = example_Input;
    }

    public String getExample_Output() {
        return example_Output;
    }

    public void setExample_Output(String example_Output) {
        this.example_Output = example_Output;
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

    @Override
    public String toString() {
        return "TestcaseDTO{" +
                "quiz_No=" + quiz_No +
                ", example_Input='" + example_Input + '\'' +
                ", example_Output='" + example_Output + '\'' +
                ", testcase_Input='" + testcase_Input + '\'' +
                ", testcase_Output='" + testcase_Output + '\'' +
                '}';
    }
}
