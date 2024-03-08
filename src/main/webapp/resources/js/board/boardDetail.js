  //board delete
  const frm = document.querySelector("#contactForm");
	$("#delete").on("click", function(e){
	let n = $(this).attr("data-board_Num")
	console.log("board_Num : ", n)
	      e.preventDefault();
	      frm.setAttribute("action", "./delete");
	      frm.setAttribute("method", "post");
	      frm.submit();
	      
})
	  
//reply add

$(document).ready(function(){
	$('#replyAddBtn').click(function(){   //버튼을 클릭하였을 때
	console.log(123)
	let reply_num = $('input[name=reply_Num]').val();
	let replyAddVal = $('textarea[name=replyAddVal]').val();
	let user_Name = document.getElementById('user_name').value;
	
		let sendData = "reply_Contents="+replyAddVal
						+"&board_Num="+$('input[name=board_Num]').val()
						+"&user_Name="+user_Name;   //폼의 이름 값을 변수 안에 담아줌
		console.log(sendData)
		$.ajax({
			type:'post',   //post 방식으로 전송
			url:'/reply/add',   //데이터를 주고받을 파일 주소
			data:sendData,   //위의 변수에 담긴 데이터를 전송해준다.
			dataType: "text",   //html 파일 형식으로 값을 담아온다.
			success : function(result){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
				console.log('tedy');
				$('#addForm').html(result.trim());  //현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다.
				location.reload();
				//location.href="http://localhost/qna/detail?board_Num="+$('input[name=board_Num]').val();
			}
		});
	});
});

//reply delete

$(".delete2").on("click", function(){
	let n = $(this).attr("data-reply_Num")
	console.log("reply_Num : ", n)

	
	fetch("../reply/delete",{
		method:"post",
		headers : {"Content-type": 'application/x-www-form-urlencoded;charset=utf-8'},
		body:"reply_Num="+n
	})
	.then(r=>r.json())
	.then(r=>{
		replyList.innerHTML="";
	})
		location.reload();
})
