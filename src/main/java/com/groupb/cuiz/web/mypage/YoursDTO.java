package com.groupb.cuiz.web.mypage;

import org.springframework.stereotype.Component;

@Component
public class YoursDTO {

	private Integer q_Count;
	private String a_Date;
	
	public Integer getQ_Count() {
		return q_Count;
	}
	public void setQ_Count(Integer q_Count) {
		this.q_Count = q_Count;
	}
	public String getA_Date() {
		return a_Date;
	}
	public void setA_Date(String a_Date) {
		this.a_Date = a_Date;
	}
	
	
	
}
