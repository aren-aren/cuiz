package com.groupb.cuiz;


import java.util.List;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.quiz.QuizDTO;
import com.groupb.cuiz.web.quiz.QuizListDTO;
import com.groupb.cuiz.web.quiz.QuizService;
import com.groupb.cuiz.web.statistic.StatisticDTO;
import com.groupb.cuiz.web.statistic.StatisticService;
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

	@Autowired
	private QuizService quizService;
	@Autowired
	private StatisticService statisticService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {

		List<RankingDTO> ar = service.getList();
		List<QnaDTO> ar2 = service.getQNAList();

		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.setSort("3");

		List<QuizListDTO> quizs = quizService.getList(pager);

		model.addAttribute("list", ar);
		model.addAttribute("list2", ar2);
		model.addAttribute("quizs", quizs);

		StatisticDTO statisticDTO = statisticService.getMainStatistic();

		model.addAttribute("statistic", statisticDTO);

		return "index";
	}
	
	

	
}
