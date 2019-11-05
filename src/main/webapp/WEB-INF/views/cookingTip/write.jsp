<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script href="${pageContext.request.contextPath}/resources/css/style.css"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    
<style>
.list-form {
	position: relative;
	z-index: 2;
	height: 54px;
	width: 100%;
	background-color: $white-color;
	font-size: 12px;
	margin-bottom: 15px;
	border: 1px solid #dadfe5;
	border-bottom: 2px solid #dadfe5;
	border-radius: 0;
	padding: 15px 30px;
	font-weight: 500;
	color: black;
} 
.frm {
	position: relative;
	width: 100%;
}
.list-form-textarea {
	position: relative;
	z-index: 2;
	width: 100%;
	background-color: $white-color;
	font-size: 12px;
	margin-bottom: 15px;
	border: 1px solid #dadfe5;
	border-bottom: 2px solid #dadfe5;
	border-radius: 0;
	padding: 15px 30px;
	font-weight: 500;
	color: black;
	resize: none;
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
    <div class="bueno-search-area section-padding-100-0 pb-70 bg-img" style="background-image: url(${pageContext.request.contextPath}/resources/img/core-img/pattern.png);">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="#" method="post">
                        <div class="row">
                            <div class="col-12 col-sm-6 col-lg-3">
                                <div class="form-group mb-30">
                                    <select class="form-control" id="recipe">
                                      <option value="">Recipe</option>
                                      <option value="">Recipe 1</option>
                                      <option value="">Recipe 2</option>
                                      <option value="">Recipe 3</option>
                                      <option value="">Recipe 4</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <div class="form-group mb-30">
                                    <select class="form-control" id="vegan">
                                      <option value="">Vegan</option>
                                      <option value="">Vegan 1</option>
                                      <option value="">Vegan 2</option>
                                      <option value="">Vegan 3</option>
                                      <option value="">Vegan 4</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <div class="form-group mb-30">
                                    <select class="form-control" id="ingredients">
                                      <option value="">Ingredients</option>
                                      <option value="">Ingredients 1</option>
                                      <option value="">Ingredients 2</option>
                                      <option value="">Ingredients 3</option>
                                      <option value="">Ingredients 4</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6 col-lg-3">
                                <div class="form-group mb-30">
                                    <button class="btn bueno-btn w-100">Search</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Search Area End ##### -->


    <!-- ##### Catagory Post Area Start ##### -->
    <div class="catagory-post-area section-padding-100">
        <div class="container">
        	<div class="title" style="margin-bottom: 40px; border-bottom: 1px solid #b1a8a8;">
        		<h2>나만의 꿀팁 전하기</h2>
        	</div>
            <div class="row justify-content-center">
                <!-- Post Area -->
                <div class="col-12 col-lg-8 col-xl-9">
                    <!-- Single Blog Post -->
                    <div class="single-blog-post style-1 d-flex flex-wrap mb-30">
                        <!-- Blog Thumbnail -->
                        <form action="write.do" method="post" enctype="multipart/form-data" id="frm" name="frm" class="frm" onsubmit="return check();">
                        	<div class="row">
	                            <div class="col-12 col-lg-6">
	                                <input type="text" class="list-form" name="id" value="${ id }" readonly>
	                            </div>
	                            <div class="col-12 col-lg-6">
	                                <input type="password" class="list-form" name="passwd" id="passwd" placeholder="Passward*">
	                            </div>
	                            <div class="col-12">
	                                <input type="text" class="list-form" name="subject" id="subject" placeholder="Subject*">
	                            </div>
	                            <div class="col-12">
	                                <input type="file" class="list-form" name="imgfile">
	                            </div>
	                            <div class="col-12">
	                                <textarea class="list-form-textarea" name="content" id="content" rows="17" placeholder="Content*"></textarea>
	                            </div>
	                            <div class="listwirte">
		                   			<input class="btn bueno-btn mt-30 mr-15" type="submit" value="글쓰기" >
		                   			<input class="btn bueno-btn mt-30 mr-15" type="reset" value="다시쓰기" >
		                   			<input class="btn bueno-btn mt-30 mr-15" type="button" value="목록보기" onclick="location.href='tipboardForm.do';">
		                        </div>
	                        </div>
	                    </form>    
                    </div>
                </div>

                <!-- Sidebar Area -->
                <jsp:include page="../include/post_sidebar.jsp" />
                
            </div>
        </div>
    </div>
    <!-- ##### Catagory Post Area End ##### -->


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
function check() {
	if ($('#passwd').val().length == 0) {
		alert('게시글 패스워드를 입력해주세요');
		$('#passwd').focus();
		return false;
	}
	if ($('#subject').val().length == 0) {
		alert('게시글 제목을 입력해주세요');
		$('#subject').focus();
		return false;
	}
	if ($('#content').val().length == 0) {
		alert('게시글 내용을 입력해주세요');
		$('#content').focus();
		return false;
	}
}
</script>	
</body>

</html>