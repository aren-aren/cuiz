package com.groupb.cuiz.web.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.member.role.RoleDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.groupb.cuiz.web.member.MemberDAO.";
	
	public int realDelete() throws Exception{
		return sqlSession.delete(namespace+"realDelete");
	}
	
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
	
	public List<MemberDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"getList",pager);
	}
	public List<MemberDTO> delete_list(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"delete_list",pager);
	}
	public Long getCommonTotalCount() throws Exception{
		return sqlSession.selectOne(namespace+"getCommonTotalCount");
	}
	public Long getDeleteTotalCount() throws Exception{
		return sqlSession.selectOne(namespace+"getDeleteTotalCount");
	}
	
	
	public int user_recovered(MemberDTO dto) throws Exception{
		return sqlSession.update(namespace+"user_recovered",dto);
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
	public int getAtendence(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getAtendence",dto);
	}
	public int setAtendence(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setAtendence",dto);
	}
	
	public int setCoin(MemberDTO dto) throws Exception{
		return sqlSession.update(namespace+"setCoin",dto);
	}
	public int setConatt(MemberDTO dto ) throws Exception{
		return sqlSession.update(namespace+"setConatt",dto);
	}
	public int getConatt(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getConatt",dto);
	}
	public int setBonus(MemberDTO dto) throws Exception{
		return sqlSession.update(namespace+"setBonus",dto);
	}
	
	public int setKakao(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setKakao",dto);
	}
	public int getAll(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getAll",dto);
	}
	public MemberDTO getKakaoLogin(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getKakaoLogin",dto);
	}
	public int setDefaultRole(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setDefaultRole",dto);
	}
	public int getKakaoNickCount(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getKakaoNickCount",dto);
	}
	public int setNaver(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setNaver",dto);
	}
	public int getNaver(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getNaver",dto);
	}
	public MemberDTO naver_login(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"naver_login",dto);
	}


	public int setJumsu(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(namespace + "setJumsu", memberDTO);
	}
	public int setTotalAtt(MemberDTO dto) throws Exception{
		return sqlSession.update(namespace+"setTotalAtt",dto);
	}

    public int buyTestcase(Map<String, Object> map) {
		return sqlSession.update(namespace + "buyTestcase", map);
    }
}
