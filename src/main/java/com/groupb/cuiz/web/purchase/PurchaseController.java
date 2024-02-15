package com.groupb.cuiz.web.purchase;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupb.cuiz.support.util.parser.ParameterToJson;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.purchase.kakao.ResponseDTO;


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
	public String kakaoPay(ItemDTO itemDTO, ResponseDTO responseDTO) throws IOException {
	
		URL address = new URL("https://open-api.kakaopay.com/online/v1/payment/ready");
		HttpURLConnection connection = (HttpURLConnection) address.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "SECRET_KEY DEVC6856C2EEE2F34D162ED6157E9BAB2B2980A8");
		connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		connection.setDoOutput(true);
		int tax_free_amount = itemDTO.getItem_Price()*(10/11);
		
		Calendar datetime = Calendar.getInstance();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddmmssSSS");
		String orderNum = time.format(datetime.getTime());

				
		String parameter = "cid=TC0ONETIME" // 가맹점 코드
				+ "&partner_order_id="+orderNum // 가맹점 주문번호 시간으로 생성
				+ "&partner_user_id=CUIZ" // 가맹점 회원 id				
				+ "&quantity=1" // 상품 수량 1 고정							
				+ "&total_amount="+itemDTO.getItem_Price() //상품가격 추가;
				+ "&tax_free_amount="+tax_free_amount // 상품 비과세 금액
				+ "&item_name="+itemDTO.getItem_Name() // 상품명 추가
				+ "&approval_url=http://localhost/shop/list/" // 결제성공	
				+ "&fail_url=http://localhost/shop/detail?"+itemDTO.getItem_Num() // 결제 실패 시
				+ "&cancel_url=http://localhost/shop/detail?"+itemDTO.getItem_Num() //localhost/shop/detail?
				;
		
		parameter = ParameterToJson.parameterToJson(parameter);
		System.out.println("parameter = " + parameter);
		
		OutputStream send = connection.getOutputStream(); // 이제 뭔가를 를 줄 수 있다.
		DataOutputStream dataSend = new DataOutputStream(send); // 이제 데이터를 줄 수 있다.
		dataSend.writeBytes(parameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)
		dataSend.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
		System.out.println(parameter);
		System.out.println();
		int result = connection.getResponseCode(); // 전송 잘 됐나 안됐나 html 번호 받음 받는다.
		System.out.println("html  :  "+result);

		InputStream receive; // 받다
		
		if(result == 200) {
			
			receive = connection.getInputStream();
			
		}else{
			
			receive = connection.getErrorStream();
		}

		
		InputStreamReader read = new InputStreamReader(receive); //받은걸 읽어옴
		BufferedReader change = new BufferedReader(read);// 바이트를 읽기위해 형변환,
		
		System.out.println(receive);
		String response = change.readLine();
		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		
		responseDTO = mapper.readValue(response, ResponseDTO.class);
	
		System.out.println("리다이렉트 주소 "+responseDTO.getNext_redirect_pc_url());
	
		
		return responseDTO.getNext_redirect_pc_url();
		
		
	}
}



