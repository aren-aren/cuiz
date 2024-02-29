const quizNo = document.getElementById("quiz_no");
const memberCode = document.getElementById("quiz-member-code");
const solveResult = document.getElementById("solve-result");
const runBtn = document.getElementById("run-btn");
const initBtn = document.getElementById("init-btn");
const submitBtn = document.getElementById("submit-btn");
const footer = document.getElementsByTagName("footer")
const answerCorrectModal = new bootstrap.Modal(document.getElementById("answer_correct_modal"))
const testcaseShowBtn = document.getElementById("testcase-show-btn");

const spinner = `<div id="loadingSpinner" class="spinner-border text-white" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>`;

[...document.querySelectorAll("[data-bs-toggle='tooltip']")].map(tool => new bootstrap.Tooltip(tool));

let selectedTestcaseNum;

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

const onShowTestcase = () => {
    if(selectedTestcaseNum == null) return;

    fetch(`showTestcase?quiz_No=${quizNo.value}&testcase_No=${selectedTestcaseNum}`)
        .then(r=>r.json())
        .then(r=> {
            const notice = `Input : ${r.testcase_Input}\n Output : ${r.testcase_Output}`;
            alert(notice);

            const template = `
            <tr>
                <td>${r.testcase_Input}</td>
                <td><pre>${r.testcase_Output}</pre></td>
            </tr>
            `;
            document.getElementById("example-io-tbody").innerHTML += template;
            answerCorrectModal.hide();
        })
        .catch(e => {
            alert((e + "").split("\"")[1]);
            answerCorrectModal.hide();
        });
}

function countNumber(target, start, up, step){
    for(let i = 1 ; i <= step ; ++i){
        let nowStep = (i*up)/step;
        setTimeout(()=>{
            target.innerText = (parseInt(start) + parseInt(nowStep));
        },(1000*i)/step);
    }
}

function answerCorrectProcess() {
    fetch("getJumsuData?quiz_No=" + quizNo.value,{
        method : "get",
        headers : {
            "Content-Type":"application/json"
        }
    }).then(r=> r.json())
        .then(r=>{
            document.querySelectorAll(".correct-notice").forEach(e=>e.classList.remove("d-none"));
            document.querySelectorAll(".hint-notice").forEach(e=>e.classList.add("d-none"));

            const jumsuResultArea = document.getElementById("jumsu-result-area");
            const jumsuUpArea = document.getElementById("jumsu-up-area");

            jumsuResultArea.innerText = r.oldJumsu;
            jumsuUpArea.innerText = r.upJumsu;

            countNumber(jumsuResultArea, r.oldJumsu, r.upJumsu, 13);

            answerCorrectModal.show();
        })
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
            if (r.answer_Check) answerCorrectProcess();
        })
}

/**
 *
 * @param event
 */
const onHintBtnClick = event => {
    if(!event.target.classList.contains("tc-show-btn")) return;

    document.querySelectorAll(".correct-notice").forEach(e=>e.classList.add("d-none"));
    document.querySelectorAll(".hint-notice").forEach(e=>e.classList.remove("d-none"));

    selectedTestcaseNum = event.target.getAttribute("data-testcase-no");

    answerCorrectModal.show();
}

/**
 * 실행 결과 데이터를 실행결과 영역에 출력한다
 * @param results
 */
function showSolveResult(results, isSubmit){
    const divOption = `tabindex="0"
                     data-bs-toggle="tooltip"
                     data-bs-placement="right"
                     data-bs-title="이미 구매한 테스트케이스 입니다."`;
    let resultTemplate = "";
    let index = 1;

    for (let result of results) {
        let textColor = 'text-success';
        let testcaseShowBtn = "";
        if(!result.result){
            textColor = 'text-danger';
            if(isSubmit) {
                testcaseShowBtn = `
<div class="tc-show" ${result.buyed?divOption:""} >
    <button class="btn btn-cuiz btn-sm tc-show-btn ${result.buyed?"disabled" : ""}" data-testcase-no="${result.testcase_No}">Hint</button>
</div>`;
                document.getElementById("hint-tip").classList.remove("d-none");
                document.getElementById("hint-tip").classList.add("d-inline-block");
            }
        }
        resultTemplate += `
            <h5 class="my-2 ${textColor} tc-result">${index++} : ${result.resultMessage} ${testcaseShowBtn}</h5>
        `;
    }

    solveResult.innerHTML = resultTemplate;
    [...solveResult.querySelectorAll("[data-bs-toggle='tooltip']")].map(tool => new bootstrap.Tooltip(tool));

}

testcaseShowBtn.addEventListener("click", onShowTestcase);
initBtn.addEventListener("click", onInitEditor);
runBtn.addEventListener("click", onRunCode);
submitBtn.addEventListener("click", onSubmit);
solveResult.addEventListener("click", onHintBtnClick);