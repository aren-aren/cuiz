const TabActive = "tab-active"
// localStorage.setItem(TabActive, "home")
const headerNavs = document.querySelectorAll(".nav li a");
let beforeActive = null
let savedActive = localStorage.getItem(TabActive);
console.log("savedActive : " + savedActive)
if(beforeActive !== null) {
    document.getElementById(beforeActive).className = "active"
}

if(savedActive !== null) {
    document.getElementById(savedActive).className = "active"

}


// beforeNav.className = "active"
headerNavs.forEach(currentNav => {
    currentNav.addEventListener("click", (e)=>{
        e.preventDefault();
        localStorage.removeItem(TabActive)
        localStorage.setItem(TabActive, currentNav.id)
        currentNav.className = "active"
        beforeActive = e.target.id; // 이전 active에 현재 id 저장

        location.href = currentNav.href
        // location.reload(true);
    })
})