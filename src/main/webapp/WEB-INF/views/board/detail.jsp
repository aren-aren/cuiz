
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
        
        

          <!-- mini box -->
          <div class="row">
            <div class="col-lg-12">
              <div class="main-profile">
                <div class="row">
	                <c:set var="b" value="${board}"></c:set>
					 <c:if test="${b eq 'Notice'}" >
		                 
	                  </c:if>
	                  
	                  <div class="col-lg-4 align-self-center">
	                    <div class="main-info header-text">
	                      <span>${board} Detail</span>
	                      <h4>${boardDTO.board_Title}</h4>

						  <c:forEach items="${boardDTO.fileDTOs}" var="f">
							<div class="col-lg-4">
								<!-- <img src="../resources/upload/${board}/${f.file_Name}"> -->
								<!--  <a href="/resources/upload/${board}/${f.file_Name}">${f.ori_Name}</a> -->
								<img src ="/resources/upload/${kind}/${f.file_Name}" onerror="this.style.display='none'" style="display: flex; flex-direction: column;">
							</div>
							</c:forEach>

	                      <p>${boardDTO.board_Contents}</p>
	                      
	          				<form id="contactForm" action="delete" method="post" enctype="multipart/form-data">
	                          <div class="main-border-button">
	                     		<c:if test="${boardDTO.member_ID eq member.member_ID}">
		                            <a href="./update?board_Num=${boardDTO.board_Num}">Update</a>
		                            <a id="delete" href="#">Delete</a>
	                     		</c:if>
	                          </div>
	                          <input type="hidden" name="board_Num" value="${boardDTO.board_Num}">
	          				</form>
				                	                      
	                    </div>
	                  </div>
                  
                </div>
              </div>
            </div>
          </div>
          
          
          <!-- reply -->
          
		  <c:if test="${b eq 'QnA'}">
			<div class="row" style="margin-top:30px">
			<div class="col-lg-12">
				<div class="main-profile ">
				<div class="row">
				
					<div class="col-lg-12">
					<div class="main-info">
						<span>댓글</span>
						
						<!-- reply list -->

						<c:forEach items="${replyDTO}" var="r">
						
						<form>
							<input type="hidden" name="user_Name" value="${member.member_ID}">
						
							<div class="col-lg-12">
							<ul id="addForm">
								<li>${r.reply_Contents}<span>${r.user_Name}</span></li>
							</ul>
							</div>
							
						</form>
						
						<!-- reply delete -->
						
							
						<form id="contactForm" action="" method="post" enctype="multipart/form-data">
								
							<div class="main-border-button">
							<c:if test="${replyDTO.user_Name eq member.member_ID}">
							<c:if test="${not empty member}">
								<a id="delete" href="#">Delete</a>
							</c:if>
							</c:if>
							</div>
						</form>
						
						</c:forEach>
							
						
							
						<c:if test="${list.size()==0}">
							<li><h3>검색결과가 없습니다.</h3></li>
						</c:if>
						

					
						
							<br><br>

						<!-- reply add -->
						

 						<form id="replyAddFrom" method="post" action="/board/detail">
 
							<div class="d-none" id="submitErrorMessage">
								<div class="text-center text-danger mb-3">Error sending message!</div>
							</div>
							
							<div class="col-lg-12 input-group mb-3">
								<input type="text" name="replyAddVal" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
								<button class="btn btn-outline-secondary" type="submit" id="submitButton button-addon2 replyAddBtn">Add</button>
							</div>

 						</form>

							

						
					</div>
					</div>
					
				
					
				</div>
				</div>
				</div>
				</div>
			
			</c:if>
	           
		         
		         
		<div>
		</div>
		           
       </div>
      </div>
   </div>
   </div>
   


  <c:import url="../temps/footer.jsp"></c:import>

  </body>

  <script>
  const del = document.getElementById("delete");
  const frm = document.querySelector("#contactForm");


  del.addEventListener("click", (e)=>{
      e.preventDefault();
      frm.submit();
  });
  
  </script>
  
  	<script src="/boardDetail.js" type="text/javascript"></script>
  

</html>
