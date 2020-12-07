<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
    <%@ include file="top-nav.jsp" %>
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">My Account</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">My Account</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      
      <div id="content">
        <div class="container">
          <div class="row bar">
            <div id="customer-account" class="col-lg-9 clearfix">
              <p class="lead">회원정보 수정</p>
              
              <div class="box mt-5">
                <div class="heading">
                  <h3 class="text-uppercase">회원상세정보</h3>
                </div>
                
                <form action="member-update.do" method="post" enctype="multipart/form-data">
                
                  <div class="row">
                  
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="name">이름</label>
                        <input id="firstname" name="name" value="<%= (String) request.getAttribute("name") %>" 
                        type="text" class="form-control">
                      </div>
                    </div>
                    
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="lastname">이메일</label>
                        <input id="lastname" name="email" value="${email}" type="text" class="form-control" readonly>
                      </div>
                    </div>

                  </div>
                  
                  <div class="row">
                  
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="name">비밀번호</label>
                        <input id="firstname" name="pw" value="" type="password" class="form-control">
                      </div>
                    </div>             
                 
                    
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="phone">전화번호</label>
                        <input id="phone" name="phone"
                        value="${phone}" type="text" class="form-control">
                      </div>
                    </div>
                    
                        <div class="form-group">
		                    <label for="email-login">사진</label>
		                    <input id="email-login" name="image" type="file" value="${image}" class="form-control">
		                    <img src="files/${image}" height="100px"/>
		                  </div>       
                    
                    <div class="form-group">
		                    <label for="name-login">등록일</label>
		                    <input id="name-login" name="regdate" type="date" value="${birthday}" class="form-control">
		                  </div>
                    
                  </div>
                  
                  <!-- 
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label for="company">Company</label>
                        <input id="company" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  
                  <div class="row">
                    <div class="col-md-6 col-lg-3">
                      <div class="form-group">
                        <label for="city">Company</label>
                        <input id="city" type="text" class="form-control">
                      </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                      <div class="form-group">
                        <label for="zip">ZIP</label>
                        <input id="zip" type="text" class="form-control">
                      </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                      <div class="form-group">
                        <label for="state">State</label>
                        <select id="state" class="form-control"></select>
                      </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                      <div class="form-group">
                        <label for="country">Country</label>
                        <select id="country" class="form-control"></select>
                      </div>
                    </div>
                    
                      <div class="col-md-6">
                      <div class="form-group">
                        <label for="email_account">Email</label>
                        <input id="email_account" type="text" class="form-control">
                      </div>
                    </div>
                    
                    -->      
                 
                  
		                    

                    <div class="col-md-12 text-center">
                      <button type="submit" class="btn btn-template-outlined"><i class="fa fa-save"></i> 회원정보수정</button>

                      <button type="reset" class="btn btn-template-outlined"><i class="fa fa-trash-o"></i>수정취소</button>
                    </div>
                    
                  </div>
                </form>
              </div>
            </div>
            <!-- 
            <div class="col-lg-3 mt-4 mt-lg-0">
               CUSTOMER MENU
              <div class="panel panel-default sidebar-menu">
                <div class="panel-heading">
                  <h3 class="h4 panel-title">Customer section</h3>
                </div>
                <div class="panel-body">
                  <ul class="nav nav-pills flex-column text-sm">
                    <li class="nav-item"><a href="customer-orders.html" class="nav-link active"><i class="fa fa-list"></i> My orders</a></li>
                    <li class="nav-item"><a href="customer-wishlist.html" class="nav-link"><i class="fa fa-heart"></i> My wishlist</a></li>
                    <li class="nav-item"><a href="customer-account.html" class="nav-link"><i class="fa fa-user"></i> My account</a></li>
                    <li class="nav-item"><a href="index.html" class="nav-link"><i class="fa fa-sign-out"></i> Logout</a></li>
                  </ul>
                </div>
              </div>
            </div>
            -->
          </div>
        </div>
      </div>
     	  <jsp:include page="getit-footer.jsp"></jsp:include>
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