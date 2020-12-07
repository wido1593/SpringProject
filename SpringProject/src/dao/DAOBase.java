package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.servlet.jsp.jstl.sql.Result;

public abstract class DAOBase implements DAO {

	//DAO�씤�꽣�럹�씠�뒪�뿉�꽌 �젙�쓽�븳 硫붿냼�뱶瑜� �긽�꽭�솕�떆�궓�떎.
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		//�겢�옒�뒪 濡쒕뱶
		try {
			//�옄諛� Class 硫붿냼�뱶以� forName�쓣 �궗�슜�븳�떎. ""�븞�뿉 �겢�옒�뒪瑜� 濡쒕뱶�븯�뿬 JDBC瑜� �옄�룞�쑝濡� �벑濡앺빐以��떎.
			Class.forName("oracle.jdbc.OracleDriver");//�뼱�뵪�뒗嫄곗�
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DB�쓽 �뿰寃� URL, ID, PSSWD濡� �젒�냽�쓣 �떆�룄.
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "csb060", "cometrue");
			return conn;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}	
		
		//�옄�썝�쉶�닔
		public void closeDBResources(ResultSet rs, Statement stmt, 
				PreparedStatement pstmt, Connection conn) 
		{
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
	
	
	

}
