package com.groupb.cuiz.web.board.qna;

import java.sql.Date;
public class ReplyDTO {
	
	private Long reply_Num;
	private Long board_Num;
	private String member_Nick;
	private String user_Name;
	private String reply_Contents;
	private Date reply_Date;
	

	
	public String getMember_Nick() {
		return member_Nick;
	}
	public void setMember_Nick(String member_Nick) {
		this.member_Nick = member_Nick;
	}
	public Long getReply_Num() {
		return reply_Num;
	}
	public void setReply_Num(Long reply_Num) {
		this.reply_Num = reply_Num;
	}
	public Long getBoard_Num() {
		return board_Num;
	}
	public void setBoard_Num(Long board_Num) {
		this.board_Num = board_Num;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getReply_Contents() {
		return reply_Contents;
	}
	public void setReply_Contents(String reply_Contents) {
		this.reply_Contents = reply_Contents;
	}
	public Date getReply_Date() {
		return reply_Date;
	}
	public void setReply_Date(Date reply_Date) {
		this.reply_Date = reply_Date;
	}

	

	

}
