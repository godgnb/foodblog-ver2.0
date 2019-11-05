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
.media {
    border-bottom: 1px solid #ebebeb;
    padding: 0 0 22px 0;
}
.media-left {
    padding-right: 25px;
    display: table-cell;
}
.media-body{
	padding: 30px 0 30px;
	display: table-cell;
    vertical-align: middle;
}
.info_writer {
    font-size: 12px;
    color: #777;
    margin: 0;
    display: inline-block;
}
.info_writer span {
	padding: 0 5px 0 5px;
}
.page-link-move {
    width: 50px;
    height: 33px;
    line-height: 33px;
    font-size: 15px;
    color: #7a7a7a;
    text-transform: uppercase;
    text-align: center;
    display: inline-block;
    border-radius: 0;
    padding: 0;
    margin-right: 5px;
    border: none;
}
.search{
	width: 300px;
    height: 50px;
    background-color: transparent;
    border: none;
    color: black;
    border-bottom: 2px solid #817773;
    font-size: 16px;
    font-style: italic;
    vertical-align: middle;
    margin-left: 100px;
	
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
        		<h2>${ pageInfo.count }개의 행복한 팁이 있습니다</h2>
        	</div>
        	<div class="row justify-content-center">
                <!-- Post Area -->
                <div class="col-12 col-lg-8 col-xl-9">
		        	<c:choose>
		        		<c:when test="${ pageInfo.count gt 0 }">
		        			<c:forEach var="boardlist" items="${ tipboardList }">
		        				<!-- Single Blog Post -->
			                    <div class="media">
			        			<!-- Media Area -->
				                 	<div class="media-left">
				                 	<a href="contentForm.do?num=${ boardlist.num }&pageNum=${ pageNum }">
										<img src="" alt="" style="width: 200px;height: 130px;">
									</a>
									</div>
				                  	<div class="media-body">
				                  		<h4 class="media-heading" id="media-heading"><a href="contentForm.do?num=${ boardlist.num }&pageNum=${ pageNum }">${ boardlist.subject }</a></h4>
						                <p class="info_writer">${ boardlist.id }<span>|</span><fmt:formatDate value="${ boardlist.regDate }" pattern="yyyy-MM-dd HH:mm"/><span>|</span>
						                <span class="cate_view">${ boardlist.readcount }</span><span>|</span><span class="cate_comment">${ boardlist.commcount }</span></p>
									</div>
								</div>
		        			</c:forEach>
		        		</c:when>
		        		<c:otherwise>
		        			<div class="media">
			                	<div class="media-body">
		                      		<h4 class="media-heading" id="media-heading"></h4>
								</div>
							</div>
		        		</c:otherwise>
		        	</c:choose>
        	
        			<!-- Search Area -->
                    <div class="pagination-area mt-70">
                        <nav aria-label="Page navigation example">
                           <c:if test="${ pageInfo.count gt 0 }">
                           		<ul class="pagination">
                           			<%-- [이전] 출력 --%>
                           			<c:if test="${ pageInfo.startPage gt pageInfo.pageBlock }">
                           				<li class="page-item">
	                            			<a href="tipboardForm.do?pageNum=${ pageInfo.startPage-pageInfo.pageBlock }&search=${ search }" class="page-link-move">[이전]</a>
	                           			</li>
                           			</c:if>
                           			<%--페이지블록 출력 --%>
                           			<c:forEach var="i" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" step="1">
                           				<c:choose>
                           					<c:when test="${ i eq pageNum }">
                           						<li class="page-item active">
		                           					<a href="tipboardForm.do?pageNum=${ i }&search=${ search }" class="page-link">${ i }</a>
		                           				</li>
                           					</c:when>
                           					<c:otherwise>
                           						<li class="page-item">
		                                   			<a href="tipboardForm.do?pageNum=${ i }&search=${ search }" class="page-link">${ i }</a>
		                               			</li>
                           					</c:otherwise>
                           				</c:choose>
                           			</c:forEach>
                           			<%-- [다음] 출력 --%>
                           			<c:if test="${ pageInfo.endPage lt pageInfo.pageCount }">
                           				<li class="page-item">
	                           				<a href="tipboardForm.do?pageNum=${ pageInfo.startPage + pageInfo.pageBlock }&search=${ search }" class="page-link-move">[다음]</a>
	                       				</li>
                           			</c:if>
                           		</ul>
                           </c:if>
                        </nav>
                        <form action="tipboardForm.do" method="get">
                        <div class="listwirte">
                      		<c:if test="${ empty id }">
                      			<input class="btn bueno-btn mt-30" type="button" value="글쓰기" onclick="idCheck();">
                      		</c:if>
                      		<c:if test="${ not empty id }">
                      			<input class="btn bueno-btn mt-30" type="button" value="글쓰기" onclick="location.href='writeForm.do';">
                      		</c:if>
                      		
							<input type="text" name="search" class="search mt-30" value="${ search }" placeholder="Search">
							<button type="submit" class="btn mt-30">
								<i class="fa fa-search"></i>
							</button>
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
	function idCheck() {
		var check = confirm('로그인이 필요한 작업입니다. \n로그인하시겠습니까?');
		if (check) {
			location.href='loginForm.do';
		}
	}
</script>		
</body>

</html>