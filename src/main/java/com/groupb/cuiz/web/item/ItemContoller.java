package com.groupb.cuiz.web.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import oracle.jdbc.proxy.annotation.Post;

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
	
	@GetMapping("add")
	public String setItem() {
		
		return "/shop/add";
		
	}
	
	@PostMapping("add")
	public void setItem(ItemDTO itemDTO ) {
		
		int result = itemService.setItem(itemDTO);
		
		System.out.println(result);
		
	}
	
}
