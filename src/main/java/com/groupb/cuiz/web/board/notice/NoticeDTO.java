package com.groupb.cuiz.web.board.notice;

import java.util.List;

import com.groupb.cuiz.web.board.BoardDTO;

public class NoticeDTO extends BoardDTO{
	
	private List<BoardDTO> fileDTOs;
	
	

	public List<BoardDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

}
