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


import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;
import com.groupb.cuiz.web.purchase.kakao.ReceiptDTO;
import com.groupb.cuiz.web.purchase.kakao.ResponseDTO;


@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;	

	private ResponseDTO responseDTO;
	
	@GetMapping("success")
	public void kakopaySuccess(String pg_token, ReceiptDTO receiptDTO, HttpSession session,ItemDTO itemDTO) throws Exception {
		System.out.println("Pg_Token : "+ pg_token);
		
		this.responseDTO.setPg_token(pg_token);		
		
		int result = purchaseService.kakaoPaySuccess(itemDTO,responseDTO, receiptDTO, session);	
		
		
		
		
	}
	
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
	@PostMapping("kakaopay")
	@ResponseBody	
	public String kakaoPay(ItemDTO itemDTO, ResponseDTO responseDTO, Model model) throws Exception {
	
		responseDTO = purchaseService.kakaoPay(itemDTO, responseDTO);
		this.responseDTO = responseDTO;
		System.out.println( responseDTO.getPartner_order_id());
	return 	responseDTO.getNext_redirect_pc_url();
		
		
	}
	

	
	
	
}



