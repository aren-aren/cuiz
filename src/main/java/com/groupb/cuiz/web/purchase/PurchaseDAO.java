package com.groupb.cuiz.web.purchase;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.web.item.ItemDTO;

@Repository
public class PurchaseDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.groupb.cuiz.web.purchase.PurchaseDAO.";
	
	
	
	public List<ItemDTO> getList(PurchaseDTO purchaseDTO){
		
		return sqlSession.selectList(NAMESPACE+"getList", purchaseDTO);
		
	}
	
	public int buyItem(PurchaseDTO purchaseDTO) {
		
	  return sqlSession.insert(NAMESPACE+"buyItem", purchaseDTO);
		
	}
	
	public long check(PurchaseDTO purchaseDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"check", purchaseDTO);
	}
	
}
