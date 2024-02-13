package com.groupb.cuiz.web.board;

import java.util.List;

import com.groupb.cuiz.support.util.pager.Pager;

public interface BoardDAO {
	
	//totalCount
	public Long getTotalCount(Pager pager)throws Exception;
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//add
	public int getAdd(BoardDTO boardDTO) throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//update
	public int getUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int getDelete(BoardDTO boardDTO) throws Exception;

}
