package com.groupb.cuiz.web.statistic;

public class StatisticDTO {
    private Integer numOfProblem;
    private Integer numOfBoard;
    private Integer numOfMember;
    private Integer maxJumsu;

    public Integer getNumOfProblem() {
        return numOfProblem;
    }

    public void setNumOfProblem(Integer numOfProblem) {
        this.numOfProblem = numOfProblem;
    }

    public Integer getNumOfBoard() {
        return numOfBoard;
    }

    public void setNumOfBoard(Integer numOfBoard) {
        this.numOfBoard = numOfBoard;
    }

    public Integer getNumOfMember() {
        return numOfMember;
    }

    public void setNumOfMember(Integer numOfMember) {
        this.numOfMember = numOfMember;
    }

    public Integer getMaxJumsu() {
        return maxJumsu;
    }

    public void setMaxJumsu(Integer maxJumsu) {
        this.maxJumsu = maxJumsu;
    }

    @Override
    public String toString() {
        return "StatisticDTO{" +
                "numOfProblem=" + numOfProblem +
                ", numOfBoard=" + numOfBoard +
                ", numOfMember=" + numOfMember +
                ", maxJumsu=" + maxJumsu +
                '}';
    }
}
