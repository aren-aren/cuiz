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
<input type="hidden" id="quiz_no" value="${dto.quiz_No}">
<div class="container-fluid">
    <div class="row">
        <div class="col-12" style="height: 180px">
            &nbsp;
        </div>
        <div class="featured-games header-text">
            <div class="heading-section">
                <h4 class="text-center">${dto.quiz_Title}</h4>
            </div>
        </div>
        <div class="row min-vh-70">
            <div class="col-5">
                <div class="container">
                    <div class="featured-games text-white bg-black">
                        <h5>문제 설명</h5>
                        <div class="my-3">
                            ${dto.quiz_Contents}
                        </div>
                        <hr>
                        <h5>예제 입출력</h5>
                        <div>
                            <table class="table text-white my-3 solve-table">
                                <thead>
                                <tr>
                                    <th>입력</th>
                                    <th>출력</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dto.testcase}" var="tc">
                                    <tr>
                                        <td>${tc.testcase_Input}</td>
                                        <td><pre>${tc.testcase_Output}</pre></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div id="codeAndResult" class="col-7">
                <div>
                    <wc-codemirror mode="text/x-java"
                                   class="code-editor"
                                   id="quiz-member-code"
                                   theme="tomorrow-night-eighties">
<script type="wc-content">
${answer.sourcecode}
</script>
                    </wc-codemirror>
                </div>
                <div class="bg-black solve-result-area">
                    <div class="border-bottom border-top text-white p-2">
                        <div class="d-inline-block">실행결과</div>
                        <div id="hint-tip" class="d-none text-danger">
                            (틀린 문제에 마우스커서를 올리면 아이템을 사용하여 테스트케이스를 확인할 수 있는 버튼이 나타납니다.)
                        </div>
                    </div>
                    <div id="solve-result" class="text-white p-2">
                        실행결과가 여기에 표시됩니다.
                    </div>
                </div>
            </div>
            <div class="col-12 mb-3">
                <div class="float-start me-1">
                    <a class="btn btn-secondary">질문 게시판</a>
                </div>
                <div class="float-start"
                     <c:if test="${!answer.answer_Check}">
                     tabindex="0"
                     data-bs-toggle="tooltip"
                     data-bs-placement="right"
                     data-bs-title="정답을 맞춘 문제만 다른사람의 풀이를 볼 수 있습니다."
                     </c:if>
                >
                    <a class="btn btn-secondary <c:if test="${!answer.answer_Check}">disabled</c:if>" href="otherSolve?quiz_No=${dto.quiz_No}">다른 사람 풀이</a>
                </div>
                <div class="float-end">
                    <button class="btn btn-cuiz" id="submit-btn">제출하기</button>
                </div>
                <div class="float-end mx-1">
                    <button class="btn btn-info" id="run-btn">코드 실행</button>
                </div>
                <div class="float-end">
                    <button class="btn btn-secondary" id="init-btn">초기화</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="answer_correct_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="d-none correct-notice">
                        <h1 class="modal-title fs-5 text-dark">축하합니다.</h1>
                    </div>
                    <div class="d-none hint-notice">
                        <h1 class="modal-title fs-5 text-dark">힌트 보기</h1>
                    </div>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
                </div>
                <div class="d-none correct-notice">
                    <div class="modal-body">
                        <h2 class="text-black">정답입니다.</h2>
                        <h5 class="text-black">대충 점수 올랐단는 알림</h5>
                    </div>
                </div>
                <div class="d-none hint-notice">
                    <div class="modal-body">
                        <h2 class="text-black">힌트를 보려면 아이템이 필요합니다.</h2>
                        <h5 class="text-black">필요 아이템 개수 : 100개</h5>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="d-none hint-notice">
                        <button type="button" class="btn btn-primary">테스트 케이스 보기</button>
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="../temps/footer.jsp"></c:import>
<script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/index.js"></script>
<script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/mode/clike/clike.js"></script>
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/theme/tomorrow-night-eighties.css">
<script src="/resources/js/quiz/solve.js" type="text/javascript"></script>

</body>

</html>
