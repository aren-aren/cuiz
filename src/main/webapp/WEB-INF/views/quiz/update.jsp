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
                        <div class="featured-games header-text">
                            <div class="heading-section">
                                <h4><em>Update</em> Quiz</h4>
                            </div>
                            <div class="px-3">
                                <div id="content-update">
                                <div class="heading-section">
                                    <h4>내용 수정</h4>
                                </div>
                                <input type="text"
                                       name="quiz_Title"
                                       class="form-control mb-4"
                                       id="quiz_Title"
                                       placeholder="문제 제목을 입력하세요"
                                       value="${dto.quiz_Title}"/>
                                <textarea id="quiz_Contents_summernote"
                                          name="quiz_Contents"
                                          placeholder="문제 내용을 입력하세요">${dto.quiz_Contents}</textarea>
                                <div class="row mb-3">
                                    <div class="col-6">
                                        <input type="text"
                                               class="form-control"
                                               name="quiz_Type"
                                               placeholder="문제 유형을 입력하세요"
                                               value="${dto.quiz_Type}">
                                    </div>
                                    <div class="col-6 pt-2">
                                        <div class="text-white d-inline-block me-3">
                                            문제 난이도 :
                                        </div>
                                        <c:forEach var="idx" begin="1" end="5">
                                            <input id="quiz-lev-${idx}"
                                                   class="form-check-input "
                                                   type="radio"
                                                   name="quiz_Level"
                                                   value="${idx}"
                                                   <c:if test="${idx eq dto.quiz_Level}">checked</c:if>
                                            >
                                            <label for="quiz-lev-${idx}"
                                                   class="form-check-label text-white">${idx}&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                        </c:forEach>
                                    </div>
                                </div>
                                </div>
                                <div id="code-update">
                                    <div class="heading-section">
                                        <h4>코드&테스트케이스 수정</h4>
                                    </div>
                                    <wc-codemirror mode="text/x-java"
                                                   class="mb-3"
                                                   id="quiz_SampleCode"
                                                   theme="tomorrow-night-eighties">
<script type="wc-content">
${dto.quiz_SampleCode}
</script>
                                    </wc-codemirror>
                                    <div>
                                        <button id="code-update-btn" class="btn btn-cuiz">코드 수정하기</button>
                                    </div>
                                    <div>
                                        <table class="table table-dark table-striped">
                                            <thead>
                                                <tr>
                                                    <th style="width: 5%">번호</th>
                                                    <th style="width: 40%;">입력</th>
                                                    <th style="width: 40%">출력</th>
                                                    <th style="width: 10%">타입</th>
                                                    <th style="width: 5%"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="testcases-table">
                                                <c:forEach items="${dto.testcase}" var="testcase">
                                                    <tr>
                                                        <td>${testcase.testcase_No}</td>
                                                        <td>${testcase.testcase_Input}</td>
                                                        <td>${testcase.testcase_Output}</td>
                                                        <td>${testcase.testcase_Type}</td>
                                                        <td><button data-tc-no="${testcase.testcase_No}" class="btn btn-outline-danger btn-sm border-0">X</button></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-6">
                                            <div class="input-group">
                                                <input type="text"
                                                       id="example_input"
                                                       class="form-control"
                                                       placeholder="예제 Input을 입력하세요"/>
                                                <button type="button" class="btn btn-cuiz input-add-btn" data-input="example">추가</button>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="input-group">
                                                <input type="text"
                                                       id="quiz_input"
                                                       class="form-control"
                                                       placeholder="실제 문제 Input을 입력하세요"/>
                                                <button type="button" class="btn btn-cuiz input-add-btn" data-input="quiz">추가</button>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <ul id="example-input-list" class="list-group bg-white input-list"></ul>
                                        </div>
                                        <div class="col-6">
                                            <ul id="quiz-input-list" class="list-group bg-white input-list"></ul>
                                        </div>
                                    </div>

                                </div>
                                <div class="mb-3">
                                    <button type="button" id="submit-btn" class="btn btn-cuiz">저장하기</button>
                                    <button id="switch-body" data-body-type="content" type="button" class="btn btn-cuiz">코드&테스트케이스 수정으로</button>
                                </div>
                                <div>
                                    <a class="btn btn-secondary" href="solve?quiz_No=${dto.quiz_No}">돌아가기</a>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="sampleRunModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5 text-dark" id="staticBackdropLabel">확인 후 등록 버튼을 눌러주세요</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div id="sampleRunModalBody" class="modal-body">
                    <div id="loadingSpinner" class="spinner-border d-none" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                    <table id="resultTable" class="table">
                        <thead>
                        <tr>
                            <th>Input</th>
                            <th>Output</th>
                        </tr>
                        </thead>
                        <tbody id="sampleRunResult" class="table-striped">
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button id="addSubmit" type="button" class="btn btn-primary">등록하기</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>

    <c:import url="../temps/footer.jsp"></c:import>
    <script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/index.js"></script>
    <script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/mode/clike/clike.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/theme/tomorrow-night-eighties.css">
    <script src="/resources/js/quiz/update.js" type="text/javascript"></script>

</body>

</html>
