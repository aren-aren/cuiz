const quizAttachBtn = document.getElementById("quiz-attach-btn");
const quizAttachModal = new bootstrap.Modal(document.getElementById("quiz-attach-modal"));

let codeData = [];

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
                        const codeContentDiv = document.getElementById("code-content-div");

                        codeContentDiv.innerHTML = "";

                        for (const quizData of r) {
                            const inputTemplate = `
<div class="row border-bottom m-2">
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
                            codeContentDiv.innerHTML += inputTemplate;
                        }

                        console.log(codeContentDiv);

                        quizAttachModal.show();
                    })
            } else {

            }

        }
    )
}