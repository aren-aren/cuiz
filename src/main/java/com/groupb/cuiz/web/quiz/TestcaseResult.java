package com.groupb.cuiz.web.quiz;

public class TestcaseResult {
    private boolean result;
    private String resultMessage;


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
                ", result=" + result +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
