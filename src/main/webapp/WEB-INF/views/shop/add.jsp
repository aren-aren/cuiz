<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temps/header_css.jsp"></c:import>
<style>
	.color-white{
		color : white;	
	}
	.input-join{
	width: 450px;
	}
	#updBtnFrm{
		margin-top : 10%;
		margin-left : 40%;
	}

	.yes{
		color : seagreen;
	}	
	.no{
		color : crimson;
	
</style>
</head>
<body>
	<!-- ***** Preloader Start ***** -->
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <!-- ***** Preloader End ***** -->
	
	<c:import url="../temps/header.jsp"></c:import>
	
	<form id="updBtnFrm" action="./add" method="POST" enctype="multipart/form-data">
	<div>
		<h2>아이템 추가</h2>
	</div>
	<input type="text" name="item_Num" value="${dto.item_Num}" >
	<div>
		<label for="item_Name" class="form-label color-white">닉네임을 입력해주세요</label>
		<input type="text" name="item_Name" id="item_Name" class="form-control input-join" placeholder="영어와 숫자로 이루어진 4-10글자">
		<div id="item_Name"></div>
	</div>
	<div>
		<label for="item_Price" class="form-label color-white">가격을 입력해주세요</label>
		<input type="text" name="item_Price" id="item_Price" class="form-control input-join" placeholder="영어와 숫자로 이루어진 4-10글자">
		<div id="item_Price"></div>
	</div>
	<div>
		<label for="item_Contents" class="form-label color-white">아이템 설명을 입력하세요</label><br>
		<input type="text" id="item_Contents" name="item_Contents" class="form-control input-join" placeholder="아이템 설명을 입력하세요">
	</div>
	<div>
		<br><label for="profile" class="color-white"> 사진을 선택해주세요.</label><br><br>
	</div>
	<div class="input-group mb-3 input-join">
		 <input type="file" id="profile" class="form-control" name="file">
	</div>
	<br><br>
		
	<div class="col-lg-8">
	<div class="main-border-button">
		<button type="submit" id="updateBtn">Update</button>
	</div>
	</div>
	</form>

	<c:import url="../temps/footer.jsp"></c:import>
	
</body>
</html>