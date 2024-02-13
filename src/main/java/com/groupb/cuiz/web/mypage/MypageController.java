package com.groupb.cuiz.web.mypage;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.groupb.cuiz.support.util.photo.PhotoEncoder;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;



@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	@Autowired
	private MypageService mypageService;	
	@Autowired
	private PhotoEncoder photoEncoder;
	@GetMapping("profile")
	public String mypage()  {			
		
		return "/mypage/profile";
		
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<ItemDTO> getList(MemberDTO memberDTO){
		
		System.out.println(memberDTO.getMember_ID());
		
		List<ItemDTO> ar =  mypageService.getList(memberDTO);
		
		ar = photoEncoder.ListToString(ar);
		
		return ar;
		
		
		
		
	}
	
	
}
