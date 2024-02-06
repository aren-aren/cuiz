const sampleRun = document.getElementById("sampleRun");
const sampleCode = document.getElementById("quiz_SampleCode");
const addForm = document.getElementById("addForm");

sampleRun.addEventListener("click",()=>{
     let data = new FormData(addForm);
     data.append("quiz_SampleCode", sampleCode.value)


     fetch(`sampleRun`, {
          method : "post",
          body : data
     })
         .then(res=>res.text())
         .then(r => console.log(r))

})