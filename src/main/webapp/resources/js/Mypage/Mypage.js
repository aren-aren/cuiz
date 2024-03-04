const memberID= document.getElementById("memberID");
const perList = document.getElementById("perList");
const itemBtn = document.getElementById("itemBtn");
const purcBtn = document.getElementById("purcBtn");
const coinSpn = document.getElementById("coinSpn");
const videoB= document.getElementById("videoB");
const itemSet = document.getElementById("itemSet");

// const searchfrm = document.getElementById("searchfrm");
// const searchBtn = document.getElementById("searchBtn");

let itemNum = document.getElementById("itemNum").value;
let item_Group = document.getElementById("item_Group").value;

let memCoin = document.getElementById("memCoin");
let itemlist = document.getElementById("itemlist");



let listAll = document.getElementById("list-all");
let listGroup1 = document.getElementById("list-group1");
let listGroup2 = document.getElementById("list-group2");
let listGroup3 = document.getElementById("list-group3");
let listGroup4 = document.getElementById("list-group4");
let bg_video = document.getElementById("bg_video");

let icon = '<i class="fa-solid fa-coins"></i>'  
coinSpn.innerHTML=icon+parseInt(memCoin.value).toLocaleString('ko-KR');

itemlist.style.display = 'none';
// 결제목록 들어가기
purcBtn.addEventListener("click", function(){
  window.open("/purchase/list",'결제목록','width=1400, height=700, scrollbars=yes');
})

//아이템 메뉴 숨기기
itemBtn.addEventListener("click",function(){
  toggleList(itemlist);
});

//토글기능
function toggleList(selectlist){
  //토글할 리스트
  //selectlist 
  //숨기기 
  if(selectlist.style.display !== 'none'){
    selectlist.style.display = 'none';
    itemBtn.innerText="아이템목록";
  }
  //보이기
  else{ 
    selectlist.style.display = 'block'
    itemBtn.innerText="아이템 목록 닫기";
  }
}


document.addEventListener("DOMContentLoaded ",frm(memberID.value));
async function frm (id){
  try {
    let respone = await fetch("./list?member_ID="+id)
    let result = await respone.json()     
      for(let list of result){
        // let item = JSON.parse(list);
        // console.log(result)
        let item_group = list.item_Group;        
        let tag = `<img src="${list.item_Photo_to_String}" alt="" style="overflow:hidden; margin:0 auto; "/>`;
        let p = parseInt(`${list.item_Price}`);
        let price = p.toLocaleString('ko-KR');   

        if(item_group==1){

          tag = `<video src="${list.item_Photo_to_String}" muted autoplay playsinline loop width=100%>`;   
        }
        let html ="";
        html =`        
        <div class="col-3" onclick="temp(${list.item_Num},${list.item_Group})">
          <div class="item"  style="height: 250px" > 
            <div class="thumb" >                            
            ${tag}
            </div>
            <div class="down-content">
            <h4 class="temp" data-temp ="${list.item_Num},${list.item_Group}"  >${list.item_Name}</h4>
            </div>             
          </div>
        </div>`        
        listAll.innerHTML += html;        
        if(item_group==1){      
        listGroup1.innerHTML += html;
        }
        if(item_group==2){
          listGroup2.innerHTML += html;
        }
        if(item_group==3){
          listGroup3.innerHTML += html;
        }
        if(item_group==4){          
          listGroup4.innerHTML += html;
        }
      }   
  } catch (e) {
    console.log(e)
  }    
  }
 

  

async function temp(Num,gum){
   itemNum = Num;
   item_Group = gum;
  let respone = await fetch("./temp?item_Num="+itemNum+"&item_Group="+gum);
  let result = await respone.json();
    bg_video.setAttribute("src",result.item_Photo_to_String); 
  }

itemSet.addEventListener("click", async function(){ 
  try {
    let response = await fetch("./setUpdate?item_Num="+itemNum+"&item_Group="+item_Group);
    console.log(typeof response)
    let result = await response.text();
    console.log(result)
    let msg = "실패";
    if(result=="1"){
      msg = "성공";
    }    
    alert(msg);
  } catch (error) {
    console.log(error)
  }

})



