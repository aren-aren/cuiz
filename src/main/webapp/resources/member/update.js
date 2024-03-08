
let join_btn = document.getElementById("join-btn");

let hidden_Token = document.getElementById("hidden_Token").value;


console.log(hidden_Token);



if(hidden_Token==0){
    let user_pw = document.getElementById("PW");
    let user_pw2 = document.getElementById("PW2");
    let divPW = document.getElementById("password_check");
    let divPW2 = document.getElementById("password2_check");

    join_btn.setAttribute("disabled","disabled")
    divPW.setAttribute("class","no");
    divPW2.setAttribute("class","no");
    
    function pwcheck(password) {
        let check = new RegExp('(?=.*[a-zA-Z0-9])(?=.*[~!@#$%^&*])(?=.{8,20})');
        if(check.test(password) )
        return true;
        else
        return false;
    
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
    if(divPW.getAttribute("class") == "yes" && divPW2.getAttribute("class") == "yes"){
        join_btn.disabled = false;            
    }
    else{
        join_btn.disabled = true;
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
    if(divPW.getAttribute("class") == "yes" && divPW2.getAttribute("class") == "yes"){
        join_btn.disabled = false;            
    }else{
        join_btn.disabled = true;
    }

})
}