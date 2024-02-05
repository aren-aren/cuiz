package com.groupb.cuiz.web.item;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.groupb.cuiz.web.cart.CartDTO;
import com.groupb.cuiz.web.cart.CartService;
import com.groupb.cuiz.web.member.MemberDTO;


@Controller
@RequestMapping("/shop/*")
public class ItemContoller {

	@Autowired
	private ItemService itemService;
	@Autowired
	private CartService cartService;
	
	
	@GetMapping("addCart")
	public int addList(CartDTO cartDTO, Model model) {
		System.out.println("addcart on itemcontroller");
		cartDTO.setMember_ID("hello");	
		int result = cartService.addList(cartDTO);		
		return result;
		
	}
	
	
	@GetMapping("list")
	public String getList(Model model) {
		
		
		List<ItemDTO> ar = itemService.getList(); 		
		model.addAttribute("list", ar);
		
		return "/shop/list";

	}
	
	@GetMapping("detail")
	public String getDetail(Model model, ItemDTO itemDTO) throws UnsupportedEncodingException {
		
		itemDTO = itemService.getDetail(itemDTO);
		
		model.addAttribute("dto", itemDTO);
		
		return "/shop/detail";
	}
	
	
	@GetMapping("add")
	public String setItem() {
		
		return "/shop/add";
		
	}
	
	
	@PostMapping("add")
	public void setItem(ItemDTO itemDTO, MultipartFile file) throws Exception {
		System.out.println("add start");
			
		System.out.println(file);
		
		int result = itemService.setItem(itemDTO, file);
		
		System.out.println("test :" + itemDTO);
		
		System.out.println(result);
		
	}
	
	@PostMapping("delete")
	public String delete(ItemDTO itemDTO) {
		
		int result = itemService.delete(itemDTO);
		
		return "./list";
					
	}
	
	@GetMapping("update")
	public String update(ItemDTO itemDTO, Model model) throws Exception {
		System.out.println(itemDTO.getItem_Num());
		
		ItemDTO result = itemService.getDetail(itemDTO);
		
		model.addAttribute("dto", result);
		
		return "/shop/update";
		
	}
	
	@PostMapping("update")
	public String update(ItemDTO itemDTO, MultipartFile file) throws IOException {
		System.out.println(itemDTO.getItem_Name());
		System.out.println(file+"Controller");
		int result = itemService.update(itemDTO, file);
		
		
		return "/shop/list";
	}
	

	
	
	
	
	
}
