package com.groupb.cuiz.web.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop/*")
public class ItemContoller {

	@Autowired
	private ItemService itemService;
	
	
	@GetMapping("list")
	public String getList(Model model) {
		
		
		List<ItemDTO> ar = itemService.getList(); 
		model.addAttribute("list", ar);
		
		return "/shop/list";
		
	}
	
	@GetMapping("detail")
	public String getDetail(Model model, ItemDTO itemDTO) {
		
		itemDTO = itemService.getDetail(itemDTO);
		
		model.addAttribute("dto", itemDTO);
		
		return "/shop/detail";
	}
	
	
	
	
}
