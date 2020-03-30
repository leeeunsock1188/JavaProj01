package project_ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBControll {
	// 자원들 선언
	Connection con; // 연결 
	PreparedStatement pstmt; //준비된 진술
	ResultSet rs;// 결과 
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@localhost:1521:orcl";
			String userid = "hr";
			String userpw = "1234";
			con = DriverManager.getConnection(url,userid,userpw);
		}catch(Exception e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	// insert 문 
//	public void insert(String name, String phone, String birth) {
//		connect();
//		try {
//			String query = "INSERT INTO phonebook_tb ("
//					+ "idx, phone_name, phone_number, birth) "
//					+ "VALUES ("
//					+ "phone_seq.nextVal, ?, ?, ? "
//					+ ")";
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, name);
//			pstmt.setString(2, phone);
//			pstmt.setString(3, birth);
//			pstmt.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		close();
//	}
	
	// insert 문 
		public void insert(PhoneInfo phone) {
			connect();
			try {
				String query = "INSERT INTO phonebook_tb ("
						+ "idx, phone_name, phone_number, birth) "
						+ "VALUES ("
						+ "phone_seq.nextVal, ?, ?, ? "
						+ ")";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, phone.name);
				pstmt.setString(2, phone.phoneNumber);
				pstmt.setString(3, phone.address);
				pstmt.executeUpdate(); //db안에 넣은 위에값을 저장함.
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			close();
		}
	
	// select 문 
	public void selectAll() {
		connect();
		// statement select문
		
		close();
	}
	
}
