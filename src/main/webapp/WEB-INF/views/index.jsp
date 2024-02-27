<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
                        <div class="col-3 border-end mb-0 text-center">
                            <div class="fs-6 text-white opacity-50"> 전체 문제 </div>
                            <div class="h2 text-white text-cuiz">${statistic.numOfProblem}</div>
                            <div>
                                <a class="fs-6" href="quiz/list">문제 풀러 가기</a>
                            </div>
                        </div>
                        <div class="col-3 border-end mb-0 text-center">
                            <div class="fs-6 text-white opacity-50"> 전체 게시글 </div>
                            <div class="h2 text-white text-cuiz">${statistic.numOfBoard}</div>
                            <div>
                                <a class="fs-6" href="qna/list">게시판 보러 가기</a>
                            </div>
                        </div>
                        <div class="col-3 border-end mb-0 text-center">
                            <div class="fs-6 text-white opacity-50"> 전체 회원 </div>
                            <div class="h2 text-white text-cuiz">${statistic.numOfMember}</div>
                        </div>
                        <div class="col-3 mb-0 text-center">
                            <div class="fs-6 text-white opacity-50"> 최고점 </div>
                            <div class="h2 text-white text-cuiz">${statistic.maxJumsu}</div>
                            <div>
                                <a class="fs-6" href="quiz/list">문제를 풀고<br>점수를 올리세요</a>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="gaming-library">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="top-streamers bg-dark h-100">
                                <div class="heading-section">
                                    <a href="qna/list"><h4 class="d-inline-block"><em>최신</em> 게시글</h4></a>
                                </div>
                                <ul>
                                    <c:forEach items="${list2}" var="dto">
                                        <li class="main-list">
                                            <div class="fs-5">
                                                <a class="main-list-other"
                                                   href="mypage/yours?member_ID=${dto.member_ID}">@${dto.member_Nick}</a>
                                                <a class="main-list-title"
                                                   href="qna/detail?board_Num=${dto.board_Num}">${dto.board_Title}</a>
                                            </div>
                                            <div>
                                                <span class="fw-normal text-secondary"><fmt:formatDate value="${dto.board_Date}"
                                                                      pattern="yyyy-MM-dd HH:mm"/></span>
                                                <span class="text-secondary"><i class="fa-regular fa-eye me-1"></i>${dto.board_Hit}</span>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="top-streamers bg-dark h-100">
                                <div class="heading-section">
                                    <a href="quiz/list?sort=3"><h4 class="d-inline-block"><em>많이 도전한</em> 문제</h4></a>
                                </div>
                                <ul>
                                    <c:forEach items="${quizs}" var="dto">
                                        <li class="main-list">
                                            <div class="d-block">
                                                <div class="fw-normal d-inline-block text-secondary me-2">Lv.${dto.quiz_Level}</div>
                                                <div class="d-inline-block text-secondary"><i class="fa-solid fa-pencil me-2"></i>${dto.total_Count}</div>
                                            </div>
                                            <div class="fs-5 problem-ranking">
                                                <a class="main-list-other"
                                                   href="quiz/solve?quiz_No=${dto.quiz_No}">#${dto.quiz_No}</a>
                                                <a class="main-list-title"
                                                   href="quiz/solve?quiz_No=${dto.quiz_No}">${dto.quiz_Title}</a>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="top-streamers bg-dark h-100">
                                <div class="heading-section">
                                    <h4 class="d-inline-block"><em>일일</em> 랭킹</h4>
                                </div>
                                <ul>
                                    <c:forEach items="${list}" var="dto" varStatus="status">
                                        <li class="main-list pb-0">
                                            <div class="row">
                                                <div class="col-4 mb-0">
                                                    <c:if test="${status.index < 3}">
                                                    <img src="/resources/assets/images/${status.index+1}등.png"
                                                         class="templatemo-item">
                                                    </c:if>
                                                </div>
                                                <div class="col-8 mb-0">
                                                    <div class="row">
                                                        <img class="col-3 me-3 mb-0"
                                                             <c:if test="${not empty dto.member_Profile_String}">
                                                             src="data:image/png;base64,${dto.member_Profile_String}"
                                                            </c:if>
                                                            <c:if test="${empty dto.member_Profile_String}">
                                                             src="/resources/assets/images/basic.jpeg"
                                                            </c:if>
                                                             style="clip-path: circle(); width: 2.5rem; height: 2.5rem">
                                                        <h4 class="col-8 mb-0">
                                                            <a class="main-list-title"
                                                               href="mypage/yours?member_ID=${dto.member_ID}">
                                                                    ${dto.member_Nick}
                                                            </a>
                                                        </h4>
                                                        <div class="col-3"></div>
                                                        <div class="col-9"><h4>${dto.daily_Jumsu}</h4></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <%--<div class="col-lg-4">
                            <div class="heading-section">
                                <h4>최신 게시글</h4>
                            </div>
                            <div class="item">
                                <ul>
                                    <li><h4>제목</h4></li>
                                    <li><h4>작성자</h4></li>
                                    <li><h4>조회수</h4></li>
                                    <li><h4></h4></li>
                                </ul>
                                <c:forEach items="${list2}" var="dto" varStatus="status">
                                    <ul>
                                        <li><span>${dto.board_Title}</span></li>
                                        <li><<span>${dto.member_ID}</span></li>
                                        <li><span><i class="fa-regular fa-eye"></i>${dto.board_Hit}</span></li>
                                        <li>
                                            <div class="main-border-button"><a
                                                    href="/qna/detail?board_Num=${dto.board_Num}">내용보기</a></div>
                                        </li>
                                    </ul>

                                </c:forEach>
                            </div>
                        </div>--%>
                        <%--<div class="col-lg-4">
                            <div class="heading-section">
                                <h4>일일 랭킹</h4>
                            </div>
                            <c:forEach items="${list}" var="dto" varStatus="status">
                                <div class="item">
                                    <ul>
                                        <c:if test="${status.index+1 eq 1}">
                                            <li><img src="/resources/assets/images/1등.png" alt=""
                                                     class="templatemo-item"></li>
                                        </c:if>
                                        <c:if test="${status.index+1 eq 2}">
                                            <li><img src="/resources/assets/images/2등.png" alt=""
                                                     class="templatemo-item"></li>
                                        </c:if>
                                        <c:if test="${status.index+1  eq  3 }">
                                            <li><img src="/resources/assets/images/3등.png" alt=""
                                                     class="templatemo-item"></li>
                                        </c:if>
                                        <c:if test="${status.index+1 eq 4  || status.index+1 eq 5}">
                                            <li><img src="" alt="" class="templatemo-item"></li>
                                        </c:if>
                                        <li><h4>닉네임</h4><span>${dto.member_Nick}</span></li>
                                        <li><h4>오늘의 점수</h4><span>${dto.daily_Jumsu}</span></li>
                                        <li>
                                            <div class="main-border-button"><a
                                                    href="/mypage/yours?member_ID=${dto.member_ID}">정보보러가기</a></div>
                                        </li>
                                    </ul>
                                </div>

                            </c:forEach>
                        </div>--%>
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
