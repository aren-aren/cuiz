package com.groupb.cuiz.mypage;

import java.sql.Blob;

public class ItemDTO {
	
	private Integer product_Num;
	private String product_Name;
	private String product_Contents;
	private Integer product_Price;
	private Byte[] product_Photo;
	
	
	
	
	
	public Integer getProduct_Num() {
		return product_Num;
	}
	public void setProduct_Num(Integer product_Num) {
		this.product_Num = product_Num;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Contents() {
		return product_Contents;
	}
	public void setProduct_Contents(String product_Contents) {
		this.product_Contents = product_Contents;
	}
	public Integer getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(Integer product_Price) {
		this.product_Price = product_Price;
	}
	public Byte[] getProduct_Photo() {
		return product_Photo;
	}
	public void setProduct_Photo(Byte[] product_Photo) {
		this.product_Photo = product_Photo;
	}
	
	

}
