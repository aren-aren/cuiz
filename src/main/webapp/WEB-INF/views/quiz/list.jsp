<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">

<c:import url="../temps/header_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/quiz/quiz.css">

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
                    <div class="col-lg-12">
                        <div class="gaming-library">
                            <div class="heading-section">
                                <h4 class="middle-title"><em>Quiz</em> List</h4>
                            </div>
                            <form action="list" method="get">
                                <div class="row">
                                            <div class="col-2">
                                                <select id="level-select"
                                                        name="searchItem"
                                                        class="form-select form-select-sm"
                                                        data-level="${pager.searchItem}">
                                                    <option value="0" selected>난이도</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                            </div>
                                            <div class="col-2">
                                                <select id="kind-select"
                                                        name="kind"
                                                        class="form-select form-select-sm"
                                                        data-kind="${pager.kind}">
                                                    <option value="0" selected>모든 문제</option>
                                                    <option value="1">푼 문제</option>
                                                    <option value="2">안 푼 문제</option>
                                                    <option value="3">실패한 문제</option>
                                                </select>
                                            </div>
                                            <div class="col-2">
                                                <select id="sort-select"
                                                        name="sort"
                                                        class="form-select form-select-sm"
                                                        data-sort="${pager.sort}">
                                                    <option value="0" selected>기본순</option>
                                                    <option value="1">정답률 높은순</option>
                                                    <option value="2">정답률 낮은순</option>
                                                    <option value="3">많이 도전 한순</option>
                                                    <option value="4">적게 도전 한순</option>
                                                </select>
                                            </div>
                                            <div class="col-4">
                                                <input id="search-Input"
                                                       type="text"
                                                       class="form-control form-control-sm"
                                                       name="search"
                                                       value="${pager.search}"
                                                       data-search="${pager.search}">
                                            </div>
                                            <div class="col-1">
                                                <button class="btn btn-cuiz btn-sm form-control" id="searchBtn">검색</button>
                                            </div>
                                            <div class="col-1">
                                                <button type="reset" class="btn btn-secondary btn-sm">초기화</button>
                                            </div>
                                    </div>
                            </form>
                            <div class="col-12">
                                <table class="table table-dark table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width: 10%">번호</th>
                                        <th style="width: 50%">제목</th>
                                        <th style="width: 10%">난이도</th>
                                        <th style="width: 10%">도전한 사람</th>
                                        <th style="width: 10%">맞힌 사람</th>
                                        <th style="width: 10%">정답률</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="dto">
                                        <tr>
                                            <td>${dto.quiz_No}</td>
                                            <td><a href="solve?quiz_No=${dto.quiz_No}">${dto.quiz_Title}</a></td>
                                            <td>${dto.quiz_Level}</td>
                                            <td>${dto.total_Count}</td>
                                            <td>${dto.correct_Count}</td>
                                            <td>${dto.correct_Rate}%</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div id="paging-div" data-page="${pager.page}">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination justify-content-center">
                                            <c:if test="${!pager.start}">
                                                <li class="page-item">
                                                    <button class="page-link" data-page="${pager.startNum-1}">Previous
                                                    </button>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                                                <li class="page-item">
                                                    <button class='page-link ${(pager.page == i)?"current-page":""}'
                                                            data-page="${i}">${i}</button>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${!pager.last}">
                                                <li class="page-item">
                                                    <button class="page-link" data-page="${pager.lastNum+1}">Next
                                                    </button>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/quiz/list.js"></script>
<c:import url="../temps/footer.jsp"></c:import>

</body>

</html>
