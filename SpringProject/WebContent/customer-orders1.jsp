<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="header.jsp" %>	 
      <%@ include file="top-nav.jsp" %>	  
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">About Us</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">About Us</li>
              </ul>
            </div>
          </div> 
        </div>
      </div>
      <div id="content">
        <section class="bar no-mb">
          <div class="container">
            <div class="col-md-12">
              <div class="heading">
                <h2>Meet Our Team</h2>
              </div>
              <div class="row text-center">
              
               <%@ page import="java.util.*,b201512060.*" %>
               <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>         

               <c:forEach var="member" items="${requestScope.memberList }">
                      <div class="col-md-4">
                  <div data-animate="fadeInUp" class="team-member">
                    <div class="image"><img src="files/${member.image }" alt="" class="img-fluid rounded-circle"></div>
                    <h3><a href="team-member.html">${member.name}</a></h3>
                    <p class="role">${member.email }</p>
                    <ul class="social list-inline">
                      <li class="list-inline-item"><a href="#" class="external facebook"><i class="fa fa-facebook"></i></a></li>
                      <li class="list-inline-item"><a href="#" class="external gplus"><i class="fa fa-google-plus"></i></a></li>
                      <li class="list-inline-item"><a href="#" class="external twitter"><i class="fa fa-twitter"></i></a></li>
                      <li class="list-inline-item"><a href="#" class="email"><i class="fa fa-envelope"></i></a></li>
                    </ul>
                    <div class="text">
                      <p>${member.phone }</p>
                      <p> ${member.birthday }</p>
                      <td> <span class="badge badge-info">${member.pw }</span></td>
                    </div>
                  </div>
                </div>
                      </c:forEach>
                      
                      
                      
                
              
                
              </div>
              <div class="see-more text-center"><a href="portfolio-4.html" class="btn btn-template-outlined">See all our team members</a></div>
            </div>
          </div>
        </section>
        <section class="bar bg-gray">
          <div class="container">
            <div class="heading text-center">
              <h2>Our Clients</h2>
            </div>
            <ul class="list-unstyled owl-carousel customers no-mb">
              <li class="item"><img src="img/customer-1.png" alt="" class="img-fluid"></li>
              <li class="item"><img src="img/customer-2.png" alt="" class="img-fluid"></li>
              <li class="item"><img src="img/customer-3.png" alt="" class="img-fluid"></li>
              <li class="item"><img src="img/customer-4.png" alt="" class="img-fluid"></li>
              <li class="item"><img src="img/customer-5.png" alt="" class="img-fluid"></li>
              <li class="item"><img src="img/customer-6.png" alt="" class="img-fluid"></li>
            </ul>
          </div>
        </section>
        <section class="bar background-pentagon mb-0">
          <div class="container">
            <div class="row">
              <div class="col-md-12">
                <div class="heading text-center">
                  <h2>Testimonials</h2>
                </div>
                <p class="lead">We have worked with many clients and we always like to hear they come out from the cooperation happy and satisfied. Have a look what our clients said about us.</p>
                <!-- Carousel Start-->
                <ul class="owl-carousel testimonials list-unstyled equal-height">
                  <li class="item">
                    <div class="testimonial d-flex flex-wrap">
                      <div class="text">
                        <p>One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections.</p>
                      </div>
                      <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                        <div class="icon"><i class="fa fa-quote-left"></i></div>
                        <div class="testimonial-info d-flex">
                          <div class="title">
                            <h5>John McIntyre</h5>
                            <p>CEO, TransTech</p>
                          </div>
                          <div class="avatar"><img alt="" src="img/person-1.jpg" class="img-fluid"></div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="item">
                    <div class="testimonial d-flex flex-wrap">
                      <div class="text">
                        <p>The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. "What's happened to me? " he thought. It wasn't a dream.</p>
                      </div>
                      <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                        <div class="icon"><i class="fa fa-quote-left"></i></div>
                        <div class="testimonial-info d-flex">
                          <div class="title">
                            <h5>John McIntyre</h5>
                            <p>CEO, TransTech</p>
                          </div>
                          <div class="avatar"><img alt="" src="img/person-2.jpg" class="img-fluid"></div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="item">
                    <div class="testimonial d-flex flex-wrap">
                      <div class="text">
                        <p>His room, a proper human room although a little too small, lay peacefully between its four familiar walls.</p>
                        <p>A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame.</p>
                      </div>
                      <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                        <div class="icon"><i class="fa fa-quote-left"></i></div>
                        <div class="testimonial-info d-flex">
                          <div class="title">
                            <h5>John McIntyre</h5>
                            <p>CEO, TransTech</p>
                          </div>
                          <div class="avatar"><img alt="" src="img/person-3.png" class="img-fluid"></div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="item">
                    <div class="testimonial d-flex flex-wrap">
                      <div class="text">
                        <p>It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. Gregor then turned to look out the window at the dull weather. Drops of rain could be heard hitting the pane, which made him feel quite sad.</p>
                      </div>
                      <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                        <div class="icon"><i class="fa fa-quote-left"></i></div>
                        <div class="testimonial-info d-flex">
                          <div class="title">
                            <h5>John McIntyre</h5>
                            <p>CEO, TransTech</p>
                          </div>
                          <div class="avatar"><img alt="" src="img/person-4.jpg" class="img-fluid"></div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="item">
                    <div class="testimonial d-flex flex-wrap">
                      <div class="text">
                        <p>It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. Gregor then turned to look out the window at the dull weather. Drops of rain could be heard hitting the pane, which made him feel quite sad. Gregor then turned to look out the window at the dull weather. Drops of rain could be heard hitting the pane, which made him feel quite sad.</p>
                      </div>
                      <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                        <div class="icon"><i class="fa fa-quote-left"></i></div>
                        <div class="testimonial-info d-flex">
                          <div class="title">
                            <h5>John McIntyre</h5>
                            <p>CEO, TransTech</p>
                          </div>
                          <div class="avatar"><img alt="" src="img/person-1.jpg" class="img-fluid"></div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
                <!-- Carousel End-->
              </div>
            </div>
          </div>
        </section>
      </div>
      <!-- GET IT-->
      <div class="get-it">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 text-center p-3">
              <h3>Do you want cool website like this one?</h3>
            </div>
            <div class="col-lg-4 text-center p-3">   <a href="#" class="btn btn-template-outlined-white">Buy this template now</a></div>
          </div>
        </div>
      </div>
      <!-- FOOTER -->
      <footer class="main-footer">
        <div class="container">
          <div class="row">
            <div class="col-lg-3">
              <h4 class="h6">About Us</h4>
              <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              <hr>
              <h4 class="h6">Join Our Monthly Newsletter</h4>
              <form>
                <div class="input-group">
                  <input type="text" class="form-control">
                  <div class="input-group-append">
                    <button type="button" class="btn btn-secondary"><i class="fa fa-send"></i></button>
                  </div>
                </div>
              </form>
              <hr class="d-block d-lg-none">
            </div>
            <div class="col-lg-3">
              <h4 class="h6">Blog</h4>
              <ul class="list-unstyled footer-blog-list">
                <li class="d-flex align-items-center">
                  <div class="image"><img src="img/detailsquare.jpg" alt="..." class="img-fluid"></div>
                  <div class="text">
                    <h5 class="mb-0"> <a href="post.html">Blog post name</a></h5>
                  </div>
                </li>
                <li class="d-flex align-items-center">
                  <div class="image"><img src="img/detailsquare.jpg" alt="..." class="img-fluid"></div>
                  <div class="text">
                    <h5 class="mb-0"> <a href="post.html">Blog post name</a></h5>
                  </div>
                </li>
                <li class="d-flex align-items-center">
                  <div class="image"><img src="img/detailsquare.jpg" alt="..." class="img-fluid"></div>
                  <div class="text">
                    <h5 class="mb-0"> <a href="post.html">Very very long blog post name</a></h5>
                  </div>
                </li>
              </ul>
              <hr class="d-block d-lg-none">
            </div>
            <div class="col-lg-3">
              <h4 class="h6">Contact</h4>
              <p class="text-uppercase"><strong>Universal Ltd.</strong><br>13/25 New Avenue <br>Newtown upon River <br>45Y 73J <br>England <br><strong>Great Britain</strong></p><a href="contact.html" class="btn btn-template-main">Go to contact page</a>
              <hr class="d-block d-lg-none">
            </div>
            <div class="col-lg-3">
              <ul class="list-inline photo-stream">
                <li class="list-inline-item"><a href="#"><img src="img/detailsquare.jpg" alt="..." class="img-fluid"></a></li>
                <li class="list-inline-item"><a href="#"><img src="img/detailsquare2.jpg" alt="..." class="img-fluid"></a></li>
                <li class="list-inline-item"><a href="#"><img src="img/detailsquare3.jpg" alt="..." class="img-fluid"></a></li>
                <li class="list-inline-item"><a href="#"><img src="img/detailsquare3.jpg" alt="..." class="img-fluid"></a></li>
                <li class="list-inline-item"><a href="#"><img src="img/detailsquare2.jpg" alt="..." class="img-fluid"></a></li>
                <li class="list-inline-item"><a href="#"><img src="img/detailsquare.jpg" alt="..." class="img-fluid"></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="copyrights">
          <div class="container">
            <div class="row">
              <div class="col-lg-4 text-center-md">
                <p>&copy; 2018. Your company / name goes here</p>
              </div>
              <div class="col-lg-8 text-right text-center-md">
                <p>Template design by <a href="https://bootstrapious.com/free-templates">Bootstrapious Templates </a></p>
                <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
              </div>
            </div>
          </div>
        </div>
      </footer>
    </div>
    <!-- Javascript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/waypoints/lib/jquery.waypoints.min.js"> </script>
    <script src="vendor/jquery.counterup/jquery.counterup.min.js"> </script>
    <script src="vendor/owl.carousel/owl.carousel.min.js"></script>
    <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
    <script src="js/jquery.parallax-1.1.3.js"></script>
    <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
    <script src="vendor/jquery.scrollto/jquery.scrollTo.min.js"></script>
    <script src="js/front.js"></script>
  </body>
</html>