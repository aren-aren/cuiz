package com.groupb.cuiz.web.mypage;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupb.cuiz.web.member.MemberDTO;



@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	@Autowired
	private MypageService mypageService;	
	
	
	@GetMapping("profile")
	public String mypage()  {			
		
		return "/mypage/profile";
		
	}
	
}
