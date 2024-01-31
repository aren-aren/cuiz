package com.groupb.cuiz.mypage;

import java.sql.Date;

public class Purchase_ListDTO {


	public Integer Item_Num;
	public Integer member_ID;
	public Date pl_List;
	
	
	
	
	
	
	public Integer getItem_Num() {
		return Item_Num;
	}
	public void setItem_Num(Integer item_Num) {
		Item_Num = item_Num;
	}
	public Integer getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(Integer member_ID) {
		this.member_ID = member_ID;
	}
	public Date getPl_List() {
		return pl_List;
	}
	public void setPl_List(Date pl_List) {
		this.pl_List = pl_List;
	}
	
	
	
	
}
