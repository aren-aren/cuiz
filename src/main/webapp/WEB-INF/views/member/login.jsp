<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	
	#frm{
		margin-left : 40%;
		margin-top : 10%;
	}
	.color-white{
	color : white;
	}
	.color-crimson{
		color : crimson;
	}
	.join{
		margin-left : 12%;
	}
	#sns{
		width:300px;
		height :200px;
	}
</style>
<c:import url="../temps/header_css.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<form id="frm" action="login" method="POST">
	<div>
		<h2>로그인</h2>
	</div>
	<div class ="color-crimson">
		${msg}
	</div>
		<div class="mb-3">
			<label for="ID" class="form-label color-white">아이디를 입력해주세요</label>
			<input type="TEXT" id="ID" style="width:300px" class="form-control input-join" name="member_ID">
		</div>
		<div class="mb-3">
			<label for="PW" class="form-label color-white">비밀번호를 입력해주세요</label>
			<input style="width:300px" type="password" id="PW" class="form-control input-join" name="member_Password">
		</div>
		<div>
			<button class="btn btn-primary">로그인</button>
			<a class="join btn btn-secondary" href="/member/join">회원가입</a>
		</div>
		<div>
			<input id="sns" type="button" value="SNS 들어갈 자리">
		</div>
		
	</form>
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>