package com.groupb.cuiz.web.quiz;

public class TestcaseDTO {
    private Integer testcase_No;
    private Integer quiz_No;
    private String[] quiz_Example_Inputs;
    private String[] quiz_Example_Outputs;
    private String[] quiz_Inputs;
    private String[] quiz_Outputs;

    public Integer getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(Integer quiz_No) {
        this.quiz_No = quiz_No;
    }

    public String[] getQuiz_Example_Inputs() {
        return quiz_Example_Inputs;
    }

    public void setQuiz_Example_Inputs(String[] quiz_Example_Inputs) {
        this.quiz_Example_Inputs = quiz_Example_Inputs;
    }

    public String[] getQuiz_Example_Outputs() {
        return quiz_Example_Outputs;
    }

    public void setQuiz_Example_Outputs(String[] quiz_Example_Outputs) {
        this.quiz_Example_Outputs = quiz_Example_Outputs;
    }

    public String[] getQuiz_Inputs() {
        return quiz_Inputs;
    }

    public void setQuiz_Inputs(String[] quiz_Inputs) {
        this.quiz_Inputs = quiz_Inputs;
    }

    public String[] getQuiz_Outputs() {
        return quiz_Outputs;
    }

    public void setQuiz_Outputs(String[] quiz_Outputs) {
        this.quiz_Outputs = quiz_Outputs;
    }
}
