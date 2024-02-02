package com.groupb.cuiz.web.item;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class ItemDTO {
	
	private Integer item_Num;
	private String item_Name;
	private String item_Contents;
	private Integer item_Price;
	private byte[] item_Photo;		
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
	public byte[] getItem_Photo(byte[] photo) {		
		
		return item_Photo;
	}
	public void setItem_Photo(byte[] item_Photo) throws IOException {	
		
		this.item_Photo = item_Photo;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "ItemDTO [item_Num=" + item_Num + ", item_Name=" + item_Name + ", item_Contents=" + item_Contents
				+ ", item_Price=" + item_Price + ", item_Photo=" + Arrays.toString(item_Photo) + ", flag=" + flag + "]";
	}
	
	
	
	

}
