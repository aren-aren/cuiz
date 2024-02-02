const deleteBtn = document.getElementById("deleteBtn");
const delBtnFrm = document.getElementById("delBtnFrm");
const updateBtn = document.getElementById("updateBtn");
const updBtnFrm = document.getElementById("updBtnFrm");


if(deleteBtn!=null){
    deleteBtn.addEventListener("click",(e)=>{
        e.preventDefault();
    
        if(!confirm("'확인'누르시면 삭제됩니다.")){
            return false;
        };
        
        console.log("delete")   
        delBtnFrm.submit();
    })
}

if(updateBtn!=null){

    updateBtn.addEventListener("click",(e)=>{
        console.log(e)
        
        if(!confirm("수정페이지로 이동합니다.")){
            return false;
        };
        
        console.log("update")   
        // updBtnFrm.setAttribute("action", "./update");
        // updBtnFrm.setAttribute("method", "POST");
        updBtnFrm.submit();
    })
}
