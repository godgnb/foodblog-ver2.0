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
.info_writer {
 	font-size: 12px;
    color: #777;
    margin: 0;
    display: inline-block;
}
.contact-form-area .form-control{
	position: relative;
    z-index: 2;
    height: 54px;
    width: 100%;
    background-color: #ffffff;
    font-size: 12px;
    margin-bottom: 15px;
    border: 1px solid #dadfe5;
    border-bottom: 2px solid #dadfe5;
    border-radius: 0;
    padding: 15px 30px;
    font-weight: 500;
    color: black;
    -webkit-transition-duration: 500ms;
    transition-duration: 500ms;
}
textarea.form-control {
	resize: none;
	color: black;
}
#postimg {
	width: 50%;
	height: 430px;
	border: 1px solid #9c919145;
}
.post-content {
	 display:inline-block; /* default값 inline */
     width:750px; /* display가 block일때만 지정가능 */
     height:auto; /* display가 block일때만 지정가능 */
     color:black;/* 글자색 : white */
     white-space: pre-wrap;
}
hr {
    margin-top: 1rem;
    margin-bottom: 1rem;
    border: 0;
    border-top: 1px solid #7a7a7a;
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


    <!-- ##### Post Details Area Start ##### -->
    <section class="post-news-area section-padding-100-0 mb-70">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Post Details Content Area -->
                <div class="col-12 col-lg-8 col-xl-9">
                    <div class="post-details-content mb-100">
                       	<div class=" mb-50">
                            <img id ="postimg" src="${pageContext.request.contextPath}/upload/${attach.filename }">
                        </div>
                        <div class="blog-content">
                            <h4 class="post-title">${ tipBoard.subject }</h4>
                            <div class="post-meta mb-50">
                                <span class="info_writer"><fmt:formatDate value="${ tipBoard.regDate }" pattern="MMMMM dd, yyyy" /></span>
                                <span class="info_writer">By ${ tipBoard.id }</span>
                            </div>
                            <div class="post-content">${ tipBoard.content }</div>
                        </div>
                    </div>
					<hr>
                    <!-- Comment Area Start -->
					<div class="comment_area clearfix mb-100">
					    <h4 class="mb-50">Comments</h4>
					     <ol>
					     <c:choose>
							<c:when test="${pageInfo.count gt 0}">
								<c:forEach var="commentlist" items="${commentList}">
							        <!-- Single Comment Area -->
							        <li class="single_comment_area">
					            		<!-- Comment Content -->
							            <div class="comment-content d-flex" style="max-width: 20rem;">
											<!-- Comment Meta -->
							                <div class="comment-meta">
							                    <div class="d-flex">
							                    	<span class="post-author" id="comment_id">${commentlist.id}</span>	
							                    		<c:if test="${id ne commentlist.id}">
							                    	<span class="reply" id="comment_date"><fmt:formatDate value="${commentlist.regDate}" pattern="yyyy.MM.dd HH:mm"/></span>
							                    	</c:if>
							                 	    <c:if test="${id eq commentlist.id}">
							                 	    	<span class="post-date" id="comment_date"><fmt:formatDate value="${commentlist.regDate}" pattern="yyyy.MM.dd HH:mm"/></span>
								                 	    <span class="post-date" id="comment_edit">
								                 	    	<a href="commentEditForm.do?num=${commentlist.num}&pageNum=${pageNum}&reNum=${commentlist.reNum}">수정</a>
								                 	    </span>
						                                <span class="reply" id="comment_delete">
						                                	<a href="commentDelete.do?num=${commentlist.num}&pageNum=${pageNum}&reNum=${commentlist.reNum}">삭제</a>
						                                </span>
					                                </c:if>
							                    </div>
							                    	<div class="post-content">${commentlist.content}</div>
							                </div>
							            </div>
				       				</li>
			       				</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="media">
				                	<div class="media-body">
			                      		<h4 class="media-heading" id="media-heading">댓글이 없습니다</h4>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					    </ol>
					    <!-- Page Area -->
	                    <div class="pagination-area mt-70">
	                        <nav aria-label="Page navigation example">
	                           <c:if test="${ pageInfo.count gt 0 }">
	                           		<ul class="pagination">
	                           			<%-- [이전] 출력 --%>
	                           			<c:if test="${ pageInfo.startPage gt pageInfo.pageBlock }">
	                           				<li class="page-item">
		                            			<a href="contentForm.do?num=${num}&pageNum=${ pageInfo.startPage-pageInfo.pageBlock }" class="page-link-move">[이전]</a>
		                           			</li>
	                           			</c:if>
	                           			<%--페이지블록 출력 --%>
	                           			<c:forEach var="i" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" step="1">
	                           				<c:choose>
	                           					<c:when test="${ i eq pageNum }">
	                           						<li class="page-item active">
			                           					<a href="contentForm.do?num=${num}&pageNum=${ i }" class="page-link">${ i }</a>
			                           				</li>
	                           					</c:when>
	                           					<c:otherwise>
	                           						<li class="page-item">
			                                   			<a href="contentForm.do?num=${num}&pageNum=${ i }" class="page-link">${ i }</a>
			                               			</li>
	                           					</c:otherwise>
	                           				</c:choose>
	                           			</c:forEach>
	                           			<%-- [다음] 출력 --%>
	                           			<c:if test="${ pageInfo.endPage lt pageInfo.pageCount }">
	                           				<li class="page-item">
		                           				<a href="contentForm.do?num=${num}&pageNum=${ pageInfo.startPage + pageInfo.pageBlock }" class="page-link-move">[다음]</a>
		                       				</li>
	                           			</c:if>
	                           		</ul>
	                           </c:if>
	                        </nav>
						</div>
					</div>
					
					<div class="post-a-comment-area mb-30 clearfix">
						<c:if test="${id ne tipBoard.id}">
						<!-- Reply Form -->
						<h4 class="mb-50">Leave a reply</h4>
						<div class="contact-form-area">	
						    <form action="commentWrite.do" method="post" onclick="return idCheck();">
						    <input type="hidden" name="num" id ="num" value="${tipBoard.num}"> 
						    <input type="hidden" name="pageNum" id ="pageNum" value="${pageNum}">
						        <div class="row">
						            <div class="col-12 col-lg-6">
						                <input type="text" class="form-control" name="id" id="id" value="${id}" placeholder="id" readonly>
						            </div>
						            <div class="col-12">
						                <textarea name="content" class="form-control" name="content" id="content" cols="30" rows="10" placeholder="Comment"></textarea>
						            </div>
						            <div class="col-12">
						                <button class="btn bueno-btn mt-30" type="button" onclick="location.href='tipboardForm.do?pageNum=${pageNum}';">목록보기</button>
						                <button class="btn bueno-btn mt-30" type="submit" id="rewrite">답글쓰기</button>
						            </div>
						        </div>
						    </form>
						</div>
						</c:if>
						<c:if test="${id eq tipBoard.id}">
						    <div class="col-12">
						    	<input class="btn bueno-btn mt-30" type="button" value="글수정" onclick="location.href='updateForm.do?num=${tipBoard.num}&pageNum=${pageNum}';">
								<input class="btn bueno-btn mt-30" type="button" value="글삭제" onclick="checkDelete();">
						        <input class="btn bueno-btn mt-30" type="button" value="목록보기" onclick="location.href='tipboardForm.do?pageNum=${pageNum}';">
						    </div>
						</c:if>
					</div>
                </div>

                <!-- Sidebar Widget -->
                <jsp:include page="../include/post_sidebar.jsp" />
                
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
function checkDelete() {
	var result = confirm('글을 정말 삭제하시겠습니까?');
	if (result == true) {
		location.href = 'deleteForm.do?num=${tipBoard.num}&pageNum=${pageNum}';
	}
}
</script>
<script>
function idCheck() {
	var id = $('#id').val();
	console.log(id);
	if (id == '') {
		var check = confirm('로그인이 필요한 작업입니다. \n로그인하시겠습니까?');
		if (check) {
			location.href='loginForm.do';
		}
	}
}
</script>
<!-- <script>
$('#rewrite').on('click', function () {
	var name = $('#name').val();
	var content = $('content').val();
	var num = $('num').val();
	
	$.ajax({
		url: 'commentWrite.do',
		data:{name: name, content: content, num: num},
		success: function (data) {
			
		}
	});
});
</script> -->

</body>

</html>