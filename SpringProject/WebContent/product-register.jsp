<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<jsp:include page="header.jsp"></jsp:include>
	  <jsp:include page="top-nav.jsp"></jsp:include>	
	  
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">상품등록</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                <li class="breadcrumb-item active"></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      
      <div id="content">
        <div class="container">
          <div class="row">
            <div class="col-lg-6">
              <div class="box">
                <h2 class="text-uppercase">새로운 상품 등록</h2>
				<hr>
	                <form action="product-register.do" method="post" 
	                enctype="multipart/form-data" >
	                
		                  <div class="form-group">
		                    <label for="name-login">이름</label>
		                    <input id="name-login" name="name" type="text" class="form-control">
		                  </div>
		                  
		                  <div class="form-group">
		                    <label for="name-login">가격</label>
		                    <input id="name-login" name="price" type="text" class="form-control">
		                  </div>
		                  
		                  <div class="form-group">
		                    <label for="name-login">구분</label>
		                    <input id="name-login" name="cno" type="text" class="form-control">
		                  </div>
		                  
		                   <div class="form-group">
		                    <label for="name-login">등록일</label>
		                    <input id="name-login" name="regdate" type="date" class="form-control">
		                  </div>
                  
		                  <div class="form-group">
		                    <label for="email-login">사진</label>
		                    <input id="email-login" name="image" type="file" class="form-control">
		                  </div>
		                  
		                  <div class="text-center">
		                    <button type="submit" class="btn btn-template-outlined"><i class="fa fa-user-md"></i> 등록</button>
		                  </div>
	                  
	                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <jsp:include page="getit-footer.jsp"></jsp:include>
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