package com.groupb.cuiz.web.purchase;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
	@PostMapping("kakaopay")
	@ResponseBody	
	public void kakaoPay(ItemDTO itemDTO) throws IOException {
	
		URL address = new URL("https://open-api.kakaopay.com/online/v1/payment/ready");
		HttpURLConnection connection = (HttpURLConnection) address.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "PRD219CB492C961B4CEF1725AD3054234A1F4F56");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		connection.setDoOutput(true);
		
		String parameter = "cid=TC0ONETIME" // 가맹점 코드
				+ "&partner_order_id=partner_order_id" // 가맹점 주문번호
				+ "&partner_user_id=partner_user_id" // 가맹점 회원 id
				+ "&item_name=초코파이" // 상품명
				+ "&quantity=1" // 상품 수량
				+ "&total_amount=5000" // 총 금액
				+ "&vat_amount=200" // 부가세
				+ "&tax_free_amount=0" // 상품 비과세 금액
				+ "&approval_url=http://localhost:8000/" // 결제 성공 시
				+ "&fail_url=http://localhost:8000/" // 결제 실패 시
				+ "&cancel_url=http://localhost:8000/"; // 결제 취소 시
		OutputStream send = connection.getOutputStream(); // 이제 뭔가를 를 줄 수 있다.
		DataOutputStream dataSend = new DataOutputStream(send); // 이제 데이터를 줄 수 있다.
		dataSend.writeBytes(parameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)
		dataSend.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
		
		int result = connection.getResponseCode(); // 전송 잘 됐나 안됐나 번호를 받는다.
		InputStream receive; // 받다
		
		System.out.println(result);


//
//		cid	//String	O	가맹점 코드, 10자
//		partner_order_id	//String	O	가맹점 주문번호, 최대 100자
//		partner_user_id	//String	O	가맹점 회원 id, 최대 100자
//		item_name	//String	O	상품명, 최대 100자
//		quantity	//Integer	O	상품 수량
//
//
//		total_amount	//Integer	O	상품 총액
//		
//		approval_url//	String	O	결제 성공 시 redirect url, 최대 255자
//		cancel_url	//String	O	결제 취소 시 redirect url, 최대 255자
//		fail_url	//String	O	결제 실패 시 redirect url, 최대 255자
//

		
	}
}
