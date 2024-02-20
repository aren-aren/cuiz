package com.groupb.cuiz.web.purchase.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ResponseDTO {


	private String tid;
	private String tms_result;
	private String created_at;
	private String partner_order_id;
	private String partner_user_id = "CUIZ";
	private String next_redirect_pc_url;	
	private String next_redirect_mobile_url;
	private String next_redirect_app_url;
	private String android_app_scheme;
	private String ios_app_scheme;
	private String pg_token;
	private String response;
	private String htmlCode;
	private Integer item_Num;
 	
	

	public Integer getItem_Num() {
		return item_Num;
	}
	public void setItem_Num(Integer item_Num) {
		this.item_Num = item_Num;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getHtmlCode() {
		return htmlCode;
	}
	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}
	public String getPg_token() {
		return pg_token;
	}
	public void setPg_token(String pg_token) {
		this.pg_token = pg_token;
	}
	public String getPartner_order_id() {
		return partner_order_id;
	}
	public void setPartner_order_id(String partner_order_id) {
		this.partner_order_id = partner_order_id;
	}
	public String getPartner_user_id() {
		return partner_user_id;
	}
	public void setPartner_user_id(String partner_user_id) {
		this.partner_user_id = partner_user_id;
	}
	public String getIos_app_scheme() {
		return ios_app_scheme;
	}
	public void setIos_app_scheme(String ios_app_scheme) {
		this.ios_app_scheme = ios_app_scheme;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTms_result() {
		return tms_result;
	}
	public void setTms_result(String tms_result) {
		this.tms_result = tms_result;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	public String getNext_redirect_mobile_url() {
		return next_redirect_mobile_url;
	}
	public void setNext_redirect_mobile_url(String next_redirect_mobile_url) {
		this.next_redirect_mobile_url = next_redirect_mobile_url;
	}
	public String getNext_redirect_app_url() {
		return next_redirect_app_url;
	}
	public void setNext_redirect_app_url(String next_redirect_app_url) {
		this.next_redirect_app_url = next_redirect_app_url;
	}
	public String getAndroid_app_scheme() {
		return android_app_scheme;
	}
	public void setAndroid_app_scheme(String android_app_scheme) {
		this.android_app_scheme = android_app_scheme;
	}
	
	
	
	
	
	
}
