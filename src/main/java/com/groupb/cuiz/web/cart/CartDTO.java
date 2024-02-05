package com.groupb.cuiz.web.cart;

import java.sql.Date;

public class CartDTO {

	public Integer item_Num;
	public String member_ID;
	public Date add_Date;
	
	
	
	public Integer getItem_Num() {
		return item_Num;
	}
	public void setItem_Num(Integer item_Num) {
		this.item_Num = item_Num;
	}
	
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	public Date getAdd_Date() {
		return add_Date;
	}
	public void setAdd_Date(Date add_Date) {
		this.add_Date = add_Date;
	}
	@Override
	public String toString() {
		return "CartDTO [item_Num=" + item_Num + ", member_ID=" + member_ID + ", add_Date=" + add_Date + "]";
	}
	
	
	
	
}
