package com.groupb.cuiz.web.mypage;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.groupb.cuiz.support.util.photo.PhotoEncoder;
import com.groupb.cuiz.web.item.ItemContoller;
import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.item.ItemService;
import com.groupb.cuiz.web.member.MemberDTO;



@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	
	@Autowired
	private ItemService i;
	@Autowired
	private MypageService mypageService;	
	@Autowired
	private PhotoEncoder photoEncoder;
	@GetMapping("profile")
	public String mypage()  {			
		
		return "/mypage/profile";
		
	}
	
//	sangul
	@GetMapping("yours")
	public String yours(MemberDTO dto,Model model) {
		dto = mypageService.temp(dto);
		
		model.addAttribute("yours", dto);
		
		return "/mypage/yours";
	}
	
	
	@GetMapping("list")
	@ResponseBody
	public List<ItemDTO> getList(MemberDTO memberDTO) throws UnsupportedEncodingException{
		
		System.out.println(memberDTO.getMember_ID());
		
		List<ItemDTO> ar =  mypageService.getList(memberDTO);
		// blob 파일을 String 으로 변환
		ar = photoEncoder.ListToString(ar);			
		
		return ar;
		
		
		
		
	}
	
	
}
