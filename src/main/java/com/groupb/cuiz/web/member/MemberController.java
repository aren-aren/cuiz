package com.groupb.cuiz.web.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.groupb.cuiz.web.member.role.RoleDTO;

@Controller
@PropertySource("classpath:key/config/key-ignore.properties")
@RequestMapping("/member/*")
public class MemberController {

	@Value("${kakaoKey.password}")
    private String kakaoKey;
	
	@Autowired
	private MemberService memberService;
	
	
	
	@GetMapping("emailCheck")
	public String emailCheck(MemberDTO dto,Model model ) throws Exception {
		System.out.println("emailCheck 진입");
		System.out.println(dto.getMember_Email());
		
		
		int number = memberService.sendEmail(dto);
		
		System.out.println("emailCheck 아웃 : " + number);
		model.addAttribute("result", number);
		return "/commons/ajaxResult";
		
	}
	
	@GetMapping("naver_login")
	public String naver_Login() {
		//난수 생성
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130,random).toString();
		
		// 네이버 약관동의 + 로그인창으로 이동 / 로그인 성공시 콜백 
		StringBuffer url = new StringBuffer();
		url.append("https://nid.naver.com/oauth2.0/authorize?");
		url.append("client_id="+"Uzjdng8GLBiFqeurZWu7");
		url.append("&response_type=code");
		url.append("&redirect_uri=http://localhost/member/naver_callback");
		url.append("&state="+state);
		
