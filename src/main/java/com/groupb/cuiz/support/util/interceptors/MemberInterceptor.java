package com.groupb.cuiz.support.util.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.groupb.cuiz.web.member.MemberDTO;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member") ==null ) {
			request.setAttribute("msg", "로그인해야만 접속 가능합니다.");
			request.setAttribute("path", "/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		
		String role = dto.getMember_Role();
		
		if(role.equals("ADMIN") || role.equals("MEMBER"))
		{
			return true;
		}
		
		request.setAttribute("msg", "로그인해야만 접속 가능합니다.");
		request.setAttribute("path", "/member/login");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		return false;
	}
	
}
