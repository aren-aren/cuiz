package com.groupb.cuiz.web.quiz;

import java.sql.Date;
import java.util.List;

public class MemberAnswerDTO {
    private String member_Id;
    private String quiz_No;
    private String sourcecode;
    private Date answer_Date;
    private Boolean answer_Check;
    private String result_Message;
    private List<TestcaseResult> testcase_Results;

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

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode;
    }

    public String getResult_Message() {
        return result_Message;
    }

    public void setResult_Message(String result_Message) {
        this.result_Message = result_Message;
    }

    public List<TestcaseResult> getTestcase_Results() {
        return testcase_Results;
    }

    public void setTestcase_Results(List<TestcaseResult> testcase_Results) {
        this.testcase_Results = testcase_Results;
    }

    public Date getAnswer_Date() {
        return answer_Date;
    }

    public void setAnswer_Date(Date answer_Date) {
        this.answer_Date = answer_Date;
    }

    public Boolean getAnswer_Check() {
        return answer_Check;
    }

    public void setAnswer_Check(Boolean answer_Check) {
        this.answer_Check = answer_Check;
    }

    @Override
    public String toString() {
        return "MemberAnswerDTO{" +
                "member_Id='" + member_Id + '\'' +
                ", quiz_No='" + quiz_No + '\'' +
                ", source_Code='" + sourcecode + '\'' +
                ", resultMessage='" + result_Message + '\'' +
                ", testcaseResults=" + testcase_Results +
                '}';
    }
}
