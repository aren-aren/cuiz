<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="UTF-8">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>add</h1>
	
	<div>
		<h2>add</h2>
	</div>
	<form id="frm" action="add" method="POST" enctype="multipart/form-data">
	<input type="text" name="item_Num" >
	<div>
		<label for="ID">아이디를 입력하세요</label>
		<input type="text" id="ID" name="item_Name">
	</div>	
	<div>
		<label for="mail">가격을 입력하세요</label>
		<input type="text" id="mail" name="item_Price">
	</div>
	<div>
		<label for="nick">설명을 입력하세요</label>
		<input type="text" id="nick" name="item_Contents">
	</div>	
	<div>
		<label for="profile">사진 선택</label>
		<input type="file" id="profile" name="file" accept="image/*">
	</div>
	
	<div>
		<button>추가하기</button>
	</div>
	</form>

	
</body>
</html>
