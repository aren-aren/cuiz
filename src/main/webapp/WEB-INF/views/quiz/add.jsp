<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">

<c:import url="../temps/header_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/quiz/add.css">

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
                                <h4>Add Quiz</h4>
                            </div>
                            <div class="px-3">
                                <form id="addForm">
                                    <input type="text"
                                           name="quiz_Title"
                                           class="form-control mb-4"
                                           id="quiz_Title"
                                           placeholder="문제 제목을 입력하세요"/>
                                    <textarea class="form-control mb-3"
                                              id="quiz_Contents"
                                              name="quiz_Contents"
                                              rows="10"
                                              placeholder="문제 내용을 입력하세요"></textarea>
                                    <wc-codemirror mode="text/x-java"
                                                   class="mb-3"
                                                   id="quiz_SampleCode"
                                                   name="quiz_SampleCode"
                                                   theme="tomorrow-night-eighties">
                                        <script type="wc-content">
                                            public class Main{

                                                public static void main(String[] args){
                                                    /* 예제 코드를 적어주세요 */
                                                    System.out.println("hello, world");
                                                }
                                            }
                                        </script>
                                    </wc-codemirror>
                                    <input type="text" id="example_input" class="form-control mb-3" name="example_inputs"
                                           placeholder="예제 Input을 입력하세요"/>
                                    <input type="text" id="quiz_input" class="form-control mb-3" name="quiz_inputs"
                                           placeholder="실제 문제 Input을 입력하세요">
                                    <div class="row mb-3">
                                        <div class="col-6">
                                            <input type="text" class="form-control" placeholder="문제 유형을 입력하세요">
                                        </div>
                                        <div class="col-6 pt-2">
                                            <div class="text-white d-inline-block me-3">문제 난이도 :</div>
                                            <input id="quiz-lev-1" class="form-check-input " type="radio"
                                                   name="quiz_Level" value="1">
                                            <label for="quiz-lev-1"
                                                   class="form-check-label text-white">1&nbsp;&nbsp;</label>
                                            <input id="quiz-lev-2" class="form-check-input" type="radio"
                                                   name="quiz_Level" value="2">
                                            <label for="quiz-lev-2"
                                                   class="form-check-label text-white">2&nbsp;&nbsp;</label>
                                            <input id="quiz-lev-3" class="form-check-input" type="radio"
                                                   name="quiz_Level" value="3">
                                            <label for="quiz-lev-3"
                                                   class="form-check-label text-white">3&nbsp;&nbsp;</label>
                                            <input id="quiz-lev-4" class="form-check-input" type="radio"
                                                   name="quiz_Level" value="4">
                                            <label for="quiz-lev-4"
                                                   class="form-check-label text-white">4&nbsp;&nbsp;</label>
                                            <input id="quiz-lev-5" class="form-check-input" type="radio"
                                                   name="quiz_Level" value="5">
                                            <label for="quiz-lev-5"
                                                   class="form-check-label text-white">5&nbsp;&nbsp;</label>
                                        </div>
                                    </div>
                                    <div class="main-button">
                                        <a class="w-100 text-center" id="sampleRun">실행해보기</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <c:import url="../temps/footer.jsp"></c:import>
    <script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/index.js"></script>
    <script type="module" src="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/mode/clike/clike.js"></script>
    <script src="/resources/js/quiz/add.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/gh/vanillawc/wc-codemirror@1/theme/tomorrow-night-eighties.css">

</body>

</html>
