package com.groupb.cuiz.web.quiz;

import java.util.Arrays;
import java.util.List;

public class QuizDTO {
    private Integer quiz_No;
    private String member_Id;
    private String quiz_Title;
    private String quiz_Contents;
    private String quiz_Type;
    private Integer quiz_Level;
    private String[] quiz_Example_Inputs;
    private String[] quiz_Example_Outputs;
    private String[] quiz_Inputs;
    private String[] quiz_Outputs;
    private Integer quiz_Point;
    private Integer quiz_Price;
    private TestcaseDTO testcase;

    public Integer getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(Integer quiz_No) {
        this.quiz_No = quiz_No;
    }

    public String getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(String member_Id) {
        this.member_Id = member_Id;
    }

    public String getQuiz_Title() {
        return quiz_Title;
    }

    public void setQuiz_Title(String quiz_Title) {
        this.quiz_Title = quiz_Title;
    }

    public String getQuiz_Contents() {
        return quiz_Contents;
    }

    public void setQuiz_Contents(String quiz_Contents) {
        this.quiz_Contents = quiz_Contents;
    }

    public String getQuiz_Type() {
        return quiz_Type;
    }

    public void setQuiz_Type(String quiz_Type) {
        this.quiz_Type = quiz_Type;
    }

    public Integer getQuiz_Level() {
        return quiz_Level;
    }

    public void setQuiz_Level(Integer quiz_Level) {
        this.quiz_Level = quiz_Level;
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

    public Integer getQuiz_Point() {
        return quiz_Point;
    }

    public void setQuiz_Point(Integer quiz_Point) {
        this.quiz_Point = quiz_Point;
    }

    public TestcaseDTO getTestcase() {
        return testcase;
    }

    public void setTestcase(TestcaseDTO testcase) {
        this.testcase = testcase;
    }

    public Integer getQuiz_Price() {
        return quiz_Price;
    }

    public void setQuiz_Price(Integer quiz_Price) {
        this.quiz_Price = quiz_Price;
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "quiz_No=" + quiz_No +
                ", member_Id='" + member_Id + '\'' +
                ", quiz_Title='" + quiz_Title + '\'' +
                ", quiz_Contents='" + quiz_Contents + '\'' +
                ", quiz_Point=" + quiz_Point +
                ", quiz_Price=" + quiz_Price +
                '}';
    }

}
