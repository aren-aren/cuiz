
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<c:import url="../temps/header_css.jsp"></c:import>
<script src="https://kit.fontawesome.com/17a98cc585.js" crossorigin="anonymous"></script>


<body style="">

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

   <!-- ***** Header Area Start ***** -->
  <c:import url="../temps/header.jsp"></c:import>
  <!-- ***** Header Area End ***** -->
<div  id="videoB" style="position: relative; z-index:0; margin-top: 120px; padding-top: 0px " >

  <div  class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-content" style="margin-top:10px">

          <!-- ***** Banner Start ***** -->
          <div class="row">
            <div class="col-lg-12">
              <div class="main-profile ">
                <div class="row">
                  <div class="col-lg-4">
                    <img src="${avatar}" alt="" style="border-radius: 23px;">
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <div class="main-info header-text">
                       <span>${member.member_Role}</span>
                      <h4>${member.member_Nick}</h4>
                       <h4 class="data-id">${member.member_ID}</h4>
                      <div class="main-border-button">
                        <a href="/member/update">회원정보 수정</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 align-self-center">
                     <ul>
                      <li>점수<span>${member.member_Jumsu}</span></li>
                      <li>출석일 수 <span>${member.member_TotalAtt}</span></li>
                      <li>가입일 <span>${member.member_RegDate}</span></li>
                      <li>Coin<span id=coinSpn></span></li>
                    </ul>
                  </div>
                </div>              
              </div>
            </div>
          </div>
          <!-- ***** Banner End ***** -->
  		<span class="main-border-button">
         <button id="itemBtn" type="button" >아이템 목록</button>        
       </span>
       <span class="main-border-button">
         <button id="purcBtn" type="button">결제목록</button>
       </span>
          <!-- ***** 구매 앝이템 리스트***** -->
          <div class="most-popular" id="itemlist" >
            <div class="row">
              <div class="col-lg-12">
                <div class="heading-section">
                  <h4><em>Most Popular</em> Right Now</h4>
                	</div>
                	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				  <li class="nav-item" role="presentation">
				    <button class="nav-link active" id="pills-list-tab" data-bs-toggle="pill" data-bs-target="#listall" type="button" role="tab" aria-controls="pills-home" aria-selected="true">전체</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list1-tab" data-bs-toggle="pill" data-bs-target="#listgroup1" type="button" role="tab" aria-controls="pills-list1" aria-selected="false">배경</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list2-tab" data-bs-toggle="pill" data-bs-target="#listgroup2" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">테두리</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list3-tab" data-bs-toggle="pill" data-bs-target="#listgroup3" type="button" role="tab" aria-controls="pills-disabled" aria-selected="false" >기타</button>
				  </li>
				   <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list4-tab" data-bs-toggle="pill" data-bs-target="#listgroup4" type="button" role="tab" aria-controls="pills-disabled" aria-selected="false" >기타</button>
				  </li>
				   
				</ul>
                <div class="tab-content" id="pills-tabContent" >
				  <div class="tab-pane fade show active"  role="tabpanel" id="listall" aria-labelledby="pills-list-tab" tabindex="0">
				  	<div class="row" id="list-all"></div>
				  </div>
				  
				  <div class="tab-pane fade row" id="listgroup1" role="tabpanel" aria-labelledby="pills-list1-tab" tabindex="0">
				  		<div class="row" id="list-group1"></div>
				  </div>
				  <div class="tab-pane fade row" id="listgroup2" role="tabpanel" aria-labelledby="pills-list2-tab" tabindex="0">
				  		<div class="row" id="list-group2"></div>
				  </div>
				  <div class="tab-pane fade row" id="listgroup3" role="tabpanel" aria-labelledby="pills-disabled-tab" tabindex="0">
				  		<div class="row" id="list-group3"></div>
				  </div>
				  <div class="tab-pane fade row" id="listgroup4" role="tabpanel" aria-labelledby="pills-list2-tab" tabindex="0">
				  		<div class="row" id="list-group4"></div>
				  </div>
				  
				</div>
              </div>
            </div>
          </div>
          <!-- ***** Most Popular End ***** -->
          <!-- ***** Gaming Library End ***** -->
        </div>
      </div>
    </div>
  </div>
</div>
<div style="position: relative; z-index:0; margin-top: 120px; padding-top: 0px">
<c:import url="../temps/footer.jsp"></c:import>
</div>
	<input id="memCoin"  type="hidden" value="${member.member_Coin}"/> 
	<input id="memberID"  type="hidden" value="${member.member_ID}"/> 
	<script src="/resources/js/Mypage/Mypage.js"></script>
  </body>

</html>
