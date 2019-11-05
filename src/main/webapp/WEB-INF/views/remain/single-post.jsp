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
    <title>Bueno</title>

    <!-- Favicon -->
    <link rel="icon" href="../img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../css/style.css">

</head>

<body>
    <!-- ##### Header Area Start ##### -->
    	<jsp:include page="../include/header.jsp" />
    <!-- ##### Header Area End ##### -->


    <!-- ##### Treading Post Area Start ##### -->
    	<jsp:include page="../include/ranking.jsp" />
    <!-- ##### Treading Post Area End ##### -->


    <!-- ##### Search Area Start ##### -->
    <div class="bueno-search-area section-padding-100-0 pb-70 bg-img" style="background-image: url(../img/core-img/pattern.png);">
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
                        <div class="blog-thumbnail mb-50">
                            <img src="../img/bg-img/24.jpg" alt="">
                        </div>
                        <div class="blog-content">
                            <a href="#" class="post-tag">Healthy Food</a>
                            <h4 class="post-title">Friend eggs with ham</h4>
                            <div class="post-meta mb-50">
                                <a href="#" class="post-date">July 11, 2018</a>
                                <a href="#" class="post-author">By Julia Stiles</a>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc tristique justo id elit bibendum pharetra non vitae lectus. Mauris libero felis, dapibus a ultrices sed, commodo vitae odio. Sed auctor tellus quis arcu tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ac tincidunt nunc. Cras sed mollis erat. Quisque risus lorem, mattis nec nisl a, efficitur faucibus ligula. Nulla facilisi. Integer sodales, metus nec finibus lobortis, ex justo pharetra quam, vel vehicula urna turpis ut risus. Sed dignissim erat sapien, non malesuada justo cursus nec. Nunc porta pulvinar varius.</p>

                            <p>Suspendisse nisl leo, gravida quis tortor at, ornare commodo neque. Donec tortor turpis, pharetra et pulvinar vitae, ullamcorper et mi. Sed eu magna aliquam, suscipit massa sit amet, mattis augue. Nam ut tortor ut ligula molestie feugiat vitae et nulla. Sed porta erat vitae leo pellentesque malesuada. In sollicitudin, massa euismod aliquet volutpat, enim metus varius dui, vestibulum efficitur ante velit non nisi. Cras varius bibendum sapien, id tincidunt velit placerat id. Nunc vitae facilisis nunc. Suspendisse ut felis sagittis mauris faucibus tincidunt vitae id tortor. Nullam tincidunt finibus turpis, a accumsan mauris laoreet cursus. Phasellus pharetra odio sapien, id suscipit nisi lobortis ut.</p>

                            <p>Duis posuere odio vitae neque egestas luctus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer risus neque, sollicitudin pharetra pulvinar a, imperdiet porttitor nunc. Aenean pretium, libero eu pulvinar commodo, lorem enim bibendum est, vel suscipit est mi non tortor. Vestibulum sit amet pretium tortor. Donec posuere, dui quis dictum hendrerit, odio mauris aliquam lacus, eu egestas libero risus vel nisi. Proin condimentum varius lectus sed dapibus. Etiam nec iaculis est.</p>
                        </div>
                    </div>

                    <!-- Comment Area Start -->
                    <div class="comment_area clearfix mb-100">
                        <h4 class="mb-50">Comments</h4>

                        <ol>
                            <!-- Single Comment Area -->
                            <li class="single_comment_area">
                                <!-- Comment Content -->
                                <div class="comment-content d-flex">
                                    <!-- Comment Author -->
                                    <div class="comment-author">
                                        <img src="../img/bg-img/32.jpg" alt="author">
                                    </div>
                                    <!-- Comment Meta -->
                                    <div class="comment-meta">
                                        <div class="d-flex">
                                            <a href="#" class="post-author">Jane Smith</a>
                                            <a href="#" class="post-date">July 11, 2018</a>
                                            <a href="#" class="reply">Reply</a>
                                        </div>
                                        <p>Consectetur adipiscing elit. Praesent vel tortor facilisis, volutpat nulla placerat, tinci dunt mi. Nullam vel orci dui. Su spendisse sit amet laoreet neque. Fusce sagittis sus cipit sem a consequat.</p>
                                    </div>
                                </div>

                                <ol class="children">
                                    <li class="single_comment_area">
                                        <!-- Comment Content -->
                                        <div class="comment-content d-flex">
                                            <!-- Comment Author -->
                                            <div class="comment-author">
                                                <img src="../img/bg-img/33.jpg" alt="author">
                                            </div>
                                            <!-- Comment Meta -->
                                            <div class="comment-meta">
                                                <div class="d-flex">
                                                    <a href="#" class="post-author">Christian Williams</a>
                                                    <a href="#" class="post-date">April 15, 2018</a>
                                                    <a href="#" class="reply">Reply</a>
                                                </div>
                                                <p>Consectetur adipiscing elit. Praesent vel tortor facilisis, Nullam vel orci dui. Su spendisse sit amet laoreet neque.</p>
                                            </div>
                                        </div>
                                    </li>
                                </ol>
                            </li>

                            <!-- Single Comment Area -->
                            <li class="single_comment_area">
                                <!-- Comment Content -->
                                <div class="comment-content d-flex">
                                    <!-- Comment Author -->
                                    <div class="comment-author">
                                        <img src="../img/bg-img/32.jpg" alt="author">
                                    </div>
                                    <!-- Comment Meta -->
                                    <div class="comment-meta">
                                        <div class="d-flex">
                                            <a href="#" class="post-author">Cris Williams</a>
                                            <a href="#" class="post-date">July 11, 2018</a>
                                            <a href="#" class="reply">Reply</a>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vel tortor facilisis, volutpat nulla placerat, tincidunt mi. Nullam vel orci dui. Su spendisse sit amet laoreet neque. Fusce sagittis suscipit.</p>
                                    </div>
                                </div>
                            </li>
                        </ol>
                    </div>

                    <div class="post-a-comment-area mb-30 clearfix">
                        <h4 class="mb-50">Leave a reply</h4>

                        <!-- Reply Form -->
                        <div class="contact-form-area">
                            <form action="#" method="post">
                                <div class="row">
                                    <div class="col-12 col-lg-6">
                                        <input type="text" class="form-control" id="name" placeholder="Name*">
                                    </div>
                                    <div class="col-12 col-lg-6">
                                        <input type="email" class="form-control" id="email" placeholder="Email*">
                                    </div>
                                    <div class="col-12">
                                        <input type="text" class="form-control" id="subject" placeholder="Website">
                                    </div>
                                    <div class="col-12">
                                        <textarea name="message" class="form-control" id="message" cols="30" rows="10" placeholder="Message"></textarea>
                                    </div>
                                    <div class="col-12">
                                        <button class="btn bueno-btn mt-30" type="submit">Submit Comment</button>
                                    </div>
                                </div>
                            </form>
                        </div>
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
		<jsp:include page="../include/common_script.jsp" />
</body>

</html>