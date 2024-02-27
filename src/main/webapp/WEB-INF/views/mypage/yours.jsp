
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
 <c:import url="../temps/header_css.jsp"></c:import>
 <link rel="style" href="/resources/jandi/glanceyear.css">

<style>
 rect.day { fill: #eee; shape-rendering: crispedges; }
 rect.day:hover { stroke: #aaa; stroke-width: 1px; }
 rect.day[data-count] { fill: #3d9692; }
 rect.day[data-count='1'] { fill: #c3dbda; }
 rect.day[data-count='2'] { fill: #5caeaa; }
 rect.day[data-count='3'] { fill: #277672; }
svg text { fill: #CCC; font-size: 9px; }
svg text.month { fill: #AAA; }
 #debug{
 color : white;
 }
 
 .glanceyear-legend {
	color: #aaa;
	float: right;
	font-size: 12px;
	text-align: middle;
	text-wrap: none;
}
.sang{
	width:710px;
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
                    <img src="data:image/png;base64,${yours.member_Profile_String}" alt="" style="border-radius: 23px;">
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <div class="main-info header-text">
                       <span>${yours.member_Role}</span>
                      <h4>${yours.member_Nick}</h4>     
                    </div>
                  </div>
                  <div class="col-lg-4 align-self-center">
                     <ul>
                      <li>점수<span>${yours.member_Jumsu}</span></li>
                      <li>출석일 수 <span>${yours.member_TotalAtt}</span></li>
                      <li>가입일 <span>${yours.member_RegDate}</span></li>
                    </ul>
                  </div>
                </div>
                <div class="glanceyear-content sang" id="demo">

				</div>
				<div class="glanceyear-summary sang">
				<div class="glanceyear-legend">
				Less&nbsp;
				<span style="background-color: #eee"></span>
				<span style="background-color: #c3dbda"></span>
				<span style="background-color: #5caeaa"></span>
				<span style="background-color: #277672"></span>
				&nbsp;More
			</div>
			
			<span id="debug"></span>
		</div>
                
              </div>
            </div>
          </div>
          <!-- ***** Banner End ***** -->

          <!-- ***** 구매 앝이템 리스트***** -->
          	
          <!-- ***** Most Popular End ***** -->
          <!-- ***** Gaming Library End ***** -->
        </div>
      </div>
    </div>
  </div>
</div>
	<input id="memberID"  type="hidden" value="${yours.member_ID}"/> 
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/jandi/jquery.glanceyear.js"></script>
	

	  <script>
    let massive = [
    {date:'2024-2-1', value:'2'},	
    {date:'2023-8-4', value:'2'},
    {date:'2023-9-3', value:'3'},
    {date:'2023-10-14', value:'2'},
    {date:'2023-10-13', value:'8'},
     {date:'2023-7-3', value:'1'},
    {date:'2023-7-4', value:'2'},
    {date:'2023-7-7', value:'3'},
    {date:'2023-6-3', value:'1'},
    {date:'2023-6-4', value:'2'},
    {date:'2023-6-5', value:'3'},
    {date:'2023-6-14', value:'2'}
];

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
