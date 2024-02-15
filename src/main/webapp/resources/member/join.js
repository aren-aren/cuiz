let user_id = document.getElementById("ID");
let user_pw = document.getElementById("PW");
let user_pw2 = document.getElementById("PW2");
let divID = document.getElementById("id_check");
let divPW = document.getElementById("password_check");
let divPW2 = document.getElementById("password2_check");
let nick = document.getElementById("nick");
let nick_check = document.getElementById("nick_check");

let join_btn = document.getElementById("join-btn");

let emailRequest = document.getElementById("emailRequest");
let emailCheck = document.getElementById("emailCheck");
let emailText = document.getElementById("emailText").value;
let emailDiv = document.getElementById("emailDiv");

emailRequest.addEventListener("click",function(){
    let email = document.getElementById("email").value;
    console.log(email);

    fetch("/member/emailCheck?member_Email="+email,{
        method : 'GET'
    })
    .then(res=>res.text())
    .then(res => {
        console.log("emailcheck끝");
        console.log("인증번호 : " + res);
    })


})

emailCheck.addEventListener("click",function(){
    if(emailText=='a'){
        emailDiv.setAttribute("class","yes")
        emailDiv.innerHTML("이메일 인증이 완료되었습니다.");
    }else{
        emailDiv.setAttribute("class","no")
        emailDiv.innerHTML("이메일 인증번호가 다릅니다.");    
    }

})


join_btn.setAttribute("disabled","disabled")
nick_check.setAttribute("class","no");
divID.setAttribute("class","no");
divPW.setAttribute("class","no");
divPW2.setAttribute("class","no");



nick.addEventListener("blur",function(){
    
    fetch("/member/nickcheck?member_Nick="+nick.value,{
        method : "GET"
    })
    .then(res => res.text())
    .then(res => {
        if(nickcheck(nick.value)){

        if(res>0){
            nick_check.innerHTML = "중복된 닉네임입니다.";
            nick_check.setAttribute("class","no");
        }
        else{
            nick_check.innerHTML = "사용가능한 닉네임입니다.";
            nick_check.setAttribute("class","yes");
        }

        if(nick_check.getAttribute("class") == "yes" && divID.getAttribute("class") == "yes" && divPW.getAttribute("class") == "yes" && divPW2.getAttribute("class") == "yes"){
            join_btn.disabled = false;            
        }else{
            join_btn.disabled = true;
        }
    }
    else{
        nick_check.innerHTML = "닉네임 작성 양식을 지켜주세요";
         nick_check.setAttribute("class","no");
    }


    })
})

user_id.addEventListener("blur",function(){

    fetch("/member/idcheck?member_ID="+user_id.value,{
        method : "GET"
    })
    .then(res => res.text())
    .then(res =>{
        if(idcheck(user_id.value)){

            if(res>0){
                divID.innerHTML = "중복된 아이디입니다.";
                divID.setAttribute("class","no");
            }
            else if(res == 0){
                divID.innerHTML = "사용가능한 아이디입니다.";
                divID.setAttribute("class","yes");
            }
            if(nick_check.getAttribute("class") == "yes" && divID.getAttribute("class") == "yes" && divPW.getAttribute("class") == "yes" && divPW2.getAttribute("class") == "yes"){
                join_btn.disabled = false;            
            }else{
                join_btn.disabled = true;
            }
        }
        else{
            divID.innerHTML = "아이디는 4~20글자내에 대소문자와 숫자로 조합해주세요";
            divID.setAttribute("class","no");
        }
    })
})

function idcheck(id){
    let check = /^[a-zA-Z0-9]{4,20}$/
    console.log(id);
    if(check.test(id)) return true;
    else return false;
}

function pwcheck(password) {
    let check = new RegExp('(?=.*[a-zA-Z0-9])(?=.*[~!@#$%^&*])(?=.{4,20})');
    if(check.test(password) )
    return true;
    else
    return false;

}

function nickcheck(nick){
    let check = /^[a-zA-Z0-9]{4,10}$/;
    if(check.test(nick)) return true;
    else return false;
}

user_pw.addEventListener("blur",function(){
    if(user_pw.value.length<8 ){
        divPW.innerHTML = "비밀번호 작성 양식을 지켜주세요"
        divPW.setAttribute("class","no");
    }
    else if (user_pw.value.length>20){
        divPW.innerHTML = "최대 20자로 작성해주세요.";
        divPW.setAttribute("class","no");
    }
    else{
        if(pwcheck(user_pw.value)){
            divPW.innerHTML = "사용가능한 비밀번호입니다.";
            divPW.setAttribute("class","yes");
        }
        else{
            divPW.innerHTML = "특수문자(~,@,#,$,%,^,&,*),숫자와 대소문자 최소 1글자를 조합해주세요";
            divPW.setAttribute("class","no");
        }
    }


    if(user_pw2.value != ''){
        if(user_pw.value != user_pw2.value){
            divPW2.innerHTML = "비밀번호가 일치하지않습니다.";
            divPW2.setAttribute("class","no");
        }
        else{
            divPW2.innerHTML = "비밀번호 작성 양식을 지켜주세요."
            divPW2.setAttribute("class","no");
            if(divPW.getAttribute("class") == "yes"){
            divPW2.innerHTML = "비밀번호가 일치합니다.";
            divPW2.setAttribute("class","yes");
        }

        if(nick_check.getAttribute("class") == "yes" && divID.getAttribute("class") == "yes" && divPW.getAttribute("class") == "yes" && divPW2.getAttribute("class") == "yes"){
            join_btn.disabled = false;            
        }else{
            join_btn.disabled = true;
        }
    }


}
})

user_pw2.addEventListener("blur",function(){
    if(user_pw.value != user_pw2.value){
        divPW2.innerHTML = "비밀번호가 일치하지않습니다.";
        divPW2.setAttribute("class","no");
    }
    else{
        divPW2.innerHTML = "비밀번호 작성 양식을 지켜주세요."
        divPW2.setAttribute("class","no");
        if(divPW.getAttribute("class") == "yes"){
        divPW2.innerHTML = "비밀번호가 일치합니다.";
        divPW2.setAttribute("class","yes");
    }
    }

    if(user_pw.value.length<8 ){
        divPW.innerHTML = "비밀번호 작성 양식을 지켜주세요"
        divPW.setAttribute("class","no");
    }
    else if (user_pw.value.length>20){
        divPW.innerHTML = "최대 20자로 작성해주세요.";
        divPW.setAttribute("class","no");
    }
    else{
        if(pwcheck(user_pw.value)){
            divPW.innerHTML = "사용가능한 비밀번호입니다.";
            divPW.setAttribute("class","yes");
        }
        else{
            divPW.innerHTML = "특수문자(~,@,#,$,%,^,&,*),숫자와 대소문자 최소 1글자를 조합해주세요";
            divPW.setAttribute("class","no");
        }
    }

    if(nick_check.getAttribute("class") == "yes" && divID.getAttribute("class") == "yes" && divPW.getAttribute("class") == "yes" && divPW2.getAttribute("class") == "yes"){
        join_btn.disabled = false;            
    }else{
        join_btn.disabled = true;
    }
})


