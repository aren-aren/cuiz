package com.groupb.cuiz.web.quiz;

import java.util.List;

public class MemberAnswerDTO {
    private String member_Id;
    private String quiz_No;
    private String member_Source_Code;
    private String resultMessage;
    private List<TestcaseResult> testCaseResultDTOS;

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

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<TestcaseResult> getTestCaseResultDTOS() {
        return testCaseResultDTOS;
    }

    public void setTestCaseResultDTOS(List<TestcaseResult> testCaseResultDTOS) {
        this.testCaseResultDTOS = testCaseResultDTOS;
    }

    @Override
    public String toString() {
        return "MemberAnswerDTO{" +
                "member_Id='" + member_Id + '\'' +
                ", quiz_No='" + quiz_No + '\'' +
                ", member_Source_Code='" + member_Source_Code + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", testCaseResultDTOS=" + testCaseResultDTOS +
                '}';
    }
}
