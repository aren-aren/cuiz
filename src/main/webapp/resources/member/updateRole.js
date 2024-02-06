let member_role = document.getElementsByClassName("member_role form-select")
let table= document.getElementById("table");
let role = document.getElementsByClassName("color-white role")
let role_check = document.getElementsByClassName("role_check");
let IDc = document.getElementsByClassName("color-white memberid")
console.log(1);



for(let i=0; i<member_role.length;i++){
    console.log(role[i].getAttribute('data-role'));    

    for(let j=0; j<role_check.length;j++){
        if(role_check[j].value == role[i].getAttribute('data-role')){
            role_check[j].selected = true;
        }
    }
    
}

table.addEventListener("change",function(e){
    if(e.target.classList.contains('member_role'))
    {
        console.log(e);
        for(let i=0; i<member_role.length;i++)
        {
            console.log(role[i].getAttribute("data-id"))
            let check = confirm("멤버 권한을 정말로 변경하시겠습니까? \n" +
            "현재 권한: " +role[i].getAttribute("data-role") +
            "\n변경 후 권한 : " + member_role[i].value )
            if(check){
            fetch("/member/updateRole?member_ID="+role[i].getAttribute('data-id')+"&member_Role="+member_role[i].value,{
                method : 'GET'
            })
            .then(res => res.text())
            .then(res=>{
                if(res>0)
                alert("변경 성공");
                else alert("변경 실패");
                location.href="/member/list";
            })
            break;
        }else{
            location.href="/member/list";
            break;
        }
    }
}
    

})
