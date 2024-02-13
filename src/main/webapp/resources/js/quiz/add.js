const sampleRun = document.getElementById("sampleRun");
const sampleCode = document.getElementById("quiz_SampleCode");
const addForm = document.getElementById("addForm");
const sampleRunModal = new bootstrap.Modal(document.getElementById("sampleRunModal"))
const addSubmit = document.getElementById("addSubmit");

const quiz_Contents_summernote = document.getElementById("quiz_Contents_summernote");

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
    let sampleRunInput = document.getElementById("example_input").value.split(",");
    sampleRunInput.push(...document.getElementById("quiz_input").value.split(","));

    tableSpinnerToggle();

    for (let i = 0; i < data.length; i++) {
        let tr = document.createElement("tr");
        let td =  document.createElement("td");
        td.innerText = sampleRunInput[i];
        let td2 = document.createElement("td");
        td2.innerText = data[i];
        tr.append(td);
        tr.append(td2);
        sampleRunResult.append(tr);
    }
}