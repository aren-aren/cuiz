package com.groupb.cuiz.web.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDAO;
import com.groupb.cuiz.web.member.MemberService;


@Component
public class UserDelete {
//
//	@Autowired
//	private MemberService memberService;
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private ItemDAO itemDAO;
	
//	public UserDelete() {
//		
//	}
//	@Autowired
//	public UserDelete(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	public int setDelete()  throws Exception{
		int result = 10;
		System.out.println("30분 알람입니다.");
//		result = dao.realDelete();
//		
//		ItemDTO itemDTO = new ItemDTO();
//		itemDTO.setItem_Num(0);
//		
//		result = itemDAO.delete(itemDTO);
//		System.out.println("3일 차이 삭제 횟수 : " + result);
		
		
		return 1;
			
		
	}
	

	
}
