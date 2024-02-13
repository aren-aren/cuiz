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
			 		<div class="gaming-library">
			   			<div class="col-lg-12">
							<div class="heading-section">
								<h4>${board} List</h4>
							</div>
						

							<div class="item">
								<ul>
									<li><h3>No</h3></li>
									<li><h3>Title</h3></li>
									<li><h3>Writer</h3></li>
									<li><h3>Date</h3></li>
									<li><h4>More &emsp; &emsp; &emsp;</h4></li>
								</ul>
							</div>

							<c:if test="${list.size()==0}">
								<li><h3>검색결과가 없습니다.</h3></li>
							</c:if>
							
							<c:forEach items="${list}" var="dto">
								<c:set var="f" value="0"></c:set>
								
								<c:catch>
									<c:set var="f" value="${dto.flag}"></c:set>
										<c:if test="${f eq 1 }">
												<li><h3></h3></li>
												<li><h3>삭제된 게시판입니다.</h3></li>
												<li><h3></h3></li>
												<li><h3></h3></li>
										</c:if>
								</c:catch>

								<c:if test="${f eq 0 }">
									<div class="item">
										<ul>
											<li><h3>${dto.board_Num}</h3></li>
											<li><h3>${dto.board_Title}</h3></li>
											<li><h3>${dto.member_ID}</h3></li>
											<li><h3>${dto.board_Date}</h3></li>
											<li>
												<c:if test="${not empty member}">
													<div class="main-border-button">
														<a href="./detail?board_Num=${dto.board_Num}">
															<c:catch>
																<c:forEach begin="1" end="${dto.board_Depth}">--</c:forEach>
															</c:catch>
														자세히 보기</a>
													</div>
												</c:if>
											</li>
										</ul>
									</div>
								</c:if>
							</c:forEach>
						</div>


						<div class="mb-3">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:if test="${!pager.start}">
										<li class="page-item">
											<a class="page-link"
											href="./list?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a>
										</li>
									</c:if>
									<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
										var="i">
										<li class="page-item"><a class="page-link"
											href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
									</c:forEach>

									<c:if test="${!pager.last}">
										<li class="page-item">
											<a class="page-link"
											href="./list?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</c:if>
								</ul>
							</nav>
						</div>
						
						<div>
							<form class="row g-3" action="./list">
								<div class="col-auto">
									<select name="kind" class="form-select"
										aria-label="Default select example">
										<option class="a" value="kind1">Title</option>
										<option class="a" value="kind2">Contents</option>
										<option class="a" value="kind3">Writer</option>
										<option class="a" value="kind4">Title+Contents+Writer</option>
									</select>
								</div>

								<div class="col-auto">
									<label for="search" class="visually-hidden">Search</label> <input
										type="text" name="search" class="form-control" id="search">
								</div>

								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-3">검색</button>
								</div>
							</form>
						</div>
							

						<c:if test="${not empty member}">
							<div class="col-lg-12">
								<div class="main-button">
									<a href="./add">Add</a>
								</div>
							</div>
						</c:if>


					</div>
				</div>
			</div>
		</div>
	</div>


  <c:import url="../temps/footer.jsp"></c:import>


</body>

</html>
