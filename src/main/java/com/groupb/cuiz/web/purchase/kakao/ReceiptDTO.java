package com.groupb.cuiz.web.purchase.kakao;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptDTO {
	
		private String member_ID;
		private Integer item_Num;
		private String cid; //가맹점코드
	    private String aid;
	    private String tid; //결제 고유번호
	    private String sid;
	    private String partner_order_id;
	    private String partner_user_id;
	    private String payment_method_type;
	    private String item_name;
	    private String item_code;
	    private Integer quantity;
	    private Date created_at;
	    private Date approved_at;
	    private Integer total;
	    private Integer tax_free;
	    private Integer vat;	
	    private Amount amount;
	    private String payload;
	    private Integer cancel_total;
	    private Integer cancel_tax_free;	    
	   
	    
	    
	    private Amount cancel_amount;	    
	    private Approved_cancel_amount approved_cancel_amount;
	    private card_info card_info;
	    
	
	    
	  
		public Integer getVat() {
			return vat;
		}
		public void setVat(Integer vat) {
			this.vat = vat;
		}
		public Integer getCancel_total() {
		return cancel_total;
		}
		public void setCancel_total(Integer cancel_total) {
			this.cancel_total = cancel_total;
		}
		public Integer getCancel_tax_free() {
			return cancel_tax_free;
		}
		public void setCancel_tax_free(Integer cancel_tax_free) {
			this.cancel_tax_free = cancel_tax_free;
		}
		public Amount getCancel_amount() {
			return cancel_amount;
		}
		public void setCancel_amount(Amount cancel_amount) {
			this.cancel_amount = cancel_amount;
		}
		public Approved_cancel_amount getApproved_cancel_amount() {
			return approved_cancel_amount;
		}
		public void setApproved_cancel_amount(Approved_cancel_amount approved_cancel_amount) {
			this.approved_cancel_amount = approved_cancel_amount;
		}
		public Integer getTax_free() {
			return tax_free;
		}
		public void setTax_free(Integer tax_free) {
			this.tax_free = tax_free;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
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
	    
	    public card_info getCard_info() {
			return card_info;
		}

		public void setCard_info(card_info card_info) {
			this.card_info = card_info;
		}

		public String getPayload() {
			return payload;
		}

		public void setPayload(String payload) {
			this.payload = payload;
		}

	public String getItem_code() {
			return item_code;
		}

		public void setItem_code(String item_code) {
			this.item_code = item_code;
		}

	public String getSid() {
			return sid;
		}

		public void setSid(String sid) {
			this.sid = sid;
		}

	public String getCid() {
			return cid;
		}

		public void setCid(String cid) {
			this.cid = cid;
		}

		public String getAid() {
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		public String getTid() {
			return tid;
		}

		public void setTid(String tid) {
			this.tid = tid;
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

		public String getPayment_method_type() {
			return payment_method_type;
		}

		public void setPayment_method_type(String payment_method_type) {
			this.payment_method_type = payment_method_type;
		}

		public String getItem_name() {
			return item_name;
		}

		public void setItem_name(String item_name) {
			this.item_name = item_name;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		

		public Date getCreated_at() {
			return created_at;
		}
		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}
		public Date getApproved_at() {
			return approved_at;
		}
		public void setApproved_at(Date approved_at) {
			this.approved_at = approved_at;
		}
		public Amount getAmount() {
			return amount;
		}

		public void setAmount(Amount amount) {
			this.amount = amount;
		}

	
		
		
	@JsonIgnoreProperties(ignoreUnknown = true)	
	public class Amount{
		
		private Integer total;
	    private Integer tax_free;
	    private Integer vat;
	    private Integer discount;
	    private Integer point;
	    private Integer green_deposit;	  
	    
	    
	    
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public Integer getTax_free() {
			return tax_free;
		}
		public void setTax_free(Integer tax_free) {
			this.tax_free = tax_free;
		}
		public Integer getVat() {
			return vat;
		}
		public void setVat(Integer vat) {
			this.vat = vat;
		}
		public Integer getDiscount() {
			return discount;
		}
		public void setDiscount(Integer discount) {
			this.discount = discount;
		}
		public Integer getPoint() {
			return point;
		}
		public void setPoint(Integer point) {
			this.point = point;
		}
		public Integer getGreen_deposit() {
			return green_deposit;
		}
		public void setGreen_deposit(Integer green_deposit) {
			this.green_deposit = green_deposit;
		}
	    
	    
		    
	    
	    
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	 public class Approved_cancel_amount {
		  
		  	private Integer total;
		    private Integer tax_free;
		    private Integer vat;
		    private Integer discount;
		    private Integer point;
		    private Integer green_deposit;
			
		    
		    
		    public Integer getTotal() {
				return total;
			}
			public void setTotal(Integer total) {
				this.total = total;
			}
			public Integer getTax_free() {
				return tax_free;
			}
			public void setTax_free(Integer tax_free) {
				this.tax_free = tax_free;
			}
			public Integer getVat() {
				return vat;
			}
			public void setVat(Integer vat) {
				this.vat = vat;
			}
			public Integer getDiscount() {
				return discount;
			}
			public void setDiscount(Integer discount) {
				this.discount = discount;
			}
			public Integer getPoint() {
				return point;
			}
			public void setPoint(Integer point) {
				this.point = point;
			}
			public Integer getGreen_deposit() {
				return green_deposit;
			}
			public void setGreen_deposit(Integer green_deposit) {
				this.green_deposit = green_deposit;
			}	  	    
		    
	  }
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class card_info{
		
		private String aid;
	    private String interest_free_install;
	    private String bin;
	    private String card_type;
	    private String card_mid;
	    private String card_item_code;
	    private String approved_id;
	    private String install_month;
	    private String installment_type;
	    private String kakaopay_purchase_corp;
	    private String kakaopay_purchase_corp_code;
	    private String kakaopay_issuer_corp;
	    private String kakaopay_issuer_corp_code;
	    
	    
	    
	    
	    
		
		public String getAid() {
			return aid;
		}
		public void setAid(String aid) {
			this.aid = aid;
		}
		public String getCard_item_code() {
			return card_item_code;
		}
		public void setCard_item_code(String card_item_code) {
			this.card_item_code = card_item_code;
		}
		public String getInterest_free_install() {
			return interest_free_install;
		}
		public void setInterest_free_install(String interest_free_install) {
			this.interest_free_install = interest_free_install;
		}
		public String getBin() {
			return bin;
		}
		public void setBin(String bin) {
			this.bin = bin;
		}
		public String getCard_type() {
			return card_type;
		}
		public void setCard_type(String card_type) {
			this.card_type = card_type;
		}
		public String getCard_mid() {
			return card_mid;
		}
		public void setCard_mid(String card_mid) {
			this.card_mid = card_mid;
		}
		public String getApproved_id() {
			return approved_id;
		}
		public void setApproved_id(String approved_id) {
			this.approved_id = approved_id;
		}
		public String getInstall_month() {
			return install_month;
		}
		public void setInstall_month(String install_month) {
			this.install_month = install_month;
		}
		public String getInstallment_type() {
			return installment_type;
		}
		public void setInstallment_type(String installment_type) {
			this.installment_type = installment_type;
		}
		public String getKakaopay_purchase_corp() {
			return kakaopay_purchase_corp;
		}
		public void setKakaopay_purchase_corp(String kakaopay_purchase_corp) {
			this.kakaopay_purchase_corp = kakaopay_purchase_corp;
		}
		public String getKakaopay_purchase_corp_code() {
			return kakaopay_purchase_corp_code;
		}
		public void setKakaopay_purchase_corp_code(String kakaopay_purchase_corp_code) {
			this.kakaopay_purchase_corp_code = kakaopay_purchase_corp_code;
		}
		public String getKakaopay_issuer_corp() {
			return kakaopay_issuer_corp;
		}
		public void setKakaopay_issuer_corp(String kakaopay_issuer_corp) {
			this.kakaopay_issuer_corp = kakaopay_issuer_corp;
		}
		public String getKakaopay_issuer_corp_code() {
			return kakaopay_issuer_corp_code;
		}
		public void setKakaopay_issuer_corp_code(String kakaopay_issuer_corp_code) {
			this.kakaopay_issuer_corp_code = kakaopay_issuer_corp_code;
		}	    
		
	    
		
	}
	
}