
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

          <!-- ***** Featured Games Start ***** -->
          <div class="row">
            <div class="col-lg-8">
              <div class="featured-games header-text">
                <div class="heading-section">
                  <h4><em>Featured</em> Games</h4>
                </div>
                <div class="owl-features owl-carousel">
                  <div class="item">
                    <div class="thumb">
                      <img src="/resources/assets/images/featured-01.jpg" alt="">
                      <div class="hover-effect">
                        <h6>2.4K Streaming</h6>
                      </div>
                    </div>
                    <h4>CS-GO<br><span>249K Downloads</span></h4>
                    <ul>
                      <li><i class="fa fa-star"></i> 4.8</li>
                      <li><i class="fa fa-download"></i> 2.3M</li>
                    </ul>
                  </div>
                  <div class="item">
                    <div class="thumb">
                      <img src="/resources/assets/images/featured-02.jpg" alt="">
                      <div class="hover-effect">
                        <h6>2.4K Streaming</h6>
                      </div>
                    </div>
                    <h4>Gamezer<br><span>249K Downloads</span></h4>
                    <ul>
                      <li><i class="fa fa-star"></i> 4.8</li>
                      <li><i class="fa fa-download"></i> 2.3M</li>
                    </ul>
                  </div>
                  <div class="item">
                    <div class="thumb">
                      <img src="/resources/assets/images/featured-03.jpg" alt="">
                      <div class="hover-effect">
                        <h6>2.4K Streaming</h6>
                      </div>
                    </div>
                    <h4>Island Rusty<br><span>249K Downloads</span></h4>
                    <ul>
                      <li><i class="fa fa-star"></i> 4.8</li>
                      <li><i class="fa fa-download"></i> 2.3M</li>
                    </ul>
                  </div>
                  <div class="item">
                    <div class="thumb">
                      <img src="/resources/assets/images/featured-01.jpg" alt="">
                      <div class="hover-effect">
                        <h6>2.4K Streaming</h6>
                      </div>
                    </div>
                    <h4>CS-GO<br><span>249K Downloads</span></h4>
                    <ul>
                      <li><i class="fa fa-star"></i> 4.8</li>
                      <li><i class="fa fa-download"></i> 2.3M</li>
                    </ul>
                  </div>
                  <div class="item">
                    <div class="thumb">
                      <img src="/resources/assets/images/featured-02.jpg" alt="">
                      <div class="hover-effect">
                        <h6>2.4K Streaming</h6>
                      </div>
                    </div>
                    <h4>Gamezer<br><span>249K Downloads</span></h4>
                    <ul>
                      <li><i class="fa fa-star"></i> 4.8</li>
                      <li><i class="fa fa-download"></i> 2.3M</li>
                    </ul>
                  </div>
                  <div class="item">
                    <div class="thumb">
                      <img src="/resources/assets/images/featured-03.jpg" alt="">
                      <div class="hover-effect">
                        <h6>2.4K Streaming</h6>
                      </div>
                    </div>
                    <h4>Island Rusty<br><span>249K Downloads</span></h4>
                    <ul>
                      <li><i class="fa fa-star"></i> 4.8</li>
                      <li><i class="fa fa-download"></i> 2.3M</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4">
              <div class="top-downloaded">
                <div class="heading-section">
                  <h4><em>Top</em> Downloaded</h4>
                </div>
                <ul>
                  <li>
                    <img src="/resources/assets/images/game-01.jpg" alt="" class="templatemo-item">
                    <h4>Fortnite</h4>
                    <h6>Sandbox</h6>
                    <span><i class="fa fa-star" style="color: yellow;"></i> 4.9</span>
                    <span><i class="fa fa-download" style="color: #ec6090;"></i> 2.2M</span>
                    <div class="download">
                      <a href="#"><i class="fa fa-download"></i></a>
                    </div>
                  </li>
                  <li>
                    <img src="/resources/assets/images/game-02.jpg" alt="" class="templatemo-item">
                    <h4>CS-GO</h4>
                    <h6>Legendary</h6>
                    <span><i class="fa fa-star" style="color: yellow;"></i> 4.9</span>
                    <span><i class="fa fa-download" style="color: #ec6090;"></i> 2.2M</span>
                    <div class="download">
                      <a href="#"><i class="fa fa-download"></i></a>
                    </div>
                  </li>
                  <li>
                    <img src="/resources/assets/images/game-03.jpg" alt="" class="templatemo-item">
                    <h4>PugG</h4>
                    <h6>Battle Royale</h6>
                    <span><i class="fa fa-star" style="color: yellow;"></i> 4.9</span>
                    <span><i class="fa fa-download" style="color: #ec6090;"></i> 2.2M</span>
                    <div class="download">
                      <a href="#"><i class="fa fa-download"></i></a>
                    </div>
                  </li>
                </ul>
                <div class="text-button">
                  <a href="profile.html">View All Games</a>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Featured Games End ***** -->


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
					       <li class="nav-item ">
					          <button class=" text-danger" type="button" aria-current="page" value="kind0">전체</button>
					        </li>
					        <li class="nav-item ">
					          <button class=" text-danger" type="button" aria-current="page"  value="kind2">Coin</button>
					        </li>
					        <li class="nav-item ">
					          <button class=" text-danger" type="button" aria-current="page"  value="kind1">현금</button>
					        </li>
					        <c:if test="${fn:toUpperCase(member.member_Role)=='ADMIN'}">     
					        	<li class="nav-item text-danger">					               
							         <button class=" text-danger" type="button" aria-current="page" href="#" value="kind1">삭제된 아이템</button>
							       
					       		</li>
			                </c:if>
					        <li>
						        <select name="sort" id="sort">
						       		<option>정렬</option>
									<option value="PricaeAsc">가격:오름차순</option>
									<option value="PricaeDesc">가겨:내림차순</option>				       		
						       	</select>
					        </li>
					        <li>
						        <select name="searchItem">
									<option value="itemName">제목</option>
									<option value="itemContents">내용</option>
						       		<option value="itemAll">제목+내용</option>
					     	  	</select>
					        </li>
					        <li>
					       	 <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
					        
					        </li>
					        <li>
					     	  	 <button class="main-border-button button" id="search2"  type="button">Search</button>
					        </li>				        
					     
					      </ul>
				      </div>
				      
				      <div class="main-button" >
				       	
				     
				        
				       
				       </div>
				       	
				      </form>
				    </div>
				  </div>
				</nav>            
             	
                <div class="heading-section">
                  <h4><em>Most Popular</em> Right Now</h4>              
                </div>
                
                <div class="row" id="formun">            
                
                
           <%--      <c:forEach items="${list}" var="list">
           		
           		<c:if test="${list.item_Num>=10000 and list.item_Num<=10100 }">
           		 <div class="col-lg-3 col-sm-6">
                    <div class="item">
                  	 <a href="detail?item_Num=${list.item_Num}">
                      	<img src="data:image/jpeg;base64,${list.item_Photo_to_String}" alt="">
                     </a>
                     
                      <a href="detail?item_Num=${list.item_Num}">
                      	<h4>${list.item_Name}<br><span>${list.item_Price}</span></h4> 
                      </a>
                     
                     	
                      <ul>
                        <li><i class="fa fa-star"></i> 4.8</li>
                        <li><i class="fa fa-download"></i> 2.3M</li>
                      </ul>
                    </div>
                  </div>
           		</c:if>
               </c:forEach>   
                 --%>
           
           
           <%--  삭제등 기타 여부
                <c:if test="${list.flag eq 1}">
            --%>

        <%--         
                </c:if>
                 --%>
                
             
                 
                  
                  
                  
                  
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
