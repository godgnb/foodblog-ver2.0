<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
		 	 font-size: 25px;
		 	 margin: 0 0 30px 95px;
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
                            <h4 class="post-title" style="font-size: 40px">My Account</h4>
                        </div>
                    </div>

                    <!-- Comment Area Start -->
                    <div class="comment_area1 clearfix mb-50">
                    
                    </div>

                    <div class="post-a-comment-area mb-30 clearfix">
                        <h4 class="form_title">Detail Information</h4>

                        <!-- Register Form -->
                        <div class="contact-form-area">
                            <form name="frm" action="edit.do" method="get" id="join">
                                <div class="row" >
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="id" name="id" value="${ member.id }" readonly>
                                        <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Passward*" >
                                        <input type="text" class="form-control" id="name" name="name" value="${ member.name }" >
                                        <input type="tel" class="form-control" id="phone" name="phone" value="${ member.phone }" >
                                        <input type="text" class="form-control" id="email" name="email" value="${ member.email }" >
                                        
                                        <input class="btn bueno-btn mt-30 mr-15" type="submit" value="정보수정" id="edit">
                                        <input class="btn bueno-btn mt-30 mr-15" type="button" value="회원탈퇴" id="delete">
                                        <input class="btn bueno-btn mt-30 mr-15" type="button" value="메인으로" onclick="location.href='main.do'">
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
$('#delete').on('click', function () {
	var passwd = $('#passwd').val();
	if (passwd.length == 0) {
		alert('패스워드를 입력해주세요');
		$('#passwd').focus();
		return false;
	}
	
	var check = confirm("탈퇴하시겠습니까?");
	if (check == true) {
		location.href='accountDelete.do';
	}
});
$('#edit').on('click', function () {
	var passwd = $('#passwd').val();
	if (passwd.length == 0) {
		alert('패스워드를 입력해주세요');
		$('#passwd').focus();
		return false;
	}
});
</script>
</body>

</html>