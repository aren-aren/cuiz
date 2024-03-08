package com.groupb.cuiz.web.ranking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.cuiz.web.board.qna.QnaDTO;
import com.groupb.cuiz.web.quiz.QuizDTO;

@Service
public class RankingService {
	
	@Autowired
	private RankingDAO dao;
	
	
	
	public List<RankingDTO> getList() throws Exception{
		List<RankingDTO> ar = new ArrayList<RankingDTO>();
		
		ar = dao.getList();
		
		return ar;
	}
	
	
	public List<QnaDTO> getQNAList() throws Exception{
		return dao.getQNAList();
		
	}
	
}
