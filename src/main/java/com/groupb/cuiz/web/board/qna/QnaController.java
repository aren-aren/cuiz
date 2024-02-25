package com.groupb.cuiz.web.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.groupb.cuiz.web.quiz.MemberAnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.member.MemberDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private ReplyService replyService;
	
	
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
		
		System.out.println("list : " + ar.size());
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
		
	}
	
	@GetMapping("add")
	public String getAdd()throws Exception {
		
		return "board/add";
		
	}
	
	@PostMapping("add")
	public String getAdd(QnaDTO qnaDTO, MemberAnswerDTO answerDTO, MultipartFile[] attachs, HttpSession session)throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setMember_ID(memberDTO.getMember_ID());
		qnaDTO.setAnswerDTO(answerDTO);

		int result = qnaService.getAdd(qnaDTO, attachs);
		return "redirect:./list";

	}
	
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("kind", "qna");
		
		//처음 가지고 올 때만 댓글 목록도 조회
		/*
		 * ReplyDTO replyDTO = new ReplyDTO(); Pager pager = new Pager();
		 * replyDTO.setBoard_Num(boardDTO.getBoard_Num()); List<ReplyDTO> replyList =
		 * replyService.getList(pager);

		 * model.addAttribute("pager", pager); model.addAttribute("replyList",
		 * replyList);
		 */
		
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
	public String getDelete (QnaDTO boardDTO)throws Exception {
		boardDTO.setFlag(1);
		int result = qnaService.getDelete(boardDTO);
		return "redirect:./list";
		
	}
}
