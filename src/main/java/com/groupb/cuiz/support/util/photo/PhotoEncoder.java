package com.groupb.cuiz.support.util.photo;


import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.stereotype.Component;

import com.groupb.cuiz.web.item.ItemDTO;

@Component
public class PhotoEncoder {

	
public List<ItemDTO> ListToString(List<ItemDTO> ar){
		
	String photo = "data:image/png;base64,";
	String video = "data:video/mp4;base64,";
	
	
		ar.stream().forEach(p -> {
			String select = photo;
			if(p.getItem_Photo()!=null) {				
			
				if(p.getItem_Group()==1) {
					 select = video;
				}
				
				p.setItem_Photo_to_String(select+new String(p.getItem_Photo(),StandardCharsets.UTF_8));
			}
			
		});		
		
		
	return ar;		
	}

public ItemDTO blobToString(ItemDTO itemDTO) {
	
	String photo = "data:image/png;base64,";
	String video = "data:video/mp4;base64,";
	
	String select = photo;
	
	if(itemDTO.getItem_Photo()!=null) {				
		
		if(itemDTO.getItem_Group()==1) {
			 select = video;
		}
		
		itemDTO.setItem_Photo_to_String(select+new String(itemDTO.getItem_Photo(),StandardCharsets.UTF_8));
	}

	return itemDTO;
	
}
	
}
