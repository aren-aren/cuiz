package com.groupb.cuiz.web.board.qna;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.groupb.cuiz.web.quiz.MemberAnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.member.MemberDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@Inject
	private ReplyService replyService;

	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}

	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}

	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {

		List<BoardDTO> ar = qnaService.getList(pager);

		System.out.println("list : " + ar.size());

		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);

		return "board/list";

	}

	@GetMapping("add")
	public String getAdd() throws Exception {

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
	public ModelAndView getDetail(BoardDTO boardDTO, ModelAndView mv, Model model, Pager pager) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		model.addAttribute("kind", "qna");
		mv.setViewName("board/detail");


		ReplyDTO replyDTO = new ReplyDTO();
		replyDTO.setBoard_Num(boardDTO.getBoard_Num());
		List<ReplyDTO> replyList = replyService.getList(pager, replyDTO);
		
		System.out.println("start = " +  pager.getStartNum());
		
		mv.addObject("pager", pager);
		mv.addObject("replyList", replyList);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       

		return mv;

	}

	@GetMapping("update")
	public String getUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/update";

	}

	@PostMapping("update")
	public String getUpdate(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		int result = qnaService.getUpdate(boardDTO, attachs);
		return "redirect:./list";

	}

	@PostMapping("delete")
	public String getDelete(QnaDTO boardDTO) throws Exception {
		boardDTO.setFlag(1);
		int result = qnaService.getDelete(boardDTO);
		return "redirect:./list";

	}

}