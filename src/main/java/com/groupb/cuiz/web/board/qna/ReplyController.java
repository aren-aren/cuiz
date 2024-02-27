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
	
	@PostMapping("delete")
	public String getDelete(ReplyDTO replyDTO,Model model) throws Exception {
		int result = replyService.getDelete(replyDTO);
		System.out.println(replyDTO.getReply_Num());
		System.out.println("delete controller 진입");
		model.addAttribute("num",replyDTO.getBoard_Num());
		
		return "reply/delete";
	
	}
	
	
	@GetMapping("add")
	public String getAdd()throws Exception{
		return "board/detail";
	}
	
	@PostMapping("add")
	public String getAdd(ReplyDTO replyDTO, HttpSession session, Model model, Pager pager)throws Exception{
		
		System.out.println("reply_Contents = "+ replyDTO.getReply_Contents( ));
		System.out.println("board_num = " + replyDTO.getBoard_Num());
		System.out.println("user_Name = " + replyDTO.getUser_Name());
		
		int result = replyService.getAdd(replyDTO);	
		
		model.addAttribute("result", result);
		
		List<ReplyDTO> ar = replyService.getList(pager, replyDTO);
		model.addAttribute("list", ar);
		
		return "/commons/ajaxResult";
	}
	
	@PostMapping("list")
	public String getList(Pager pager , ReplyDTO replyDTO, Model model)throws Exception{
		List<ReplyDTO> ar = replyService.getList(pager, replyDTO);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "ar";
		
	}

}