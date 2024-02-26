$(document).ready(function(){
	$('#replyAddBtn').click(function(){   //submit 버튼을 클릭하였을 때
		let sendData = "replyAddVal="+$('input[name=replyAddVal]').val();   //폼의 이름 값을 변수 안에 담아줌
		$.ajax({
			type:'post',   //post 방식으로 전송
			url:'detail.jsp',   //데이터를 주고받을 파일 주소
			data:sendData,   //위의 변수에 담긴 데이터를 전송해준다.
			dataType:form,   //html 파일 형식으로 값을 담아온다.
			success : function(result){   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
				$('#addForm').html(result.trim());  //현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다. 
			}
		});
	});
});