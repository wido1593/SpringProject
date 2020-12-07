package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

//DAOBase�쓽 湲곕뒫�쓣 �솗�옣�븳�떎.
public class MemberDAO extends DAOBase {
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
    private ResultSet rs = null;
	private MemberDTO member = null;//MemberDTO�삎�쑝濡� member�깮�꽦
	HttpSession session = null;
	private ArrayList<MemberDTO> alMember = null;
	
	//MemberController�뿉 login 硫붿냼�뱶瑜� 嫄곗퀜�꽌 �삤寃뚮맂�떎.
	public ArrayList<MemberDTO> list (HttpServletRequest request, HttpServletResponse response) {
				
		try {
			//DAOBase瑜� �솗�옣�븯�뿬 媛��졇���꽌 �궗�슜�븷 �닔 �엳�뒗 硫붿냼�뱶, �겢�옒�뒪瑜� 硫붾え由ъ뿉 �삱�젮以��떎.
			conn=getConnection();
			//硫붾え由ъ뿉 �긽二쇰맂 �겢�옒�뒪�쓽 湲곕뒫�쓣 遺덈윭�삩�떎. �뙆�씪誘명꽣媛� �뾾�씠 �떎�뻾臾몄쓣 �떎�뻾�븳�떎.
			stmt = conn.createStatement();
			//荑쇰━臾� �떎�뻾�븯�뿬 ResultSet�삎 rs�뿉 ���엯�떆耳쒖��떎.
			rs = stmt.executeQuery("select * from member_csb"); 
			//ArrayList瑜� �깮�꽦
			alMember = new ArrayList<MemberDTO>();
			//�떎�뻾�븳 荑쇰━臾몄쓽 媛믪씠 �엳�쓣�븣源뚯� 諛섎났.
		while(rs.next()) {
			member = new MemberDTO();
			//�씫�뼱�삩 媛믩뱾�쓣 硫붿냼�뱶瑜� �씠�슜�빐 媛믪쓣 吏��젙�빐以��떎.
			member.setEmail(rs.getString(1));//泥ル쾲吏몃�� Email濡�
			member.setPw(rs.getString(2));
			member.setName(rs.getString(3));
			member.setPhone(rs.getString(4));
			member.setImage(rs.getString(5));
			member.setBirthday(rs.getDate(6));
			alMember.add(member);//�깮�꽦�맂 ArrayList�뿉 �쐞�뿉�꽌 吏��젙�븳 媛믩뱾�쓣 �꽔�뼱以��떎.
			//�씠�썑 媛믪씠 吏��젙�맂 �븯�굹�쓽 ArrayList媛� 異붽��맂�떎.
		}	
		return alMember;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�옄�썝�쉶�닔
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return alMember;
		
		
	}	
	
	
	public ArrayList<MemberDTO> listName (HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//DAOBase瑜� �솗�옣�븯�뿬 媛��졇���꽌 �궗�슜�븷 �닔 �엳�뒗 硫붿냼�뱶, �겢�옒�뒪瑜� 硫붾え由ъ뿉 �삱�젮以��떎.
			conn=getConnection();
			//硫붾え由ъ뿉 �긽二쇰맂 �겢�옒�뒪�쓽 湲곕뒫�쓣 遺덈윭�삩�떎. �뙆�씪誘명꽣媛� �뾾�씠 �떎�뻾臾몄쓣 �떎�뻾�븳�떎.
			stmt = conn.createStatement();
			//荑쇰━臾� �떎�뻾�븯�뿬 ResultSet�삎 rs�뿉 ���엯�떆耳쒖��떎.
			rs = stmt.executeQuery("select * from member_csb order by name ASC"); 
			//ArrayList瑜� �깮�꽦
			alMember = new ArrayList<MemberDTO>();
			//�떎�뻾�븳 荑쇰━臾몄쓽 媛믪씠 �엳�쓣�븣源뚯� 諛섎났.
		while(rs.next()) {
			member = new MemberDTO();
			//�씫�뼱�삩 媛믩뱾�쓣 硫붿냼�뱶瑜� �씠�슜�빐 媛믪쓣 吏��젙�빐以��떎.
			member.setEmail(rs.getString(1));//泥ル쾲吏몃�� Email濡�
			member.setPw(rs.getString(2));
			member.setName(rs.getString(3));
			member.setPhone(rs.getString(4));
			member.setImage(rs.getString(5));
			member.setBirthday(rs.getDate(6));
			alMember.add(member);//�깮�꽦�맂 ArrayList�뿉 �쐞�뿉�꽌 吏��젙�븳 媛믩뱾�쓣 �꽔�뼱以��떎.
			//�씠�썑 媛믪씠 吏��젙�맂 �븯�굹�쓽 ArrayList媛� 異붽��맂�떎.
		}	
		return alMember;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�옄�썝�쉶�닔
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return alMember;
		
		
	}	
	
	
	public ArrayList<MemberDTO> listBirth (HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//DAOBase瑜� �솗�옣�븯�뿬 媛��졇���꽌 �궗�슜�븷 �닔 �엳�뒗 硫붿냼�뱶, �겢�옒�뒪瑜� 硫붾え由ъ뿉 �삱�젮以��떎.
			conn=getConnection();
			//硫붾え由ъ뿉 �긽二쇰맂 �겢�옒�뒪�쓽 湲곕뒫�쓣 遺덈윭�삩�떎. �뙆�씪誘명꽣媛� �뾾�씠 �떎�뻾臾몄쓣 �떎�뻾�븳�떎.
			stmt = conn.createStatement();
			//荑쇰━臾� �떎�뻾�븯�뿬 ResultSet�삎 rs�뿉 ���엯�떆耳쒖��떎.
			rs = stmt.executeQuery("select * from member_csb order by BIRTHDAY DESC"); 
			//ArrayList瑜� �깮�꽦
			alMember = new ArrayList<MemberDTO>();
			//�떎�뻾�븳 荑쇰━臾몄쓽 媛믪씠 �엳�쓣�븣源뚯� 諛섎났.
		while(rs.next()) {
			member = new MemberDTO();
			//�씫�뼱�삩 媛믩뱾�쓣 硫붿냼�뱶瑜� �씠�슜�빐 媛믪쓣 吏��젙�빐以��떎.
			member.setEmail(rs.getString(1));//泥ル쾲吏몃�� Email濡�
			member.setPw(rs.getString(2));
			member.setName(rs.getString(3));
			member.setPhone(rs.getString(4));
			member.setImage(rs.getString(5));
			member.setBirthday(rs.getDate(6));
			alMember.add(member);//�깮�꽦�맂 ArrayList�뿉 �쐞�뿉�꽌 吏��젙�븳 媛믩뱾�쓣 �꽔�뼱以��떎.
			//�씠�썑 媛믪씠 吏��젙�맂 �븯�굹�쓽 ArrayList媛� 異붽��맂�떎.
		}	
		return alMember;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�옄�썝�쉶�닔
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return alMember;
		
		
	}	
	
	//濡쒓렇�씤
	public MemberDTO login(HttpServletRequest request, HttpServletResponse response) {	
		
		try {
			//MemberDAO�쓽 硫붿냼�뱶瑜� �떎�뻾. DB�겢�옒�뒪 �샇異�
			conn=getConnection();
			stmt = conn.createStatement();	
			//select * from member_csb where email = '諛쏆븘�삩 �뙆�씪誘명꽣以� �씠由꾩씠 email�씤 �뙆�씪誘명꽣�쓽 媛�' 
			//and pw ='諛쏆븘�삩 �뙆�씪誘명꽣以� �씠由꾩씠 pw�씤 �뙆�씪誘명꽣�쓽 媛�'
			rs = stmt.executeQuery("select * from member_csb " + 
				"where email='" + request.getParameter("email")+ "'" + 
				" and pw='" + request.getParameter("pw") + "'"); 
			//�쐞�뿉 �빐�떦�븯�뒗 媛믪씠 �엳�떎硫�.
			if(rs.next()) {
			member = new MemberDTO();
			member.setEmail(rs.getString(1));
			member.setPw(rs.getString(2));
			member.setName(rs.getString(3));
			member.setPhone(rs.getString(4));
			member.setImage(rs.getString(5));
			member.setBirthday(rs.getDate(6));
			}
			
			return member;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return member;
		
	}
	
	
	public int register(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		member = new MemberDTO();
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPw(request.getParameter("pw"));
		member.setPhone(request.getParameter("phone"));		
		try {		
			member.setBirthday(formatter.parse(request.getParameter("regdate")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		member.setImage((String)request.getAttribute("image"));
	//dto.setImage((String)request.getParameter("image"));
	
	String sql = "insert into member_csb(name, email, pw, phone, image, birthday ) " +
				"values(?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getImage());
			pstmt.setDate(6, new java.sql.Date(member.getBirthday().getTime()));
			
	
			result = pstmt.executeUpdate(); // 질의를 통해 수정된 레코드의 수
			return result;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeDBResources(rs, stmt, pstmt, conn);
		}
		return result;
	}
	
	
	
	public int update(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		member = new MemberDTO();
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPw(request.getParameter("pw"));
		member.setPhone(request.getParameter("phone"));		
		try {		
			member.setBirthday(formatter.parse(request.getParameter("regdate")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		member.setImage((String)request.getAttribute("image"));
	//dto.setImage((String)request.getParameter("image"));
	
	String sql = "update member_csb set name=?, phone=?, pw=?, image=?, birthday=? where email=?";
		try {
			conn = getConnection();
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getPw());			
			pstmt.setString(4, member.getImage());
			pstmt.setDate(5, new java.sql.Date(member.getBirthday().getTime()));
			pstmt.setString(6, member.getEmail());
	
			result = pstmt.executeUpdate(); // 질의를 통해 수정된 레코드의 수
			return result;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeDBResources(rs, stmt, pstmt, conn);
		}
		return result;
	}

	
	
	public MemberDTO info (HttpSession session) {
				
		try {
			conn=getConnection();
			stmt = conn.createStatement();
		// 占쏙옙占쏙옙 占쏙옙체占싸븝옙占쏙옙 statement 占쏙옙체 占쏙옙占쏙옙	
    	rs = stmt.executeQuery("select * from member_csb " + 
				"where email='" + (String)session.getAttribute("email")+ "'"); //session.getAttribute占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙..
    	/*rs = stmt.executeQuery("select * from member_csb " + 
				"where email='" + (String) session.getParameter("email")+ "'");占쏙옙占� 占쏙옙占쌨듸옙 효占쏙옙占쏙옙 占쏙옙 */
		// email, pw占쏙옙 form占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙 占쏙옙占쏙옙占� 占싱몌옙
		if(rs.next()) {
			member = new MemberDTO();
			member.setEmail(rs.getString(1));
			//member.setPw(rs.getString(2));
			member.setName(rs.getString(3));
			member.setPhone(rs.getString(4));
			member.setImage(rs.getString(5));
			member.setBirthday(rs.getDate(6));
		}		return member; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return member; 
		
	}
	
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		try {
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from member_csb where email=?");
				pstmt.setString(1, request.getParameter("email"));
			
				result = pstmt.executeUpdate();
				return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
				return result;
	
	}

}
