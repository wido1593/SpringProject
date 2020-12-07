package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;//annotation
import javax.servlet.annotation.WebServlet;//annotation
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.MemberDAO;
import dao.ProductDAO;
import dto.MemberDTO;


/**
 * Servlet implementation class MemberController
 */
//mapping된 이름들
@WebServlet({ "/MemberController", "/member-logout.do", "/member-delete.do", "/member-update.do","/member-info.do", 
	"/member-register.do", "/member-login.do", "/member-list.do", "/member-list-name.do", "/member-list-birth.do" })

@MultipartConfig(location="",
fileSizeThreshold=1024*1024,
maxFileSize=1024*1024*5,
maxRequestSize=1024*1024*5*5)

public class MemberController extends HttpServlet {
	//변하지 않는 상수를 정적으로 지정.
	private static final long serialVersionUID = 1L;	
	//Connection : 특정 데이터베이스와의 연결 (세션). SQL이 실행되고 결과는 연결 컨텍스트에서 리턴
	Connection conn = null;
	//Statement : 정적 SQL 문을 실행하고 생성 된 결과를 리턴하는 데 사용되는 오브젝트.
	Statement stmt = null;
	//PreparedStatement : 미리 컴파일 된 SQL 문을 나타내는 객체
	PreparedStatement pstmt = null;
	//ResultSet : 데이터베이스 결과 집합을 나타내는 데이터 테이블. 대개 데이터베이스를 쿼리하는 문을 실행하여 생성
	ResultSet rs = null;
	MemberDTO member = null;
	ArrayList<MemberDTO> alMember = null;
	//session객체에 null값, 사용준비
	HttpSession session = null;
	MemberDAO dao = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//post방식으로 sevlet으로 넘어 왔다면 이부분이 실행될것이다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    //HttpServletRequest : 요청 파라미터 조회, HttpSession 객체 조회, request scope 상의 component간의 데이터 공유 지원
    //HttpServletResponse : 응답할 Client에 대한 정보와 동작을 가지고 있는 객체
    //응답 Header정보 설정 (Content Type 설정) , Redirect 방식으로 수행 넘기기
    //SQL, Servlet, IO에 대해 오류처리를 해준다.
    protected void process(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
    	//한글이 깨지지 않도록 UTF-8로 '받아'옴
    	request.setCharacterEncoding("UTF-8");		
    	session = request.getSession();//session을 받아 seeeion 객체 생성
    	dao = new MemberDAO();
		conn = dao.getConnection();			
		//URI를 가져와서 마지막 /의 뒤값을 action으로 가져온다.
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf('/');
		String action = uri.substring(lastIndex + 1);
		
		if(action.equals("member-list.do")) 
			list(request, response);
		
		else if(action.equals("member-list-name.do"))
			listName(request, response);
		
		else if(action.equals("member-list-birth.do"))
			listBirth(request, response);
		
		else if(action.equals("member-login.do"))
			login(request, response);
		
		else if(action.equals("member-register.do"))
			register(request, response);
		
		else if(action.equals("member-update.do"))
			update(request, response);
		
		else if(action.equals("member-info.do"))
			info(request,response);
		
		else if(action.equals("member-delete.do"))
			delete(request,response);
		
		else if(action.equals("member-logout.do"))
			logout(request,response);
		
		else
			;
    }      
    //리스트
    private void list (HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
    	//DB에서 멤버값을 읽어와 ArrayList에 지정하여 지정된 ArrayList를 리턴한다.
    	alMember = dao.list(request, response);
    	//memberList로 이름을 지정하여 값을 넣어준다.
		request.setAttribute("memberList", alMember);
		//지정하 값들을 forward하여 customer-order.jsp로 보낸다.
		request.getRequestDispatcher("customer-orders1.jsp").forward(request, response);
    }
    
    //리스트
    private void listName (HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
    	//DB에서 멤버값을 읽어와 ArrayList에 지정하여 지정된 ArrayList를 리턴한다.
    	alMember = dao.listName(request, response);
    	//memberList로 이름을 지정하여 값을 넣어준다.
		request.setAttribute("memberList", alMember);
		//지정하 값들을 forward하여 customer-order.jsp로 보낸다.
		request.getRequestDispatcher("customer-orders1.jsp").forward(request, response);
    }
    
