package com.groupb.cuiz.web.mypage;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;
import com.groupb.cuiz.web.quiz.MemberAnswerDTO;

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
	
	public List<ItemDTO> mypageSet(MemberDTO memberDTO) {
		
		return sqlSession.selectList(NAMESPACE+"mypageSet", memberDTO);
		
	}
	
	public int mypageSetUpdate(MypageSetDTO mypageSetDTO) {
		
		return sqlSession.update(NAMESPACE+"mypageSetUpdate", mypageSetDTO);
		
	}
	
	public int mypageSetNew(MypageSetDTO mypageSetDTO) {
		
		return sqlSession.insert(NAMESPACE+"MypageSetNew", mypageSetDTO);
		
	}
	
	public int itemSetCheck(MypageSetDTO mypageSetDTO){
				
		return sqlSession.selectOne(NAMESPACE+"itemSetCheck", mypageSetDTO);
	}	
	
	
	
	
//	SANGUL
	
	public List<String> getAnswerDate(MemberDTO dto) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getAnswerDate",dto);
	}
	public List<YoursDTO> getCountAnswer(MemberDTO dto) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCountAnswer",dto);
	}
	
	
	
	
}
