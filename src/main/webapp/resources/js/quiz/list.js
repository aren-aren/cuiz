const levelSelect = document.getElementById("level-select");
const kindSelect = document.getElementById("kind-select");
const level = levelSelect.getAttribute("data-level");
const kind = kindSelect.getAttribute("data-kind");
levelSelect.querySelectorAll("option").forEach(opt=>{
    opt.selected = level === opt.value;
})

kindSelect.querySelectorAll("option").forEach(opt => {
    opt.selected = kind === opt.value;
})