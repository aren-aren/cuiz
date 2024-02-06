package com.groupb.cuiz.web.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.web.item.ItemDTO;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.groupb.cuiz.web.cart.CartDAO.";
	
	
	public List<ItemDTO> getList(CartDTO catCartDTO){
		
		return sqlSession.selectList(NAMESPACE+"getList", catCartDTO);
		
	}
	
	public int addList(CartDTO cartDTO) {
		
	  return sqlSession.insert(NAMESPACE+"addList", cartDTO);
		
	}
	
}
