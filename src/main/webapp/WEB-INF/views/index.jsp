<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<c:import url="./temps/header_css.jsp"></c:import>

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

  <c:import url="./temps/header.jsp"></c:import>
  <!-- ***** Header Area End ***** -->

  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-content">

          <!-- ***** Banner Start ***** -->
          <div class="main-banner">
            <div class="row">
              <div class="col-lg-7">
                <div class="header-text">
                  <h6>Welcome To Cyborg</h6>
                  <h4><em>Browse</em> Our Popular Games Here</h4>
                  <div class="main-button">
                    <a href="browse.html">Browse Now</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Most Popular End ***** -->

          <!-- ***** Gaming Library Start ***** -->

	          <div class="gaming-library">
                  <div class="row">
                      <div class="col-lg-4">
                          <div class="top-streamers">
                              <div class="heading-section">
                                  <h4><em>최신</em> 게시글</h4>
                              </div>
                              <ul>
                                  <c:forEach items="${list2}" var="dto">
                                  <li>
                                      <a href="#">${dto.member_Nick}</a>
                                      <h6>${dto.board_Title}</h6>
                                      <span>${dto.board_Date}</span>
                                  </li>
                                  </c:forEach>
                              </ul>
                          </div>
                      </div>
                  <div class="col-lg-4">
                      <div class="heading-section">
                          <h4>최신 게시글</h4>
                      </div>
                      <c:forEach items="${list2}" var="dto" varStatus="status">
                          <div class="item">
                              <ul>
                                  <li><h4>제목</h4><span>${dto.board_Title}</span></li>
                                  <li><h4>작성자</h4><span>${dto.member_ID}</span></li>
                                  <li><h4>조회수</h4><span><i class="fa-regular fa-eye">${dto.board_Hit}</span></li>
                                  <li><div class="main-border-button"><a href="/qna/detail?board_Num=${dto.board_Num}">내용보기</a></div></li>
                              </ul>
                          </div>

                      </c:forEach>
                  </div>
	            <div class="col-lg-4">
	              <div class="heading-section">
	                <h4>일일 랭킹</h4>
	              </div>
	              <c:forEach items="${list}" var="dto" varStatus="status">
		              <div class="item">
		                <ul>
		                <c:if test="${status.index+1 eq 1}">
		                  <li><img src="/resources/assets/images/1등.png" alt="" class="templatemo-item"></li>
		                </c:if>
		                 <c:if test="${status.index+1 eq 2}">
		                  <li><img src="/resources/assets/images/2등.png" alt="" class="templatemo-item"></li>
		                </c:if>
		                 <c:if test="${status.index+1  eq  3 }">
		                  <li><img src="/resources/assets/images/3등.png" alt="" class="templatemo-item"></li>
		                </c:if>
		                 <c:if test="${status.index+1 eq 4  || status.index+1 eq 5}">
		                  <li><img src="" alt="" class="templatemo-item"></li>
		                </c:if>
		                  <li><h4>닉네임</h4><span>${dto.member_Nick}</span></li>
		                  <li><h4>오늘의 점수</h4><span>${dto.daily_Jumsu}</span></li>
		                  <li><div class="main-border-button"><a href="/mypage/yours?member_ID=${dto.member_ID}">정보보러가기</a></div></li>
		                </ul>
		              </div>

	              </c:forEach>
	            </div>
                  </div>
	          </div>
          <!-- ***** Gaming Library End ***** -->
        </div>
      </div>
    </div>
  </div>
  

  <c:import url="./temps/footer.jsp"></c:import>

  </body>

</html>
