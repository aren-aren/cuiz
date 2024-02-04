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
	width: 300px;
	}
	#frm{
		margin-top : 10%;
		margin-left : 40%;
	}
	#sns{
	width:300px;
	height :200px;
	}
	.yes{
		color : seagreen;
	}	
	.no{
		color : crimson;
	}
	#join-btn{
		margin-left : 40px;
	}
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
	
	<form id="frm" action="join" method="POST" enctype="multipart/form-data">
	<div>
		<h2>회원가입</h2>
	</div>
	<div>
		<label for="ID" class="form-label color-white">아이디를 입력해주세요<br>
		아이디는 4~20글자내에 대,소문자와 숫자로 조합해주세요.
		</label>
		<input type="TEXT" id="ID" class="form-control input-join" name="member_ID">
		<div id="id_check" ></div>
	</div>
	<div class="mb-3">
	<label for="PW" class="form-label color-white">비밀번호를 입력해주세요</label>
	<input type="password" id="PW" class="form-control input-join" name="member_Password" aria-describedby="passwordHelpBlock">
		<div id="passwordHelpBlock" class="form-text">
	  		비밀번호는 특수문자(~,!,@,#,$,%,^,&,*),숫자와 대,소문자를 포함한 8-20글자 이내로 입력해주세요
		</div>
		<div id="password_check"></div>
	<div>
	</div>
		<label for="PW2" class="form-label color-white">비밀번호 확인</label>
		<input type="password" id="PW2" class="form-control input-join">
		<div id="password2_check"></div>
	</div>
	<div class="mb-3">
  		<label for="email" class="form-label color-white">Email 입력해주세요</label>
  		<input type="email" class="form-control input-join" id="email" name="member_Email" placeholder="name@example.com" >
	</div>
	<div>
		<label for="nick" class="form-label color-white">닉네임을 영어(대소문자),숫자로 이루어진 4~10글자내에서 설정해주세요</label>
		<input type="text" name="member_Nick" id="nick" class="form-control input-join">
		<div id="nick_check"></div>
	</div>
	<div>
		<label for="phone" class="form-label color-white">휴대폰 번호를 입력해주세요</label><br>
		<input type="text" id="phone" name="member_PhoneNumber" class="form-control input-join" placeholder="-를 제외하고 입력해주세요">
	</div>
	<div>
		<br><label for="profile" class="color-white">프로필 사진을 선택해주세요.</label><br><br>
	</div>
	<div class="input-group mb-3 input-join">
		 <input type="file" id="profile" class="form-control" name="member_Profile">
	</div>
	<br><br>
	
	<div>
		<input id="sns" type="button" value="SNS 들어갈 자리">
	</div>
	
	<div>
		<button id="join-btn" disabled="n" class="btn btn-secondary">회원가입</button>
	</div>
	</form>

	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/member/join.js"></script>
	
</body>
</html>