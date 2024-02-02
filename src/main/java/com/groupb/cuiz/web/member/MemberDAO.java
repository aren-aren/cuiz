package com.groupb.cuiz.web.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.web.member.role.RoleDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.groupb.cuiz.web.member.MemberDAO.";
	
	
	public int SetJoin(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setJoin",dto);
	}
	
	public MemberDTO get()throws Exception{
		return sqlSession.selectOne(namespace+"get");
	}
	
	public int setUpdate(MemberDTO dto) throws Exception{
		return sqlSession.update(namespace+"setUpdate",dto);
	}
	
	public int setNickcheck(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"setNickcheck",dto);
	}
	
	public MemberDTO getDetail(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",dto);
	}
	
	public int setIdcheck(MemberDTO dto)throws Exception {
		return sqlSession.selectOne(namespace+"setIdcheck",dto);
	}
	
	public List<MemberDTO> getList(MemberDTO dto) throws Exception{
		return sqlSession.selectList(namespace+"getList",dto);
	}
	
	public int setUpdateRole(MemberDTO dto) throws Exception{
		return sqlSession.update(namespace+"setUpdateRole",dto);
	}
	
	public int deleteRole(RoleDTO dto) throws Exception{
		return sqlSession.delete(namespace+"deleteRole",dto);
	}
	public int setDelete(MemberDTO dto )throws Exception{
		return sqlSession.update(namespace+"setDelete",dto);
	}
	
	public int insertRole(RoleDTO dto) throws Exception{
		return sqlSession.insert(namespace+"insertRole",dto);
	}
}
