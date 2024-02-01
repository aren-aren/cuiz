package com.groupb.cuiz.web.board;

import java.sql.Date;

public class BoardDTO {

	private Long board_Num;
	private String board_Title;
	private String board_Contents;
	private Date board_Date;
	private Long board_Hit;
	
	
	public Long getBoard_Num() {
		return board_Num;
	}
	public void setBoard_Num(Long board_Num) {
		this.board_Num = board_Num;
	}
	public String getBoard_Title() {
		return board_Title;
	}
	public void setBoard_Title(String board_Title) {
		this.board_Title = board_Title;
	}
	public String getBoard_Contents() {
		return board_Contents;
	}
	public void setBoard_Contents(String board_Contents) {
		this.board_Contents = board_Contents;
	}
	public Date getBoard_Date() {
		return board_Date;
	}
	public void setBoard_Date(Date board_Date) {
		this.board_Date = board_Date;
	}
	public Long getBoard_Hit() {
		return board_Hit;
	}
	public void setBoard_Hit(Long board_Hit) {
		this.board_Hit = board_Hit;
	}

	
	
}
