package com.groupb.cuiz.web.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;

public interface BoardService {
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//add
	public int getAdd(BoardDTO boardDTO, MultipartFile [] attchs) throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//update
	public int getUpdate(BoardDTO boardDTO, MultipartFile [] attchs) throws Exception;
	
	//delete
	public int getDelete(BoardDTO boardDTO) throws Exception;




}
