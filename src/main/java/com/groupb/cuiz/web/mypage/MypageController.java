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
	public String mypage(MemberDTO memberDTO, Model model) throws UnsupportedEncodingException {		
		
		memberDTO.setMember_ID("hello");
		memberDTO = mypageService.temp(memberDTO);
		if(memberDTO.getMember_Profile_Blob()!=null) {
			System.out.println(memberDTO.getMember_Profile_Blob());
		String photo = new String(memberDTO.getMember_Profile_Blob(),"UTF-8");
		
		model.addAttribute("sajin", photo);
			System.out.println(photo);
		
		}
				
		model.addAttribute("member", memberDTO);
		
		return "/mypage/profile";
		
	}
	
}
