<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../temps/header_css.jsp"></c:import>
<style>
	.main-button{
	margin-left : 25%;
	margin-top : 7%;
    font-size: 14px;
    color: #fff;
    background-color: #e75e8d;
    padding: 12px 30px;
    display: inline-block;
    border-radius: 25px;
    font-weight: 400;
    text-transform: capitalize;
    letter-spacing: 0.5px;
    transition: all .3s;
    position: relative;
    overflow: hidden;
	}
	#table{
		
	}
	.tbody{
		width:50%;
		margin-left : 25%;
	}
	.color-white{
		color : white;
	}
	.member_role{
		width : 100px;
	}
	.pager_btn{
		background-color: black;
		color : white;
		
	}
	.pager_btn:hover {
		background-color: #e75e8d; 
	}
	.select{
		background-color: #e75e8d; 
	}
	.pagerlabel{
		margin-left : 45%;
	}
	</style>

</head>
	
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	<div>
		<a class="main-button" href="/member/list?page=1">Member_List</a>
	</div>
	
	<div class="tbody">
	<table id="table" class="table table=dark">
		<tr>
			<th class="color-white">아이디</th>
			<th class="color-white">닉네임</th>
			<th class="color-white">탈퇴일</th>
			<th class="color-white">권한</th>
			<th class="color-white">계정 복구</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
			
		<tr>
			<td class="color-white memberid">${dto.member_ID}</td>
			<td class="color-white">${dto.member_Nick}</td>
			<td class="color-white">${dto.member_DelDate}</td>
			<td class="color-white member_role">${dto.member_Role}</td>
			<td class="color-white"><a href="/member/user_recovered?member_ID=${dto.member_ID}" class="btn btn-primary">V</a></td>
		</c:forEach>
		
	</table>
	</div>
						<div class="mb-3 pagerlabel">
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
										<li class="page-item"><a class="page-link pager_btn ${pager.page==i?"select":""}"
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
	
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>