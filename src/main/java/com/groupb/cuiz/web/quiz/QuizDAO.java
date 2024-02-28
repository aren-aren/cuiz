package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.member.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QuizDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.groupb.cuiz.web.quiz.QuizDAO.";

    public int addTestcases(List<TestcaseDTO> list) throws Exception {
        return sqlSession.insert(NAMESPACE + "addTestcases", list);
    }

    public int addQuiz(QuizDTO quizDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "addQuiz", quizDTO);
    }

    public Long getQuizTotalCount(Pager pager) {
        return sqlSession.selectOne(NAMESPACE + "getQuizTotalCount",pager);
    }

    public List<QuizListDTO> getList(Pager pager) {
        return sqlSession.selectList(NAMESPACE + "getQuizList", pager);
    }

    public QuizDTO getQuizDetail(QuizDTO quizDTO) {
        return getQuizDetail(quizDTO.getQuiz_No());
    }

    public QuizDTO getQuizDetail(Integer quiz_No){
        return sqlSession.selectOne(NAMESPACE + "getQuizDetail", quiz_No);
    }

    public List<TestcaseDTO> getTestCases(Map<String, Object> map) {
        return sqlSession.selectList(NAMESPACE + "getTestCases", map);
    }

    public MemberAnswerDTO getAnswer(MemberAnswerDTO answerDTO) {
        return sqlSession.selectOne(NAMESPACE + "getAnswer", answerDTO);
    }

    public int updateAnswer(MemberAnswerDTO answerDTO) {
        return sqlSession.update(NAMESPACE + "updateAnswer", answerDTO);
    }

    public int setAnswer(MemberAnswerDTO answerDTO) {
        return sqlSession.insert(NAMESPACE + "setAnswer", answerDTO);
    }

    public Integer getQuizLevel(MemberAnswerDTO answerDTO) {
        return sqlSession.selectOne(NAMESPACE + "getQuizLevel", answerDTO);
    }

    public int updateQuiz(QuizDTO quizDTO) {
        return sqlSession.update(NAMESPACE + "updateQuiz", quizDTO);
    }

    public int deleteTestcase(TestcaseDTO testcaseDTO) {
        return sqlSession.delete(NAMESPACE + "deleteTestcase", testcaseDTO);
    }

    public List<AnswerShowDTO> getAnswers(Map<String, Object> map) {
        return sqlSession.selectList(NAMESPACE + "getAnswers", map);
    }

    public List<MemberAnswerDTO> getMemberAnswers(MemberDTO memberDTO) {
        return sqlSession.selectList(NAMESPACE + "getMemberAnswers", memberDTO);
    }

    public Long getAnswerTotalCount(Map<String, Object> map) {
        return sqlSession.selectOne(NAMESPACE + "getAnswerTotalCount", map);
    }

    public JumsuUpdateDTO getJumsuData(QuizDTO quizDTO) {
        return sqlSession.selectOne(NAMESPACE + "getJumsuData", quizDTO);
    }

    public List<QuizDTO> getAllQuizs() {
        return sqlSession.selectList(NAMESPACE + "getAllQuizs");
    }

    public void buyTestcase(Map<String, Object> map) {
        sqlSession.insert(NAMESPACE + "buyTestcase" , map);
    }

    public List<TestcaseDTO> getBuyedTestcase(QuizDTO quiz) {
        return sqlSession.selectList(NAMESPACE + "getBuyedTestcase", quiz);
    }
}
