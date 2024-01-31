<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>join</h1>
	
	<div>
		<h2>회원가입</h2>
	</div>
	<form action="join" method="POST">
	<div>
		<label for="ID">아이디를 입력하세요</label>
		<input type="text" id="ID" name="member_ID">
	</div>
	<div>
		<label for="PW">비밀번호를 입력하세요</label>
		<input type="text" id="PW" name="member_Password">
	</div>
	<div>
		<label for="mail">E-mail을 입력하세요</label>
		<input type="text" id="mail" name="member_Email">
	</div>
	<div>
		<label for="nick">닉네임을 입력하세요</label>
		<input type="text" id="nick" name="member_Nick">
	</div>
	<div>
		<label for="phone">전화번호를 입력하세요</label>
		<input type="text" id="phone" name="member_PhoneNumber" placeholder="-는 제외해주세요.">
	</div>
	<div>
		<label for="photo">사진 선택</label>
		<input type="file" id="photo" name="member_Profile">
	</div>
	<div>
		<button>가입하기</button>
	</div>
	</form>
</body>
</html>