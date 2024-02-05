package com.groupb.cuiz.web.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupb.cuiz.web.member.MemberDTO;



@Controller
@RequestMapping("/mypage/*")
public class MypageController {

	@GetMapping("profile")
	public String mypage(MemberDTO memberDTO, Model model) {
		
		
		
		return "/mypage/profile";
		
	}
	
}
