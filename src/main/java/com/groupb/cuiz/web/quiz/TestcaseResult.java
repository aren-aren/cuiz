package com.groupb.cuiz.web.quiz;

public class TestcaseResult {
    private Integer testcase_No;
    private boolean isBuyed;
    private boolean result;
    private String resultMessage;


    public Integer getTestcase_No() {
        return testcase_No;
    }

    public void setTestcase_No(Integer testcase_No) {
        this.testcase_No = testcase_No;
    }

    public boolean isBuyed() {
        return isBuyed;
    }

    public void setBuyed(boolean buyed) {
        isBuyed = buyed;
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
        return "TestcaseResult{" +
                "testcase_No=" + testcase_No +
                ", result=" + result +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
