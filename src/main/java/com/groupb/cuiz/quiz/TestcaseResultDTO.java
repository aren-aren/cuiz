package com.groupb.cuiz.quiz;

public class TestcaseResultDTO {
    private Integer testcaseNum;
    private boolean result;
    private String resultMessage;

    public Integer getTestcaseNum() {
        return testcaseNum;
    }

    public void setTestcaseNum(Integer testcaseNum) {
        this.testcaseNum = testcaseNum;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "TestcaseResultDTO{" +
                "testcaseNum=" + testcaseNum +
                ", result=" + result +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
