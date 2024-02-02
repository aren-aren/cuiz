package com.groupb.cuiz.web.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.web.member.role.RoleDTO;

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
		if(memberDTO!=null) {
			return memberDTO;
		}
		
		return null;
	}
	
	public int setUpdate(MemberDTO dto) throws Exception{
		return dao.setUpdate(dto);
	}
	
	public int setNickcheck(MemberDTO dto) throws Exception{
		return dao.setNickcheck(dto);
	}
	
	public int setIdcheck(MemberDTO dto) throws Exception{
		return dao.setIdcheck(dto);
		
	}

	public int setUpdateRole(MemberDTO dto) throws Exception{
		return dao.setUpdateRole(dto);
	}
	
	public int deleteRole(RoleDTO dto) throws Exception{
		return dao.deleteRole(dto);
	}
	public int setDelete(MemberDTO dto) throws Exception{
		return dao.setDelete(dto);
	}
	public int insertRole(RoleDTO dto) throws Exception{
		return dao.insertRole(dto);
	}
	
	public List<MemberDTO> getList(MemberDTO dto) throws Exception{
		return dao.getList(dto);
	}
}
