package com.groupb.cuiz.web.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.groupb.cuiz.web.quiz.QuizDTO;
import com.groupb.cuiz.web.ranking.RankingDAO;
import com.groupb.cuiz.web.ranking.RankingDTO;

public class DailyRanking {
	
	
		@Autowired
		private RankingDAO dao;
	
		public List<RankingDTO> daily_Ranking() throws Exception {
				
				// 테이블 비우기
				dao.setDelete();
				
				// 문제 풀은 기록있는 사람들 찾기
				List<RankingDTO> ar = dao.getAnswerID();
				
				//
				List<RankingDTO> result = new ArrayList<RankingDTO>();
				for(RankingDTO dto : ar) {
					int jumsu = 0;
					System.out.println(dto.getMember_ID());
					dao.setInsert(dto);
					List<QuizDTO> quizNO = dao.getQuizNO(dto);
						for(QuizDTO quizDTO : quizNO) {
							jumsu += dao.getJumsu(quizDTO);
						}
					dto.setDaily_Jumsu(jumsu);
					dao.setJumsu(dto);
				}
				
				result = dao.getRanking();
				
				for(RankingDTO dto:result) {
					RankingDTO rankingDTO = dao.getNick(dto);
					dto.setMember_Nick(rankingDTO.getMember_Nick());
					dao.setNick(dto);
				}
				
				
				return result;
			}
}
