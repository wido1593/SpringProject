package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dto.ProductDTO;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;//

public class ProductDAO extends DAOBase {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
    private ResultSet rs = null;
	private ProductDTO dto = null;	
	
	public int register(HttpServletRequest request, HttpServletResponse response) 
	{
		int result = 0;
		//��吏������� 媛�吏�湲곗����
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dto = new ProductDTO();
		dto.setName(request.getParameter("name"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setCno(request.getParameter("cno"));
		dto.setImage((String)request.getAttribute("image"));
		try {
			dto.setRegdate(formatter.parse(request.getParameter("regdate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	//dto.setImage((String)request.getParameter("image"));
	
	String sql = "insert into product_csb (pno, name, price, cno, regdate, image) " +
				"values(p_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getCno());
			pstmt.setDate(4, new java.sql.Date(dto.getRegdate().getTime()));//�깅���媛���吏�.
			pstmt.setString(5, dto.getImage());
	
			result = pstmt.executeUpdate(); 
			return result;
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ъ�⑺�� ������ 臾댁“嫄�(finally) �����댁���. 
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		
		return result;
	}
    //����
	public int update(ProductDTO p)
	{
		//try臾몄�� ����濡� �대（�� 吏�吏������ㅻ㈃ 0
		int result = 0;
		try {
			conn = getConnection();
			String sql = "update product_csb set name=?, price=?, cno=?, image=?" +
					"where pno=?";			
			pstmt = conn.prepareStatement(sql);
			//?�� ������濡� 媛�吏���
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getCno());
			pstmt.setString(4, p.getImage());
			pstmt.setInt(5,  p.getPno());			
			result = pstmt.executeUpdate(); 
			return result;// return pstmt.executeUpdate(); �� 媛���			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ъ�⑺�� ������ 臾댁“嫄�(finally) �����댁���. 
		finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}		
		return result;//������ 寃곌낵瑜� ���ㅼ���.
	}
	
	//���몃낫湲�
	public ProductDTO getDetail(int pno) {
	
    	try {
			conn = getConnection();
			stmt = conn.createStatement(); // 占쏙옙占쏙옙 占쏙옙체占싸븝옙占쏙옙 statement 占쏙옙체 占쏙옙占쏙옙	
			rs = stmt.executeQuery("select * from product_csb where pno="+pno); 
		// email, pw占쏙옙 form占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙 占쏙옙占쏙옙占� 占싱몌옙
    	
			while(rs.next()) {
			dto = new ProductDTO();
			dto.setPno(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setPrice(rs.getInt(3));
			dto.setCno(rs.getString(4));
			dto.setImage(rs.getString(8));
			
			}
			return dto;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return dto;
		
	}
	
	
		//����	
		public int delete(HttpServletRequest request, HttpServletResponse response) {
				int result = 0;
				try {
						conn = getConnection();
						pstmt = conn.prepareStatement("delete from product_csb where pno=?");
						pstmt.setString(1, request.getParameter("pno"));
					
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
	
	
    public ArrayList<ProductDTO> selectListBetween(int start, int end, String sequence, String name){
    	ArrayList<ProductDTO> dtoList = null;//new ArrayList<ProductDTO>()
    		
    	try {
    	conn = getConnection();
    	stmt = conn.createStatement(); 
    	//遺��ъ�ㅺ� �띠�� 媛��� product_csb���� 遺��ъ�� a濡� 吏�����怨�, start~ end�� 媛�留� 媛��몄�⑤��.
    	//String query = "select * from (select rownum as rnum, pno, name, price, cno, image from product_csb order by pno ASC) " + 
    			//"a where a.rnum between " + start + " and " + end ; //end踰���瑜� ��泥대��댁��  
    	    
    	String query = "select b.pno, b.name, b.price, b.cno, b.image, b.regdate " +
				"from " +
				"(select rownum as rnum, a.pno, a.name, a.price, a.cno, a.image, a.regdate " +
				"from " +
					"(select pno, name, price, cno, image, regdate " +
					"from product_csb " +
					"order by "+ name + " " + sequence + ") a where rownum <= " + end + " ) b " +
					"where b.rnum >= " + start;
    	rs = stmt.executeQuery(query);
    	
    	//ProductDTO dto = null;
    	dtoList = new ArrayList<ProductDTO>();
		while(rs.next()) {
			dto = new ProductDTO();
			dto.setPno(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setPrice(rs.getInt(3));
			dto.setCno(rs.getString(4));
			dto.setImage(rs.getString(5));
			dto.setRegdate(rs.getDate(6));
			
			dtoList.add(dto);			
		}
		return dtoList;
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	//��������
    	finally {
			this.closeDBResources(rs, stmt, pstmt, conn);			
		}
		return dtoList;
    }
    
    //��泥� �� 媛���瑜� 援ы����.
	public int selectCount() {
		int totalRows= 0;
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				//媛���瑜� �몄�댁�⑤��.
				rs = stmt.executeQuery("select count(*) from product_csb"); 
				if(rs.next())
					totalRows = rs.getInt(1);
				return totalRows;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally {
				this.closeDBResources(rs, stmt, pstmt, conn);			
			}
			return totalRows;
	}
	
	
}
 