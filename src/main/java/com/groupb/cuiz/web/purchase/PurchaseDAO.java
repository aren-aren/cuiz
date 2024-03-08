package com.groupb.cuiz.web.purchase;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;
import com.groupb.cuiz.web.purchase.kakao.ReceiptDTO;

@Repository
public class PurchaseDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.groupb.cuiz.web.purchase.PurchaseDAO.";
	
	//영수증 확인
	
	public Map<String, Object> receiptDetail(ReceiptDTO receiptDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"receiptDetail", receiptDTO);
		
	}
	
	//결제내역 보기
	public List<ReceiptDTO> purchaseList(MemberDTO memberDTO) {
		
		return sqlSession.selectList(NAMESPACE+"purchaseList", memberDTO);
		
	}
	
	
	//kakaopay 환불
	
	public int kakaopayCancel(ReceiptDTO receiptDTO) {
		
		return sqlSession.update(NAMESPACE+"kakaopayCancel", receiptDTO);
		
	}
	
	
//	KAKAOPAY
	public int kakopaySuccess(ReceiptDTO receiptDTO) {
		
		return sqlSession.insert(NAMESPACE+"kakopaySuccess", receiptDTO);
		
	}
	
	public int kakopaySuccessCard(ReceiptDTO receiptDTO) {
		
		return sqlSession.insert(NAMESPACE+"kakopaySuccessCard", receiptDTO);
	}
	
	
	
	
	
	public List<ItemDTO> getList(PurchaseDTO purchaseDTO){
		
		return sqlSession.selectList(NAMESPACE+"getList", purchaseDTO);
		
	}
	
	public int buyItem(PurchaseDTO purchaseDTO) {
		
	  return sqlSession.insert(NAMESPACE+"buyItem", purchaseDTO);
		
	}
	
	public long check(PurchaseDTO purchaseDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"check", purchaseDTO);
	}
	
}
