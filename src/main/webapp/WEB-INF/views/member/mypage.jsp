<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${member.member_Nick}
	<c:if test="${not empty avatar}">
	<h2><img src="${avatar}"/></h2>
	</c:if>
	
	<c:if test="${empty avatar}">
	<h2><img src="/resources/assets/images/basic.jpeg"/></h2>
	</c:if>
	

	
	<h1>아이디 : ${member.member_ID}</h1>
	<h2>연속출석일 : ${member.member_Conatt}</h2>
	<h2>혀재 코인 : ${member.member_Coin}</h2>
</body>
</html>