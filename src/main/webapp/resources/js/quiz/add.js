const sampleRun = document.getElementById("sampleRun");
const sampleCode = document.getElementById("quiz_SampleCode");
const addForm = document.getElementById("addForm");
const sampleRunModal = new bootstrap.Modal(document.getElementById("sampleRunModal"))
const addSubmit = document.getElementById("addSubmit");

const quiz_Contents_summernote = document.getElementById("quiz_Contents_summernote");

const inputList = {
    "example" : [],
    "quiz" : []
}

const getLi = (value, dataType) => {
    const li = document.createElement("li");
    li.classList.add("list-group-item");
    li.innerText = value;

    const btn = document.createElement("button");
    btn.type = "button";
    btn.classList.add("btn","btn-outline-danger","btn-sm", "border-0", "float-end");
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
            document.getElementById(inputId + "_hidden").value = inputList[inputId].join(",");
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
    document.getElementById(dataType + "_hidden").value = inputList[dataType].join(",");
    li.target.parentNode.remove();
}))

addSubmit.addEventListener("click",()=>addForm.submit())

sampleRun.addEventListener("click",()=>{
    document.getElementById("quizSampleCodeInput").value = sampleCode.value;

    let data = new FormData(addForm);

    tableSpinnerToggle();

    document.getElementById("sampleRunResult").querySelectorAll("*").forEach(e=>e.remove());
    sampleRunModal.show();
     fetch(`sampleRun`, {
          method : "post",
          body : data
     })
         .then(res=>res.json())
         .then(r => {
             showSampleRunModalOutput([...r.exOutputs, ...r.qOutputs]);

             const exampleOutput = document.getElementById("example_output");
             const quizOutput = document.getElementById("quiz_output");
             exampleOutput.value = r.exOutputs.join(",");
             quizOutput.value = r.qOutputs.join(",");
         })
})

function tableSpinnerToggle(){
    document.getElementById("loadingSpinner").classList.toggle("d-none");
    document.getElementById("resultTable").classList.toggle("d-none");
}

function showSampleRunModalOutput(data){
    const sampleRunResult = document.getElementById("sampleRunResult");
    let sampleRunInput = document.getElementById("example_hidden").value.split(",");
    sampleRunInput.push(...document.getElementById("quiz_hidden").value.split(","));

    tableSpinnerToggle();

    for (let i = 0; i < data.length; i++) {
        let tr = document.createElement("tr");
        let td =  document.createElement("td");
        td.innerText = sampleRunInput[i];
        let td2 = document.createElement("td");
        let pre = document.createElement("pre");
        pre.innerText = data[i];
        td2.append(pre);
        tr.append(td);
        tr.append(td2);
        sampleRunResult.append(tr);
    }
}

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

}