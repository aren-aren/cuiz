const quizNo = document.getElementById("quiz_no");
const memberCode = document.getElementById("quiz-member-code");
const solveResult = document.getElementById("solve-result");
const runBtn = document.getElementById("run-btn");
const initBtn = document.getElementById("init-btn");
const submitBtn = document.getElementById("submit-btn");
const footer = document.getElementsByTagName("footer")
//const runCodeModal = new bootstrap.Modal(document.getElementById("run-code-modal"))
footer[0].querySelectorAll("*").forEach(e=>e.remove());
/**
 * 입력한 코드 에디터를 초기화시키는 이벤트리스너 함수
 */
const onInitEditor = () => {
    document.getElementById("codeAndResult").innerHTML = `
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
                </div>`
}



/**
 * 작성한 코드를 1차적으로 테스트를 돌려본다.
 */
const onRunCode = ()=> {
    let data = {
        quiz_No : quizNo.value,
        member_Source_Code : memberCode.value
    }

    fetch('run',{
        method: "post",
        headers: {"Content-type" : "application/json"},
        body: JSON.stringify(data)
    }).then(r=>r.json())
        .then(r=>showSolveResult(r))
}

/**
 * 최종 완료된 코드를 서버로 전송/제출 `채점`한다.
 * @returns {null}
 */
const onSubmit = () => {
    return null;
}

/**
 * 실행 결과 데이터를 실행결과 영역에 출력한다
 * @param data
 */
function showSolveResult(data){
    solveResult.innerHTML = `
        
    `;
}


initBtn.addEventListener("click", onInitEditor);
runBtn.addEventListener("click", onRunCode)
submitBtn.addEventListener("click", onSubmit)

