package com.groupb.cuiz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public MemberDTO get() throws Exception{
		return dao.get();
	}
	
	public int setJoin(MemberDTO dto) throws Exception{
		return dao.SetJoin(dto);
	}
	public MemberDTO getDetail(MemberDTO dto) throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = dao.getDetail(dto);

        return memberDTO;
    }
}
