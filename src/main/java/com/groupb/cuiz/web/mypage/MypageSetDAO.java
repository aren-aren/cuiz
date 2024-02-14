package com.groupb.cuiz.web.mypage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageSetDAO {

	@Autowired
	private SqlSession sqlSession;	
	private final String NAMESPACE = "com.groupb.cuiz.web.mypage.MypageSetDAO.";
	
	
	//아이템 장착시 테이블이 없는경우 데이터 생성용
	public int setTable(MypageSetDTO mypageSetDTO) {
		
		return sqlSession.insert(NAMESPACE+"mypageSetDTO",mypageSetDTO);
		
	}
	
	
	
}
