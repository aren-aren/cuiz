package com.groupb.cuiz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public int setJoin(MemberDTO dto) throws Exception{
		return dao.SetJoin(dto);
	}
	
}
