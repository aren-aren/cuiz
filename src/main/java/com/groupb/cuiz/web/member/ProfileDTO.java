package com.groupb.cuiz.web.member;

//kakao에서 정보를 매개변수로 받기 위함.

public class ProfileDTO {
	private String nickname;
	private String profile_image_url;
	private String account_Email;
	
	
	public String getAccount_Email() {
		return account_Email;
	}
	public void setAccount_Email(String account_Email) {
		this.account_Email = account_Email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile_image_url() {
		return profile_image_url;
	}
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	
}
