package com.groupb.cuiz.web.purchase;





import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	//영수증 확인
	
	@GetMapping("receipt")
	public String receiptDetail(ReceiptDTO receiptDTO, Model model) {
				
		Map<String, Object> map = purchaseService.receiptDetail(receiptDTO);
		

		model.addAttribute("dto", map);
		
		return "/purchase/receipt";				
	}
	
	
	
	//결제내역 확인
	@GetMapping("list")
	public String perchaseList(HttpSession session, Model model, MemberDTO memberDTO) {
		
		
		memberDTO = (MemberDTO)session.getAttribute("member");
		
		if(memberDTO==null) {
			
			model.addAttribute("msg","로그인이 필요합니다.");
			model.addAttribute("path", "/member/login");
			
			return "/commons/resultkakao";
		}
		
		
		List<ReceiptDTO> ar = purchaseService.purchaseList(memberDTO);			
		
		model.addAttribute("list", ar);
		
		return "/purchase/purchaselist";
		
	}
	
	
	//카카오페이
	
	
	
	//카카오페이 결제 환불
	
	
	

	@GetMapping("cancellation")
	public String kakaopayCancel(HttpSession session, Model model,ResponseDTO responseDTO) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");		
		System.out.println("kakaopayCancel purchaseController 85 :   "+responseDTO.getTid());
		Map<String, Object> resultMap =purchaseService.kakaopayCancel(memberDTO, responseDTO); 
		//반환값
		// 0 : 실패
		// 1 : 성공
		// 에러코드 실패;
		
		System.out.println(resultMap.get("result"));
		if(resultMap.get("result")=="1") {
			model.addAttribute("msg", "환불이 완료되었습니다");
			model.addAttribute("result", resultMap.get("result"));
			model.addAttribute("response", resultMap.get("response"));
			
		}else if(resultMap.get("result")=="0") {			
			model.addAttribute("result", resultMap.get("result"));
			model.addAttribute("msg", "환불할 코인이 부족합니다.");		
			
		}else {				
			model.addAttribute("result", resultMap.get("result"));
			model.addAttribute("msg", "에러발생 관리자에게 문의하시오");			
			model.addAttribute("response", resultMap.get("response"));
			
		}	
		
		return "/commons/resultkakao";
		
	}
	
	
	//카카오페이 결제
	
	@PostMapping("kakaopay")
	@ResponseBody	
	public String kakaoPay(ItemDTO itemDTO, ResponseDTO responseDTO, Model model, HttpSession session) throws Exception {
		
	
		System.out.println("카카오페이"+itemDTO.getItem_Num());
		
		responseDTO = purchaseService.kakaoPay(itemDTO, responseDTO);		
		this.responseDTO = responseDTO;		
				
		return 	responseDTO.getNext_redirect_pc_url();
		
		
	}
	
	
	
	//카카오페이 결제 성공시
	@GetMapping("success")
	public String kakopaySuccess(String pg_token, ReceiptDTO receiptDTO, HttpSession session,ItemDTO itemDTO, Model model) throws Exception {		
	

		this.responseDTO.setPg_token(pg_token);				
		receiptDTO = purchaseService.kakaoPaySuccess(itemDTO,responseDTO, receiptDTO, session);		
		
		model.addAttribute("total", receiptDTO.getAmount().getTotal());	
		model.addAttribute("msg", "결제가 완료되었습니다.");
		System.out.println("결제완료");
		
		return "/commons/resultkakao";
		
	}
	
	//카카오페이 결제 실패시
	@GetMapping("cancel")
	public String kakaopayCancel(Model model) {	
		
		model.addAttribute("msg", "결제를 취소하였습니다.");
		
		return "/commons/resultkakao";
			
	}	
	@GetMapping("fail")
	public String kakaopayFail(Model model) {	
		
		model.addAttribute("msg", "결제중 문제가 발생하였습니다.");
	
		
		return "/commons/resultkakao";
			
	}	
	
	
	
//	@GetMapping("list")
//	public String list(PurchaseDTO purchaseDTO, Model model) {	
//		purchaseDTO.setMember_ID("hello");
//		List<ItemDTO> ar = purchaseService.getList(purchaseDTO);
//		model.addAttribute("dto", ar);
//		
//		return "/purchase/list";
//		
//	}
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



