package com.groupb.cuiz.web.member;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.web.member.role.RoleDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("delete")
	public String setDelete(MemberDTO dto, Model model,HttpSession session) throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO) session.getAttribute("member");
		dto.setMember_ID(memberDTO.getMember_ID());
		int result = memberService.setDelete(dto);
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("list")
	public String getList(MemberDTO dto,Model model) throws Exception{
		List<MemberDTO> ar = memberService.getList(dto);
		
		model.addAttribute("list", ar);
		
		return "member/list";
	}
	
	
	@GetMapping("join")
	public String setJoin() throws Exception {
	
		return ("member/join");
				
	}
	
	@GetMapping("nickcheck")
	public String setNickcheck(MemberDTO dto,Model model) throws Exception{
		int result = memberService.setNickcheck(dto);
		
		model.addAttribute("result", result);		
		
		return "/commons/ajaxResult";
	}
	
	@GetMapping("idcheck")
	public String setIdcheck(MemberDTO dto,Model model) throws Exception{
		int result = memberService.setIdcheck(dto);
		
		model.addAttribute("result", result);
		
		return "/commons/ajaxResult";
	}
	
	@PostMapping("join")
	public String setJoin( MemberDTO dto,Model model) throws Exception {
		System.out.println(dto);
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setMember_ID(dto.getMember_ID());
		int result = memberService.setJoin(dto);
		memberService.insertRole(roleDTO);
		
		model.addAttribute("msg", dto);
		
		return ("redirect:/member/login");
				
	}
	
	@GetMapping("logout")
	public String setLogOut(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/";
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
		 if(dto.getMember_Flag()!=0) {
			 model.addAttribute("msg", "회원탈퇴된 계정입니다.");
			 model.addAttribute("path", "/");
			 return "commons/result";
		 }
		 
		 
		 
		session.setAttribute("member", dto);
		//System.out.println( new String(dto.getMember_Profile_byte(), "UTF-8") );
		session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
		Map<String, Object> map = memberService.getAtendence(dto);
		int result = (int) map.get("result");
		dto = (MemberDTO)map.get("dto");
		
		if(result ==0) {
			model.addAttribute("msg", "출석 포인트 3점이 지급되었습니다.");
			model.addAttribute("path", "/");
		}
		else {
			return "redirect:/";
		}
		 
		return "commons/result";
	}
	
	@GetMapping("mypage")
	public String setMypage() throws Exception{
		return "member/mypage";
	}
	@GetMapping("update")
	public String setUpdate() throws Exception{
		return "member/update";
	}
	
	@PostMapping("update")
	public String setUpdate(HttpSession session,MemberDTO dto) throws Exception{
		int result = memberService.setUpdate(dto);
		
		if(result>0) {
		dto = memberService.getDetail(dto);
		}
		session.setAttribute("member", dto);
		session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(),StandardCharsets.UTF_8));
		
		return "redirect:/member/mypage";
	}
	
	@GetMapping("11")
	public String get(Model model) throws Exception{
		MemberDTO dto = memberService.get();
		model.addAttribute("msg", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
		
		return "member/temp";
	}
	
	@GetMapping("updateRole")
	public String setUpdateRole(Model model, MemberDTO dto) throws Exception{
		int result;
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setMember_ID(dto.getMember_ID());
		if(dto.getMember_Role().equals("MEMBER") ) {
			roleDTO.setRole_Num(200);
			memberService.deleteRole(roleDTO);
		}
		else {
			roleDTO.setRole_Num(100);
			memberService.insertRole(roleDTO);
		}
		result = memberService.setUpdateRole(dto);
		model.addAttribute("result", result);
		
		return "/commons/ajaxResult";
	}
	
}
