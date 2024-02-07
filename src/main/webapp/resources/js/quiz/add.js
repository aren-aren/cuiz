const sampleRun = document.getElementById("sampleRun");
const sampleCode = document.getElementById("quiz_SampleCode");
const addForm = document.getElementById("addForm");
const sampleRunModal = new bootstrap.Modal(document.getElementById("sampleRunModal"))
const addSubmit = document.getElementById("addSubmit");

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
         .then(res=>res.text())
         .then(r => {
             r = r.split("###");
             let data = [];
             data.push(...r[0].split(","));
             data.push(...r[1].split(","));
             showSampleRunModalOutput(data);

             document.getElementById("example_output").value = r[0];
             document.getElementById("quiz_output").value = r[1];
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