<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../temps/header_css.jsp"></c:import>
	<style>
	#table{
		margin-top : 10%;
		
	}
	.color-white{
		color : white;
	}
	</style>
</head>
	
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	<table id="table" class="table table=dark">
		<tr>
			<th class="color-white">아이디</th>
			<th class="color-white">닉네임</th>
			<th class="color-white">가입일</th>
			<th class="color-white">권한</th>
			<th class="color-white">권한 변경</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
		<tr>
			<td class="color-white memberid">${dto.member_ID}</td>
			<td class="color-white">${dto.member_Nick}</td>
			<td class="color-white">${dto.member_RegDate}</td>
			<td data-role="${dto.member_Role}" data-id = "${dto.member_ID}"  class="color-white role">${dto.member_Role}</td>
			<td class="color-white"> <select class="member_role form-select" style="width : 100px">
					<option class= "role_check" value="ADMIN">관리자</option>
					<option class= "role_check" value="MEMBER">멤버</option>
				</select>
		 	</td>
		 <tr>
		</c:forEach>
	</table>
	
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/member/updateRole.js"></script>
</body>
</html>