package com.groupb.cuiz.web.mypage;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.groupb.cuiz.support.util.photo.PhotoEncoder;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.item.ItemService;
import com.groupb.cuiz.web.member.MemberDTO;



@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	

	@Autowired
	private MypageService mypageService;	
	@Autowired
	private PhotoEncoder photoEncoder;
	

	
	
	//마이페이지 진입
	@GetMapping("profile")
	public String mypage(MemberDTO dto,Model model,HttpSession session, MypageSetDTO mypageSetDTO) throws Exception {			
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO==null) {			
			model.addAttribute("msg","로그인이 필요합니다.");
			model.addAttribute("path","/member/login");
			return "/commons/result";			
		}
		
		List<ItemDTO> ar = mypageService.mypageSet(memberDTO);
		
		Map<String, Object> map =	mypageService.getCount(memberDTO);
		
		model.addAttribute("media", ar);
		model.addAttribute("map", map);
		return "/mypage/profile";
		
	}
	
	//
	@GetMapping("list")
	@ResponseBody
	public List<ItemDTO> getList(MemberDTO memberDTO) throws UnsupportedEncodingException{
		
		List<ItemDTO> ar =  mypageService.getList(memberDTO);
		// blob 파일을 String 으로 변환
		ar = photoEncoder.ListToString(ar);			
		
		return ar;
		
	}	
	//아이템 장착		
	@GetMapping("setUpdate")
	@ResponseBody
	public int mypageSetUpdate(HttpSession session,MypageSetDTO mypageSetDTO) {
			
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		mypageSetDTO.setMember_ID(memberDTO.getMember_ID());		
	
		return  mypageService.mypageSetUpdate(mypageSetDTO); 
				
	}
	//아이템조회
	@GetMapping("temp")
	@ResponseBody
	public ItemDTO mypage(ItemDTO itemDTO) {		
		itemDTO=mypageService.mypageTemp(itemDTO);	
		return itemDTO;
		
	}
	
	
	
	
//	sangul
	@GetMapping("yours")
	public String yours(MemberDTO dto,Model model,HttpSession session) throws Exception {
		dto = mypageService.temp(dto);
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO != null) {
			if(memberDTO.getMember_ID().equals(dto.getMember_ID())) {
				return "redirect:/mypage/profile";
			}
		}
		
		Map<String, Object> map =	mypageService.getCount(dto);
		
		
			System.out.println("map value = " + map.values());
			
		
		model.addAttribute("yours", dto);
		model.addAttribute("map", map);
		
		
		return "/mypage/yours";
	}
	
	

	
}
