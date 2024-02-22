const codeUpdate = document.getElementById("code-update");
const contentUpdate = document.getElementById("content-update");
const switchBodyBtn = document.getElementById("switch-body");
const sampleRunModal = new bootstrap.Modal(document.getElementById("sampleRunModal"));
const testcasesTable = document.getElementById("testcases-table");
const urlParams = new URLSearchParams(window.location.search);
const exampleInputList = document.getElementById("example-input-list");
const quizInputList = document.getElementById("quiz-input-list");

const quizTitle = document.getElementById("quiz_Title");
const quizContents = document.getElementById("quiz_Contents_summernote");
const quizSampleCode = document.getElementById("quiz_SampleCode");
const quizType = document.getElementById("quiz_type");
const quizLevels = document.getElementsByName("quiz_Level");
const checkTestcaseBtn = document.getElementById("check-testcase-btn");

const updateSubmit = document.getElementById("updateSubmit");

const inputList = {
    "example" : [],
    "exampleOutputs" : [],
    "quiz" : [],
    "quizOutputs" : []
}

const checkTestcase = event => {
    fetch("checkRun?quiz_No=" + urlParams.get("quiz_No"))
        .then(r=>r.json())
        .then(r=>{
            let resultObject = r.reduce((acc, val)=>({...acc, [val.testcase_No]:val.result}), {});
            const checkResult = testcasesTable.querySelectorAll(`td[data-tc-no]`);

            checkResult.forEach(e=>{
                const tcNo = e.getAttribute("data-tc-no");
                e.innerHTML = `<i class="fa-regular ${resultObject[tcNo] ? "fa-circle text-success " : "fa-x text-danger"}"></i>`;
            })
        })
}

const makeTr = data =>{
    const tr = document.createElement("tr");
    tr.innerHTML = `
        <td>${data.testcase_No}</td>
        <td>${data.testcase_Input}</td>
        <td>${data.testcase_Output}</td>
        <td data-tc-no="${data.testcase_No}" class="check-result"></td>
        <td>${data.testcase_Type}</td>
        <td>
            <button data-tc-no="${data.testcase_No}"
                class="btn btn-outline-danger btn-sm border-0">삭제
            </button>
        </td>
    `;
    return tr;
}

const getTestcases = () => {
    fetch("getTestcases?quiz_No=" + urlParams.get("quiz_No"))
        .then(r=> r.json())
        .then(r => {
            testcasesTable.innerHTML = "";
            for (let tc of r) {
                testcasesTable.append(makeTr(tc));
            }
            exampleInputList.innerHTML = "";
            quizInputList.innerHTML = "";
            inputList.quizOutputs = [];
            inputList.quiz = [];
            inputList.example = [];
            inputList.exampleOutputs = [];
        })
}

const updateTestcase = event => {
    const data = getUpdateData("code");
    saveQuiz("testcase", JSON.stringify(data), getTestcases);
    sampleRunModal.hide();
}

document.getElementById("testcases-table").addEventListener("click", event=>{
    if(event.target.tagName!=="BUTTON"){
        return;
    }

    const tcNo = event.target.getAttribute("data-tc-no");
    fetch("delete/testcase", {
        method : "post",
        headers : {
            "Content-type" : "application/json"
        },
        body : JSON.stringify({"testcase_No" : tcNo})
    }).then(r=>r.json())
        .then(r=>{
            if(r){
                alert("삭제 되었습니다.");
            }
            else{
                alert("삭제에 실패했습니다.");
            }

            event.target.parentElement.parentElement.remove();
        })
})

const getUpdateData = type => {
    let data = null;
    if(type === "content"){
        data = {
            quiz_No : urlParams.get("quiz_No"),
            quiz_Title : quizTitle.value,
            quiz_Contents : quizContents.value,
            quiz_SampleCode : quizSampleCode.value,
            quiz_Type : quizType.value,
            quiz_Level : [...quizLevels].filter(e=>e.checked)[0].value
        }
    } else if (type === "code"){
        data = []
        for (let idx in inputList.example) {
            let element = {};
            element.quiz_No = urlParams.get("quiz_No");
            element.testcase_Input = inputList.example[idx];
            element.testcase_Output = inputList.exampleOutputs[idx];
            element.testcase_Type = "EXAMPLE";
            data.push(element);
        }

        for (let idx in inputList.quiz) {
            let element = {};
            element.quiz_No = urlParams.get("quiz_No");
            element.testcase_Input = inputList.quiz[idx];
            element.testcase_Output = inputList.quizOutputs[idx];
            element.testcase_Type = "QUIZ";
            data.push(element);
        }

    }
    return data;
}

const saveQuiz = (bodyType, updateData, after) => {
    fetch("update/"+bodyType, {
        method : "post",
        headers : {
            "Content-type" : "application/json"
        },
        body : updateData
    }).then(r=>r.json())
        .then(r=>{
            if(r){
                alert("저장 되었습니다.");
            }
            else{
                alert("저장에 실패했습니다.");
            }

            if(after !== undefined){
                after();
            }
        })
}

