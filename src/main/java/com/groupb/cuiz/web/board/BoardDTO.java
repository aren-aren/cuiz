package com.groupb.cuiz.web.board;

import java.sql.Timestamp;

public class BoardDTO {

	private Long board_Num;
	private String board_Title;
	private String member_ID;
	private String member_Nick;
	private String board_Contents;
	private Timestamp board_Date;
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
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public String getMember_Nick() {
		return member_Nick;
	}

	public void setMember_Nick(String member_Nick) {
		this.member_Nick = member_Nick;
	}

	public String getBoard_Contents() {
		return board_Contents;
	}
	public void setBoard_Contents(String board_Contents) {
		this.board_Contents = board_Contents;
	}

	public Timestamp getBoard_Date() {
		return board_Date;
	}

	public void setBoard_Date(Timestamp board_Date) {
		this.board_Date = board_Date;
	}

	public Long getBoard_Hit() {
		return board_Hit;
	}
	public void setBoard_Hit(Long board_Hit) {
		this.board_Hit = board_Hit;
	}


	
	
}
