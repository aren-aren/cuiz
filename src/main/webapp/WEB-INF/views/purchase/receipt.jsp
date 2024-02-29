<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<c:import url="../temps/header_css.jsp"></c:import>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
       <div class="col-lg-12">
         <div class="main-profile ">
           <div class="row">                 
           
             <div class="col-lg-4 align-self-center">
                <ul>
                 <li>결제일 <span>${dto.APPROVED_AT}</span></li>
                 <li>상품이름<span>${dto.ITEM_NAME}</span></li>
                 <li>판매총액<span>&#8361<span>${dto.TOTAL}</span></span></li>
                 <li>면세금액<span>&#8361<span>${dto.VAT}</span></span></li>
                 <li>세금<span>&#8361<span>${dto.TOTAL-dto.VAT}</span></span></li>
                 <li>결제유형<span>${dto.PAYMENT_METHOD_TYPE}</span></li>
               </ul>
               <c:if test="${dto.PAYMENT_METHOD_TYPE eq 'CARD'}">
               <ul>
                 <li>카드사 <span>${dto.KAKAOPAY_ISSUER_CORP}</span></li>
                 <c:if test="${dto.INSTALL_MONTH eq '00'}">
                 	<li>할부<span>일시불</span></li>
                 </c:if>
                 <c:if test="${dto.INSTALL_MONTH ne '00'}">
                	<li>할부<span>${dto.INSTALL_MONTH}</span></li>                 </c:if>                 
                       
               </ul>
               </c:if>
               
             </div>
           </div>              
         </div>
       </div>
     </div>

</body>
</html>