package com.groupb.cuiz.web.quiz;

import com.groupb.cuiz.support.util.pager.Pager;
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

    public Long getTotalCount(Pager pager) {
        return sqlSession.selectOne(NAMESPACE + "getQuizTotalCount",pager);
    }

    public List<QuizListDTO> getList(Pager pager) {
        return sqlSession.selectList(NAMESPACE + "getQuizList", pager);
    }

    public QuizDTO getDetail(QuizDTO quizDTO) {
        return sqlSession.selectOne(NAMESPACE + "getQuizDetail", quizDTO);
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
}
