const memberID= document.getElementById("memberID");
const perList = document.getElementById("perList");
const itemBtn = document.getElementById("itemBtn");
const purcBtn = document.getElementById("purcBtn");
const coinSpn = document.getElementById("coinSpn");
const videoB= document.getElementById("videoB");

// const searchfrm = document.getElementById("searchfrm");
// const searchBtn = document.getElementById("searchBtn");
let memCoin = document.getElementById("memCoin");
let itemlist = document.getElementById("itemlist");
itemlist.style.display = 'none';


let listAll = document.getElementById("list-all");
let listGroup1 = document.getElementById("list-group1");
let listGroup2 = document.getElementById("list-group2");
let listGroup3 = document.getElementById("list-group3");
let listGroup4 = document.getElementById("list-group4");


  let icon = '<i class="fa-solid fa-coins"></i>'
  parseInt(memCoin.value).toLocaleString('ko-KR');    
  coinSpn.innerHTML=icon+parseInt(memCoin.value).toLocaleString('ko-KR');


// 결제목록 들어가기


purcBtn.addEventListener("click", function(){
  window.open("/purchase/list");
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
  }
  //보이기
  else{ 
    selectlist.style.display = 'block'
  }

}


document.addEventListener("DOMContentLoaded ",frm(memberID.value));


async function frm (id){
  try {
    let respone = await fetch("./list?member_ID="+id)
    let result = await respone.json()
      console.log(result)  
      
      for(let list of result){
        // let item = JSON.parse(list);
        // console.log(result)
        let item_group = list.item_Group;        
        let tag = `<img src="${list.item_Photo_to_String}" alt="" style="overflow:hidden; margin:0 auto; "/>`;
        let p = parseInt(`${list.item_Price}`);
        let price = p.toLocaleString('ko-KR');
        console.log(p+"   "+price);

        if(item_group==1){
          tag = `<video src="${list.item_Photo_to_String}" muted autoplay playsinline loop width=100%>`;   
        }

        if(list.item_Num==112){
          console.log(videoB)
          let bg_video = document.createElement("video")
          bg_video.setAttribute("id","testbg")
          bg_video.setAttribute("src",`${list.item_Photo_to_String}`)
          bg_video.classList.add("mx-auto")
          bg_video.muted=true;
          bg_video.autoplay = true
          bg_video.playsinline= true
          bg_video.loop= true
          bg_video.setAttribute("style","display:block; margin:0 auto; width : 100%; z-index:-1;   position: absolute;")
          console.log(bg_video)
          // videoB.innerHTML = `<video src="${list.item_Photo_to_String}" id="testbg" muted autoplay playsinline loop width=100% z-index=-1/>`;   
          videoB.prepend(bg_video)
          console.log(videoB)
        }


        let html ="";
        html =`        
        <div class="col-3" >
          <div class="item"  style="height: 250px" > 
            <div class="thumb">                            
            ${tag}
            </div>
            <div class="down-content">
            <h4>${list.item_Name}</h4>
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



// searchBtn.addEventListener("click" ,(e)=>{

//     temp = e.target.value;
//     ar = formun.children;
//     console.log(ar)
//     console.log(temp)
//     for(let list of ar){
//       console.log("aaaaaaa"+list.id);
//       if(1== document.getElementById(temp)){
//         console.log('trus');
//         document.getElementById(temp).style.visibility = "visible";
//       }
//       document.getElementById(temp).style.visibility = "hidden";
//       // if(list.id == temp ){
//       //   document.getElementById(temp).style.visibility = "hidden";
//       // }
//       // list.id.style.visibility = "hidden";
      
//     }

// });