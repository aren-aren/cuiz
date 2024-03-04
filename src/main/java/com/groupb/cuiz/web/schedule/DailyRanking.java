package com.groupb.cuiz.web.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.groupb.cuiz.web.quiz.QuizDTO;
import com.groupb.cuiz.web.quiz.QuizEnum;
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
				
				
				List<RankingDTO> result = new ArrayList<RankingDTO>();
				
				for(RankingDTO dto : ar) {
					int jumsu = 0;
					dao.setInsert(dto);
					//getQuizNO == 각 회원마다 정답인 문제 데이터들을 가져옵니다.
					List<QuizDTO> quizNO = dao.getQuizNO(dto);
						for(QuizDTO quizDTO : quizNO) {
							//getJumsu == 각 문제에 점수가 아닌 LEVEL을 가져옵니다
							int level = dao.getJumsu(quizDTO);
							//enum을 활용하여 각 문제에 레벨에 맞는 점수를 가져옵니다.
							QuizEnum e = QuizEnum.get(level);
							jumsu+= e.getJumsu();
							//이넘 활용해서 각 레벨 별 점수 가져오기
						}
						//최종 정산된 점수 배정
					dto.setDaily_Jumsu(jumsu);
					dao.setJumsu(dto);
					jumsu = 0;
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
