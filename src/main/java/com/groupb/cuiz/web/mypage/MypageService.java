package com.groupb.cuiz.web.mypage;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.cuiz.web.item.ItemDTO;
import com.groupb.cuiz.web.member.MemberDTO;
import com.groupb.cuiz.web.quiz.MemberAnswerDTO;

@Service
public class MypageService {

	@Autowired
	private MypageDAO mypageDAO;
	
	
	public MemberDTO temp(MemberDTO memberDTO) {
		
		
		return mypageDAO.temp(memberDTO);
		
	}
	
	public List<ItemDTO> getList(MemberDTO memberDTO){
		
		return mypageDAO.getList(memberDTO);
		
	}
	
//	sang
	public Map<String, Object> getCount(MemberDTO dto) throws Exception{
		List<YoursDTO> ar = mypageDAO.getCountAnswer(dto);
			
		
		Map<String,Object> map = new HashMap<String, Object>();
		for(YoursDTO yoursDTO : ar) {
			System.out.println("date = " + yoursDTO.getA_Date());
			System.out.println("count = " + yoursDTO.getQ_Count());
			map.put(yoursDTO.getA_Date(), yoursDTO.getQ_Count());
		}
		
		return map;
	}
	
	
}
