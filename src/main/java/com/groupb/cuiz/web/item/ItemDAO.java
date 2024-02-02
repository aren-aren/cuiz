package com.groupb.cuiz.web.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.groupb.cuiz.web.item.ItemDAO.";
	
	public List<ItemDTO> getList(){
		
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	
	public int setItem(ItemDTO itemDTO) {
		System.out.println(NAMESPACE+"setItem");
		return sqlSession.insert(NAMESPACE+"setItem", itemDTO);
		
	}
	
	public ItemDTO getDetail(ItemDTO itemDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", itemDTO);		
		
	}
	
	public int delete(ItemDTO itemDTO) {
		System.out.println(itemDTO.getItem_Num());
		return sqlSession.delete(NAMESPACE+"delete", itemDTO);
	}
	
	public int update(ItemDTO itemDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"update", itemDTO);
	}
	
	
	
}