		return "redirect:"+url;
	}
	
	@RequestMapping(value= "naver_callback", method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
	public String naver_Callback(@RequestParam(value="code") String code,@RequestParam(value="state")String state,HttpServletResponse hsresponse) throws Exception{
		
		/*
		 * WebClient webClient = WebClient.builder() .baseUrl("https://nid.naver.com")
		 * .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		 * .build();
		 * 
		 * JSONObject response = webClient.post() .uri(uriBuilder -> uriBuilder
		 * .path("/oauth2.0/token") .queryParam("client_id","Uzjdng8GLBiFqeurZWu7")
		 * .queryParam("client_secret","C60_bEeiCa")
		 * .queryParam("grant_type","authorization_code") .queryParam("state",state)
		 * .queryParam("code",code) .build())
		 * .retrieve().bodyToMono(JSONObject.class).block();
		 * 
		 * 
		 * String token = (String) response.get("access_token"); getUserInfo(token);
		 */
		
		
	    	  StringBuilder urlBuilder = new StringBuilder();
	          try {
	           
	             /* 요청 URL 생성 */
	             urlBuilder.append("https://nid.naver.com");//BaseURL
	             urlBuilder.append("/oauth2.0/token");//BaseURL

	             
	            
	             /* POST 파라미터 생성  */
	             Map<String, Object> params = new LinkedHashMap<>();
	             params.put("client_id","Uzjdng8GLBiFqeurZWu7");
	             params.put("client_secret","C60_bEeiCa");
	             params.put("grant_type","authorization_code");
	             //params.put("grant_type","refresh_token");
	             params.put("state",state);
	             params.put("code", code);
	             StringBuilder postData = new StringBuilder();
	             for(Map.Entry<String,Object> param :params.entrySet()){
	                if(postData.length()!=0) postData.append('&');
	                postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
	                postData.append('=');
	                postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
	             }
	             byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	             URL url = new URL(urlBuilder.toString()); //URL 생성
	             
	             //token을 주려는 url이랑 길만 뚫어 준거고
	             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	             
	             //통신정보 헤더부분이랑     바디를 사용하겠다고 설정(POST)
	             conn.setRequestMethod("POST");
	               conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
	             //conn.setRequestProperty("Content-Length",String.valueOf(postDataBytes.length));
//	             conn.setRequestProperty("Accept", "application/json");
	             conn.setDoOutput(true);
	             
	             //url에 인코딩한거 그대로  (?) 던져줬어 
	             conn.getOutputStream().write(postDataBytes);
	             
	             
	             // 응답 읽기
	             BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	             String inputLine;
	             StringBuilder response = new StringBuilder();
	             while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	             }
	             br.close();
	             // JSON 데이터 파싱
	             ObjectMapper objectMapper = new ObjectMapper();
	             Map<String, Object> data = objectMapper.readValue(response.toString(), Map.class);
	             System.out.println("data = " + data);
	             String accessToken =  (String) data.get("access_token");
	             System.out.println("=====================");
	             System.out.println(accessToken);
	             conn.disconnect();
	             
	             //자바에서 alert창 띄우기
	             String msg = getUserInfo(accessToken,hsresponse);
	             hsresponse.setContentType("text/html");
	             PrintWriter out = hsresponse.getWriter();
	             out.println(msg);
	             System.out.println("msg = " + msg);
	             //자바에서 alert창 띄우기
	             
	             
	           //  return accessToken;
	          }catch(Exception e) {
	             e.printStackTrace();
	             throw new RuntimeException("액세스토큰 조회 오류 발생!");
	          }
	  
	    	return "redirect:/";
	    	
	          
	}
	

	
	
	public String getUserInfo(String accessToken,HttpServletResponse hrresponse) {
	      StringBuilder urlBuilder = new StringBuilder();
	      try {

	         /* 요청 URL 생성 */
	         urlBuilder.append("https://openapi.naver.com");//BaseURL
	         urlBuilder.append("/v1/nid/me");//End Point

	         URL url = new URL(urlBuilder.toString()); //URL 생성
	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         conn.setRequestProperty("content-type", "application/json");
	         conn.setRequestProperty("authorization", "Bearer "+accessToken);
	         // 응답 읽기
	         BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	         String inputLine;
	         StringBuilder response = new StringBuilder();
	         while ((inputLine = br.readLine()) != null) {
	            response.append(inputLine);
	         }
	         br.close();
	         // JSON 데이터 파싱
	         ObjectMapper objectMapper = new ObjectMapper();
	         Map<String, Object> data = objectMapper.readValue(response.toString(), Map.class);
	         System.out.println("data = " + data);

	         Map<String, Object> result = (Map<String, Object>) data.get("response");

	         String name= (String) result.get("name");
	         String nickName = (String) result.get("nickname");
	         String email = (String) result.get("email");

	         System.out.println("name = " + name);
	         System.out.println("nick = " + nickName);
	         System.out.println("email = " + email);
	         conn.disconnect();
	         
	         
	         
	         MemberDTO dto = new MemberDTO();
	         dto.setMember_ID(email);
	         dto.setMember_Email(email);
	         dto.setMember_Nick(nickName);
	         dto.setMember_Token(1);
	         
	         if(memberService.getNaver(dto) == 0) {
	        	 String msg = naver_join(dto,hrresponse);
	        	 return msg;
	         
	         }
	         else {
	        	 naver_login(dto,hrresponse);
	         }
	         return "";
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	         throw new RuntimeException("2차 액세스토큰 조회 오류 발생!");
	      }
	}
	
	
	
