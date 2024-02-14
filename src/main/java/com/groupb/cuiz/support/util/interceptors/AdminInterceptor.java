package com.groupb.cuiz.support.util.interceptors;

import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.groupb.cuiz.web.member.MemberDTO;
import com.groupb.cuiz.web.member.role.Member_RoleDTO;
import com.groupb.cuiz.web.member.role.RoleDTO;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 진입");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member") ==null ) {
			request.setAttribute("msg", "로그인부터 해 !");
			request.setAttribute("path", "/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		String roles = memberDTO.getMember_Role(); 
		if(roles.equals("ADMIN")) {
			System.out.println("관리자 성공");
			return true;
		}
		
		System.out.println("실패");
		request.setAttribute("msg", "권한이 부족합니다.");
		request.setAttribute("path", "/");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		
		
		return false;
	}
	
}
