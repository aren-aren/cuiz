package com.groupb.cuiz.web.ranking;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.groupb.cuiz.web.board.qna.QnaDTO;
import com.groupb.cuiz.web.quiz.QuizDTO;

@Component
public class RankingDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.groupb.cuiz.web.ranking.RankingDAO.";
	
	public int setDelete() throws Exception{
		return sqlSession.delete(namespace+"setDelete");
	}
	
	public int setInsert(RankingDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setInsert",dto);
	}
	
	public List<RankingDTO> getAnswerID() throws Exception {
		return  sqlSession.selectList(namespace+"getAnswerID");
	}
	
	public List<QuizDTO> getQuizNO(RankingDTO dto) throws Exception{	
		return sqlSession.selectList(namespace+"getQuizNO",dto);
	}

	public int getJumsu(QuizDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getJumsu",dto);
	}
	public int setJumsu(RankingDTO dto) throws Exception{
		return sqlSession.update(namespace+"setJumsu",dto);
	}
	public List<RankingDTO> getRanking( ) throws Exception{
		return sqlSession.selectList(namespace+"getRanking");
	}
	public RankingDTO getNick(RankingDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getNick",dto);
	}
	public int setNick(RankingDTO dto) throws Exception{
		return sqlSession.update(namespace+"setNick",dto);
	}
	
	public List<RankingDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	
	public List<QnaDTO> getQNAList() throws Exception{
		return sqlSession.selectList(namespace+"getQNAList");
	}
	
}
