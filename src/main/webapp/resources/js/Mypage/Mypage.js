const perList = document.getElementById("perList");
const memberID= document.getElementById("memberID");
// const searchfrm = document.getElementById("searchfrm");
// const searchBtn = document.getElementById("searchBtn");

let listAll = document.getElementById("list-all");
let listGroup1 = document.getElementById("list-group1");
let listGroup2 = document.getElementById("list-group2");
let listGroup3 = document.getElementById("list-group3");
let listGroup4 = document.getElementById("list-group4");




document.addEventListener("DOMContentLoaded ",frm(memberID.value));


function frm(id){
    fetch("list?member_ID="+id)
    .then(result=>result.json())
    .then(result=>{

      console.log(result)  
      
      for(let list of result){
        // let item = JSON.parse(list);
        let item_group = list.item_Group;
        
        let tag = `<img src="${list.item_Photo_to_String}" alt="" style="overflow:hidden; margin:0 auto; "/>`;
        
        if(item_group==1){
          tag = `<video src="${list.item_Photo_to_String}" muted autoplay playsinline loop width=100%>`;   
        }

        let html ="";
        html =`
        
        <div class="col-lg-3 col-sm-6" style="display: inline-block;">
          <div class="item" style="height: 200px">                              
            ${tag}
           <h4>${list.item_Name}<br><span>${list.item_Price}</span></h4>
          
           <ul>
           <li><i class="fa fa-star"></i> 4.8</li>
           <li><i class="fa fa-download"></i> 2.3M</li>
           </ul>    
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
   
    })  
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