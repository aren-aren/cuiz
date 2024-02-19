package com.groupb.cuiz.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class tempController {

	
	@Autowired
	private SecretKeyController key;
	
	
	@GetMapping("key")
	public String getKey(Model model) throws Exception {
		String keyValue = key.getKey123();
		model.addAttribute("result", keyValue);
		System.out.println("key = " +keyValue);
		return "/commons/ajaxResult"; 
		
	}
}
