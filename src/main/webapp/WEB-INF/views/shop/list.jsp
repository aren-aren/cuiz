
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>


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

          <!-- ***** Live Stream Start ***** -->
			  <!-- ***** Item NAV Start ***** -->	 
          <div class="most-popular">
            <div class="row">
              <div class="col-lg-12">
              <nav class="navbar navbar-expand-lg bg-body-tertiary">
				  <div class="container-fluid">
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    
			  
				    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				      <c:if test="${fn:toUpperCase(member.member_Role)=='ADMIN'}">     
				   		
				   		   <a class="navbar-brand text-danger" href="add">Insert Item</a>
				   		
				   	  </c:if>
				      <div id="searchBtn">
				      <form class="d-flex" role="search" id="searchfrm">
					      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
					       <li class="nav-item col-1">
					          <button class=" text-danger valBtn" type="button" aria-current="page" value="kind0" onclick="fetchItem('kind0')">전체</button>
					        </li>
					        <li class="nav-item col-1">
					          <button class=" text-danger " type="button" aria-current="page"  value="kind2" onclick="fetchItem('kind2')">Coin</button>
					        </li>
					        <li class="nav-item col-1">
					          <button class=" text-danger valBtn" type="button" aria-current="page"  value="kind1" onclick="fetchItem('kind1')">현금</button>
					        </li>
					        <c:if test="${fn:toUpperCase(member.member_Role)=='ADMIN'}">     
					        	<li class="nav-item text-danger col-3">					               
							         <button class=" text-danger" type="button" aria-current="page" href="#" value="kind3">삭제된 아이템</button>
							       
					       		</li>
			                </c:if>
					        <li class="col-3">
						        <select name="sort" id="sort">
						       		<option>=====정렬====</option>
									<option value="PricaeAsc">가격:오름차순</option>
									<option value="PricaeDesc">가격:내림차순</option>				       		
						       	</select>
					        </li>
					        <li class="col-2">
						        <select name="searchItem">
									<option value="itemName">제목</option>
									<option value="itemContents">내용</option>
						       		<option value="itemAll">제목+내용</option>
					     	  	</select>
					        </li>
					        <li>
					        
					        </li>
					        <li class="col-4">
					       	 <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
					        
					        </li>
					        <li>
					        </li>				        
					     
					      </ul>
					     	  	 <button class="main-border-button button" id="search2"  type="button">Search</button>
				      
				      <div class="main-button" >
				       	
				     
				        
				       
				       </div>
				       	
				      </form>
				      </div>
				    </div>
				  </div>
				</nav>            
             	
                <div class="heading-section">
                  <h4><em>Most Popular</em> Right Now</h4>              
                </div>
                
                <div class="row" id="formun">
                  
                  <div class="col-lg-12">
                    <div class="main-button">
                      <a href="browse.html">Discover Popular</a>
                    </div>
                  </div>
                  
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Live Stream End ***** -->

        </div>
      </div>
    </div>
  </div>
  
  <c:import url="../temps/footer.jsp"></c:import>	
  	<script src="/resources/js/shop/list.js"></script>
  </body>

</html>
