package com.groupb.cuiz.web.item;


public class ItemDTO {
	
	private Integer item_Num;
	private String item_Name;
	private String item_Contents;
	private Integer item_Price;
	private Byte[] item_Photo;
	private Integer flag;
	
	
	
	public Integer getItem_Num() {
		return item_Num;
	}
	public void setItem_Num(Integer item_Num) {
		this.item_Num = item_Num;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public String getItem_Contents() {
		return item_Contents;
	}
	public void setItem_Contents(String item_Contents) {
		this.item_Contents = item_Contents;
	}
	public Integer getItem_Price() {
		return item_Price;
	}
	public void setItem_Price(Integer item_Price) {
		this.item_Price = item_Price;
	}
	public Byte[] getItem_Photo() {
		return item_Photo;
	}
	public void setItem_Photo(Byte[] item_Photo) {
		this.item_Photo = item_Photo;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
	
	

}
