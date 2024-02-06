package com.groupb.cuiz.web.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.cuiz.web.member.MemberDTO;

@Service
public class MypageService {

	@Autowired
	private MypageDAO mypageDAO;
	
	
	public MemberDTO temp(MemberDTO memberDTO) {
		
		
		return mypageDAO.temp(memberDTO);
		
	}
	
	
}
