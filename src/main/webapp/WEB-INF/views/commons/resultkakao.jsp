<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">		
		
		let msg = "${msg}";
		let total =  "${total}";		
		let result = "${result}";

		 if(total>0){		
			let coin = total/10;
			msg = '${msg}\n\n'+'결제금액 : '+'${total}' +'\n코인충전갯수 :  '+coin;
		} 
		 if (result==1){
			
			 msg = '${msg}'+'\n\n'+'${response}';			 
		 }		
		 
		if (result>1){			
			let obj= '${response}';
			console.log(obj);		
			let errorMsg = obj["error_message"];
			let errorCode = obj["error_code"];			
			msg = '${msg}'+'\n\n'+errorMsg+"\n\n error_code : "+errorCode;			 
		}		
		 
		alert(msg);
		
		window.self.close();
		
	</script>
</body>
</html>