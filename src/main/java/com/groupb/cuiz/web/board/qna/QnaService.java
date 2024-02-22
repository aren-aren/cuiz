package com.groupb.cuiz.web.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.board.BoardDTO;
import com.groupb.cuiz.web.board.BoardService;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	
//	@Autowired
//	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		Long totalCount = qnaDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return qnaDAO.getList(pager);
	}

	@Override
	public int getAdd(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		// TODO Auto-generated method stub
		
		
		String path = servletContext.getRealPath("resources/upload/qna");
		
//		for(MultipartFile f :attachs) {
//			if (f.isEmpty()) {
//				continue;
//				
//			}
//			
//			String fileName = fileManager.fileSave(path, f);
//			
//			BoardFileDTO boardFileDTO =new BoardFileDTO();
//			boardFileDTO.setFile_Name(fileName);
//			boardFileDTO.setOri_Name(f.getOriginalFilename());
//			boardFileDTO.setBoard_Num(boardDTO.getBoard_Num());
			
//			result = qnaDAO.getFileAdd(boardFileDTO);
//		}
		int result = qnaDAO.getAdd(boardDTO);
		
		return result;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int getUpdate(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getUpdate(boardDTO);
	}

	@Override
	public int getDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
//		List<BoardFileDTO> files = qnaDAO.getFileList(boardDTO);
		
//		String path = servletContext.getRealPath("/resources/upload/qna");
		
//		for(BoardFileDTO b: files) {
//			fileManager.fileDelete(path, b.getFile_Name());
			
//		}
		
//		int result = qnaDAO.getFileDelete(boardDTO);
		
		int result = qnaDAO.getDelete(boardDTO);
		
		return result;
	}

}
