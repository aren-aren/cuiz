package com.groupb.cuiz.web.quiz;

import java.util.List;

public class MemberAnswerDTO {
    private String member_Id;
    private String quiz_No;
    private String member_Source_Code;
    private Boolean answerResult;
    private String resultMessage;
    private List<String> exampleInputs;
    private List<String> exampleOutputs;
    private List<TestcaseResultDTO> testCaseResultDTOS;

    public String getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(String member_Id) {
        this.member_Id = member_Id;
    }

    public String getQuiz_No() {
        return quiz_No;
    }

    public void setQuiz_No(String quiz_No) {
        this.quiz_No = quiz_No;
    }

    public String getMember_Source_Code() {
        return member_Source_Code;
    }

    public void setMember_Source_Code(String member_Source_Code) {
        this.member_Source_Code = member_Source_Code;
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

    public List<String> getExampleInputs() {
        return exampleInputs;
    }

    public void setExampleInputs(List<String> exampleInputs) {
        this.exampleInputs = exampleInputs;
    }

    public List<String> getExampleOutputs() {
        return exampleOutputs;
    }

    public void setExampleOutputs(List<String> exampleOutputs) {
        this.exampleOutputs = exampleOutputs;
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
                "member_Id='" + member_Id + '\'' +
                ", quiz_No='" + quiz_No + '\'' +
                ", member_Source_Code='" + member_Source_Code + '\'' +
                ", answerResult=" + answerResult +
                ", resultMessage='" + resultMessage + '\'' +
                ", exampleInputs=" + exampleInputs +
                ", exampleOutputs=" + exampleOutputs +
                ", testCaseResultDTOS=" + testCaseResultDTOS +
                '}';
    }
}
