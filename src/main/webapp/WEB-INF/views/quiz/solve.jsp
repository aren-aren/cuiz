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
                        ${dto.quiz_Contents}
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
                            public class Main{

                                public static void main(String[] args){
                                    /* 입력되는 Input에 대한 답을 출력해주세요 */
                                    System.out.println("hello, world");
                                }
                            }
                        </script>
                    </wc-codemirror>
                </div>
                <div class="bg-black solve-result-area">
                    <div class="border-bottom border-top text-white p-2">
                        실행결과
                    </div>
                    <div id="solve-result" class="text-white p-2">
                        실행결과가 여기에 표시됩니다.
                    </div>
                </div>
            </div>
            <div class="col-12 mb-3">
                <div class="float-start">
                    <a class="btn btn-secondary">질문 게시판</a>
                </div>
                <div class="float-end" style="min-width: 90px">
                    <button class="btn btn-cuiz" id="submit-btn">제출하기</button>
                </div>
                <div class="float-end mx-1" style="min-width: 95px">
                    <button class="btn btn-info" id="run-btn">코드 실행</button>
                </div>
                <div class="float-end mx-1" style="min-width: 75px">
                    <button class="btn btn-secondary" id="init-btn">초기화</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="answer_correct_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5 text-dark" id="staticBackdropLabel">축하합니다.</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div id="sampleRunModalBody" class="modal-body">
                    <h2>정답입니다.</h2>
                    <h5>대충 점수 올랐단는 알림</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>

    <c:import url="../temps/footer.jsp"></c:import>
    <script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/index.js"></script>
    <script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/mode/clike/clike.js"></script>
    <script src="/resources/js/quiz/solve.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/theme/tomorrow-night-eighties.css">

</body>

</html>
