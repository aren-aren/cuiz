package com.groupb.cuiz.web.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private ServletContext servletContext;

	public List<ReplyDTO> getList(Pager pager, ReplyDTO replyDTO) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		
		pager.makeNum(replyDAO.getTotalCount(replyDTO));
		
		return replyDAO.getList(pager);
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