const deleteBtn = document.getElementById("deleteBtn");
const delBtnFrm = document.getElementById("delBtnFrm");
const updateBtn = document.getElementById("updateBtn");

deleteBtn.addEventListener("click",(e)=>{
    

    if(!confirm("'확인'누르시면 삭제됩니다.")){
        return false;
    };
    
    console.log("delete")   
    delBtnFrm.setAttribute("action", "./delete");
    delBtnFrm.setAttribute("method", "POST");
    delBtnFrm.submit();
})


updateBtn.addEventListener("click",(e)=>{
    

    if(!confirm("수정페이지로 이동합니다.")){
        return false;
    };
    
    console.log("update")   
    delBtnFrm.setAttribute("action", "./update");
    delBtnFrm.setAttribute("method", "POST");
    delBtnFrm.submit();
})