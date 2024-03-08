
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
<section>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-content">
					<div class="start-stream">
						<div class="col-lg-12">
						
							<div class="heading-section">
								<h4><em>${board}</em> Update</h4>
							</div>
							<div class="row">
								<div class="item heading-section">
									<form id="contactForm" action="update" method="post" enctype="multipart/form-data">
											<!-- 상품명 input-->
											<input type="hidden" name ="board_Num" value="${boardDTO.board_Num}" />
											<div class="form-floating mb-3">
												<input class="form-control" name="board_Title" id="name" type="text" placeholder="Title" data-sb-validations="required"  value="${boardDTO.board_Title}"/>
												<label for="name">Title</label>
												<div class="invalid-feedback" data-sb-feedback="message:required">필수항목 입니다.</div>
											</div>
											<!-- Message input-->
											<div class="form-floating mb-3">
												<textarea class="form-control" name="board_Contents" id="message" placeholder="Contents" style="height: 40rem" data-sb-validations="required" >${boardDTO.board_Contents}</textarea>
												<label for="message">Contents</label>
												<div class="invalid-feedback" data-sb-feedback="name:required">필수항목 입니다</div>
											</div>
											<!-- an error submitting the form-->
											<div class="d-none" id="submitErrorMessage">
												<div class="text-center text-danger mb-3">Error sending message!</div>
											</div>
											<div class="col-lg-12">
												<div class="d-grid">
													<button class="btn btn-primary btn-lg" id="submitButton" type="submit">Update</button>
												</div>
											</div>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
   		</div>
	</div>
</section>




  <c:import url="../temps/footer.jsp"></c:import>

  </body>

</html>
