package com.groupb.cuiz.web.mypage;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.cuiz.support.util.photo.PhotoEncoder;
import com.groupb.cuiz.web.item.ItemDAO;
import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;


@Service
public class MypageService {

	@Autowired
	private MypageDAO mypageDAO;
	@Autowired
	private PhotoEncoder photoEncoder;
	@Autowired
	private ItemDAO itemDAO;
	
	public List<ItemDTO> getList(MemberDTO memberDTO){
		
		return mypageDAO.getList(memberDTO);
		
	}
	
	
	public List<ItemDTO> mypageSet(MemberDTO memberDTO) {
		
		List<ItemDTO> ar = mypageDAO.mypageSet(memberDTO);
		if(ar!=null) {			
			ar = photoEncoder.ListToString(ar);
		}
		return ar;
		
		
	}
		
	
	public int mypageSetUpdate(MypageSetDTO mypageSetDTO) {
		
		System.out.println("mypage1");
		int check = mypageDAO.itemSetCheck(mypageSetDTO);		
		System.out.println("mypag2");
		if(check==0) {
			
			return mypageDAO.mypageSetNew(mypageSetDTO);
		
		}
		
		System.out.println("NUM - " + mypageSetDTO.getItem_Num());
		return mypageDAO.mypageSetUpdate(mypageSetDTO);
			
	}
	
	
	public ItemDTO mypageTemp(ItemDTO itemDTO) {
		
		return itemDAO.getDetail(itemDTO);
	}
	
	
	
//	sang
	public Map<String, Object> getCount(MemberDTO dto) throws Exception{
		List<YoursDTO> ar = mypageDAO.getCountAnswer(dto);
			
		
		Map<String,Object> map = new HashMap<String, Object>();
		for(YoursDTO yoursDTO : ar) {
			map.put(yoursDTO.getA_Date(), yoursDTO.getQ_Count());
		}
		
		return map;
	}
	
	public MemberDTO temp(MemberDTO memberDTO) {
		
		
		return mypageDAO.temp(memberDTO);
		
	}
	
	
}
