package com.groupb.cuiz.web.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDAO;
import com.groupb.cuiz.web.member.MemberService;



public class UserDelete {
//
//	@Autowired
//	private MemberService memberService;
	
	@Autowired
	private MemberDAO dao;
	

	
	public void setDelete()  throws Exception{
		
		System.out.println("30분 알람입니다.");
		System.out.println(dao);
		int result = dao.realDelete();
				
		
			
		
	}



	public MemberDAO getDao() {
		return dao;
	}



	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	
	

	
}
