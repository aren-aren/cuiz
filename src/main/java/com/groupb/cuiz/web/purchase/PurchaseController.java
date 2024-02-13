package com.groupb.cuiz.web.purchase;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;


@RestController
@RequestMapping("/purchase/*")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	
	@GetMapping("list")
	public String list(PurchaseDTO purchaseDTO, Model model) {	
		purchaseDTO.setMember_ID("hello");
		List<ItemDTO> ar = purchaseService.getList(purchaseDTO);
		model.addAttribute("dto", ar);
		
		return "/purchase/list";
		
	}
	@PostMapping("buy")
	@ResponseBody
	public int buyItem(ItemDTO itemDTO,HttpSession httpSession) throws Exception {
		if(httpSession.getAttribute("member")==null) {
			return 4;
		}		
	
	
		int result = purchaseService.buyItem(httpSession, itemDTO);
		
		System.out.println(result);
		//0: 실패
		//1: 성공
		//2: 캐쉬템임
		//3: 잔액부족
		//4: 로그인 필요
		return result;
		
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
