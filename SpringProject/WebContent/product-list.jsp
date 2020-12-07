<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="header.jsp" %>	
 <script>
  				 function change_sequence(sequence, name){
  					 
  					 if(sequence=="ASC")
  						 {
  						 sequence = "DESC";
  						 }
  					else if (sequence == "DESC")
  						{
  						sequence = "ASC";
  						}
  					 
  					 location.href="product-list.do?sequence="+sequence+"&name="+name;
  				 }
  				 
  				function sequence_name(sequence, name){
 					 
 					 if(name=="pno")//"":쿼리
 						 {
 						 name = "name";
 						 }
 					else if (name == "name")
  						{
 						name = "pno";
  						}
 					 
 					location.href="product-list.do?sequence="+sequence+"&name="+name;
 				 }
  		</script>
 <%@ include file="top-nav.jsp" %>	
		
		<% 
         String sequence = "ASC";
         if(request.getParameter("sequence") != null)
            sequence = request.getParameter("sequence");
         
         String name = "pno";
         if(request.getParameter("name") != null)
            name = request.getParameter("name");
      %>
      
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">상품목록</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">상품목록</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      
       
				
      <div id="content" class="bg-gray">
      
        <div class="container" >
	          <section class="bar">
	          
	            <div class="row">
	              <div class="col-md-12">
	                <div class="heading">
	                  <h2>상품들</h2>
	                  	<div class="text-right">
  				
			  				<button class="btn btn-template-outlined" style="border-color: black;" onClick="sequence_name('<%=sequence%>','<%=name%>')">
			  				<i class="fa fa-font"></i> 기준 </button>
			  				
			  				&ensp;
			  				<button class="btn btn-template-outlined" style="border-color: black;" onClick="change_sequence('<%=sequence%>','<%=name%>')">
			  				<i class="fa fa-retweet"></i> 정렬순서 </button>
		  				
		  				
		  				</div>
	                </div>
	              </div>
	            </div>
	            
	            <div class="row portfolio text-center">	            
	   				 <!-- 지정한 라이브러리의 메소드를 사용하시 위해서 태그라이브러리를 c로 지정하였다.    -->	            
	            	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>            
	            
				<!-- ${pagination.beginPage } : ${pagination.endPage } -->
				<!-- 반복문 넘겨받은 parmeter인 productList의 값만큼 반복한다.-->
					<c:forEach var="dto" items="${productList}">
						<div class="col-md-4">
						  <div class="box-image">
						    <div class="image">
						    <img src="files/${dto.image }" alt="" class="img-fluid">
								
								<div class="overlay d-flex align-items-center justify-content-center">
								  <div class="content">
								  
								    <div class="name">
								      <h3><a href="product-detail.do" class="color-white">${dto.name }</a></h3>
									</div>
								
									<div class="text">
									  <p class="d-none d-sm-block">${dto.price } - ${dto.cno } - ${dto.regdate }</p>
									<p class="buttons">
									 <a href="product-detail.do?pno=${dto.pno}" class="btn btn-template-outlined-white">상세보기</a>									
									</p>
							        </div>
								          
					        	</div>
						      </div>
						      
						    </div>
						  </div>
						</div>
					</c:forEach>
					
	            </div>
	          </section>
        
        
        
        	
        	<div class="col-md-12" align="center">
        	
		        <nav aria-label="Page navigation example">
	                 <ul class="pagination">
	                 <c:if test="${pagination.beginPage > pagination.paginationCount }">
	                   <li class="page-item"><a href="product-list.do?pageNum=${pagination.endPage - 1 }" class="page-link">«</a></li>
	                   </c:if>
	                   <c:forEach var="pnum" begin="${pagination.beginPage }" end="${pagination.endPage }">
	                   <c:if test="${pnum == pagination.curPage }">
	                   <li class="page-item active">
	                   </li>
	                   </c:if>
	                   <a href="product-list.do?sequence=<%=sequence %>&name=<%=name %>&pageNum=${pnum }" class="page-link">${pnum }</a>
	                   </c:forEach>
	                   <c:if test="${pagination.endPage < pagination.totalPages }">
	         				<li class="page-item"><a href="product-list.do?sequence=<%=sequence%>&name=<%=name%>&pageNum=${pagination.endPage + 1 }"" class="page-link">>></a></li>
	         				</c:if>
	                 </ul>
		         </nav>
		         
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
