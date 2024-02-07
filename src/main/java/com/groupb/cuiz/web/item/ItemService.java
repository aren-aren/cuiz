package com.groupb.cuiz.web.item;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	
	public List<ItemDTO> getList(Pager pager){
		
		List<ItemDTO> ar = itemDAO.getList(pager);
		
			ar = decoderListToString(ar);

	
		return ar;
		
	}
	
	
	public ItemDTO getDetail(ItemDTO itemDTO) throws UnsupportedEncodingException {
		System.out.println("item service : "+itemDTO.getItem_Num());
		
		itemDTO = itemDAO.getDetail(itemDTO);			
		
		
		if(itemDTO.getItem_Photo()!=null) {
//			System.out.println("service.getDetail  : " + itemDTO.getItem_Photo());			
			String photo = new String(itemDTO.getItem_Photo(),"UTF-8");
			itemDTO.setItem_Photo_to_String(photo);
		}
		
		return itemDTO;		
	}

	
	
	public int add(ItemDTO itemDTO, MultipartFile file) throws IOException {
		
		System.out.println("service add "+ file);
		
		if(!file.isEmpty()) {
			
			byte[] photo = photoEncoder(file); 
			System.out.println(photo);
			itemDTO.setItem_Photo(photo);			
		}
		
				
		return itemDAO.add(itemDTO);
	}
	
	
	
	public int delete(ItemDTO itemDTO) {
		
		return itemDAO.delete(itemDTO);
		
	}
	
	
	
	
	public int update(ItemDTO itemDTO, MultipartFile file) throws IOException {
		System.out.println("Service!!   "+itemDTO.getItem_Photo());
		System.out.println("Service!!   "+ file);

		if(!file.isEmpty()) {
			byte[] photo = photoEncoder(file); 	
			System.out.println("after encoding"+ photo);
			itemDTO.setItem_Photo(photo);			
		}
		
		
		
		return itemDAO.update(itemDTO);
	}
	
	
	
	
	public List<ItemDTO> decoderListToString(List<ItemDTO> ar){
		
		
		ar.stream().forEach(p -> {
			if(p.getItem_Photo()!=null) {				
				try {
					p.setItem_Photo_to_String(new String(p.getItem_Photo(),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});		
	return ar;		
	}
	
	
	public byte[] photoEncoder(MultipartFile file) throws IOException {
		
		byte[] photo = Base64.getEncoder().encode(file.getBytes()); 
		
		return photo;
		
	}
	
}
