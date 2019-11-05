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
	 	 	border-bottom: 1px solid #b1a8a8;
	 	 }
	 	 .contact-form-area .form-control{
	 	 	width: 320px;
	 	 	color: black;
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
    <div class="bueno-search-area section-padding-100-0 pb-70 bg-img" style="background-image: url(${pageContext.request.contextPath}/resources/img/core-img/pattern.png);"></div>
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
                        <h4 class="mb-30" style="font-size: 40px">Login</h4>

                        <!-- Login Form -->
                        <div class="contact-form-area">
                            <form action="" method="post" name="frm" id="frm">
                                <div class="row">
                                    <div class="col-6">
                                        <input type="text" class="form-control" id="id" name="id" placeholder="Id">
                                        <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Passward">
                                        <span id="com_login"></span><br>
                                        <label>Remember Me</label>
										<input type="checkbox" name="rememberMe" value="true"/><br><br>
                                        <button class="btn bueno-btn" type="button" id="loginbtn">Login</button>
                                        <button class="btn bueno-btn" type="button" onclick="location.href='registerForm.do'">Register</button>
                                        
                                    </div>
                                    <div class="col-6 col-lg-6">
                                     	<img src="${pageContext.request.contextPath}/resources/img/bg-img/4.jpg" alt="" />
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
$('#loginbtn').click(function () {
	var id = $('#id').val();
	var passwd = $('#passwd').val();

	$.ajax({
		url: 'login.do',
		data: {id: id, passwd: passwd},
		success: function (data) {
			console.log(typeof data);
			console.log(data);
			
			idDupMessage(data);
		}
	});
});

function idDupMessage(check) {
	if (check == 1) {
		$('#com_login').html('');
		location.href = 'main.do';
	} else {
		$('#com_login').html('아이디 혹은 패스워드가 일치하지 않습니다.').css('color', 'red');
	}
	
}
	
</script> 
</body>

</html>