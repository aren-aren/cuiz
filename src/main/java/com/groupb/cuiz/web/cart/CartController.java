package com.groupb.cuiz.web.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	@GetMapping("list")
	public String list(CartDTO cartDTO, Model model) {	
		cartDTO.setMember_ID("hello");
		List<ItemDTO> ar = cartService.getList(cartDTO);
		model.addAttribute("dto", ar);
		
		return "/cart/list";
		
	}
	
//	@GetMapping("addCart")
//	public int addList(CartDTO cartDTO, Model model) {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setMember_ID("hello");	
//		int result = cartService.addList(cartDTO);		
//		
//		return result; 
//		
//	}
	
	
}
