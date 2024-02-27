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
			<th class="color-white">환불</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
			
		<tr>
			<td class="color-white memberid">${dto.approved_at}</td>
			<td class="color-white">${dto.item_name}</td>			
			<td class="color-white member_role" style="text-align: justify">&#8361<span>${dto.total}</span></td>
			<td class="color-white">${dto.payment_method_type}</td>
			<td class="color-white"><a href="receipt?tid=${dto.tid}" target="_blank">영수증</a></td>
			
			<c:if test="${not empty dto.canceled_at}">			
			<td><p style="text-color: #e75e8d;">환불완료</p></td>
			</c:if>
			<c:if test="${empty dto.canceled_at}">
				<td><button style="text-color: #e75e8d;" onclick="window.open('/purchase/cancellation?tid=${dto.tid}','결제취소','width:500px,height:300px,location=no,status=no,scrollbars=no');" >환불요청</button></td>
				<%-- <td><button style="text-color: #e75e8d;" onclick="window.open('/purchase/cancellation?tid=${dto.tid}','결제취소','width:500px,height:300px,location=no,status=no,scrollbars=no');" >환불요청</button></td> --%>
				
			</c:if>
		</c:forEach>
	
	</table>
	</div>
					
	
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>