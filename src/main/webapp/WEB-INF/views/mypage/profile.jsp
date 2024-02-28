
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
 <c:import url="../temps/header_css.jsp"></c:import>
 
 <link rel="style" href="/resources/jandi/glanceyear.css">
<style>
 rect.day { fill: #27292a; shape-rendering: crispedges; }
 rect.day:hover { stroke: #aaa; stroke-width: 1px; }
/*  rect.day[data-count] { fill: #3d9692; }
 rect.day[data-count='1'] { fill: #c3dbda; }
 rect.day[data-count='2'] { fill: #5caeaa; }
 rect.day[data-count='3'] { fill: #277672; } */
 
 rect.day[data-count='1'] { fill: #47194a; }
 rect.day[data-count='2'] { fill: #97099a; }
 rect.day[data-count='3'] { fill: #B900B9; }
 rect.day[data-count='4'] { fill: #F0F; }
 
svg text { fill: #CCC; font-size: 9px; }
svg text.month { fill: #AAA; }

 #debug{
 color : white;
 }
 .glanceyear-content{
 	overflow-x: auto;
 	width:100%;
 }
 .glanceyear-legend {
	color: #aaa;
	float: right;
	font-size: 12px;
	text-align: middle;
	text-wrap: none;
}
.glanceyear-summary{
	margin-top : 2%; 
}
.glanceyear-summary{
	width:660px;
}
.glanceyear-legend span { display: inline-block; height: 10px; width: 10px; }

</style>

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

   <!-- ***** Header Area Start ***** -->
  <c:import url="../temps/header.jsp"></c:import>
  <!-- ***** Header Area End ***** -->
<div style="background-color: white; margin-top: 120px; padding-top: 0px">

  <div class="container">
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
                      <li>Coin<span>${member.member_Coin}</span></li>
                    </ul>
                  </div>
                </div>
                
                            <div class="glanceyear-content sang" id="demo">

				</div>
				<div class="glanceyear-summary sang">
				<div class="glanceyear-legend">
				Less&nbsp;
				<span style="background-color: #27292a"></span>
				<span style="background-color: #47194a"></span>
				<span style="background-color: #97099a"></span>
				<span style="background-color: #B900B9"></span>
				<span style="background-color: #F0F"></span>
				
				
				
				&nbsp;More
			</div>
			
			<span id="debug"></span>
		</div>
                
              
              </div>
            </div>
          </div>
          <!-- ***** Banner End ***** -->

          <!-- ***** 구매 앝이템 리스트***** -->
          <div class="most-popular">
            <div class="row">
              <div class="col-lg-12">
                <div class="heading-section">
                  <h4><em>Most Popular</em> Right Now</h4>
                	</div>
                	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				  <li class="nav-item" role="presentation">
				    <button class="nav-link active" id="pills-list-tab" data-bs-toggle="pill" data-bs-target="#list-all" type="button" role="tab" aria-controls="pills-home" aria-selected="true">전체</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list1-tab" data-bs-toggle="pill" data-bs-target="#list-group1" type="button" role="tab" aria-controls="pills-list1" aria-selected="false">배경</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list2-tab" data-bs-toggle="pill" data-bs-target="#list-group2" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">테두리</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list3-tab" data-bs-toggle="pill" data-bs-target="#list-group3" type="button" role="tab" aria-controls="pills-disabled" aria-selected="false" >기타</button>
				  </li>
				   <li class="nav-item" role="presentation">
				    <button class="nav-link" id="pills-list4-tab" data-bs-toggle="pill" data-bs-target="#list-group4" type="button" role="tab" aria-controls="pills-disabled" aria-selected="false" >기타</button>
				  </li>
				   
				</ul>
                <div class="tab-content row" id="pills-tabContent" >
				  <div class="tab-pane fade show active col-lg-12 row" id="list-all" role="tabpanel" aria-labelledby="pills-list-tab" tabindex="0"></div>
				  <div class="tab-pane fade row" id="list-group1" role="tabpanel" aria-labelledby="pills-list1-tab" tabindex="0"></div>
				  <div class="tab-pane fade row" id="list-group2" role="tabpanel" aria-labelledby="pills-list2-tab" tabindex="0"></div>
				  <div class="tab-pane fade row" id="list-group3" role="tabpanel" aria-labelledby="pills-disabled-tab" tabindex="0"></div>
				  <div class="tab-pane fade row" id="list-group4" role="tabpanel" aria-labelledby="pills-list2-tab" tabindex="0"></div>
				  
				</div>
<!--                   <div class="col-lg-12">
                    <div class="main-button">
                      <a href="browse.html">Discover Popular</a>
                    </div>
                  </div> -->
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
	<input id="memberID"  type="hidden" value="${member.member_ID}"/> 
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/js/Mypage/Mypage.js"></script>
	<script src="/resources/jandi/jquery.glanceyear.js"></script>
	

	  <script>

      let map = "${map}";
      let map2 = map.replace(/[{}]/g,"");
      let ar = map2.split(",");
      let massive = [];
      for(let ar2 of ar){
        let [key,value] = ar2.split("=");
        key =key.trim();
        if(key.charAt(5) == '0'){
          key = key.substring(0,5)+key.substring(6);
        }
        let obj = {date:key.trim(),value:value.trim()};
        massive.push(obj);
      }
      
     

$('#demo').glanceyear(massive,{
eventClick: function(e) { $('#debug').html('Date: '+ e.date + ', Count: ' + e.count); },
months: ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],
weeks: ['M','T','W','T','F','S','S'],
targetQuantity:'.glanceyear-quantity',
tagId:'glanceyear-svgTag',
showToday:false,
today:new Date()
});



    </script>	
  </body>

</html>
