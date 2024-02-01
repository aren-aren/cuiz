package com.groupb.cuiz.web.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	
	public List<ItemDTO> getList(){
		
		List<ItemDTO> ar = itemDAO.getList();
		
		return ar;
		
	}
	
	public ItemDTO getDetail(ItemDTO itemDTO) {
		
		
		return itemDAO.getDetail(itemDTO);
		
		
	}

}
