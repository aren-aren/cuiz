package com.groupb.cuiz.web.item;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.support.util.photo.PhotoEncoder;
import com.groupb.cuiz.web.purchase.PurchaseService;


@Controller
@RequestMapping("/shop/*")
public class ItemContoller {

	@Autowired
	private ItemService itemService;
	@Autowired
	private PhotoEncoder photoEncoder;
	/*
	 * @Autowired private PurchaseService purchaseService;
	 */
	
	
//	@GetMapping("addCart")
//	public int addList(PurchaseDTO purchaseDTO, Model model) {
//		System.out.println("addcart on itemcontroller");
//		purchaseDTO.setMember_ID("hello");	
//		int result = purchaseService.addList(purchaseDTO);		
//		return result;
//		
//	}
//	
	
	@GetMapping("list")
	public String getList(Model model, Pager pager ) {
		
		System.out.println(pager.getKind());	
		List<ItemDTO> ar = itemService.getList(pager); 		
		model.addAttribute("list", ar);
		
		return "/shop/list";

	}
	
	
	@GetMapping("api/list")
	@ResponseBody
	public List<ItemDTO> getListJson(Pager pager){
		
		
		List<ItemDTO> ar = itemService.getList(pager); 		
		ar = photoEncoder.ListToString(ar);
		
		return ar;
		
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
	public String setItem(ItemDTO itemDTO, MultipartFile file, Model model) throws Exception {
		System.out.println("add start");
			
//		System.out.println(file.toString());
		
		int result = itemService.add(itemDTO, file);
		
//		System.out.println("testasdasdasdasda :" + itemDTO);
//		
//		System.out.println(result);
		
		model.addAttribute("msg", "추가완료");
		model.addAttribute("path", "/shop/list");
		
		if(result==0) {

			model.addAttribute("msg", "추가실패");
			model.addAttribute("path", "/shop/list");
		}
		
		return "commons/result";
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
	
	@GetMapping("success")
	public String kakaoSuccess(HttpServletRequest request) {
		System.out.println("shop success ========================================");
		Enumeration<String> r = request.getParameterNames();
		
		while (r.hasMoreElements()) {
			String string = r.nextElement();
			System.out.println("Name : "+string);
			System.out.println("Value " +request.getParameter(string));
			
		}
		
		return "/shop/success";
		
	}
	
	
	
	
	
}