    //리스트
    private void listBirth (HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
    	//DB에서 멤버값을 읽어와 ArrayList에 지정하여 지정된 ArrayList를 리턴한다.
    	alMember = dao.listBirth(request, response);
    	//memberList로 이름을 지정하여 값을 넣어준다.
		request.setAttribute("memberList", alMember);
		//지정하 값들을 forward하여 customer-order.jsp로 보낸다.
		request.getRequestDispatcher("customer-orders1.jsp").forward(request, response);
    }
    
  //로그인
  	private void login(HttpServletRequest request, HttpServletResponse response) 
      		throws SQLException, ServletException, IOException {
      	
      	member = dao.login(request, response);
  		//쿼리문을 실행하여 해당하는 쿼리문에서 값을 리턴하여 member를 성공적으로 리턴하였다면.
  		if(member != null) { 
  			//세션의 이름은 email이고 값은 MemberDTO에서 이메일을가져오는 메소드를 사용하여 세션을 지정
  			session.setAttribute("email", member.getEmail());
  			//넘겨주는 info-name의 값을 MemberDTO에서 이름을가져오는 메소드를 사용하여 지정
  			session.setAttribute("phoneNumber", member.getPhone());
  			//login-success.jsp로 요청을 경로에 전달하거나 응답에 리소스를 포함 할 수 있다
  			//Servlet의 요청을 서버의 다른 자원 (servlet, JSP 파일 또는 HTML 파일)으로 전달합니다.
  			//이 메소드는 하나의 서블릿이 요청의 사전 처리를 수행하고 응답을 생성하는 다른 자원을 허용합니다.
  			request.getRequestDispatcher("login-success.jsp").forward(request, response);
  		}
  		else
  			response.sendRedirect("login-fail.jsp");
      }
  	private String partName = null;
	private String partValue = null;
	
  	//등록
	private void register(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
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
    	int result = dao.register(request, response);
    	
    	if(result >= 1) {
    		request.setAttribute("info-name", request.getParameter("name"));
    		request.getRequestDispatcher("register-success.jsp").forward(request, response);
    	}
    	else
    		response.sendRedirect("register-fail.jsp"); 
    }
    
	
	private String getFileName(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] splitedContentDisposition = contentDispositionHeader.split(";");
		
		for (String cd : splitedContentDisposition ) {
			if (cd.trim().startsWith("filename")) {//파일네임으로 시작하니
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				}//파싱방법:=을 찾고 그다음 "를 날림.
			}
			return null;
		}
	
	
	
	
	//수정
	private void update(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
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
    	int result = dao.update(request,response);
    	
    	if(result >= 1) {
    		request.setAttribute("info-name", request.getParameter("email"));
    		request.getRequestDispatcher("update-success.jsp").forward(request, response);
    	}
    	else
    		response.sendRedirect("update-fail.jsp"); 
    }
	
	//자세히
	private void info(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
    	
		member = dao.info(session);
		
		if(member != null) { 
			request.setAttribute("name", member.getName());
			request.setAttribute("email", member.getEmail()); 
			request.setAttribute("phone", member.getPhone());
			request.setAttribute("image", member.getImage());		
			request.setAttribute("birthday", member.getBirthday());
			//request.setAttribute("member",member);
			request.getRequestDispatcher("customer-account.jsp").forward(request, response);
		}
		else
			response.sendRedirect("info-fail.jsp");
		
	}
    
	//삭제
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
    	
		int result = dao.delete(request, response);
    	
    	if(result >= 1) {
    		request.setAttribute("email", request.getParameter("email"));
    		request.getRequestDispatcher("delete-success.jsp").forward(request, response);
    	}
    	else
    		response.sendRedirect("delete-fail.jsp");
		
	}
	
	//로그아웃
    protected void logout(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, ServletException, IOException {
		//세션객체 종료시키기
    	session.invalidate();
    //	session.removeAttribute("email");
    	/*session = request.getSession();
    	if(session.getAttribute("email") == null) {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
    	else*/
    		response.sendRedirect("index.jsp");
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ArrayList<MemberDTO> alMember = new ArrayList<MemberDTO>();]
		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		MemberDTO member = null;
		request.setCharacterEncoding("UTF-8");		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jb000", "cometrue");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from jb000_member " + 
					"where email='" + request.getParameter("email")+ "'" + 
					" and pw='" + request.getParameter("pw") + "'"); 
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setEmail(rs.getString(1));
				member.setPw(rs.getString(2));
				member.setName(rs.getString(3));
				member.setPhone(rs.getString(4));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(member != null) {
			request.setAttribute("info-name", member.getName());
			request.getRequestDispatcher("login-success.jsp").forward(request, response);
		}
		else
			response.sendRedirect("login-fail.jsp");
			*/
	}

	

}
