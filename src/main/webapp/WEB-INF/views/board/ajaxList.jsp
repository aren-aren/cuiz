<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${list}" var="r">
		<input type="hidden" name="reply_Num" value="${r.reply_Num}">
		<input type="hidden" name="board_Num" value="${r.board_Num}">
		<input type="hidden" name="user_Name" value="${member.member_ID}">
		<div class="col-lg-12">
		<ul id="addForm">
			<li>${r.reply_Contents}<span>${r.user_Name}</span></li>
		</ul>
		</div>
</c:forEach>
