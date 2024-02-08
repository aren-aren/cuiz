
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
                      <p>You Haven't Gone Live yet. Go Live By Touching The Button Below.</p>
                      <div class="main-border-button">
                        <a href="#">Start Live Stream</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <ul>
                      <li>점수<span>${member.member_Jumsu}</span></li>
                      <li>출석일 수 <span>${member.member_Password}</span></li>
                      <li>가입일 <span>${member.member_RegDate}</span></li>
                      <li>Coin<span>${member.member_Coin}</span></li>
                    </ul>
                  </div>
                </div>
                <div class="row">
                  <div class="col-lg-12">
                    <div class="clips">
                      <div class="row">
                        <div class="col-lg-12">
                          <div class="heading-section">
                            <h4><em>Your Most Popular</em> Clips</h4>
                          </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                          <div class="item">
                            <div class="thumb">
                              <img src="assets/images/clip-01.jpg" alt="" style="border-radius: 23px;">
                              <a href="https://www.youtube.com/watch?v=r1b03uKWk_M" target="_blank"><i class="fa fa-play"></i></a>
                            </div>
                            <div class="down-content">
                              <h4>First Clip</h4>
                              <span><i class="fa fa-eye"></i> 250</span>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                          <div class="item">
                            <div class="thumb">
                              <img src="assets/images/clip-02.jpg" alt="" style="border-radius: 23px;">
                              <a href="https://www.youtube.com/watch?v=r1b03uKWk_M" target="_blank"><i class="fa fa-play"></i></a>
                            </div>
                            <div class="down-content">
                              <h4>Second Clip</h4>
                              <span><i class="fa fa-eye"></i> 183</span>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                          <div class="item">
                            <div class="thumb">
                              <img src="assets/images/clip-03.jpg" alt="" style="border-radius: 23px;">
                              <a href="https://www.youtube.com/watch?v=r1b03uKWk_M" target="_blank"><i class="fa fa-play"></i></a>
                            </div>
                            <div class="down-content">
                              <h4>Third Clip</h4>
                              <span><i class="fa fa-eye"></i> 141</span>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                          <div class="item">
                            <div class="thumb">
                              <img src="assets/images/clip-04.jpg" alt="" style="border-radius: 23px;">
                              <a href="https://www.youtube.com/watch?v=r1b03uKWk_M" target="_blank"><i class="fa fa-play"></i></a>
                            </div>
                            <div class="down-content">
                              <h4>Fourth Clip</h4>
                              <span><i class="fa fa-eye"></i> 91</span>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-12">
                          <div class="main-button">
                            <a href="#">Load More Clips</a>
                            
                            <div>
                            	<div id="perList">
                            	
                            	</div>
                            </div>
                            
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Banner End ***** -->
          <div class="most-popular">
            <div class="row">
              <div class="col-lg-12">
              <nav class="navbar navbar-expand-lg bg-body-tertiary">
				  <div class="container-fluid">
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>   
			  
				    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				    
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
                  
                  <div class="col-lg-12">
                    <div class="main-button">
                      <a href="browse.html">Discover Popular</a>
                    </div>
                  </div>
                  
                </div>
              </div>
            </div>
          </div>
         
        </div>
      </div>
    </div>
  </div>
  
  <c:import url="../temps/footer.jsp"></c:import>

  </body>

</html>
