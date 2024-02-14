<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="UTF-8">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update</h1>
	
	<div>
		<h2>${dto.item_Num} update</h2>
	</div>
	<form id="updBtnFrm" action="./update" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="item_Num" value="${dto.item_Num}" >
	<div>
		<label for="ID">아이디를 입력하세요</label>
		<input type="text" id="ID" name="item_Name" value="">
	</div>	
	<div>
		<label for="mail">가격을 입력하세요</label>
		<input type="text" id="mail" name="item_Price" value="">
	</div>
	<div>
		<label for="nick">설명을 입력하세요</label>
		<input type="text" id="nick" name="item_Contents" value="">
	</div>	
		<div>
		<img src="data:image/jpeg;base64,${dto.item_Photo_to_String}" >
		</div>
	<div>
		<label for="profile">사진 선택</label>
		<input type="file" id="profile" name="file" accept="image/*">
	</div>
	
	<div>
		<button type="submit" id="updateBtn">Update</button>
	</div>
	</form>

	<!-- <script src="/resources/js/shop/detail.js"></script> -->
</body>
</html>
