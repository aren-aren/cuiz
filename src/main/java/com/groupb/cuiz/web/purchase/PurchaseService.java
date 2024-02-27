package com.groupb.cuiz.web.purchase;

import java.io.BufferedReader;
import java.io.DataOutputStream;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
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
	
	//영수증 조회
	
	public Map<String, Object> receiptDetail(ReceiptDTO receiptDTO) {
		Map<String, Object> map =purchaseDAO.receiptDetail(receiptDTO);
		
		return map; 
	}
		
	//구매내역
	
	public List<ReceiptDTO> purchaseList(MemberDTO memberDTO){
		
		return purchaseDAO.purchaseList(memberDTO);		
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
	
	//카카오페이 --------------------------------------------------		
	
	
	
//카카오페이
	
	//환불
		public Map<String, Object> kakaopayCancel(MemberDTO memberDTO, ResponseDTO responseDTO) throws Exception {
			
			//반환값
			// 0 : 실패
			// 1 : 성공
			// 에러코드 실패;
			
			ReceiptDTO receiptDTO = new ReceiptDTO();
			receiptDTO.setTid(responseDTO.getTid());
		
			
			Map<String , Object> receipt = purchaseDAO.receiptDetail(receiptDTO);
			System.out.println();
			Map<String, Object> resultMap= new HashMap<String, Object>();
			ObjectMapper mapper = new ObjectMapper();				
			
			//환불 할 코인수 확인
			System.out.println(receipt);
			Integer total = Integer.parseInt(String.valueOf(receipt.get("TOTAL")));
			int coin = (Integer.parseInt(String.valueOf(receipt.get("TOTAL")))/10)-3;
			if(memberDTO.getMember_Coin()<coin) {
				
				resultMap.put("response", "코인이 부족합니다.");
				resultMap.put("result", 0);
				return resultMap;
			}				 
			 
			//requst 보내기
					
			URL url = new URL("https://open-api.kakaopay.com/online/v1/payment/cancel");			
			
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			int tax_free_amount =total*(10/11);
			jsonMap.put("cid", "TC0ONETIME");
			jsonMap.put("tid",responseDTO.getTid());
			jsonMap.put("cancel_amount",total);
			jsonMap.put("cancel_tax_free_amount",tax_free_amount);
			
			Map<String, Object> map =connectURL(jsonMap, responseDTO, url);
			
			int result = (int)map.get("result");
			String response = (String)map.get("response");			
			
			
			resultMap.put("response", response);
			resultMap.put("result", result);
			
			if(result==200) {
				//Json DTO에 넣기
				receiptDTO = mapper.readValue(response, ReceiptDTO.class);
				//영수증 update 
				result = purchaseDAO.kakaopayCancel(receiptDTO);
				//update 성공후 해당 코인 제거
				if(result==1) {
					
					int setCoin = (memberDTO.getMember_Coin() - coin-3); 
					memberDTO.setMember_Coin(setCoin);
					result = memberDAO.setCoin(memberDTO);
					resultMap.put("response",receiptDTO.getTotal());
					resultMap.put("result", result);
					return resultMap;
				}			
				
				return resultMap;
			}			
			
			return resultMap;
			
			
		}
		
		
		
		
	//성공시
	public ReceiptDTO kakaoPaySuccess(ItemDTO itemDTO, ResponseDTO responseDTO, ReceiptDTO receiptDTO, HttpSession session) throws Exception {
				
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
	
		//반환값
		// 0 : 로그인필요
		// 1 : 성공
		// 에러코드 실패;		
		
		URL appAdd=new URL("https://open-api.kakaopay.com/online/v1/payment/approve");		
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("cid", "TC0ONETIME");
		jsonMap.put("tid",responseDTO.getTid());
		jsonMap.put("partner_order_id",responseDTO.getPartner_order_id());
		jsonMap.put("partner_user_id",responseDTO.getPartner_user_id());		
		jsonMap.put("pg_token",responseDTO.getPg_token());
		
		Map<String, Object> map =connectURL( jsonMap, responseDTO, appAdd);	
				
		String response = (String) map.get("response");		
		
		int result = (int) map.get("result"); //200이 성공				
		ObjectMapper mapper = new ObjectMapper();			
		
			
		if(result == 200) {//결제성공
			
			receiptDTO = mapper.readValue(response, ReceiptDTO.class);	
			receiptDTO.setMember_ID(memberDTO.getMember_ID());
			receiptDTO.setItem_Num(responseDTO.getItem_Num());
			
			
			String arr = mapper.writeValueAsString(response);
			System.out.println(arr);
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
		//실패시 오류값 반환		
		
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
			
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("cid", "TC0ONETIME");
		jsonMap.put("partner_order_id",responseDTO.getPartner_order_id());
		jsonMap.put("partner_user_id",responseDTO.getPartner_user_id());
		jsonMap.put("quantity",1);		
		jsonMap.put("total_amount",itemDTO.getItem_Price());
		jsonMap.put("tax_free_amount",tax_free_amount);
		jsonMap.put("item_name",itemDTO.getItem_Name());
		jsonMap.put("approval_url","http://localhost/purchase/success");
		jsonMap.put("fail_url","http://localhost/purchase/fail");
		jsonMap.put("cancel_url","http://localhost/purchase/cancel");
		
		
		Map<String, Object> map = connectURL(jsonMap, responseDTO, address);
		String response = (String) map.get("response");
		int result =  (int)map.get("result");		
		
		
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
	public Map<String, Object> connectURL(Map<String, Object> jsonMap,ResponseDTO responseDTO, URL url) throws Exception {
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "SECRET_KEY DEVC6856C2EEE2F34D162ED6157E9BAB2B2980A8");
		connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		connection.setDoOutput(true);		
		
		//Map을 Json 타입  String(parameter)으로 변환
		ObjectMapper mapper = new ObjectMapper();
		
		String parameter = mapper.writeValueAsString(jsonMap); 	
		
		OutputStream send = connection.getOutputStream(); // 이제 뭔가를 를 줄 수 있다.
		DataOutputStream dataSend = new DataOutputStream(send); // 이제 데이터를 줄 수 있다.
		
		
		
		dataSend.writeBytes(parameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)
		
		
		
		dataSend.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
	
		int result = connection.getResponseCode(); // 전송 잘 됐나 안됐나 html 번호 받음 받는다.			
		;
		
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
		if(result!=200) {
			System.out.println("PuerchaseService 265 에러 코드 : "+response);			
		}
		
		map.put("response", response);
		map.put("result", result);		
		
		return map;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
