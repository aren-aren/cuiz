package com.groupb.cuiz.web.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.web.member.role.RoleDTO;

@Service
@Transactional(readOnly = true)
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	
	public MemberDTO get() throws Exception{
		return dao.get();
	}
	@Transactional
	public int setKakao(MemberDTO dto)throws Exception{
		int result = dao.setKakao(dto);
		result = dao.setDefaultRole(dto);
		return result;
	}
	public int getAll(MemberDTO dto) throws Exception{
		return dao.getAll(dto);
	}
	public MemberDTO getKakaoLogin(MemberDTO dto) throws Exception{
		return dao.getKakaoLogin(dto);
	}
	
	
	@Transactional
	public int setJoin(MemberDTO dto) throws Exception{
		dao.setDefaultRole(dto);
		
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
	@Transactional
	public int setUpdate(MemberDTO dto) throws Exception{
		return dao.setUpdate(dto);
	}
	@Transactional
	public int setNickcheck(MemberDTO dto) throws Exception{
		return dao.setNickcheck(dto);
	}
	@Transactional
	public int setIdcheck(MemberDTO dto) throws Exception{
		return dao.setIdcheck(dto);
		
	}
	@Transactional
	public int setUpdateRole(MemberDTO dto) throws Exception{
		return dao.setUpdateRole(dto);
	}
	@Transactional
	public int deleteRole(RoleDTO dto) throws Exception{
		return dao.deleteRole(dto);
	}
	@Transactional
	public int setDelete(MemberDTO dto) throws Exception{
		return dao.setDelete(dto);
	}
	@Transactional
	public int insertRole(RoleDTO dto) throws Exception{
		return dao.insertRole(dto);
	}
	
	public List<MemberDTO> getList(MemberDTO dto) throws Exception{
		return dao.getList(dto);
	}
	
	@Transactional
	public Map<String, Object> getAtendence(MemberDTO dto) throws Exception{
		int result = dao.getAtendence(dto);
		int att = 0;
		if(result==0) {
			att = dao.setAtendence(dto);
			
				if(att==1) {
					dao.setCoin(dto);
					dto.setMember_Coin(dto.getMember_Coin()+3);
					
				}
				int check = dao.getConatt(dto);
				System.out.println(check);
				if(check == 1) {
					dao.setConatt(dto);
					dto.setMember_Conatt(dto.getMember_Conatt()+1);
					int conatt = dto.getMember_Conatt();
					if(conatt==7) {
						dao.setBonus(dto);
						dto.setMember_Coin(dto.getMember_Coin()+10);
					}
					if(conatt==8) {
						dto.setMember_Conatt(0);
						dao.setConatt(dto);
						dto.setMember_Conatt(1);
					}
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
		map.put("conatt", dto.getMember_Conatt());
		map.put("dto", dto);
		
		return map;
	}
	
	

	
}
