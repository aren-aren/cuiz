package com.groupb.cuiz.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public String setJoin(MemberDTO dto,Model model) throws Exception {
		int result = memberService.setJoin(dto);
		String path = "/";
		String msg = "회원가입 실패 관리자에 문의해주세요.";
		if(result >0 ) {
			msg = "회원가입 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		return ("member/join");
				
	}
	
}
