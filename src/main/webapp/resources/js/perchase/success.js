cid	//String	O	가맹점 코드, 10자

partner_order_id	//String	O	가맹점 주문번호, 최대 100자
partner_user_id	//String	O	가맹점 회원 id, 최대 100자
item_name	//String	O	상품명, 최대 100자

quantity	//Integer	O	상품 수량
total_amount	//Integer	O	상품 총액


//tax_free_amount	//Integer	O	상품 비과세 금액
//
//값을 보내지 않을 경우 다음과 같이 VAT 자동 계산
//(상품총액 - 상품 비과세 금액)/11 : 소숫점 이하 반올림

approval_url//	String	O	결제 성공 시 redirect url, 최대 255자
cancel_url	//String	O	결제 취소 시 redirect url, 최대 255자
fail_url	//String	O	결제 실패 시 redirect url, 최대 255자

