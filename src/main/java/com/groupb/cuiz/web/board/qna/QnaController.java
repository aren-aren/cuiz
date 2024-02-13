package com.groupb.cuiz.web.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.member.MemberDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}
	
	@ModelAttribute("board")
	public String getBoard(){
		return "QnA";
	}
	
	
	@GetMapping("list")
	public String getList(Pager pager, Model model)throws Exception {
		
		List<BoardDTO> ar = qnaService.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
		
	}
	
	@GetMapping("add")
	public String getAdd()throws Exception {
		
		return "board/add";
		
	}
	
	@PostMapping("add")
	public String getAdd(BoardDTO boardDTO, MultipartFile[] attachs, HttpSession session)throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		boardDTO.setMember_ID(memberDTO.getMember_ID());
		
		int result = qnaService.getAdd(boardDTO, attachs);
		return "redirect:./list";

	}
	
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("kind", "qna");
		return "board/detail";
		
	}
	
	@GetMapping("update")
	public String getUpdate(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO =qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/update";
		
	}
	
	@PostMapping("update")
	public String getUpdate(BoardDTO boardDTO, MultipartFile[] attachs)throws Exception {
		int result = qnaService.getUpdate(boardDTO, attachs);
		return "redirect:./list";

	}
	
	@PostMapping("delete")
	public String getDelete (BoardDTO boardDTO)throws Exception {
		int result = qnaService.getDelete(boardDTO);
		return "redirect:./list";
		
	}
	

}
