package com.groupb.cuiz.web.member;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public String setJoin() throws Exception {
	
		return ("member/join");
				
	}
	@PostMapping("join")
	public String setJoin( MemberDTO dto,Model model) throws Exception {
		System.out.println(dto);
		int result = memberService.setJoin(dto);
		
		model.addAttribute("msg", dto);
		
		return ("member/temp");
				
	}
	
	@GetMapping("login")
	public String setLogin() throws Exception{
		return "member/login";
	}
	@PostMapping("login")
	public String setLogin(HttpSession session,MemberDTO dto,Model model) throws Exception{
		 dto = memberService.getDetail(dto);
		 System.out.println(dto);
		 String msg = "아이디 또는 패스워드를 확인해주세요";
		 if(dto == null) {
			 model.addAttribute("msg", msg);
			 return "member/login";
		 }
		session.setAttribute("member", dto);
		//System.out.println( new String(dto.getMember_Profile_byte(), "UTF-8") );
		session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), "UTF-8"));
		 
		return null;
	}
	
	@GetMapping("mypage")
	public String setMypage() throws Exception{
		return "member/mypage";
	}
	
	@GetMapping("11")
	public String get(Model model) throws Exception{
		MemberDTO dto = memberService.get();
		model.addAttribute("msg", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), "UTF-8"));
		
		return "member/temp";
	}
}
