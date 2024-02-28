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
		margin-left : 6%;
	}
	#sns{
		width:300px;
		height :200px;
	}
	
	.btn-login{
	font-size: 14px;
    color: #fff;
    background-color: #e75e8d;
    padding: 12px 30px;
    display: inline;
    border-radius: 25px;
    font-weight: 400;
    text-transform: capitalize;
    letter-spacing: 0.5px;
    transition: all .3s;
    position: relative;
    overflow: hidden;
    }
    .btn-join{
    font-size: 14px;
    color: white;
    background-color: #4D3DD4;
    
    padding: 12px 30px;
    display: inline;
    border-radius: 25px;
    font-weight: 400;
    text-transform: capitalize;
    letter-spacing: 0.5px;
    transition: all .3s;
    position: relative;
    overflow: hidden;
    }
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style = "background: #1f2122;" >
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
	
	<form id="frm" action="login" method="POST">
	
	
	<div>
		<input id="orderID" value="${responseDTO.partner_order_id}">
		<input id="userID" value="${responseDTO.Partner_user_id}">
		 
		<h2 style="color: #ec6090;">로그인</h2>
		
		
	</div>
	<div class ="color-crimson">
		<%-- ${msg} --%>
	</div>
		
		<div>
			<button class="btn-login">로그인</button>			
		</div>
		
	</form>
	
</body>
</html>