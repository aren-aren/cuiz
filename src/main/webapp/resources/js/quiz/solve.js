const quizNo = document.getElementById("quiz_no");
const memberCode = document.getElementById("quiz-member-code");
const solveResult = document.getElementById("solve-result");
const runBtn = document.getElementById("run-btn");
const initBtn = document.getElementById("init-btn");
const submitBtn = document.getElementById("submit-btn");
const footer = document.getElementsByTagName("footer")
const answerCorrectModal = new bootstrap.Modal(document.getElementById("answer_correct_modal"))

const spinner = `<div id="loadingSpinner" class="spinner-border text-white" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>`;

[...document.querySelectorAll("[data-bs-toggle='tooltip']")].map(tool => new bootstrap.Tooltip(tool));

footer[0].querySelectorAll("*").forEach(e=>e.remove());
/**
 * 입력한 코드 에디터를 초기화시키는 이벤트리스너 함수
 */
const onInitEditor = () => {
    const defaultSourcecode = `public class Main{
    public static void main(String[] args){
    /* 입력되는 Input에 대한 답을 출력해주세요 */
        System.out.println("hello, world");
    }
}`
    document.getElementById("quiz-member-code").value = defaultSourcecode;
    document.getElementById("solve-result").innerHTML = "실행결과가 여기에 표시됩니다.";
    document.getElementById("hint-tip").classList.add("d-none");
}



/**
 * 작성한 코드를 1차적으로 테스트를 돌려본다.
 */
const onRunCode = ()=> {
    let data = {
        quiz_No : quizNo.value,
        sourcecode : memberCode.value
    }
    solveResult.innerHTML =spinner;

    fetch('run',{
        method: "post",
        headers: {"Content-type" : "application/json"},
        body: JSON.stringify(data)
    }).then(r=>r.json())
        .then(r=> showSolveResult(r.testcase_Results, false))
}

/**
 * 최종 완료된 코드를 서버로 전송/제출 `채점`한다.
 * @returns {null}
 */
const onSubmit = () => {
    let data = {
        quiz_No: quizNo.value,
        sourcecode: memberCode.value
    }
    solveResult.innerHTML = spinner;

    fetch('submit', {
        method: "post",
        headers: {"Content-type": "application/json"},
        body: JSON.stringify(data)
    }).then(r => r.json())
        .then(r => {
            showSolveResult(r.testcase_Results, true);
            if (r.answer_Check) {
                document.querySelectorAll(".correct-notice").forEach(e=>e.classList.remove("d-none"));
                document.querySelectorAll(".hint-notice").forEach(e=>e.classList.add("d-none"));
                answerCorrectModal.show();
            }
        })
}

const onHintBtnClick = event => {
    if(!event.target.classList.contains("tc-show")) return;

    console.log(event.target);

    document.querySelectorAll(".correct-notice").forEach(e=>e.classList.add("d-none"));
    document.querySelectorAll(".hint-notice").forEach(e=>e.classList.remove("d-none"));

    let testcaseNum = event.target.getAttribute("data-testcase");


    answerCorrectModal.show();
}

/**
 * 실행 결과 데이터를 실행결과 영역에 출력한다
 * @param results
 */
function showSolveResult(results, isSubmit){
    console.log(results);
    let resultTemplate = "";
    let index = 1;
    for (let result of results) {
        let textColor = 'text-success';
        let testcaseShowBtn = "";
        if(!result.result){
            textColor = 'text-danger';
            if(isSubmit) {
                testcaseShowBtn = `<button class="btn btn-cuiz btn-sm tc-show float-end" data-testcase="${quizNo.value}:${index}">Hint</button>`;
                document.getElementById("hint-tip").classList.remove("d-none");
                document.getElementById("hint-tip").classList.add("d-inline-block");
            }
        }
        resultTemplate += `
            <h5 class="my-2 ${textColor} tc-result">${index++} : ${result.resultMessage} ${testcaseShowBtn}</h5>
        `;
    }

    solveResult.innerHTML = resultTemplate;

}

initBtn.addEventListener("click", onInitEditor);
runBtn.addEventListener("click", onRunCode);
submitBtn.addEventListener("click", onSubmit);
solveResult.addEventListener("click", onHintBtnClick);