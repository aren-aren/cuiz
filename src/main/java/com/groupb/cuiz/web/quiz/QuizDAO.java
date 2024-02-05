package com.groupb.cuiz.web.quiz;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.groupb.cuiz.web.quiz.QuizDAO.";

    public int addTestcase(List<TestcaseDTO> testcase) throws Exception {
        return sqlSession.insert(NAMESPACE + "addTestcase", testcase);
    }

    public int addQuiz(QuizDTO quizDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "addQuiz", quizDTO);
    }
}
