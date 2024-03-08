const quizAttachBtn = document.getElementById("quiz-attach-btn");
const quizAttachModal = new bootstrap.Modal(document.getElementById("quiz-attach-modal"));
const codeFindInput = document.getElementById("code-find-input");
const codeSelectBtn = document.getElementById("code-select-btn");
const codeContentDiv = document.getElementById("code-content-div");
const quizListInput = document.getElementById("quiz-list-input");
const quizList = document.getElementById("quiz-list");

let codeData = [];
let quizData = [];

const dateFormat = date => {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();

    return year + "-" + month + "-" + day;
}

if (quizAttachBtn !== null) {
    quizAttachBtn.addEventListener("click", () => {
            if (codeData.length === 0) {
                fetch("/quiz/myAnswers")
                    .then(r => r.json())
                    .then(r => {
                        console.log(r);
                        codeContentDiv.innerHTML = "";

                        let inputs = ``;
                        for (const quizData of r) {
                            const inputTemplate = `
<div class="row border-bottom m-2" data-title="${quizData.quiz_Title}">
    <div class="col-3 mb-0 p-3">
        <input id="quizNoRadio-${quizData.quiz_No}" class="form-check-input" type="radio" name="quiz_No" value="${quizData.quiz_No}">
    </div>
    <label class="col-9 mb-0" for="quizNoRadio-${quizData.quiz_No}">
        <div class="row">
            <div class="col-4 mb-0">
                #${quizData.quiz_No}    
            </div>
            <div class="col-6 mb-0">
                ${quizData.quiz_Title} 
            </div>
            <div class="col-4 mb-0">
                ${dateFormat(new Date(quizData.answer_Date))}
            </div>
            <div class="col-6">
                ${quizData.answer_Check ? "<span class='text-success'>맞힌 문제입니다.</span>" : "<span class='text-danger'>틀린 문제입니다.</span>"}
            </div>
        </div>
    </label>
</div>`
                            inputs += inputTemplate;
                        }
                        codeContentDiv.innerHTML = inputs;
                        codeData = [...codeContentDiv.children];

                        quizAttachModal.show();
                    })
            } else {
                quizAttachModal.show();
            }

        }
    )
}

quizListInput.addEventListener("focus", ()=>{
    if(quizData.length !== 0) return;

    fetch("/quiz/getAllQuizs")
        .then(r=>r.json())
        .then(r=>{
            console.log(r);
            let str = "";
            for (const quiz of r) {
                str += `
                <option value="${quiz.quiz_No}">${quiz.quiz_Title}</option>
                `
                quizData.push(r);
            }
            quizList.innerHTML = str;
        })
})

quizListInput.addEventListener("change", event=>{
    document.getElementById("quiz_No").value = event.target.value;
})

codeFindInput.addEventListener("keyup", event=>{
    const str = event.target.value;
    const regex = new RegExp(`${str}`);

    codeData.forEach(e=>{
        const title = e.getAttribute("data-title");

        if(regex.test(title)) {
            e.classList.remove("d-none");
        } else {
            e.classList.add("d-none");
        }
    })
})

codeSelectBtn.addEventListener("click", ()=>{
    let checkedInput = codeContentDiv.querySelector("input[type=radio]:checked");
    document.getElementById("quiz_No").value = checkedInput.value;
    document.getElementById("attach-code").value = 1;
    quizListInput.value = checkedInput.value;
    quizAttachModal.hide();
})