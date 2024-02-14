package com.groupb.cuiz.web.quiz;

public class QuizListDTO {
    private Integer quiz_No;
    private String quiz_Title;
    private Integer quiz_Level;
    private Integer correct_Count;
    private Integer total_Count;
    private Double correct_Rate;

    public Integer getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(Integer quiz_No) {
        this.quiz_No = quiz_No;
    }

    public String getQuiz_Title() {
        return quiz_Title;
    }

    public void setQuiz_Title(String quiz_Title) {
        this.quiz_Title = quiz_Title;
    }

    public Integer getQuiz_Level() {
        return quiz_Level;
    }

    public void setQuiz_Level(Integer quiz_Level) {
        this.quiz_Level = quiz_Level;
    }

    public Integer getCorrect_Count() {
        return correct_Count;
    }

    public void setCorrect_Count(Integer correct_Count) {
        this.correct_Count = correct_Count;
    }

    public Integer getTotal_Count() {
        return total_Count;
    }

    public void setTotal_Count(Integer total_Count) {
        this.total_Count = total_Count;
    }

    public Double getCorrect_Rate() {
        return correct_Rate;
    }

    public void setCorrect_Rate(Double correct_Rate) {
        this.correct_Rate = correct_Rate;
    }

    @Override
    public String toString() {
        return "QuizListDTO{" +
                "quiz_No=" + quiz_No +
                ", quiz_Title='" + quiz_Title + '\'' +
                ", quiz_Level=" + quiz_Level +
                ", correct_Count=" + correct_Count +
                ", total_Count=" + total_Count +
                '}';
    }
}
