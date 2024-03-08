const searchBtn = document.getElementById("searchBtn");
const searchfrm = document.getElementById("searchfrm");
const search = document.getElementById("search2");
const sort = document.getElementById("sort");


let icon = '<i class="fa-solid fa-coins"></i>'  
let formun = document.getElementById("formun");
let kindtemp = "kind0"; 
let sortTemp;
let queryStringTemp; 








document.addEventListener("DOMContentLoaded ",fetchItem(kindtemp));


sort.addEventListener("change",function(e){
  console.log(e)
  let {target:{value}} = e;
  
  let temp = (kindtemp+"&sort="+value)
  console.log(temp)


  fetchItem(temp)
})

search.addEventListener("click" , (e)=>{   
    const queryString = new URLSearchParams(new FormData(searchfrm)).toString();
    queryStringTemp = queryString;
    console.log(queryString);

  fetch("api/list?kind="+kindtemp+"&"+queryString)
    .then(result=>result.json())
    .then(result=>frm(result))
   
})






function fetchItem(kindtemp){
  console.log(kindtemp)
  fetch("api/list?kind="+kindtemp)
  .then(result=>result.json())
  .then(result=>frm(result))

};



function frm(result){
    let html ="";
    formun.innerHTML=html;
    console.log(result)
        for(let list of result){

        let tag = `<img src="${list.item_Photo_to_String}" alt="" style="overflow:hidden; margin:0 auto; ">`;

        if(list.item_Group==1){
          tag = `<video src="${list.item_Photo_to_String}" muted autoplay playsinline loop width=100%></video>`;
        }
        let ip = list.item_Price;
        let itempi= parseInt(list.item_Price).toLocaleString('ko-KR');
        let itemPrice= icon + itempi;
        
        if(list.item_Group==0){
         itemPrice= '&#8361;' +itempi;
        
        }

        console.log(itemPrice)

        html +=
           `
           <div class="col-lg-3 col-sm-6">
           <div class="item" style="height: 200px">
           <a href="detail?item_Num=${list.item_Num}">
           ${tag}
           </a>
           <a href="detail?item_Num=${list.item_Num}">
           <h4>NO_${list.item_Num}<br><span>${itemPrice}</span></h4>
           </a>
           <ul>
           <li>${list.item_Name}</li>           
           </ul>    
           </div>
           </div>
          `            
        }
        formun.innerHTML=html;
}

  