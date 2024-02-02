package com.groupb.cuiz.web.quiz;

import java.util.List;

public class MemberAnswerDTO {
    private String memberCode;
    private String quiz_No;
    private Boolean answerResult;
    private String resultMessage;
    private List<TestcaseResultDTO> testCaseResultDTOS;

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(String quiz_No) {
        this.quiz_No = quiz_No;
    }

    public Boolean getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(Boolean answerResult) {
        this.answerResult = answerResult;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<TestcaseResultDTO> getTestCaseResultDTOS() {
        return testCaseResultDTOS;
    }

    public void setTestCaseResultDTOS(List<TestcaseResultDTO> testCaseResultDTOS) {
        this.testCaseResultDTOS = testCaseResultDTOS;
    }

    @Override
    public String toString() {
        return "MemberAnswerDTO{" +
                "memberCode='" + memberCode + '\'' +
                ", quiz_No='" + quiz_No + '\'' +
                ", answerResult=" + answerResult +
                ", resultMessage='" + resultMessage + '\'' +
                ", testCaseResultDTOS=" + testCaseResultDTOS +
                '}';
    }
}
