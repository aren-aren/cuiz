package com.groupb.cuiz.web.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.support.util.pager.Pager;
import com.groupb.cuiz.web.member.role.RoleDTO;
import java.lang.Math;
@Service
@Component
@Transactional(readOnly = true)
public class MemberService {

	
	
	
	@Autowired
	private MemberDAO dao;
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	
	
	public int sendEmail(MemberDTO dto) throws Exception {
		
		Random random = new Random();
		int number = random.nextInt(900000)+100000;
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
		mimeMessageHelper.setTo(dto.getMember_Email());
		mimeMessageHelper.setSubject("[Cuiz!!] 회원가입 이메일 인증");
		String message = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        .titleNumber{\r\n"
				+ "            text-align: center;\r\n"
				+ "        }\r\n"
				+ "        .number{\r\n"
				+ "            text-align: center;\r\n"
				+ "            font-size: larger;\r\n"
				+ "            color: dimgrey;\r\n"
				+ "        }\r\n"
				+ "        .header{\r\n"
				+ "            text-align: center;\r\n"
				+ "            background-color: black;\r\n"
				+ "            color: #e75e8d;\r\n"
				+ "            margin-top: 15%;\r\n"
				+ "            margin-left: 10%;\r\n"
				+ "            margin-right: 10%;\r\n"
				+ "            padding-top: 1%;\r\n"
				+ "            padding-bottom: 1%;\r\n"
				+ "        }\r\n"
				+ "        .footer{\r\n"
				+ "            color: cadetblue;\r\n"
				+ "            text-align: center;\r\n"
				+ "            margin-top: 5%;\r\n"
				+ "        }\r\n"
				+ "        .body{\r\n"
				+ "            text-align: center;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div>\r\n"
				+ "        <div class=\"header\">\r\n"
				+ "            CUIZ\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"body\">\r\n"
				+ "            CUIZ를 이용해주셔서 감사합니다. 사용자가 본인임을 확인하는 과정입니다.<br>\r\n"
				+ "            계정을 생성하지 않는 경우에는 이 메시지를 무시해도 됩니다.\r\n"
				+ "        </div>\r\n"
				+ "        <h2 class=\"titleNumber\">인증 코드</h2>\r\n"
				+ "        <div class=\"number\">\r\n"
				+ number +"\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"footer\">\r\n"
				+ "            sang ul이꺼\r\n"
				+ "\r\n"
				+ "        </div>\r\n"
				+ "    </div>    \r\n"
				+ "</body>\r\n"
				+ "</html>";
		mimeMessageHelper.setText(message, true);
		
		javaMailSender.send(mimeMessage);
		
		return number;
	}
	
	public int setNaver(MemberDTO dto) throws Exception{
		int result = dao.setNaver(dto);
		result = dao.setDefaultRole(dto);
		return result;
	}
	
	public MemberDTO get() throws Exception{
		return dao.get();
	}
	@Transactional
	public int setKakao(MemberDTO dto)throws Exception{
		int result = dao.setKakao(dto);
		result = dao.setDefaultRole(dto);
		return result;
	}
	public int getAll(MemberDTO dto) throws Exception{
		return dao.getAll(dto);
	}
	public MemberDTO getKakaoLogin(MemberDTO dto) throws Exception{
		return dao.getKakaoLogin(dto);
	}
	
	
	public int user_recovered(MemberDTO dto) throws Exception{
		return dao.user_recovered(dto);
	}
	
	@Transactional
	public int setJoin(MemberDTO dto) throws Exception{
		dao.setDefaultRole(dto);
		
		return dao.SetJoin(dto);
	}
	public MemberDTO getDetail(MemberDTO dto) throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = dao.getDetail(dto);
		if(memberDTO!=null) {
			return memberDTO;
		}
		
		return null;
	}
	@Transactional
	public int setUpdate(MemberDTO dto) throws Exception{
		return dao.setUpdate(dto);
	}
	@Transactional
	public int setNickcheck(MemberDTO dto) throws Exception{
		return dao.setNickcheck(dto);
	}
	@Transactional
	public int setIdcheck(MemberDTO dto) throws Exception{
		return dao.setIdcheck(dto);
		
	}
	@Transactional
	public int setUpdateRole(MemberDTO dto) throws Exception{
		return dao.setUpdateRole(dto);
	}
	@Transactional
	public int deleteRole(RoleDTO dto) throws Exception{
		return dao.deleteRole(dto);
	}
	@Transactional
	public int setDelete(MemberDTO dto) throws Exception{
		return dao.setDelete(dto);
	}
	@Transactional
	public int insertRole(RoleDTO dto) throws Exception{
		return dao.insertRole(dto);
	}
	
	public List<MemberDTO> getList(Pager pager) throws Exception{
		Long totalCount = dao.getCommonTotalCount();
		pager.setPerPage(5L);
		pager.makeRow();
        pager.makeNum(totalCount);
		
		return dao.getList(pager);
	}
	public List<MemberDTO> delete_list(Pager pager) throws Exception{
		Long totalCount = dao.getDeleteTotalCount();
		
		pager.setPerPage(5L);
		pager.makeRow();
        pager.makeNum(totalCount);
		
		
		return dao.delete_list(pager);
	}
	
	
	@Transactional
	public Map<String, Object> getAtendence(MemberDTO dto) throws Exception{
		int result = dao.getAtendence(dto);
		int att = 0;
		if(result==0) {
			System.out.println("dto.getid = " + dto.getMember_ID());
			dao.setTotalAtt(dto);
			att = dao.setAtendence(dto);
			
				if(att==1) {
					dto.setMember_Coin(dto.getMember_Coin()+3);
					dao.setCoin(dto);
					
				}
				int check = dao.getConatt(dto);
				System.out.println(check);
				if(check == 1) {
					dao.setConatt(dto);
					dto.setMember_Conatt(dto.getMember_Conatt()+1);
					int conatt = dto.getMember_Conatt();
					if(conatt==7) {
						dao.setBonus(dto);
						dto.setMember_Coin(dto.getMember_Coin()+10);
					}
					if(conatt==8) {
						dto.setMember_Conatt(0);
						dao.setConatt(dto);
						dto.setMember_Conatt(1);
					}
					// 연속출석 하는중 일단은 +1 까지만 .. ? 
				}
				else {
					dto.setMember_Conatt(0);
					dao.setConatt(dto);
					dto.setMember_Conatt(1);
				}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("conatt", dto.getMember_Conatt());
		map.put("dto", dto);
		
		return map;
	}
	
	
	public MemberDTO getKakaoNickCount(MemberDTO dto) throws Exception{
		int count = dao.getKakaoNickCount(dto);
		String tag = dto.getMember_Nick()+"#"+(count+1);
		
		dto.setMember_Nick(tag);
		
		return dto;
	}
	
	public int getNaver(MemberDTO dto) throws Exception{
		int result = dao.getNaver(dto);
		
		return result;
	}
	public MemberDTO naver_login(MemberDTO dto) throws Exception{
		return dao.naver_login(dto);
		
	}
	
	public int realDelete() throws Exception{
		System.out.println("memberService check");
		return dao.realDelete();
	}
	
	
	
}
