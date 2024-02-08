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
        <div class="row">
        <div class="col-5">
            <div class="container">
                <div class="featured-games text-white bg-black">
                    ${dto.quiz_Contents}
                </div>
            </div>
        </div>
        <div class="col-7">
            <wc-codemirror mode="text/x-java"
                           class="mb-3"
                           id="quiz_SampleCode"
                           style="height: 100%"
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
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="sampleRunModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5 text-dark" id="staticBackdropLabel">채점 결과</h1>
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
