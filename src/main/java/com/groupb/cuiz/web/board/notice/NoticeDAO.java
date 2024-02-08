package com.groupb.cuiz.web.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDAO;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.board.BoardFileDTO;

@Repository("na")
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.groupb.cuiz.web.board.notice.NoticeDAO.";
	
	//totalCount
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getTotalCount",pager);
	}

	//list
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getList", pager);
	}

	//add
	@Override
	public int getAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"getAdd", boardDTO);
	}

	//detail
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getDetail", boardDTO);
	}

	//update
	@Override
	public int getUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"getUpdate", boardDTO);
	}

	//delete
	@Override
	public int getDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"getDelete", boardDTO);
	}

	public int getFileAdd(BoardFileDTO boardFileDTO) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"getFileAdd", boardFileDTO);
	}

	public List<BoardFileDTO> getFileList(BoardDTO boardDTO) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getFileList", boardDTO);
	}

}
