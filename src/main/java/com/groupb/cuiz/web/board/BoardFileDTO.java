package com.groupb.cuiz.web.board;

import com.groupb.cuiz.support.util.file.FileDTO;

public class BoardFileDTO extends FileDTO{
	
	private Long board_Num;
	
	private BoardDTO boardDTO;
	
	

	public Long getBoard_Num() {
		return board_Num;
	}

	public void setBoard_Num(Long board_Num) {
		this.board_Num = board_Num;
	}

	public BoardDTO getBoardDTO() {
		return boardDTO;
	}

	public void setBoardDTO(BoardDTO boardDTO) {
		this.boardDTO = boardDTO;
	}
	
	

}
