
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
					<div class="start-stream">
						<div class="col-lg-12">
						
							<div class="heading-section">
								<h4><em>${board}</em> Add</h4>
							</div>
							<div class="row">
								<c:set var="b" value="${board}"></c:set>
				                  <c:if test="${b eq 'QnA'}" >
									  <div class="col-4">
										  <input id="quiz-list-input" class="form-control" list="quiz-list" type="text" placeholder="링크할 문제 제목이나 번호를 검색하세요">
										  <datalist id="quiz-list">
										  </datalist>
									  </div>
									  <div class="col-3"></div>
									  <div class="col-4">
										  <button id="quiz-attach-btn" class="btn btn-cuiz float-end">코드 첨부</button>
									  </div>
				                  </c:if>
									<div class="item heading-section" style= "margin-top: 5px">
										<form id="contactForm" action="add" method="post" enctype="multipart/form-data">
											<input type="hidden" id="quiz_No" name="quiz_No">
											<input type="hidden" id="attach-code" name="flag" value="0">
											
											<!-- title input-->
											<div class="form-floating mb-3">
												<input class="form-control" name="board_Title" id="name" type="text" placeholder="Title" data-sb-validations="required"/>
												<label for="name">Title</label>
												<div class="invalid-feedback" data-sb-feedback="message:required">필수항목 입니다.</div>
											</div>

											<!-- contents input-->
											<div class="form-floating mb-3">
												<textarea class="form-control" name="board_Contents" id="message" placeholder="Contents" style="height: 40rem" data-sb-validations="required"></textarea>
												<label for="message">Contents</label>
												<div class="invalid-feedback" data-sb-feedback="name:required">필수항목 입니다</div>
											</div>

						                      <!-- 첨부파일 input-->
						                      <c:if test="${b eq 'Notice'}" >
							                      <div class="mb-3">
							                        <label for="name">파일 첨부</label>
							                        <input class="form-control" type="file" name="attachs"/>
							                        <input class="form-control" type="file" name="attachs"/>
							                        <input class="form-control" type="file" name="attachs"/>
							                        <input class="form-control" type="file" name="attachs"/>
							                        <input class="form-control" type="file" name="attachs"/>
							                      </div>
						                      </c:if>
						                      						                      
											<!-- an error submitting the form-->
											<div class="d-none" id="submitErrorMessage">
												<div class="text-center text-danger mb-3">Error sending message!</div>
											</div>
											<div class="col-lg-12">
												<div class="d-grid">
													<button class="btn btn-cuiz btn-lg" id="submitButton" type="submit">Save</button>
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

  <!-- Modal -->
  <div class="modal fade" id="quiz-attach-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
	   aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
		  <div class="modal-content">
			  <div class="modal-header">
				  <h1 class="modal-title fs-5 text-dark" id="staticBackdropLabel">등록할 코드를 고르세요</h1>
				  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			  </div>
			  <div id="sampleRunModalBody" class="modal-body">
				  <div class="mb-3">
					  <input id="code-find-input" type="text" class="form-control" placeholder="검색할 문제의 제목을 입력해주세요">
				  </div>
				  <div id="code-content-div">

				  </div>
			  </div>
			  <div class="modal-footer">
				  <button id="code-select-btn" type="button" class="btn btn-primary">선택하기</button>
				  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			  </div>
		  </div>
	  </div>
  </div>




  <c:import url="../temps/footer.jsp"></c:import>
<script src="/resources/js/board/add.js"></script>

  </body>

</html>
