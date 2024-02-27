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
	
	#table{
		
	}
	.tbody{
		margin-top : 7%;
		padding: 12px 30px;
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
		
	</div> 
	
	<div class="tbody">
	<table id="table" class="table table=dark">
		<tr>
			<th class="color-white">결제일</th>
			<th class="color-white">아이템이름</th>			
			<th class="color-white">가격</th>
			<th class="color-white">결제종류</th>
			<th class="color-white">영수증</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
			
		<tr>
			<td class="color-white memberid">${dto.approved_at}</td>
			<td class="color-white">${dto.item_name}</td>			
			<td class="color-white member_role" style="text-align: justify">&#8361<span>${dto.total}</span></td>
			<td class="color-white">${dto.payment_method_type}</td>
			<td class="color-white"><a href="receipt?tid=${dto.tid}" target="_blank">영수증</a></td>
		</c:forEach>
	
	</table>
	</div>
						<%-- <div class="mb-3 pagerlabel">
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
						</div> --%>
	
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>