package com.groupb.cuiz.web.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getAtendence(MemberDTO dto) throws Exception{
		int result = dao.getAtendence(dto);
		int att = 0;
		if(result==0) {
			att = dao.setAtendence(dto);
				if(att==1) {
					dao.setCoin(dto);
				}
				int check = dao.getConatt(dto);
				System.out.println(check);
				if(check == 1) {
					dao.setConatt(dto);
					int conatt = dto.getMember_Conatt();
					if(conatt==7) {
						dto.setMember_Conatt(0);
						dto.setMember_Coin(dto.getMember_Coin()+10);
					}
					dto.setMember_Conatt(conatt+1);
					// 연속출석 하는중 일단은 +1 까지만 .. ? 
				}
				else {
					dto.setMember_Conatt(0);
					dao.setConatt(dto);
					dto.setMember_Conatt(1);
				}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("dto", dto);
		
		return map;
	}
	
}
