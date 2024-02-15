package com.groupb.cuiz.web.purchase;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDAO;
import com.groupb.cuiz.web.member.MemberDTO;



@Service
@Transactional(readOnly = true)
public class PurchaseService {

	@Autowired
	private PurchaseDAO purchaseDAO;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ItemDAO itemDAO;
	
	
	
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
