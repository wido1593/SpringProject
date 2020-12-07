<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
      <!-- Top bar-->
      <div class="top-bar">
        <div class="container">
          <div class="row d-flex align-items-center">
      
            <div class="col-md-6 d-md-block d-none">
                 <%
		            String email = (String) session.getAttribute("email");                 
                 String phoneNumber = (String) session.getAttribute("phoneNumber");
		             	if (email != null) {
		             %>
              <p>Email:${email} Phone:${phoneNumber} </p>
              <%
		             	}
              %>
            </div>
            
            <div class="col-md-6">
              <div class="d-flex justify-content-md-end justify-content-between">
                <ul class="list-inline contact-info d-block d-md-none">
                  <li class="list-inline-item"><a href="#"><i class="fa fa-phone"></i></a></li>
                  <li class="list-inline-item"><a href="#"><i class="fa fa-envelope"></i></a></li>
                </ul>
                <div class="login">
                <!-- email로 지정된 session에 값이 있는지 확인한다. -->
		            <%
		        
		             	if (email == null) {
		             %>
		                
	                <a href="#" data-toggle="modal" data-target="#login-modal" class="login-btn"><i class="fa fa-sign-in"></i>
	                <span class="d-none d-md-inline-block">로그인</span></a>
	                <a href="customer-register.jsp" class="signup-btn"><i class="fa fa-user"></i>
	                <span class="d-none d-md-inline-block">가입</span></a>
             <%
             	} 
		             	else{
             %>
	                <a href="member-info.do" class="signup-btn"><i class="fa fa-user"></i>
	                <span class="d-none d-md-inline-block">정보</span></a>
	                <a href="member-logout.do" class="signup-btn"><i class="fa fa-user"></i>
	                <span class="d-none d-md-inline-block">로그아웃</span></a>
            <%
             	}
             %>
             	</div>
             
             <!-- 페이스북, 구글... 아이콘들 -->
                <ul class="social-custom list-inline">
                  <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                  <li class="list-inline-item"><a href="#"><i class="fa fa-google-plus"></i></a></li>
                  <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                  <li class="list-inline-item"><a href="#"><i class="fa fa-envelope"></i></a></li>
                </ul>
                
              </div>
            </div>
          </div>
        </div>
      </div>  
      <!-- Top bar end-->
      
      
      <!-- Login Modal-->
      <div id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-modalLabel" aria-hidden="true" class="modal fade">
        <div role="document" class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 id="login-modalLabel" class="modal-title">고객 로그인</h4>
              <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body">
            
            <!--  로그인시 member-login.do로  mapping되어있는 서블릿실행 -->
              <form action="member-login.do" method="post">
              
                <div class="form-group">
                  <input id="email_modal" type="text" placeholder="이메일" name="email" class="form-control">
                </div>
                <div class="form-group">
                  <input id="password_modal" type="password" placeholder="비밀번호" name="pw" class="form-control">
                </div>
                <p class="text-center">
                  <button class="btn btn-template-outlined"><i class="fa fa-sign-in"></i> 로그인</button>
                </p>
              </form>             
              <p class="text-center text-muted"><a href="customer-register.jsp"><strong>회원등록</strong></a></p>
            </div>
          </div>
        </div>
      </div>
      <!-- Login modal end-->
      
      
      
      <!-- Navbar Start-->
      <header class="nav-holder make-sticky">
        <div id="navbar" role="navigation" class="navbar navbar-expand-lg">
        
          <div class="container">
          <a href="index.jsp" class="navbar-brand home">
          		<!-- 로고 이미지 바꾸고싶을때 -->
	          <img src="img/kasina-logo.png" alt="Universal logo" class="d-none d-md-inline-block">
	          <img src="img/logo-small.png" alt="Universal logo" class="d-inline-block d-md-none">
	          
	          <span class="sr-only">Universal - go to homepage</span>
          </a>
            <button type="button" data-toggle="collapse" data-target="#navigation" class="navbar-toggler btn-template-outlined"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
            
            <div id="navigation" class="navbar-collapse collapse">
             
              <ul class="nav navbar-nav ml-auto">
              
              	<!-- 활성화 시킴 -->
                <li class="nav-item dropdown">                
                <a href="javascript: void(0)" data-toggle="dropdown" class="dropdown-toggle">회원관리 <b class="caret"></b></a>                
	                  <ul class="dropdown-menu">
	                    <li class="dropdown-item"><a href="customer-register.jsp" class="nav-link">회원등록</a></li>
	                    <li class="dropdown-item"><a href="member-info.do" class="nav-link">회원정보조회/수정</a></li>
	                    <li class="dropdown-item"><a href="index3.jsp" class="nav-link">회원정보 삭제</a></li>
	                    <%
					if (email != null && email.startsWith("admin060")) {
				%>
	                    
	                    <li class="dropdown-item"><a href="member-list.do" class="nav-link">회원목록보기(등록순)</a></li>
	                    <li class="dropdown-item"><a href="member-list-name.do" class="nav-link">회원목록보기(이름)</a></li>
	                    <li class="dropdown-item"><a href="member-list-birth.do" class="nav-link">회원목록보기(생일)</a></li>
	                    
	                    <%
					}
	                    %>
	                  </ul>
                </li>
                
                <li class="nav-item dropdown">                
                <a href="javascript: void(0)" data-toggle="dropdown" class="dropdown-toggle">상품관리 <b class="caret"></b></a>                
	                  <ul class="dropdown-menu">
	                    <li class="dropdown-item"><a href="product-list.do" class="nav-link">상품 목록</a></li>
	                           <%
					if (email != null && email.startsWith("admin060")) {
				%>
						<li class="dropdown-item"><a href="product-register.jsp" class="nav-link">상품 등록</a></li>
	                    <li class="dropdown-item"><a href="product-list-edit.do" class="nav-link">상품 수정</a></li>
	                    <li class="dropdown-item"><a href="product-list-delete.do" class="nav-link">상품 삭제</a></li>	                   
	                    <%
	                        }
	                        %>
	                    <li class="dropdown-item"><a href="product-list.do" class="nav-link">상품목록(등록순)</a></li>
	                    <li class="dropdown-item"><a href="product-list-name.do" class="nav-link">상품목록(이름 내림)</a></li>
	                    <li class="dropdown-item"><a href="product-list-date.do" class="nav-link">상품목록(날짜오름)</a></li>
	                  </ul>
                </li>
               
                
              
                <!-- ========== Contact dropdown ==================-->
               
                <!-- ========== Contact dropdown end ==================-->
              </ul>
            </div>
            <div id="search" class="collapse clearfix">
              <form role="search" class="navbar-form">
                <div class="input-group">
                  <input type="text" placeholder="Search" class="form-control"><span class="input-group-btn">
                    <button type="submit" class="btn btn-template-main"><i class="fa fa-search"></i></button></span>
                </div>
              </form>
            </div>
          </div>
        </div>
      </header>
      <!-- Navbar End--> 
