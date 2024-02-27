package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.web.member.MemberDTO;

import java.sql.Date;
import java.util.List;

public class MemberAnswerDTO {
    private String member_Id;
    private Integer quiz_No;
    private String quiz_Title;
    private String sourcecode;
    private Date answer_Date;
    private Boolean answer_Check;
    private String result_Message;
    private QuizDTO quizDTO;
    private MemberDTO memberDTO;
    private List<TestcaseResult> testcase_Results;

    public String getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(String member_Id) {
        this.member_Id = member_Id;
    }

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

    public QuizDTO getQuizDTO() {
        return quizDTO;
    }

    public void setQuizDTO(QuizDTO quizDTO) {
        this.quizDTO = quizDTO;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
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
                ", quiz_No=" + quiz_No +
                ", sourcecode='" + sourcecode + '\'' +
                ", answer_Date=" + answer_Date +
                ", answer_Check=" + answer_Check +
                '}';
    }
}
