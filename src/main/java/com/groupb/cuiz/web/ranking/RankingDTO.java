package com.groupb.cuiz.web.ranking;

public class RankingDTO {

	private Integer ranking_num;
	private String member_ID;
	private Integer daily_Jumsu;
	private String member_Nick;
	
	
	
	public String getMember_Nick() {
		return member_Nick;
	}
	public void setMember_Nick(String member_Nick) {
		this.member_Nick = member_Nick;
	}
	public Integer getRanking_num() {
		return ranking_num;
	}
	public void setRanking_num(Integer ranking_num) {
		this.ranking_num = ranking_num;
	}
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	public Integer getDaily_Jumsu() {
		return daily_Jumsu;
	}
	public void setDaily_Jumsu(Integer daily_Jumsu) {
		this.daily_Jumsu = daily_Jumsu;
	}
	
	
	
}
