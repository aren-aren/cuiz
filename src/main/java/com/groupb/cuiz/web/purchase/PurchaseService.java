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
	

	
	public Map<String, Object> connectURL(String parameter, ResponseDTO responseDTO, URL url) throws Exception {
		
		
		System.out.println("connectURL 실행" );
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "SECRET_KEY DEVC6856C2EEE2F34D162ED6157E9BAB2B2980A8");
		connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		connection.setDoOutput(true);
		
		
		System.out.println("parameter = " + parameter);
		System.out.println("퍼체이스 서비스  오더 아이디 :  "+responseDTO.getPartner_order_id());
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
		System.out.println("connectURL 리턴직전  :"+response);	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("response", response);
		map.put("result", result);
		
		
		return map;
		
	}
	
	
	public int kakaoPaySuccess(ItemDTO itemDTO, ResponseDTO responseDTO, ReceiptDTO receiptDTO, HttpSession session) throws Exception {
		
		
		if(session.getAttribute("member")==null) {
			
			return 0;
		}
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		receiptDTO.setMember_ID(memberDTO.getMember_ID());

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
			//코인 입력
			
			
			//지급할 코인 갯수 조회			
			itemDTO.setItem_Num(responseDTO.getItem_Num()); 
			itemDTO = itemDAO.getDetail(itemDTO); 
			System.out.println("아이템 가격  = " +itemDTO.getItem_Price());
			
			
			int resultCoin = ((itemDTO.getItem_Price()/10)-3);
			
			System.out.println("지급할 코인 값 "+ resultCoin );
			
			memberDTO.setMember_Coin(resultCoin);			
			memberDAO.setCoin(memberDTO);
			
			receiptDTO = mapper.readValue(response, ReceiptDTO.class);			
			return 1;
			
		}
		
		
		
		
		
		return result;
		
		
	}
	
	
	public ResponseDTO kakaoPay(ItemDTO itemDTO, ResponseDTO responseDTO) throws Exception {
		
//		결제요청
		
		System.out.println("결제요청");
		
	
		
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
				+ "&fail_url=http://localhost/shop/detail?"+itemDTO.getItem_Num() // 결제 실패 시
				+ "&cancel_url=http://localhost/shop/detail?"+itemDTO.getItem_Num() //localhost/shop/detail?
				;
		
		parameter = ParameterToJson.parameterToJson(parameter);
		Map<String, Object> map = connectURL(parameter, responseDTO, address);
		String response = (String) map.get("response");
		ObjectMapper mapper = new ObjectMapper();		
		responseDTO = mapper.readValue(response, ResponseDTO.class);
		responseDTO.setPartner_order_id(orderID);	
		responseDTO.setItem_Num(itemDTO.getItem_Num());
		System.out.println("parameter = " + parameter);
		System.out.println("퍼체이스 서비스  오더 아이디 :  "+responseDTO.getPartner_order_id());
		

		System.out.println("tid "+responseDTO.getTid());			
		System.out.println("퍼체이스 서비스  오더 아이디 리턴 직전:  "+responseDTO.getPartner_order_id());
		
		
		return responseDTO;
	}
	
	
	public List<ItemDTO> getList(PurchaseDTO purchaseDTO){		
		
		System.out.println(purchaseDTO.getMember_ID()+ purchaseDTO.getItem_Num());
		return purchaseDAO.getList(purchaseDTO);
		
	}
	
	
	
	@Transactional
	public int buyItem(HttpSession session, ItemDTO itemDTO) throws Exception {
		
		
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");					
		System.out.println("인수 :"+memberDTO.getMember_Coin());		
		System.out.println("service 확인"+itemDTO.getItem_Group());
		
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
		
		System.out.println("service check  "+check);
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
		System.out.println("서비스 결과 : "+ result);
		return result;		
		
	}
	
}
