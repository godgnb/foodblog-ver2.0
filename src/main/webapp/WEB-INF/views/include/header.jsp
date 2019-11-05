<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="header-area">

<!-- Head Photo Area -->
<div class="top-header-area bg-img bg-overlay"
	style="background-image: url(${pageContext.request.contextPath}/resources/img/bg-img/header.jpg);">
	<div class="container h-100">
		<div class="row h-100 align-items-center justify-content-between">
			<div class="col-12 col-sm-6">

				<div class="top-social-info">
					<a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest">
						<i class="fa fa-pinterest" aria-hidden="true"></i>
					</a>
					<a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook">
						<i class="fa fa-facebook" aria-hidden="true"></i>
					</a>
					<a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter">
						<i class="fa fa-twitter" aria-hidden="true"></i>
					</a>
					<a href="#" data-toggle="tooltip" data-placement="bottom" title="Dribbble">
						<i class="fa fa-dribbble" aria-hidden="true"></i>
					</a>
					<a href="#" data-toggle="tooltip" data-placement="bottom" title="Behance">
						<i class="fa fa-behance" aria-hidden="true"></i>
					</a>
					<a href="#" data-toggle="tooltip" data-placement="bottom" title="Linkedin">
						<i class="fa fa-linkedin" aria-hidden="true"></i>
					</a>
				</div>
			</div>
			<div class="col-12 col-sm-6 col-lg-5 col-xl-4">

				<div class="top-search-area">
					<form action="#" method="post">
						<input type="search" name="top-search" id="topSearch"
							placeholder="Search">
						<button type="submit" class="btn">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>




	<!-- Logo Area -->
<div class="logo-area">
    <a href="main.do"><img src="${pageContext.request.contextPath}/resources/img/core-img/mongmong6.png" alt=""></a>
</div>

<!-- Navbar Area -->
<div class="bueno-main-menu" id="sticker">
    <div class="classy-nav-container breakpoint-off">
        <div class="container">
            <!-- Menu -->
            <nav class="classy-navbar justify-content-between" id="buenoNav">

                <!-- Toggler -->
                <div id="toggler"><img src="${pageContext.request.contextPath}/resources/img/core-img/toggler.png" alt=""></div>

                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>

                <!-- Menu -->
                <div class="classy-menu">

                    <!-- Close Button -->
                    <div class="classycloseIcon">
                        <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                    </div>

                    <!-- Nav Start -->
                    <div class="classynav">
                        <ul>
                            <li><a href="main.do">Home</a></li>
                            <li><a href="#">Recipes</a>
                                <ul class="dropdown">
                                    <li><a href="../remain/catagory.jsp">10분 간단 Recipes</a></li>
                                    <li><a href="../remain/catagory-post.jsp">자취생 Recipes</a></li>
                                    <li><a href="../remain/single-post.jsp">편의점 Recipes</a></li>
                                    <li><a href="../remain/receipe.jsp">한끼 든든 Recipes</a></li>
                                    <li><a href="#">전문가 Recipes</a></li>
                                </ul>
                            </li>
<!--                             <li><a href="#">Recipes</a> -->
<!--                                 <div class="megamenu"> -->
<!--                                     <ul class="single-mega cn-col-4"> -->
<!--                                         <li><a href="#">- Recipe</a></li> -->
<!--                                         <li><a href="#">- Bread</a></li> -->
<!--                                         <li><a href="#">- Breakfast</a></li> -->
<!--                                         <li><a href="#">- Meat</a></li> -->
<!--                                         <li><a href="#">- Fastfood</a></li> -->
<!--                                         <li><a href="#">- Salad</a></li> -->
<!--                                         <li><a href="#">- Soup</a></li> -->
<!--                                     </ul> -->
<!--                                 </div> -->
<!--                             </li> -->
                            <li><a href="tipboardForm.do">Cooking Tip</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>

                        <!-- Login/Register -->
                        
                        <div class="login-area">
                       	    <c:if test="${empty id}">
                            	<a href="loginForm.do">Login / Register</a>
                            </c:if>
                            <c:if test="${not empty id}">
                            	<a href="myAccountForm.do">${id}님</a><span style="padding: 0 5px 0 5px;">|</span> 
                            	<a href="logout.do"> Logout</a>
                            	<c:if test="${id eq 'admin'}">
                            		<span style="padding: 0 5px 0 5px;">|</span>
                            		<a href="adminForm.do">관리자</a>
                            	</c:if>
                            </c:if>
                        </div>
                    </div>
                    <!-- Nav End -->
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>