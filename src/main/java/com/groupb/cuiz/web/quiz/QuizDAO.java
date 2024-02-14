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

    public int addTestcase(List<TestcaseDTO> list) throws Exception {
        return sqlSession.insert(NAMESPACE + "addTestcase", list);
    }

    public int addQuiz(QuizDTO quizDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "addQuiz", quizDTO);
    }

    public Long getTotalCount(Pager pager) {
        return sqlSession.selectOne(NAMESPACE + "getTotalCount",pager);
    }

    public List<QuizDTO> getList(Pager pager) {
        return sqlSession.selectList(NAMESPACE + "getList", pager);
    }

    public QuizDTO getDetail(QuizDTO quizDTO) {
        return sqlSession.selectOne(NAMESPACE + "getDetail", quizDTO);
    }

    public List<TestcaseDTO> getTestCases(Map<String, Object> map) {
        return sqlSession.selectList(NAMESPACE + "getExampleTestCases", map);
    }
}
