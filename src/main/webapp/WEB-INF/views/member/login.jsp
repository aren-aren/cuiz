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
	.kakaoLogin{
		width: 26%;
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
				<a href="javascript:kakaoLogin();"><img class="kakaoLogin" src="/resources/assets/images/kakao_login.jpg"/> </a>
		</div>
		<div>
			<a href="/member/naver_login"><img class="kakaoLogin" src="/resources/assets/images/naver_login.png"/> </a>
		</div>

	</form>
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>
        window.Kakao.init("a58598cd3cea0b5410f80d01ccdc89b5");

        function kakaoLogin(){
            window.Kakao.Auth.login({
                scope: 'profile_nickname,profile_image,account_email',
                success : function(authObj){
                    console.log(authObj);
                    window.Kakao.API.request({
                        url : '/v2/user/me',
                        success : res => {
                            const kakao_account = res.kakao_account;
                            console.log(kakao_account);
							console.log(kakao_account.profile.nickname);
							fetch('/member/kakaoLogin?nickname='+kakao_account.profile.nickname+"&account_Email="+kakao_account.email,{
								method : 'GET'
							})
							.then(res =>res.text())
							.then(res => {
								console.log(res.trim());
								if(res.trim()=='0') {
				
									alert("출석 포인트 3점이 지급되었습니다.");
								}
								else if(res.trim()=='null'){
									alert("회원가입이 안되어있는 아이디입니다.");
									location.href="/member/join";
									return;
									
								}
								else if(res.trim()=='7')
								{
									alert("출석 포인트 3점 + 7일 연속 출석 보너스 10점 \n 총 13점이 지급되었습니다.");	
								}
								location.href="/";
							})

							
                        }
                    });
                }
            })
        }

    </script>
</body>
</html>