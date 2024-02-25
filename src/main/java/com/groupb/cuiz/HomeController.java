package com.groupb.cuiz;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupb.cuiz.web.board.qna.QnaDTO;
import com.groupb.cuiz.web.ranking.RankingDTO;
import com.groupb.cuiz.web.ranking.RankingService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Autowired
	private RankingService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
	
		List<RankingDTO> ar = service.getList();
		List<QnaDTO> ar2 = service.getQNAList();
		model.addAttribute("list", ar);
		model.addAttribute("list2", ar2);
		return "index";
	}
	
	

	
}
