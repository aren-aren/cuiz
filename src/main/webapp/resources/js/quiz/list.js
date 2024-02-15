const levelSelect = document.getElementById("level-select");
const kindSelect = document.getElementById("kind-select");
const searchInput = document.getElementById("search-Input");
const level = levelSelect.getAttribute("data-level");
const kind = kindSelect.getAttribute("data-kind");
const search = searchInput.getAttribute("data-search")
const pagingDiv = document.getElementById("paging-div");

const getSearchParameter = () => {
    let l = level === "" ? 0 : level;
    let k = kind === "" ? 0 : kind;

    return `search=${search}&searchItem=${l}&kind=${k}`;
}
levelSelect.querySelectorAll("option").forEach(opt=>{
    opt.selected = level === opt.value;
})

kindSelect.querySelectorAll("option").forEach(opt => {
    opt.selected = kind === opt.value;
})

pagingDiv.addEventListener("click", e =>{
    if(e.target.nodeName !== "BUTTON")
        return;

    let page = e.target.getAttribute("data-page");
    location.href="?page=" + page + "&" + getSearchParameter();
})