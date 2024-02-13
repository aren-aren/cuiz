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
    private Integer quiz_Point;
    private Integer quiz_Price;
    private List<TestcaseDTO> testcase;

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

    public Integer getQuiz_Point() {
        return quiz_Point;
    }

    public void setQuiz_Point(Integer quiz_Point) {
        this.quiz_Point = quiz_Point;
    }

    public List<TestcaseDTO> getTestcase() {
        return testcase;
    }

    public void setTestcase(List<TestcaseDTO> testcase) {
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
