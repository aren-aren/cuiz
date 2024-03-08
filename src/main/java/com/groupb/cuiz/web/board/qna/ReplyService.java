package com.groupb.cuiz.web.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.cuiz.support.util.pager.Pager;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	

	public List<ReplyDTO> getList(Pager pager, ReplyDTO replyDTO) throws Exception {
		// TODO Auto-generated method stub
		pager.setPerPage(5L);
		pager.makeRow();
		
		pager.makeNum(replyDAO.getTotalCount(replyDTO));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pager", pager);
		map.put("replyDTO", replyDTO);
		
		return replyDAO.getList(map);
	}
	

	public int getAdd(ReplyDTO replyDTO) throws Exception{
		// TODO Auto-generated method stub
		
		int result = replyDAO.getAdd(replyDTO);
		
		return result;
		
	}
		
	public int getDelete(ReplyDTO replyDTO) throws Exception{
		// TODO Auto-generated method stub
		
		int result = replyDAO.getDelete(replyDTO);
		
		return result;

	}

}