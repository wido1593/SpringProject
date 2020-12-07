<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>      
	  <%@ include file="top-nav.jsp" %>      
      <div id="content">
        <div class="container">
          <div id="error-page" class="col-md-8 mx-auto text-center">
            <div class="box">
              <p class="text-center"><a href="index.html"><img src="img/logo.png" alt="Obaju template"></a></p>
              <h3>Login Success</h3>
              <%@ page import="b201512060.*" %>
              <%
              	String name = (String) request.getAttribute("info-name");//expression. el로쓰면 import,null처리 생각안해도 됨. member을 써야한다면 import
              %>
              <h4 class="text-muted">Welcome! <%= name %>! God bless you</h4>
              <p class="buttons"><a href="member-info.do" class="btn btn-template-outlined"><i class="fa fa-home"></i> 회원 상세정보 조회</a></p>
            </div>
          </div>
        </div>
      </div>
     <%@ include file="getit-footer.jsp" %> 
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