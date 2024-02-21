const codeUpdate = document.getElementById("code-update");
const contentUpdate = document.getElementById("content-update");
const switchBodyBtn = document.getElementById("switch-body");
const codeUpdateBtn = document.getElementById("code-update-btn");
const sampleRunModal = new bootstrap.Modal(document.getElementById("sampleRunModal"));
const urlParams = new URLSearchParams(window.location.search);
const inputList = {
    "example" : [],
    "exampleOutputs" : [],
    "quiz" : [],
    "quizOutputs" : []
}

codeUpdateBtn.addEventListener("click", ()=>{
    if(!confirm("소스코드를 수정하시겠습니까?")){
        return;
    }

    const sourcecode = document.getElementById("quiz_SampleCode").value;
    const quizNo = urlParams.get('quiz_No');

    const data = {
        quiz_SampleCode : sourcecode,
        quiz_No : quizNo
    }

    saveQuiz("sourcecode", JSON.stringify(data));
})

document.getElementById("testcases-table").addEventListener("click", event=>{
    const tcNo = event.target.getAttribute("data-tc-no");
    if(tcNo === ''){
        return;
    }

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

    } else if (type === "code"){
        data = {
            quiz_No : [],
            testcase_Input : [],
            testcase_Output : [],
            testcase_Type : []
        }
        for (let idx in inputList.example) {
            data.quiz_No.push(urlParams.get("quiz_No"));
            data.testcase_Input.push(inputList.example[idx]);
            data.testcase_Output.push(inputList.exampleOutputs[idx]);
            data.testcase_Type.push("EXAMPLE");
        }

        for (let idx in inputList.quiz) {
            data.quiz_No.push(urlParams.get("quiz_No"));
            data.testcase_Input.push(inputList.quiz[idx]);
            data.testcase_Output.push(inputList.quizOutputs[idx]);
            data.testcase_Type.push("QUIZ");
        }

    }
    return data;
}

const saveQuiz = (bodyType, updateData) => {
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
        })
}

switchBodyBtn.addEventListener("click", event=>{
    const bodyType = event.target.getAttribute("data-body-type");

    if(confirm("변경사항을 저장 하시겠습니까?")){
        /* 저장 실행 */
        const updateData = getUpdateData(bodyType);
        saveQuiz(bodyType, updateData);
    }

    codeUpdate.classList.toggle("d-none");
    contentUpdate.classList.toggle("d-none");

    if(bodyType === "content"){
        document.getElementById("switch-body").innerText = "내용 수정으로";
        document.getElementById("submit-btn").innerText = "테스트케이스 실행하기"
        event.target.setAttribute("data-body-type", "code");
    }
    else if(bodyType === "code"){
        document.getElementById("switch-body").innerText = "코드&테스트케이스 수정으로";
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

    const data = new FormData();
    data.append("quiz_SampleCode", document.getElementById("quiz_SampleCode").value);
    data.append("example_inputs", inputList.example.join(","));
    data.append("quiz_inputs", inputList.quiz.join(","));

    if(type === 'code'){
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