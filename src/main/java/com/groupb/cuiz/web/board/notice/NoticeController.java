package com.groupb.cuiz.web.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.board.BoardService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;
	
	//delete
	@PostMapping("delete")
	public String getDelete(BoardDTO boardDTO)throws Exception{
		int result = boardService.getDelete(boardDTO);
		return "redirect:./list";
	}
	
	//update
	@GetMapping("update")
	public String getUpdate(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/update";
		
	}
	@PostMapping("update")
	public String getUpdate(BoardDTO boardDTO, MultipartFile[]attachs)throws Exception{
		int result = boardService.getUpdate(boardDTO, attachs);
		return "redirect:./detail?boardNum="+boardDTO.getBoard_Num();
	}
	
	//add
	@GetMapping("add")
	public String getAdd()throws Exception{
		return "board/add";

	}
	@PostMapping("add")
	public String getAdd(BoardDTO boardDTO, MultipartFile [] attachs)throws Exception{
		int result = boardService.getAdd(boardDTO, attachs);
		return "redirect:./list";
	}
	
	
	//detail
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	
	//list
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}

}
