package com.groupb.cuiz.web.item;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public int setItem(ItemDTO itemDTO, MultipartFile file) throws IOException {
		
		System.out.println("service add "+ file);
		
		if(!file.isEmpty()) {
			
			byte[] photo = Base64.getEncoder().encode(file.getBytes()); 
			itemDTO.setItem_Photo(photo);
			
		}
		
		
		
		
		return itemDAO.setItem(itemDTO);
	}
	
	
	public int delete(ItemDTO itemDTO) {
		
		return itemDAO.delete(itemDTO);
		
	}
	
	
	public int update(ItemDTO itemDTO) {
		
		return itemDAO.update(itemDTO);
	}
	
	
	
	
}
