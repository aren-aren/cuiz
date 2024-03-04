
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
 <c:import url="../temps/header_css.jsp"></c:import>

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

  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-content">

          <!-- ***** Featured Start ***** -->
          <div class="row">
            <div class="col-lg-12">
              <div class="feature-banner header-text">
                <div class="row">
           		  
                 
                </div>
              </div>
            </div>
          </div> -
          <!-- ***** Featured End ***** -->

          <!-- ***** Details Start ***** -->
          <div class="game-details">
            <div class="row">
              <div class="col-lg-12">
                <h2>${dto.item_Name} Details</h2>
              </div>              
              <div class="col-lg-12">
                <div class="content">
                  <div class="row">                    
                 <div class="col-lg-4">
           		  <c:choose>
           		  	<c:when test="${dto.item_Group==1}">
                    <video src="${dto.item_Photo_to_String}" width=100%></video>         		  	
           		  	</c:when>
           		  	<c:when test="${dto.item_Group!=1}">
           		  	 <img src="${dto.item_Photo_to_String}" alt="" style="border-radius: 23px;">           		  	
           		  	</c:when>
           		  </c:choose>
           		  	
                  </div> 
                    <div class="col-lg-12">
                      <p> ${dto.item_Contents}</p>
                    <div class="col-lg-8">
                      	<form id="delBtnFrm">
                      		<input type="hidden" id="item_Num" name="item_Num" value="${dto.item_Num}">
	                      <div class="main-border-button">
	                        
	                      
	                         <c:choose>
			           		  	<c:when test="${dto.item_Group==0}">
			                    	<button  type="button"   id="kakaopBtn">Buy ${dto.item_Name} Now!</buttons>		  	
			           		  	</c:when>
			           		  	<c:when test="${dto.item_Group>0}">
			           		  		<button  type="button"   id="buyNowBtn">Buy ${dto.item_Name} Now!</button>    		  	
			           		  	</c:when>
			           		  </c:choose>
	                        
	                      <!--   <button  type="button"   id="adCartBtn">Jangbaguni</button> -->
	                      </div>
	                       <div class="main-border-button">                       	           
		                    <button type="button"   id="updateBtn">Update</button> 
		                    <button type="button"   id="deleteBtn">Delete</button>
		                    </div> 
                      	</form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Details End ***** -->          

        </div>
      </div>
    </div>
  </div>  
  <c:import url="../temps/footer.jsp"></c:import>
  </body>
  	<script src="/resources/js/shop/detail.js"></script>
	
</html>
