package com.groupb.cuiz.web.board.qna;

import java.util.List;

import com.groupb.cuiz.support.util.file.FileDTO;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.quiz.QuizDTO;

public class QnaDTO extends BoardDTO{
	
		private Long board_Ref;
		private Long board_Step;
		private Long board_Depth;
		private Integer flag;
		private List<FileDTO> fileDTOs;
		private List<ReplyDTO> replyDTOs;
		private QuizDTO quizDTO;
		

		
		
		public List<ReplyDTO> getReplyDTOs() {
			return replyDTOs;
		}
		public void setReplyDTOs(List<ReplyDTO> replyDTOs) {
			this.replyDTOs = replyDTOs;
		}
		public Integer getFlag() {
			return flag;
		}
		public void setFlag(Integer flag) {
			this.flag = flag;
		}
		public List<FileDTO> getFileDTOs() {
			return fileDTOs;
		}
		public void setFileDTOs(List<FileDTO> fileDTOs) {
			this.fileDTOs = fileDTOs;
		}
		public Long getBoard_Ref() {
			return board_Ref;
		}
		public void setBoard_Ref(Long board_Ref) {
			this.board_Ref = board_Ref;
		}
		public Long getBoard_Step() {
			return board_Step;
		}
		public void setBoard_Step(Long board_Step) {
			this.board_Step = board_Step;
		}
		public Long getBoard_Depth() {
			return board_Depth;
		}
		public void setBoard_Depth(Long board_Depth) {
			this.board_Depth = board_Depth;
		}

	public QuizDTO getQuizDTO() {
		return quizDTO;
	}

	public void setQuizDTO(QuizDTO quizDTO) {
		this.quizDTO = quizDTO;
	}
}
