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
	.member_role{
		width : 100px;
	}
	
	</style>

</head>
	
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	<table id="table" class="table table=dark">
		<tr>
			<th class="color-white">아이디</th>
			<th class="color-white">닉네임</th>
			<th class="color-white">탈퇴일</th>
			<th class="color-white">권한</th>
			<th class="color-white">계정 복구</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
			
		<tr>
			<td class="color-white memberid">${dto.member_ID}</td>
			<td class="color-white">${dto.member_Nick}</td>
			<td class="color-white">${dto.member_DelDate}</td>
			<td class="color-white member_role">${dto.member_Role}</td>
			<td class="color-white"><a href="/member/user_recovered?member_ID=${dto.member_ID}" class="btn btn-primary">V</a></td>
		</c:forEach>
	</table>

	
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>