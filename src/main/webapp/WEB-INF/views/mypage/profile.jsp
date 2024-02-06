
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
                      <li>Coin<span>${member.member_Jumsu}</span></li>
                      <li>Friends Online <span>${member.}</span></li>
                      <li>Live Streams <span>${member.}</span></li>
                      <li>Clips <span>${member.member_Coin}</span></li>
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
         
        </div>
      </div>
    </div>
  </div>
  
  <c:import url="../temps/footer.jsp"></c:import>

  </body>

</html>
