package com.groupb.cuiz.web.purchase;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.groupb.cuiz.support.util.parser.ParameterToJson;
import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDAO;
import com.groupb.cuiz.web.member.MemberDTO;
import com.groupb.cuiz.web.purchase.kakao.ReceiptDTO;
import com.groupb.cuiz.web.purchase.kakao.ResponseDTO;



@Service
/* @Transactional(readOnly = true) */
public class PurchaseService {

	@Autowired
	private PurchaseDAO purchaseDAO;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ItemDAO itemDAO;	
	
//카카오페이

	//성공시
	public ReceiptDTO kakaoPaySuccess(ItemDTO itemDTO, ResponseDTO responseDTO, ReceiptDTO receiptDTO, HttpSession session) throws Exception {
				
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
	
		//반환값
		// 0 : 로그인필요
		// 1 : 성공
		// 에러코드 실패;		
		
		URL appAdd=new URL("https://open-api.kakaopay.com/online/v1/payment/approve");		
		String approveJson= "{\"cid\":\"TC0ONETIME\","
			+ " \"tid\":"+"\""+responseDTO.getTid()+"\""+","
			+ "\"partner_order_id\":"+"\""+ responseDTO.getPartner_order_id() +"\""+"," 
			+ "\"partner_user_id\":"+"\""+responseDTO.getPartner_user_id()+"\""+","
			+ "\"pg_token\":"+""+ "\""+responseDTO.getPg_token()+"\""+"}";		
		
		Map<String, Object> map =connectURL( approveJson, responseDTO, appAdd);	
		
		
		String response = (String) map.get("response");		
		int result = (int) map.get("result"); //200이 성공				
		ObjectMapper mapper = new ObjectMapper();			
		
				
		if(result == 200) {//결제성공
			receiptDTO = mapper.readValue(response, ReceiptDTO.class);	
			receiptDTO.setMember_ID(memberDTO.getMember_ID());
			receiptDTO.setItem_Num(responseDTO.getItem_Num());
			
			//영수증 저장
			int dbput = purchaseDAO.kakopaySuccess(receiptDTO);			
			
			
			if(receiptDTO.getPayment_method_type().toUpperCase().equals("CARD") && dbput==1) {				
				int card = purchaseDAO.kakopaySuccessCard(receiptDTO);				
			}
			
			//코인 입력						
			//지급할 코인 갯수 조회			
			itemDTO.setItem_Num(responseDTO.getItem_Num()); 			
			itemDTO = itemDAO.getDetail(itemDTO);
			//
			int resultCoin = (memberDTO.getMember_Coin()+(itemDTO.getItem_Price()/10)-3);		
			memberDTO.setMember_Coin(resultCoin);			
			memberDAO.setCoin(memberDTO);								
			
			return receiptDTO;
			
		}
						
		return receiptDTO;	
		
	}
	
	
	public ResponseDTO kakaoPay(ItemDTO itemDTO, ResponseDTO responseDTO) throws Exception {		
//		결제요청		
	
		Calendar datetime = Calendar.getInstance();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddmmssSSS");
		String orderID = time.format(datetime.getTime());
		responseDTO.setPartner_order_id(orderID);
		int tax_free_amount = itemDTO.getItem_Price()*(10/11);
		URL address = new URL("https://open-api.kakaopay.com/online/v1/payment/ready");
						
		String parameter = "cid=TC0ONETIME" // 가맹점 코드
				+ "&partner_order_id="+responseDTO.getPartner_order_id() // 가맹점 주문번호 시간으로 생성
				+ "&partner_user_id="+responseDTO.getPartner_user_id() // 가맹점 회원 id				
				+ "&quantity=1" // 상품 수량 1 고정							
				+ "&total_amount="+itemDTO.getItem_Price() //상품가격 추가;
				+ "&tax_free_amount="+tax_free_amount // 상품 비과세 금액
				+ "&item_name="+itemDTO.getItem_Name() // 상품명 추가
				+ "&approval_url=http://localhost/purchase/success" // 결제성공	
				+ "&fail_url=http://localhost/purchase/fail" // 결제 실패 시
				+ "&cancel_url=http://localhost/purchase/cancel" //localhost/shop/detail?
				;
		System.out.println(parameter);
		
		parameter = ParameterToJson.parameterToJson(parameter);
		Map<String, Object> map = connectURL(parameter, responseDTO, address);
		String response = (String) map.get("response");
		int result =  (int)map.get("result");
		System.out.println("PurchaseService:192   "+result);
		System.out.println("리스폰스 위에꺼 담음"+ response);
		ObjectMapper mapper = new ObjectMapper();		
		responseDTO = mapper.readValue(response, ResponseDTO.class);
		responseDTO.setPartner_order_id(orderID);	
		responseDTO.setItem_Num(itemDTO.getItem_Num());	
		
		return responseDTO;
	}
	
	
	public List<ItemDTO> getList(PurchaseDTO purchaseDTO){		
		
		return purchaseDAO.getList(purchaseDTO);
		
	}
	
	
	
//	카카오페이용 URL
	public Map<String, Object> connectURL(String parameter, ResponseDTO responseDTO, URL url) throws Exception {
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "SECRET_KEY DEVC6856C2EEE2F34D162ED6157E9BAB2B2980A8");
		connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		connection.setDoOutput(true);		
				
		OutputStream send = connection.getOutputStream(); // 이제 뭔가를 를 줄 수 있다.
		DataOutputStream dataSend = new DataOutputStream(send); // 이제 데이터를 줄 수 있다.
		dataSend.writeBytes(parameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)
		dataSend.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
	
		int result = connection.getResponseCode(); // 전송 잘 됐나 안됐나 html 번호 받음 받는다.			
		InputStream receive; // 받다		
		if(result == 200) {
			receive = connection.getInputStream();			
		}else{			
			receive = connection.getErrorStream();			
		}
		
		InputStreamReader read = new InputStreamReader(receive); //받은걸 읽어옴
		BufferedReader change = new BufferedReader(read);// 바이트를 읽기위해 형변환,
		
		String response = change.readLine();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("response", response);
		map.put("result", result);		
		
		return map;
		
	}
	
	
	
	
	
	
	
	
	
	
	//아이템 구매
	
	@Transactional
	public int buyItem(HttpSession session, ItemDTO itemDTO) throws Exception {
		
		
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");					
	
		
		itemDTO = itemDAO.getDetail(itemDTO);
		
		if(itemDTO.getItem_Group()==5) {			
			return 2;
		}
	
		
		//코인체크
		int result_coin = (memberDTO.getMember_Coin()-itemDTO.getItem_Price()-3);
		
		if(result_coin<0) {
			return 3; //잔액부족
		}
		
		
		
		
		//아이템 유무 확인
		
		PurchaseDTO purchaseDTO = new PurchaseDTO();
		
		purchaseDTO.setMember_ID(memberDTO.getMember_ID());
		purchaseDTO.setItem_Num(itemDTO.getItem_Num());		
			
		int result = 0; // 있는경우

		Long check = purchaseDAO.check(purchaseDTO);
		
		
		if(check==0L) {
			
			result = purchaseDAO.buyItem(purchaseDTO); //없는경우
		}
		
		
		//금액 차감
		
		if(result==1) {
			memberDTO.setMember_Coin(result_coin);
			result_coin = memberDAO.setCoin(memberDTO);					
		} //성공
		
		
		
		//0: 실패
		//1: 성공
		//2: 캐쉬템임
		//3: 잔액부족
		//4: 로그인 필요
	
		return result;		
		
	}
	
	
	
}
