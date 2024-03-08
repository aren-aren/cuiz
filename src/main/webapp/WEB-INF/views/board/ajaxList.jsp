<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${replyList}" var="r">
						
	<form>
		<input type="hidden" name="user_Name" value="${member.member_ID}">
	
		<div class="col-lg-12">
		<ul id="addForm">
			<li>${r.reply_Contents}<span>${r.user_Name}</span></li>
		</ul>
		</div>
							
	</form>
</c:forEach>
