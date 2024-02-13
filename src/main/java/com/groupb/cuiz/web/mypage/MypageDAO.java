package com.groupb.cuiz.web.mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.groupb.cuiz.web.mypage.MypageDAO.";	
	
	public MemberDTO temp(MemberDTO memberDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"temp", memberDTO);
		
	}
	
	public List<ItemDTO> getList(MemberDTO memberDTO){
		
		return sqlSession.selectList(NAMESPACE+"getList", memberDTO);
		
	}
	
}
