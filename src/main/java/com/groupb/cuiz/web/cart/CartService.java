package com.groupb.cuiz.web.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.cuiz.web.item.ItemDTO;



@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;
	
	
	
	public List<ItemDTO> getList(CartDTO cartDTO){		
		
		System.out.println(cartDTO.getMember_ID()+ cartDTO.getItem_Num());
		return cartDAO.getList(cartDTO);
		
	}

	public int addList(CartDTO cartDTO) {
		
		
		return cartDAO.addList(cartDTO);
		
		
		
		
	}
	
}
