package com.groupb.cuiz.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class SecretKeyController {


	
	private String key123;

	public String getKey123() {
		return key123;
	}

	public void setKey123(String key123) {
		this.key123 = key123;
	}
	
	
	
	
}
