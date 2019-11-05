<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>MongMong</title>

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<style>
		.comment_area1 {
	 	 	border-bottom: 1px solid #eaeaea;
	 	 }
	 	 .contact-form-area .form-control{
			color: black;
	 	 }
	 	 .col-8 {
	 	 	margin-left: 100px;
	 	 }
	 	 .bueno-btn {
	 	 	margin-right: 70px;
	 	 }
	 	 .form_title {
		 	 font-size: 40px;
		 	 margin: 0 0 30px 95px;
	 	 }
	 	 .form-email{
		    position: relative;
		    z-index: 2;
		    height: 54px;
		    width: 50%;
		    background-color: #ffffff;
		    margin-right: 10px;
		    font-size: 12px;
		    border: 1px solid #dadfe5;
		    border-bottom: 2px solid #dadfe5;
		    border-radius: 0;
		    padding: 15px 30px;
		    font-weight: 500;
		    color: black;
		    -webkit-transition-duration: 500ms;
		    transition-duration: 500ms;
		}
	</style>
	
</head>

<body>
    <!-- ##### Header Area Start ##### -->
    	<jsp:include page="../include/header.jsp" />
    <!-- ##### Header Area End ##### -->


    <!-- ##### Treading Post Area Start ##### -->
    	<jsp:include page="../include/ranking.jsp" />
    <!-- ##### Treading Post Area End ##### -->


    <!-- ##### Search Area Start ##### -->
    <div class="bueno-search-area section-padding-100-0 pb-70 bg-img" style="background-image: url(../img/core-img/pattern.png);"></div>
    <!-- ##### Search Area End ##### -->
    
    
    <!-- ##### Post Details Area Start ##### -->
    <section class="post-news-area section-padding-100-0 mb-70">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Post Details Content Area -->
                <div class="col-12 col-lg-8 col-xl-9">
                    <div class="post-details-content">
                        <div class="blog-content">
                            <h4 class="post-title" style="font-size: 40px">Login / Register</h4>
                        </div>
                    </div>

                    <!-- Comment Area Start -->
                    <div class="comment_area1 clearfix mb-50">
                    
                    </div>

                    <div class="post-a-comment-area mb-30 clearfix">
                        <h4 class="form_title">Register</h4>

                        <!-- Register Form -->
                        <div class="contact-form-area">
                            <form name="frm" action="register.do" method="get" id="join" onsubmit="return check();">
                                <div class="row" >
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="id" name="id" placeholder="Id">
										<span id="com_id"></span>
                                        <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Passward" >
                                        <span id="com_passwd"></span>
                                        <input type="password" class="form-control" id="passwd2" name="passwd2" placeholder="Passward Check" >
                                        <span id="com_passwd2"></span>
                                        <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
                                        <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone Number" required>
                                        <input type="email" class="form-email" id="email" name="email" placeholder="E-mail" required>
                                        <button class="btn bueno-btn" type="button" id="emailCheck" onclick="winOpen();">인증번호 받기</button>
                                        <span id="com_email"></span><br>
                                        
                                        <button class="btn bueno-btn mt-30" type="submit" id="register" disabled>Register</button>
                                        <button class="btn bueno-btn mt-30" type="button" onclick="location='loginForm.do'">Cancel</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Post Details Area End ##### -->


    <!-- ##### Footer Area Start ##### -->
		<jsp:include page="../include/footer.jsp" />
    <!-- ##### Footer Area Start ##### -->


    <!-- ##### All Javascript Script ##### -->
	<!-- jQuery-2.2.4 js -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="${pageContext.request.contextPath}/resources/js/active.js"></script>

<script>
$('#id').blur(function () {
	var id = $(this).val();

	$.ajax({
		url: 'registerIdDupCheck.do',
		data: {id: id},
		success: function (data) {


		if (data == true) {
			$('#com_id').text('중복된 아이디입니다.').css('color', 'red');
			 $("#register").attr("disabled", true);
		} else {
			if (id.length < 5 || id.length > 15) {
			$('#com_id').text('5~15글자의 영문 대소문자, 숫자만 사용가능합니다').css('color', 'red');
			$("#register").attr("disabled", true);
			} else {
				$('#com_id').text('좋은 아이디입니다.').css('color', 'blue');
				$("#register").attr("disabled", false);
			}
			
		}	
					
			}
	});		
	 
}); // id

$('#passwd').blur(function () {
	if ($('#passwd').val().length < 8 || $('#passwd').val().length > 16) {
		$('#com_passwd').text('8~16글자의 영문 대소문자, 숫자만 사용가능합니다').css('color', 'red');
		$("#register").attr("disabled", true);
	} else {
		$('#com_passwd').text('');
		$("#register").attr("disabled", true);
	}
}); // passwd

$('#passwd2').blur(function () {
	if ($('#passwd').val() != $('#passwd2').val()) {
		$('#com_passwd2').text('패스워드가 일치하지 않습니다.').css('color', 'red');
		$("#register").attr("disabled", true);
	} else {
		$('#com_passwd2').text('패스워드가 일치합니다.').css('color', 'blue');
		$("#register").attr("disabled", false);
	}
}); // passwd2
</script>
<script>
function winOpen() {
	var inputEmail = $('#email').val();
	
	if (inputEmail == '') {
		alert('이메일을 입력하세요');
		$('#email').focus();
		return;
	}
	
	var childWindow = window.open('registerEmailCheckForm.do?inputEmail=' + inputEmail, '', 'width=400,height=300');
}
</script>
<script>
function check() {
	if ($('#com_email').text() != '인증되었습니다.') {
		alert('이메일인증은 필수입니다.');
		$('#email').focus();
		return false;
	}
	return true;
}
</script>
</body>

</html>