switchBodyBtn.addEventListener("click", event=>{
    const bodyType = event.target.getAttribute("data-body-type");

    if(bodyType === "content" && confirm("변경사항을 저장 하시겠습니까?")){
        /* 저장 실행 */
        const updateData = getUpdateData(bodyType);
        saveQuiz(bodyType, JSON.stringify(updateData));
    }

    codeUpdate.classList.toggle("d-none");
    contentUpdate.classList.toggle("d-none");

    if(bodyType === "content"){
        document.getElementById("switch-body").innerText = "내용 수정으로";
        document.getElementById("submit-btn").innerText = "테스트케이스 실행하기"
        event.target.setAttribute("data-body-type", "code");
    }
    else if(bodyType === "code"){
        document.getElementById("switch-body").innerText = "테스트케이스 관리";
        document.getElementById("submit-btn").innerText = "저장하기"
        event.target.setAttribute("data-body-type", "content");
    }
})

function tableSpinnerToggle(){
    document.getElementById("loadingSpinner").classList.toggle("d-none");
    document.getElementById("resultTable").classList.toggle("d-none");
}

function showSampleRunModalOutput(){
    tableSpinnerToggle();

    for (const idx in inputList.example) {
        let tr = document.createElement("tr");
        let td =  document.createElement("td");
        td.innerText = inputList.example[idx];
        let td2 = document.createElement("td");
        td2.innerText = inputList.exampleOutputs[idx];
        tr.append(td);
        tr.append(td2);
        sampleRunResult.append(tr);
    }

    for (const idx in inputList.quiz) {
        let tr = document.createElement("tr");
        let td =  document.createElement("td");
        td.innerText = inputList.quiz[idx];
        let td2 = document.createElement("td");
        td2.innerText = inputList.quizOutputs[idx];
        tr.append(td);
        tr.append(td2);
        sampleRunResult.append(tr);
    }
}

document.getElementById("submit-btn").addEventListener("click",event => {
    const type = switchBodyBtn.getAttribute("data-body-type");

    if(type === 'code'){
        const data = new FormData();
        data.append("quiz_SampleCode", document.getElementById("quiz_SampleCode").value);
        data.append("example_inputs", inputList.example.join(","));
        data.append("quiz_inputs", inputList.quiz.join(","));

        tableSpinnerToggle();
        document.getElementById("sampleRunResult").querySelectorAll("*").forEach(e=>e.remove());
        sampleRunModal.show();
        fetch(`sampleRun`, {
            method : "post",
            body : data
        })
            .then(res=>res.json())
            .then(r => {
                inputList.exampleOutputs = [...r.exOutputs];
                inputList.quizOutputs = [...r.qOutputs];

                showSampleRunModalOutput();
            })
    } else if(type === 'content'){
        saveQuiz(type, JSON.stringify(getUpdateData(type)));
    }
})

const getLi = (value, dataType) => {
    const li = document.createElement("li");
    li.classList.add("list-group-item");
    li.innerText = value;

    const btn = document.createElement("button");
    btn.type = "button";
    btn.classList.add("btn", "btn-outline-danger", "btn-sm", "border-0", "float-end");
    btn.setAttribute("data-type",dataType);
    btn.setAttribute("data-value", value);
    btn.innerText = "X";

    li.append(btn);

    return li;
}
document.querySelectorAll(".input-add-btn").forEach(btn => btn.addEventListener("click", event=>{
        const inputId = event.target.getAttribute("data-input");
        const inputValue = document.getElementById(inputId + "_input").value;

        if(!inputList[inputId].includes(inputValue)){
            inputList[inputId].push(inputValue);
            document.getElementById(inputId + "-input-list").prepend(getLi(inputValue, inputId));
        }

        document.getElementById(inputId + "_input").value = "";
    })
)

document.querySelectorAll(".input-list").forEach(ul => ul.addEventListener("click", li=>{
    const dataType = li.target.getAttribute("data-type");
    if(dataType == null){
        return;
    }

    const dataValue = li.target.getAttribute("data-value");
    inputList[dataType] = inputList[dataType].filter(e => e!==dataValue);
    li.target.parentNode.remove();
}))

checkTestcaseBtn.addEventListener("click", checkTestcase);
updateSubmit.addEventListener("click", updateTestcase);

window.onload = ()=> {
    if(quiz_Contents_summernote != null){
        $(quiz_Contents_summernote).summernote({
            height : 300,
            minHeight : 100,
            maxHeight : 500,
            toolbar : false,
            placeholder : "문제 내용을 입력하세요.",
            backgroundColor : "white"
        });
    }

    codeUpdate.classList.add("d-none");
}