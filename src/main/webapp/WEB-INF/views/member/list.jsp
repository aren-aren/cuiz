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
		margin-top : 1%;
		
	}
	.color-white{
		color : white;
	}
	.member_role{
		width : 100px;
	}
	.delete{
		width : 50px;
		
	}
	.main-button{
	margin-top : 7%;
    font-size: 14px;
    color: #fff;
    background-color: #e75e8d;
    padding: 12px 30px;
    display: inline-block;
    border-radius: 25px;
    font-weight: 400;
    text-transform: capitalize;
    letter-spacing: 0.5px;
    transition: all .3s;
    position: relative;
    overflow: hidden;
	</style>
</head>
	
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	<div>
		<a class="main-button" href="/member/delete_list">Delete_List</a>
	</div>
	
	<table id="table" class="table table=dark">
		<tr>
			<th class="color-white">아이디</th>
			<th class="color-white">닉네임</th>
			<th class="color-white">가입일</th>
			<th class="color-white">권한</th>
			<th class="color-white">권한 변경</th>
			<th class="color-white">회원 추방</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
			<c:if test="${dto.member_Flag == 0}">
		<tr>
			<td class="color-white memberid">${dto.member_ID}</td>
			<td class="color-white">${dto.member_Nick}</td>
			<td class="color-white">${dto.member_RegDate}</td>
			<td class="color-white member_role">${dto.member_Role}</td>
			<td class="color-white"> <select class="member_role form-select" data-ID="${dto.member_ID}" data-role="${dto.member_Role}" >
					<option  value="ADMIN">관리자</option>
					<option  value="MEMBER">멤버</option>
				</select>
		 	</td>
		 	<td class="color-white"><a href="/member/user_delete?member_ID=${dto.member_ID}" class="btn btn-primary">X</a></td>
		</tr>
			</c:if>
		</c:forEach>
	</table>
	
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/member/updateRole.js"></script>
</body>
</html>