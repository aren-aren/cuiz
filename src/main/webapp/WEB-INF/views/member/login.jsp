<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>회원가입</h2>
	</div>
	<div>
		${msg}
	</div>
	<form id="frm" action="login" method="POST">
		<div>
			<label for="ID">아이디를 입력하세요</label> <input type="text" id="ID" name="member_ID">
		</div>
		<div>
			<label for="PW">비밀번호를 입력하세요</label> <input type="text" id="PW"	name="member_Password">
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>