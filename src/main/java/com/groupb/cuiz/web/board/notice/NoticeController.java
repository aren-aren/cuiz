package com.groupb.cuiz.web.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.board.BoardService;
import com.groupb.cuiz.web.member.MemberDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;

	@ModelAttribute("bbs")
	public Integer getKind() {
		return 0;
	}

	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}

	// delete
	@PostMapping("delete")
	public String getDelete(BoardDTO boardDTO) throws Exception {
		int result = boardService.getDelete(boardDTO);
		return "redirect:./list";
	}

	// update
	@GetMapping("update")
	public String getUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/update";

	}

	@PostMapping("update")
	public String getUpdate(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		int result = boardService.getUpdate(boardDTO, attachs);
		return "redirect:./detail?board_Num=" + boardDTO.getBoard_Num();
	}

	// add
	@GetMapping("add")
	public String getAdd() throws Exception {
		return "board/add";

	}

	@PostMapping("add")
	public String getAdd(BoardDTO boardDTO, MultipartFile[] attachs, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		boardDTO.setMember_ID(memberDTO.getMember_ID());
		 
		int result = boardService.getAdd(boardDTO, attachs);
		return "redirect:./list";
	}

	// detail
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("kind", "notice");
		
		return "board/detail";
	}

	// list
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
		// 상대경로 ( 내 기준으로 경로를 책정하는거에요)
		// localhost/notice/board/list
		// 현재 경로 localhost/notice
		// ../ >>>> localhost + board/list
		// 절대 경로 ( / 기준 )
		// ( / == localhost/ ) /board/list
		// localhost/board/list
	}

}
