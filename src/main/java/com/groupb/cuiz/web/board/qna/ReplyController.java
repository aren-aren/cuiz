package com.groupb.cuiz.web.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.member.MemberDTO;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	
	@GetMapping("add")
	public String getAdd()throws Exception{
		return "board/detail";
	}
	
	@PostMapping("add")
	public String getAdd(ReplyDTO replyDTO, HttpSession session, MultipartFile [] attachs)throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		replyDTO.setUser_Name(memberDTO.getMember_ID());
		
		int result = replyService.getAdd(replyDTO, attachs);		
		return "board/detail";
	}
	
	@PostMapping("list")
	public String getList(Pager pager ,Model model)throws Exception{
		List<ReplyDTO> ar = replyService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "ar";
		
	}

}