//	public void getUserInfo(String accessToken) {
//		WebClient webClient = WebClient.builder()
//			.baseUrl("https://openapi.naver.com")
//			.defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
//			.build();
//		
//			JSONObject response = webClient.get()
//				.uri(uriBuilder -> uriBuilder
//					.path("/v1/nid/me")
//					.build())
//				.header("Autohorization", "Bearer"+accessToken)
//				.retrieve()
//				.bodyToMono(JSONObject.class).block();
//		
//			Map<String, Object> res = (Map<String, Object>)response.get("response");
//			String id= (String) res.get("id");
//			String nickName = (String) res.get("nickname");
//			String email = (String) res.get("email");
//			
//			System.out.println("id = " + id);
//			System.out.println("nick = " + nickName);
//			System.out.println("email = " + email);
//			
//	}
		
		public String naver_join(MemberDTO dto,HttpServletResponse response) throws Exception {
			Model model = new ExtendedModelMap();
			
			
			int check = memberService.getAll(dto);
			if(check==0) {
				dto= memberService.getKakaoNickCount(dto);
				int result = memberService.setKakao(dto);
				 
				
				return "<script>alert('회원가입이 완료되었습니다');</script>";
			}
			
			return "<script>alert('이미 가입된 아이디이거나 회원가입 오류입니다.');</script>";
		}
	
		
		public String naver_login(MemberDTO dto,HttpServletResponse response) throws Exception{
			Model model = new ExtendedModelMap();
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();
			HttpSession session = request.getSession();
			
 			dto = memberService.naver_login(dto);
			if(dto==null) {
				model.addAttribute("msg", "오류");
				model.addAttribute("path", "/");
				return "commons/result";
			}
			if(dto.getMember_Flag()!=0) {
				 model.addAttribute("msg", "회원탈퇴된 계정입니다.");
				 model.addAttribute("path", "/");
				 return "commons/result";
			 }
			
			Map<String, Object> map = memberService.getAtendence(dto);
			int result = (int) map.get("result");
			int conatt = (int) map.get("conatt");
			dto = (MemberDTO)map.get("dto");
			
			if(result==0) {
				model.addAttribute("result", result);
				
			}
			else {
				model.addAttribute("result",conatt);
			}
			
			session.setAttribute("member", dto);
			if(dto.getMember_Profile_Blob()!=null) {
				session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
			}
			else {
				session.setAttribute("avatar", null);
			}
			
			System.out.println("result : " + result);

			System.out.println("test2");
			return "commons/result";
			
			//나중에 여기서부터 다시해라
			// 네이버 로그인과정 하고있다 겁나 복잡하다
			
			
		}
		
	@GetMapping("kakaoJoin")
	public String setKakao(MemberDTO dto,HttpSession session,ProfileDTO profile,Model model) throws Exception{
		System.out.println(profile.getNickname());
		
		dto.setMember_ID(profile.getAccount_Email());
		dto.setMember_Nick(profile.getNickname());
		int check = memberService.getAll(dto);
		if(check==0) {
			dto.setMember_Token(1);
			dto = memberService.getKakaoNickCount(dto);
			int result = memberService.setKakao(dto);
			
			
			model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		}
		model.addAttribute("result", 0);
		return "commons/ajaxResult";
	}
	
	
	
	@GetMapping("kakaoLogin")
	public String setKakaoLogin(ProfileDTO profile,HttpSession session,MemberDTO memberDTO,Model model) throws Exception{
		MemberDTO dto = new MemberDTO();
		memberDTO.setMember_ID(profile.getAccount_Email());
		dto = memberService.getKakaoLogin(memberDTO);
		System.out.println("dto : " + dto);
		if(dto==null) {
			model.addAttribute("result", "null");
			return "commons/ajaxResult";
		}
		
		if(dto.getMember_Flag()!=0) {
			 model.addAttribute("result", "delete");
			 return "commons/ajaxResult";
		 }
		
		Map<String, Object> map = memberService.getAtendence(dto);
		int result = (int) map.get("result");
		int conatt = (int) map.get("conatt");
		dto = (MemberDTO)map.get("dto");
		
		System.out.println("result = " + result);
		if(result==0) {
			model.addAttribute("result", result);
			
		}
		else {
			model.addAttribute("result",conatt);
		}
		
		session.setAttribute("member", dto);
		if(dto.getMember_Profile_Blob()!=null) {
			session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
		}
		else {
			session.setAttribute("avatar", null);
		}
		
		System.out.println("result : " + result);
		return "commons/ajaxResult";
		
	}
	
	@GetMapping("delete")
	public String setDelete(MemberDTO dto, Model model,HttpSession session) throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO) session.getAttribute("member");
		dto.setMember_ID(memberDTO.getMember_ID());
		int result = memberService.setDelete(dto);
		
		session.invalidate();
		
		return "redirect:/";
	}
	@GetMapping("user_delete")
	public String getUser_delete(MemberDTO dto) throws Exception{
		memberService.setDelete(dto);
		
		return "redirect:/member/list";
	}
	
	@GetMapping("delete_list")
	public String delete_list(Model model) throws Exception{
		List<MemberDTO> ar = memberService.delete_list();
		
		model.addAttribute("list", ar);
		return "member/delete_list";
	}
	@GetMapping("user_recovered")
	public String user_recovered(MemberDTO dto) throws Exception{
		memberService.user_recovered(dto);
		return "redirect:/member/delete_list";
	}
	
	
	@GetMapping("list")
	public String getList(MemberDTO dto,Model model) throws Exception{
		List<MemberDTO> ar = memberService.getList(dto);
		
		model.addAttribute("list", ar);
		
		return "member/list";
	}
	
	
	@GetMapping("join")
	public String setJoin(HttpSession session) throws Exception {
		return ("member/join");
				
	}
	
	@GetMapping("nickcheck")
	public String setNickcheck(MemberDTO dto,Model model) throws Exception{
		int result = memberService.setNickcheck(dto);
		
		model.addAttribute("result", result);		
		
		return "/commons/ajaxResult";
	}
	
	@GetMapping("idcheck")
	public String setIdcheck(MemberDTO dto,Model model) throws Exception{
		int result = memberService.setIdcheck(dto);
		
		model.addAttribute("result", result);
		
		return "/commons/ajaxResult";
	}
	
	@PostMapping("join")
	public String setJoin( MemberDTO dto,Model model) throws Exception {
		System.out.println(dto);
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setMember_ID(dto.getMember_ID());
		int result = memberService.setJoin(dto);
		memberService.insertRole(roleDTO);
		
		model.addAttribute("msg", result);
		
		return ("redirect:/member/login");
				
	}
	
	@GetMapping("logout")
	public String setLogOut(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public String setLogin() throws Exception{
	
		return "member/login";
	}
	@PostMapping("login")
	public String setLogin(HttpSession session,MemberDTO dto,Model model) throws Exception{
		 dto = memberService.getDetail(dto);
		 
		 System.out.println(dto);
		 String msg = "아이디 또는 패스워드를 확인해주세요";
		 if(dto == null) {
			 model.addAttribute("msg", msg);
			 return "member/login";
		 }
		 if(dto.getMember_Flag()!=0) {
			 model.addAttribute("msg", "회원탈퇴된 계정입니다.");
			 model.addAttribute("path", "/");
			 return "commons/result";
		 }
		 
		 
		 
		Map<String, Object> map = memberService.getAtendence(dto);
		int result = (int) map.get("result");
		dto = (MemberDTO)map.get("dto");
		
		if(result ==0) {
			model.addAttribute("msg", "출석 포인트 3점이 지급되었습니다.");
			model.addAttribute("path", "/");
			if(dto.getMember_Conatt()==7) {
				model.addAttribute("msg", "출석 포인트 3점 + 7일 연속 출석 보너스 10점 \n 총 13점이 지급되었습니다.");
				
			}
		}
		else {
			session.setAttribute("member", dto);
			session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
			 
			return "redirect:/";
		}
		session.setAttribute("member", dto);
		//System.out.println( new String(dto.getMember_Profile_byte(), "UTF-8") );
		session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
		 
		return "commons/result";
	}
	
	@GetMapping("mypage")
	public String setMypage() throws Exception{
		return "member/mypage";
	}
	@GetMapping("update")
	public String setUpdate() throws Exception{
		return "member/update";
	}
	
	@PostMapping("update")
	public String setUpdate(HttpSession session,MemberDTO dto) throws Exception{
		int result = memberService.setUpdate(dto);
		
		if(result>0) {
		dto = memberService.getDetail(dto);
		}
		session.setAttribute("member", dto);
		session.setAttribute("avatar", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(),StandardCharsets.UTF_8));
		
		return "redirect:/member/mypage";
	}
	
	@GetMapping("11")
	public String get(Model model) throws Exception{
		MemberDTO dto = memberService.get();
		model.addAttribute("msg", "data:image/png;base64," + new String(dto.getMember_Profile_Blob(), StandardCharsets.UTF_8));
		
		return "member/temp";
	}
	
	@GetMapping("updateRole")
	public String setUpdateRole(Model model, MemberDTO dto) throws Exception{
		int result;
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setMember_ID(dto.getMember_ID());
		if(dto.getMember_Role().equals("MEMBER") ) {
			roleDTO.setRole_Num(200);
			memberService.deleteRole(roleDTO);
		}
		else {
			roleDTO.setRole_Num(100);
			memberService.insertRole(roleDTO);
		}
		result = memberService.setUpdateRole(dto);
		model.addAttribute("result", result);
		
		return "/commons/ajaxResult";
	}
	
}
