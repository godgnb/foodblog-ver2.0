<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증하기</title>
</head>
<body>
<form action="">
	<input type="text" name="inputnumber" id="inputnumber" placeholder="인증번호를 입력하세요">
	<button type="button" name="btn" id="btn">인증하기</button><br>
	<span id="number_check"></span>
</form>

<!-- jQuery-2.2.4 js -->
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.2.4.min.js"></script>
<script>
$('#btn').click(function () {
	var inputnumber = $('#inputnumber').val();
	
	$.ajax({
		url: 'registerEmailCheck.do',
		data: {inputnumber: inputnumber},
		success: function (data) {
			if (data == true) {
				close();
				var objSpan = opener.document.getElementById('com_email');
				$(objSpan).text('인증되었습니다.').css('color', 'blue');
				var objbtn = opener.document.getElementById('emailCheck');
				$(objbtn).hide(); 
			} else {
				$('#number_check').text('인증번호가 일치하지 않습니다.').css('color', 'red');
			}
		}
		
		
	});
});


</script>
</body>
</html>