package com.groupb.cuiz.web.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.support.util.photo.PhotoEncoder;

@Repository
public class ItemDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PhotoEncoder photoEncoder;
	
	private final String NAMESPACE="com.groupb.cuiz.web.item.ItemDAO.";
	
	public List<ItemDTO> getList(Pager pager){
		System.out.println(pager.getKind());
		return sqlSession.selectList(NAMESPACE+"getList", pager);
		
	}
	
	public int add(ItemDTO itemDTO) {
		System.out.println(NAMESPACE+"add");
		return sqlSession.insert(NAMESPACE+"add", itemDTO);
		
	}
	
	public ItemDTO getDetail(ItemDTO itemDTO) {
		System.out.println(itemDTO.getItem_Num());
		
		itemDTO = sqlSession.selectOne(NAMESPACE+"getDetail", itemDTO);			
		
		
		return photoEncoder.blobToString(itemDTO);
		
	}
	
	public int delete(ItemDTO itemDTO) {
		System.out.println(itemDTO.getItem_Num());
		return sqlSession.delete(NAMESPACE+"delete", itemDTO);
	}
	
	public int update(ItemDTO itemDTO) {
		
		return sqlSession.update(NAMESPACE+"update", itemDTO);
	}
	
	
	
}
