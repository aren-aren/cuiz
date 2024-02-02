package com.groupb.cuiz.web.item;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


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
	public void setItem(ItemDTO itemDTO, MultipartFile file) throws IOException {
		System.out.println("add start");
			
		System.out.println(file);
		
		int result = itemService.setItem(itemDTO, file);
		
		System.out.println("test :" + itemDTO);
		
		System.out.println(result);
		
	}
	
	@PostMapping("delete")
	public String delete(ItemDTO itemDTO) {
		
		int result = itemService.delete(itemDTO);
		
		return "/shop/list";
					
	}
	
	
	@PostMapping("updat")
	public void update(ItemDTO itemDTO) {
		
		int result = itemService.update(itemDTO);
		
	}
	
	@GetMapping("update")
	public String update(ItemDTO itemDTO, HttpSession session) {
		
		return "shop/update";
		
	}
	
	
}
