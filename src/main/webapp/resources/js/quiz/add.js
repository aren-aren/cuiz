const sampleRun = document.getElementById("sampleRun");
const sampleCode = document.getElementById("quiz_SampleCode");
const addForm = document.getElementById("addForm");
const sampleRunModal = new bootstrap.Modal(document.getElementById("sampleRunModal"))
const addSubmit = document.getElementById("addSubmit");

let exampleInputs = [];
let exampleOutputs = [];
let quizInputs = [];
let quizOutputs = [];

addSubmit.addEventListener("click",()=>{
    let data = new FormData(addForm);
    data.append("quiz_SampleCode", sampleCode.value);
    console.log(quizInputs);
    quizInputs.forEach(quizInput => data.append("quiz_inputs",quizInput));
    console.log(quizOutputs);
    quizOutputs.forEach(quizOutput => data.append("quiz_outputs", quizOutput));

    addForm.submit();
})

sampleRun.addEventListener("click",()=>{
    let data = new FormData(addForm);
    data.append("quiz_SampleCode", sampleCode.value);
    document.getElementById("example_input").value.split(",").forEach(exin => exampleInputs.push(exin));
    document.getElementById("quiz_input").value.split(",").forEach(qin => quizInputs.push(qin));
    exampleInputs.forEach(exampleInput => data.append("example_inputs", exampleInput));
    exampleOutputs.forEach(exampleOutput => data.append("example_outputs", exampleOutput));
    tableSpinnerToggle();

    document.getElementById("sampleRunResult").querySelectorAll("*").forEach(e=>e.remove());
    sampleRunModal.show();
     fetch(`sampleRun`, {
          method : "post",
          body : data
     })
         .then(res=>res.text())
         .then(r => {
             r = r.split("###");
             showSampleRunModalOutput(r);
             for (let i = 0; i < exampleInputs.length; i++) {
                 exampleOutputs.push(r[i]);
             }
             for (let i = exampleInputs.length; i < exampleInputs.length + quizInputs.length; i++) {
                 quizOutputs.push(r[i]);
             }
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