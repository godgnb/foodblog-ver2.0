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
	table {
	  width: 100%;
	  border-top: 1px solid #444444;
	  border-collapse: collapse;
	}
	th, td {
	  border-bottom: 1px solid #444444;
	  padding: 10px;
	  text-align: center;
	}
	thead tr {
	  background-color: #0d47a1;
	  color: #ffffff;
	}
	tbody tr:nth-child(2n) {
	  background-color: #bbdefb;
	}
	tbody tr:nth-child(2n+1) {
	  background-color: #e3f2fd;
	}
	.search {
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
                <h4 class="post-title" style="font-size: 40px">ADMIN</h4>
                    <form action="#" method="post">
                        <div class="row">
                            <div class="col-12 col-sm-6 col-lg-3">
                                <div class="form-group mb-30">
                                    <select class="form-control" id="member" onchange="window.open(value,'_self')">
                                      <option value="">회원관리</option>
                                      <option value="allMemberForm.do">전체회원정보보기</option>
                                      <option value="">전체회원정보수정</option>
                                      <option value="">전체회원정보삭제</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <div class="form-group mb-30">
                                    <select class="form-control" id="vegan">
                                      <option value="">게시판관리</option>
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
			        <div class="post-details-content">
                        <div class="blog-content">
                            <h4 class="post-title" style="font-size: 40px">전체회원수: ${pageInfo.count}</h4>
                        </div>
                    </div>
			        <table border="1">
			        	<thead>
				        	<tr>
				        		<th scope="col">아이디</th>
				        		<th scope="col">이름</th>
				        		<th scope="col">휴대폰번호</th>
				        		<th scope="col">이메일</th>
				        		<th scope="col">가일날짜</th>
				        	</tr>
			        	</thead>
			        	<tbody>
				        	<c:forEach var="member" items="${memberList}">
				        		<tr>
				        			<td>${member.id}</td>
				        			<td>${member.name}</td>
				        			<td>${member.phone}</td>
				        			<td>${member.email}</td>
				        			<td><fmt:formatDate value="${member.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				        		</tr>
				        	</c:forEach>
			        	</tbody>
			        </table>
		
					<!-- Search Area -->
                    <div class="pagination-area mt-70">
                        <nav aria-label="Page navigation example">
                           <c:if test="${ pageInfo.count gt 0 }">
                           		<ul class="pagination">
                           			<%-- [이전] 출력 --%>
                           			<c:if test="${ pageInfo.startPage gt pageInfo.pageBlock }">
                           				<li class="page-item">
	                            			<a href="allMember.do?pageNum=${ pageInfo.startPage-pageInfo.pageBlock }&search=${ search }" class="page-link-move">[이전]</a>
	                           			</li>
                           			</c:if>
                           			<%--페이지블록 출력 --%>
                           			<c:forEach var="i" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" step="1">
                           				<c:choose>
                           					<c:when test="${ i eq pageNum }">
                           						<li class="page-item active">
		                           					<a href="allMember.do?pageNum=${ i }&search=${ search }" class="page-link">${ i }</a>
		                           				</li>
                           					</c:when>
                           					<c:otherwise>
                           						<li class="page-item">
		                                   			<a href="allMember.do?pageNum=${ i }&search=${ search }" class="page-link">${ i }</a>
		                               			</li>
                           					</c:otherwise>
                           				</c:choose>
                           			</c:forEach>
                           			<%-- [다음] 출력 --%>
                           			<c:if test="${ pageInfo.endPage lt pageInfo.pageCount }">
                           				<li class="page-item">
	                           				<a href="allMember.do?pageNum=${ pageInfo.startPage + pageInfo.pageBlock }&search=${ search }" class="page-link-move">[다음]</a>
	                       				</li>
                           			</c:if>
                           		</ul>
                           </c:if>
                        </nav>
                        <form action="allMember.do" method="get">
	                        <div class="listwirte">
								<input type="text" name="search" class="search" value="${ search }" placeholder="Search">
								<button type="submit" class="btn mt-30">
									<i class="fa fa-search"></i>
								</button>
	                        </div>
                        </form>
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


</body>

</html>