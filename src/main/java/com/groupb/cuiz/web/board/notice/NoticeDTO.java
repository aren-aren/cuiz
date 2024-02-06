package com.groupb.cuiz.web.board.notice;

import java.util.List;

import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	
	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	
	

}
