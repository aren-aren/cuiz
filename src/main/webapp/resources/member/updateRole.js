let member_role = document.getElementsByClassName("member_role form-select")
let table= document.getElementById("table");
let role = document.getElementsByClassName("color-white role")
//let role_check = document.getElementsByClassName("role_check");
let IDc = document.getElementsByClassName("color-white memberid")
console.log(1);



table.addEventListener("change",function(e){
    if(e.target.classList.contains('member_role'))
    {
        console.log(e.target.getAttribute('data-ID'));
        console.log(e.target.getAttribute("data-role"))
        console.log(e.target.value);
        fetch("/member/updateRole?member_ID="+e.target.getAttribute('data-ID')+"&member_Role="+e.target.value,{
            method : 'GET'
        })
        .then(res => res.text())
        .then(res =>{
            let check = confirm("멤버 권한을 정말로 변경하시겠습니까? \n" +
             "현재 권한: " +e.target.getAttribute("data-role") +
             "\n변경 후 권한 : " + e.target.value )
            if(check){
                if(res>0) alert('변경 성공');
                else alert("변경 실패");
                location.href='/member/list';
            }
            else{
                location.href='/member/list';
            }
        })

    }
})

let coin=0;
for(let i=0; i<member_role.length;i++){
    console.log(member_role[i].getAttribute('data-role'));    
    console.log(member_role[i]);
    console.log(member_role[i].children);
    member_role[i].children[0].setAttribute("class",'ADMIN'+i);
    member_role[i].children[0].setAttribute("data"+[i],'ADMIN');
    
    member_role[i].children[1].setAttribute("class",'MEMBER'+i); 
    member_role[i].children[1].setAttribute("data"+[i],'MEMBER');
    
    if(member_role[i].children[0].getAttribute("data"+[i])==member_role[i].getAttribute('data-role') ){
        member_role[i].children[0].selected=true;
    }
    else{
        member_role[i].children[1].selected=true;
    }

    }
    


// table.addEventListener("change",function(e){
//     if(e.target.classList.contains('member_role'))
//     {
//         console.log(e);
//         for(let i=0; i<member_role.length;i++)
//         {
//             console.log(role[i].getAttribute("data-id"))
//             let check = confirm("멤버 권한을 정말로 변경하시겠습니까? \n" +
//             "현재 권한: " +role[i].getAttribute("data-role") +
//             "\n변경 후 권한 : " + member_role[i].value )
//             if(check){
//             fetch("/member/updateRole?member_ID="+role[i].getAttribute('data-id')+"&member_Role="+member_role[i].value,{
//                 method : 'GET'
//             })
//             .then(res => res.text())
//             .then(res=>{
//                 if(res>0)
//                 alert("변경 성공");
//                 else alert("변경 실패");
//                 location.href="/member/list";
//             })
//             break;
//         }else{
//             location.href="/member/list";
//             break;
//         }
//     }
// }
    

// })
