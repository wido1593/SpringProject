package controller;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;//annotation
import javax.servlet.annotation.WebServlet;//annotation
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import b201512060.Pagination;
import dao.ProductDAO;
import dto.ProductDTO;

/** 
 * Servlet implementation class ProductController
 */
@WebServlet({"/ProductController", "/product-register.do", "/product-detail.do", "/product-list.do", "/product-update.do",
	"/product-info.do", "/product-delete.do", "/product-list-edit.do", "/product-list-delete.do",
	"/product-list-name.do", "/product-list-date.do"})
//파일 업로드 설정. 순서대로 위치, 메모리에 올릴 수 있는 최대크기, 
//한 파일의 최대크기, 한번에 올릴 수 있는 최대크기 (두가지 모두 위반시  예외발생)
@MultipartConfig(location="",
fileSizeThreshold=1024*1024,
maxFileSize=1024*1024*5,
maxRequestSize=1024*1024*5*5)

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
    } 
    
    java.sql.Connection conn = null;
    java.sql.Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;	
	 
	ProductDTO dto = null;
	ArrayList<ProductDTO> dtoList = null;
	HttpSession session = null;
	
	 ProductDAO dao = null;
	 
	 protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		request.setCharacterEncoding("UTF-8");
		session = request.getSession();
		dao = new ProductDAO();
		conn = dao.getConnection();	
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf('/');
		String action = uri.substring(lastIndex + 1);
		
		if(action.equals("product-register.do"))
				register(request, response);
		else if(action.equals("product-list.do"))
			list(request, response);
		
		else if(action.equals("product-list-edit.do"))
			listEdit(request, response);
		else if(action.equals("product-list-delete.do"))
			listDelete(request, response);
		
		else if(action.equals("product-list-name.do"))
			listName(request, response);
		else if(action.equals("product-list-date.do"))
			listDate(request, response);
		
		
		else if(action.equals("product-detail.do"))
			detail(request, response);
		else if(action.equals("product-update.do"))
			update(request, response);
		else if(action.equals("product-info.do"))
			info(request, response);
		else if(action.equals("product-delete.do"))
			delete(request, response);
		
		else
			;
	}
	 
	private String partName = null;
	private String partValue = null;
	
	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException 
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//Collction은 중복값을 넣지 않는다?, Part형은  POST형으로 받은
		//multipart/form-data을 받기 위해 사용한다.
		Collection<Part> parts = request.getParts();
		
		for(Part part : parts)
		{
				partName = part.getName();
				//file형을 제외한 type은 null을 리턴한다.
				if(part.getContentType() != null)
				{
					//파일의 이름저장.
					partValue = getFileName(part);
					//값들이 유요하다면.
					if (partValue != null && ! partValue.isEmpty()) 
					{
						//워크스페이스\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\프로젝트이름\files
						//경로에 저장된다. 뒤에있는 /files이 .getRealPath("/files")로 지정한곳이다.
						String absolutePath = getServletContext().getRealPath("/files");
						// ...wtpwebapps\프로젝트이름\files + / + 파일이름으로 파일을 생성한다.
							part.write(absolutePath + File.separator + partValue);
							//dto.setImage(partValue);					
					}
				}				
				else 
				{
					//이름만 저장
					partValue = request.getParameter(partName);
				}				
				 request.setAttribute(partName, partValue);
		}
			//등록을 마치면 1이상의 값을 리턴해준다.
			int result = dao.register(request, response);
			
			//등록이 완료되면 확인화면으로 보낸다.
	    	if(result >= 1)
	    	{
	    		//request.setAttribute("info-name", request.getParameter("name"));
	    		request.getRequestDispatcher("resultView.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		response.sendRedirect("product-register-fail.jsp");
	    	}
	    	
			//request.getRequestDispatcher("resultView.jsp").forward(request, response);
	}
	
	//수정
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException 
	{		
		//Collction은 중복값을 넣지 않는다?, Part형은  POST형으로 받은
		//multipart/form-data을 받기 위해 사용한다.
		Collection<Part> parts = request.getParts();
		//키값으로 구분짓기 위해
		//int pno = Integer.parseInt(request.getParameter("pno"));
		for(Part part : parts)
		{
				partName = part.getName();
				//file형을 제외한 type은 null을 리턴한다.
				if(part.getContentType() != null)
				{
					//파일의 이름저장.
					partValue = getFileName(part);
					//값들이 유요하다면.
					if (partValue != null && ! partValue.isEmpty()) 
					{
						//워크스페이스\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\프로젝트이름\files
						//경로에 저장된다. 뒤에있는 /files이 .getRealPath("/files")로 지정한곳이다.
						String absolutePath = getServletContext().getRealPath("/files");
						// ...\프로젝트이름\files + / + 파일이름으로 파일을 생성한다.
							part.write(absolutePath + File.separator + partValue);
							//dto.setImage(partValue);					
					}
				}				
				else 
				{
					//이름만 저장
					partValue = request.getParameter(partName);
				}				
				 request.setAttribute(partName, partValue);
		}
		
			dto = new ProductDTO();
			dto.setPno(Integer.parseInt(request.getParameter("pno")));
			dto.setName(request.getParameter("name"));
			dto.setPrice(Integer.parseInt(request.getParameter("price")));
			dto.setCno(request.getParameter("cno"));
			dto.setImage((String)request.getAttribute("image"));
		
			//등록을 마치면 1이상의 값을 리턴해준다.
			int result = dao.update(dto);			
			//등록이 완료되면 확인화면으로 보낸다.
	    	if(result >= 1)
	    	{
	    		//request.setAttribute("info-name", request.getParameter("name"));
	    		request.getRequestDispatcher("resultView.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		response.sendRedirect("product-register-fail.jsp");
	    	}
	    	
			//request.getRequestDispatcher("resultView.jsp").forward(request, response);
	}
	
	private int selectCount() throws SQLException{
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select count(*) from jb060_product"); 
		int totalRows = 0;
		if(rs.next())
			totalRows = rs.getInt(1);
		return totalRows;
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int totalRows=0; 
		int rowsPerPage=3;//한페이지당 보여줄 행
		int paginationPerPage = 2;//한 페이지에 보여줄 페이지 갯수
		
		int pageNum=1;//초기값 1로
		//null만 아니면 페이지의 값을 구해 pageNum으로 넘겨준다.
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		//전체 행갯수리턴 받는다.
		totalRows = dao.selectCount();
		//페이지처리 생성
		Pagination pagination = new Pagination();
		//전체 행갯수, 지정한 페이지 번호, 한페이지당 보여줄 행, 한페이지에 보여줄 페이지 갯수 
		pagination.processPaging(totalRows, pageNum, rowsPerPage, paginationPerPage);
		
		//int curPage=request.getParameter("curPage");
		
		String sequence = "ASC";
		
		if(request.getParameter("sequence") != null)
			{
			sequence = (String) request.getParameter("sequence");
			}
		
		String name = "pno";
		
		if(request.getParameter("name") != null)    	
    		{
			name = (String) request.getParameter("name");
    		}
		
		
		dtoList = dao.selectListBetween(pagination.getStartRow(), pagination.getEndRow(), sequence, name);
		request.setAttribute("pagination",pagination);
		request.setAttribute("productList", dtoList);
		
		request.setAttribute("sequence", sequence);
		request.setAttribute("name", name);
		System.out.println(request.getParameter(sequence));
		
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
  
	}
	
	protected void listName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int totalRows=0; 
		int rowsPerPage=3;//한페이지당 보여줄 행
		int paginationPerPage = 2;//한 페이지에 보여줄 페이지 갯수
		
		int pageNum=1;//초기값 1로
		//null만 아니면 페이지의 값을 구해 pageNum으로 넘겨준다.
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		//전체 행갯수리턴 받는다.
		totalRows = dao.selectCount();
		//페이지처리 생성
		Pagination pagination = new Pagination();
		//전체 행갯수, 지정한 페이지 번호, 한페이지당 보여줄 행, 한페이지에 보여줄 페이지 갯수 
		pagination.processPaging(totalRows, pageNum, rowsPerPage, paginationPerPage);
		
		//int curPage=request.getParameter("curPage");
		
		String sequence = "DESC";
		
		if(request.getParameter("sequence") != null)
			{
			sequence = (String) request.getParameter("sequence");
			}
		
		String name = "name";
		
		if(request.getParameter("name") != null)    	
    		{
			name = (String) request.getParameter("name");
    		}
		
		
		dtoList = dao.selectListBetween(pagination.getStartRow(), pagination.getEndRow(), sequence, name);
		request.setAttribute("pagination",pagination);
		request.setAttribute("productList", dtoList);
		
		request.setAttribute("sequence", sequence);
		request.setAttribute("name", name);
		System.out.println(request.getParameter(sequence));
		
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
  
	}
	
	protected void listDate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		int totalRows=0; 
		int rowsPerPage=3;//한페이지당 보여줄 행
		int paginationPerPage = 2;//한 페이지에 보여줄 페이지 갯수
		
		int pageNum=1;//초기값 1로
		//null만 아니면 페이지의 값을 구해 pageNum으로 넘겨준다.
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		//전체 행갯수리턴 받는다.
		totalRows = dao.selectCount();
		//페이지처리 생성
		Pagination pagination = new Pagination();
		//전체 행갯수, 지정한 페이지 번호, 한페이지당 보여줄 행, 한페이지에 보여줄 페이지 갯수 
		pagination.processPaging(totalRows, pageNum, rowsPerPage, paginationPerPage);
		
		//int curPage=request.getParameter("curPage");
		
		String sequence = "DESC";
		
		if(request.getParameter("sequence") != null)
			{
			sequence = (String) request.getParameter("sequence");
			}
		
		String name = "regdate";
		
		if(request.getParameter("name") != null)    	
    		{
			name = (String) request.getParameter("name");
    		}
		
		
		dtoList = dao.selectListBetween(pagination.getStartRow(), pagination.getEndRow(), sequence, name);
		request.setAttribute("pagination",pagination);
		request.setAttribute("productList", dtoList);
		
		request.setAttribute("sequence", sequence);
		request.setAttribute("name", name);
		System.out.println(request.getParameter(sequence));
		
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
  
	}
	
	protected void listEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int totalRows=0; 
		int rowsPerPage=3;//한페이지당 보여줄 행
		int paginationPerPage = 2;//한 페이지에 보여줄 페이지 갯수
		
		int pageNum=1;//초기값 1로
		//null만 아니면 페이지의 값을 구해 pageNum으로 넘겨준다.
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		//전체 행갯수리턴 받는다.
		totalRows = dao.selectCount();
		//페이지처리 생성
		Pagination pagination = new Pagination();
		//전체 행갯수, 지정한 페이지 번호, 한페이지당 보여줄 행, 한페이지에 보여줄 페이지 갯수 
		pagination.processPaging(totalRows, pageNum, rowsPerPage, paginationPerPage);
		
		//int curPage=request.getParameter("curPage");
		
		String sequence = "ASC";
		
		if(request.getParameter("sequence") != null)
			{
			sequence = (String) request.getParameter("sequence");
			}
		
		String name = "pno";
		
		if(request.getParameter("name") != null)    	
    		{
			name = (String) request.getParameter("name");
    		}
		
		
		dtoList = dao.selectListBetween(pagination.getStartRow(), pagination.getEndRow(), sequence, name);
		request.setAttribute("pagination",pagination);
		request.setAttribute("productList", dtoList);
		
		request.setAttribute("sequence", sequence);
		request.setAttribute("name", name);
		System.out.println(request.getParameter(sequence));
		
		request.getRequestDispatcher("product-list-edit.jsp").forward(request, response);
  
	}
	
	protected void listDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int totalRows=0; 
		int rowsPerPage=3;//한페이지당 보여줄 행
		int paginationPerPage = 2;//한 페이지에 보여줄 페이지 갯수
		
		int pageNum=1;//초기값 1로
		//null만 아니면 페이지의 값을 구해 pageNum으로 넘겨준다.
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		//전체 행갯수리턴 받는다.
		totalRows = dao.selectCount();
		//페이지처리 생성
		Pagination pagination = new Pagination();
		//전체 행갯수, 지정한 페이지 번호, 한페이지당 보여줄 행, 한페이지에 보여줄 페이지 갯수 
		pagination.processPaging(totalRows, pageNum, rowsPerPage, paginationPerPage);
		
		//int curPage=request.getParameter("curPage");
		
		String sequence = "ASC";
		
		if(request.getParameter("sequence") != null)
			{
			sequence = (String) request.getParameter("sequence");
			}
		
		String name = "pno";
		
		if(request.getParameter("name") != null)    	
    		{
			name = (String) request.getParameter("name");
    		}
		
		
		dtoList = dao.selectListBetween(pagination.getStartRow(), pagination.getEndRow(), sequence, name);
		request.setAttribute("pagination",pagination);
		request.setAttribute("productList", dtoList);
		
		request.setAttribute("sequence", sequence);
		request.setAttribute("name", name);
		System.out.println(request.getParameter(sequence));
		
		request.getRequestDispatcher("product-list-delete.jsp").forward(request, response);
  
	}

	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		dto = dao.getDetail(pno);	
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("product-detail.jsp").forward(request, response);
  
		
	}
	
    protected void info(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException, SQLException {
    	//int pno = Integer.parseInt(request.getParameter("pno"));
    	int pno = Integer.parseInt(request.getParameter("pno"));
    	dto = dao.getDetail(pno);
    	if(dto != null) {
			request.setAttribute("product", dto);
			request.getRequestDispatcher("product-update.jsp").forward(request, response);
    	} else
    		response.sendRedirect("fail.jsp");
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
    	
		int result = dao.delete(request, response);
    	
    	if(result >= 1) {
    		request.setAttribute("pno", request.getParameter("pno"));
    		request.getRequestDispatcher("delete-success.jsp").forward(request, response);
    	}
    	else
    		response.sendRedirect("delete-fail.jsp");
		
	}
    
	
	//파일이름 구하기
	private String getFileName(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] splitedContentDisposition = contentDispositionHeader.split(";");
		
		for (String cd : splitedContentDisposition ) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				}
			}
			return null;
		}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   
		try {
			process(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
