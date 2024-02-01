package com.groupb.cuiz.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.groupb.cuiz.member.MemberDAO.";
	
	
	public int SetJoin(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setJoin",dto);
	}
	
	public MemberDTO get()throws Exception{
		return sqlSession.selectOne(namespace+"get");
	}
	
	public MemberDTO getDetail(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",dto);
	}
	
}
