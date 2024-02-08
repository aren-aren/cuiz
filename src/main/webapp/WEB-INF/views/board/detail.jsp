
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
          <form id="contactForm" action="delete" method="post" enctype="multipart/form-data">
          <div class="row">
            <div class="col-lg-12">
              <div class="main-profile">
                <div class="row">
                  <c:forEach items="${dto.fileDTOs}" var="f">
                    <div class="col-lg-4">
                      <!-- <img src="../resources/upload/${board}/${f.file_Name}"> -->
                      <!--  <a href="/resources/upload/${board}/${f.file_Name}">${f.ori_Name}</a> -->
                      <img src ="/resources/upload/${kind}/${f.file_Name}"   >
                      
                    </div>
                  </c:forEach>
                  <div class="col-lg-4 align-self-center">
                    <div class="main-info header-text">
                      <span>${board} Detail</span>
                      <h4>${dto.board_Title}</h4>
                      <p>${dto.board_Contents}</p>
                      <c:if test="${boardDTO.member_ID eq member.member_ID}">
                          <div class="main-border-button">
                            <a href="./update?board_Num=${dto.board_Num}">Update</a>
                            <a id="delete" href="#">Delete</a>
                          </div>
                          <input type="hidden" name="board_Num" value="${boardDTO.board_Num}">
                      </c:if>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
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
      contactForm.submit();
  });
  </script>

</html>
