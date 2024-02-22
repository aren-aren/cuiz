package com.groupb.cuiz.web.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.support.util.pager.Pager;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.groupb.cuiz.web.board.qna.ReplyDAO.";
	
	public int getAdd(ReplyDTO replyDTO)throws Exception{
		return sqlSession.insert(namespace+"getAdd", replyDTO);
	}
	
	public Long getTotalCount(Pager pager)throws Exception{
		return sqlSession.selectOne(namespace+"getTotalCount", pager);
	}
	
	public List<ReplyDTO> getList(Pager pager)throws Exception{
		return sqlSession.selectList(namespace+"getList", pager);
	}

}
