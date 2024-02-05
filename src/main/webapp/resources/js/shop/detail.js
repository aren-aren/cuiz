const deleteBtn = document.getElementById("deleteBtn");
const delBtnFrm = document.getElementById("delBtnFrm");
const updateBtn = document.getElementById("updateBtn");
const updBtnFrm = document.getElementById("updBtnFrm");
const adCartBtn = document.getElementById("adCartBtn");
const buyNowBtn = document.getElementById("buyNowBtn");





//addcart

if(adCartBtn!=null){
    adCartBtn.addEventListener("click",(e)=>{
     
       let item_Num = document.getElementById("item_Num").value;
       
       console.log(item_Num+" checkskadfj");
       fetch("./addCart?item_Num="+item_Num, {
         method:"get"})
       .then(r => r.text())
       .then(r =>{
        console.log(r);
        if(r<1){
            alert("실패");
            return false;
        }

        if(!confirm("장바구니로 이동하시겠습니까?")){            
            return false;             
        }
        location.href="/cart/list"
       })

    })
}

// if(adCartBtn!=null){
//     adCartBtn.addEventListener("click",(e)=>{
//         let item_Num = document.getElementById("item_Num").value;
//         console.log(item_Num);
//         delBtnFrm.setAttribute("action", "./addCart?item_num="+item_Num);       
//         e.preventDefault(e);
//         delBtnFrm.submit();   
        
        
//         if(!confirm("장바구니로 이동할까요?")){
//             return false;
//         }    
//         location.href="/cart/list"


//     })
// }

// delete

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


//update

if(updateBtn!=null){

    updateBtn.addEventListener("click",(e)=>{
        console.log(e)
        
        console.log("update")   
        if(!confirm("수정페이지로 이동합니다.")){
            return false;
        };
        let item_Num = document.getElementById("item_Num").value;
        location.href="./update?item_Num="+item_Num;
    })
}
