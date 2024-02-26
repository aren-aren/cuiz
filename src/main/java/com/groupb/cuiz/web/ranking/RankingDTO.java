package com.groupb.cuiz.web.ranking;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class RankingDTO {

	private Integer ranking_num;
	private String member_ID;
	private Integer daily_Jumsu;
	private String member_Nick;
	private byte[] member_Profile_Blob;
	
	
	
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

	public byte[] getMember_Profile_Blob() {
		return member_Profile_Blob;
	}

	public void setMember_Profile_Blob(byte[] member_Profile_Blob) {
		this.member_Profile_Blob = member_Profile_Blob;
	}

	public String getMember_Profile_String(){
		if(member_Profile_Blob == null){
			return null;
		}

		return new String(member_Profile_Blob, StandardCharsets.UTF_8);
	}

	@Override
	public String toString() {
		return "RankingDTO{" +
				"ranking_num=" + ranking_num +
				", member_ID='" + member_ID + '\'' +
				", daily_Jumsu=" + daily_Jumsu +
				", member_Nick='" + member_Nick + '\'' +
				", member_Profile_Blob=" + Arrays.toString(member_Profile_Blob) +
				'}';
	}
}
