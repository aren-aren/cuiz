package com.groupb.cuiz.web.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.groupb.cuiz.web.member.role.RoleDTO;
import java.lang.Math;
@Service
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
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(dto.getMember_Email());
		mimeMessageHelper.setSubject("[Cuiz!!] 회원가입 이메일 인증");
		mimeMessageHelper.setText("인증버노 : "+number);
		javaMailSender.send(mimeMessage);
		/*
		 * String mailContent = "이메일 인증 번호입니다. \n"+ number;
		 * 
		 * send.setSubject("회원가입 이메일 인증 ","utf-8");
		 * send.setText(mailContent+"utf-8","html");
		 * send.addRecipient(Message.RecipientType.TO, new
		 * InternetAddress(dto.getMember_Email())); mail.send(send);
		 */
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
	
	public List<MemberDTO> delete_list() throws Exception{
		return dao.delete_list();
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
	
	public List<MemberDTO> getList(MemberDTO dto) throws Exception{
		return dao.getList(dto);
	}
	
	@Transactional
	public Map<String, Object> getAtendence(MemberDTO dto) throws Exception{
		int result = dao.getAtendence(dto);
		int att = 0;
		if(result==0) {
			att = dao.setAtendence(dto);
			
				if(att==1) {
					dao.setCoin(dto);
					dto.setMember_Coin(dto.getMember_Coin()+3);
					
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
	
}
