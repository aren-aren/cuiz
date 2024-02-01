package com.groupb.cuiz.member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Date;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {

	private String member_ID;
	private String member_Password;
	private byte [] member_Token;
	private String member_Email;
	private Integer member_Flag;
	private Integer member_Jumsu;
	private MultipartFile member_Profile;
	private byte [] member_Profile_Blob;
	private String member_Nick;
	private String member_Role;
	private Integer member_Coin;
	private String member_PhoneNumber;
	private Date member_RegDate;
	private Date member_DelDate;
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	public String getMember_Password() {
		return member_Password;
	}
	public void setMember_Password(String member_Password) {
		this.member_Password = member_Password;
	}
	
	public String getMember_Email() {
		return member_Email;
	}
	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}
	public Integer getMember_Flag() {
		return member_Flag;
	}
	public void setMember_Flag(Integer member_Flag) {
		this.member_Flag = member_Flag;
	}
	public Integer getMember_Jumsu() {
		return member_Jumsu;
	}
	public void setMember_Jumsu(Integer member_Jumsu) {
		this.member_Jumsu = member_Jumsu;
	}
	
	public String getMember_Nick() {
		return member_Nick;
	}
	public void setMember_Nick(String member_Nick) {
		this.member_Nick = member_Nick;
	}
	public String getMember_Role() {
		return member_Role;
	}
	public void setMember_Role(String member_Role) {
		this.member_Role = member_Role;
	}
	public Integer getMember_Coin() {
		return member_Coin;
	}
	public void setMember_Coin(Integer member_Coin) {
		this.member_Coin = member_Coin;
	}
	public String getMember_PhoneNumber() {
		return member_PhoneNumber;
	}
	public void setMember_PhoneNumber(String member_PhoneNumber) {
		this.member_PhoneNumber = member_PhoneNumber;
	}
	public Date getMember_RegDate() {
		return member_RegDate;
	}
	public void setMember_RegDate(Date member_RegDate) {
		this.member_RegDate = member_RegDate;
	}
	public Date getMember_DelDate() {
		return member_DelDate;
	}
	public void setMember_DelDate(Date member_DelDate) {
		this.member_DelDate = member_DelDate;
	}
	public byte[] getMember_Token() {
		return member_Token;
	}
	public void setMember_Token(byte[] member_Token) {
		this.member_Token = member_Token;
	}
	public MultipartFile getMember_Profile() {
		return member_Profile;
	}
	public void setMember_Profile(MultipartFile member_Profile) throws IOException {
		this.member_Profile = member_Profile;
		this.member_Profile_Blob = Base64.getEncoder().encode(member_Profile.getBytes());
		System.out.println(new String(member_Profile_Blob, StandardCharsets.UTF_8));
	}
	public byte[] getMember_Profile_Blob() throws UnsupportedEncodingException {
		return member_Profile_Blob;
	}

	
	public void setMember_Profile_Blob(byte[] member_Profile_Blob) {
		this.member_Profile_Blob = member_Profile_Blob;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_ID=" + member_ID + ", member_Password=" + member_Password + ", member_Token="
				+ Arrays.toString(member_Token) + ", member_Email=" + member_Email + ", member_Flag=" + member_Flag
				+ ", member_Jumsu=" + member_Jumsu + ", member_Profile=" + member_Profile + ", member_Profile_Blob="
				+ Arrays.toString(member_Profile_Blob) + ", member_Nick=" + member_Nick + ", member_Role=" + member_Role
				+ ", member_Coin=" + member_Coin + ", member_PhoneNumber=" + member_PhoneNumber + ", member_RegDate="
				+ member_RegDate + ", member_DelDate=" + member_DelDate + "]";
	}
	

	
	
	
	
	
}
