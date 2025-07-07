package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest2 {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL  = "jdbc:mysql://localhost:3306/erp";
	public static final String USER  = "root";
	public static final String PASSWORD = "qwer1234";
	public static void main(String[] args)
	
	{
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		// 1. 드라이버 로딩
		try {
			Class.forName(DRIVER);
			//데이터베이스 연결 : 스키마 - erp
			connect = DriverManager.getConnection(URL,USER, PASSWORD);
			
			//3. PreparedStatement 객체 생성 - INSERT - user_info 테이블
			ps = connect.prepareStatement("INSERT INTO user_info(ID,PASSWORD,NAME)VALUES(?,?,?);");
			ps.setString(1, "user12");
			ps.setString(2, "2222");
			ps.setString(3, "오리");
			
			System.out.println(ps.executeUpdate() + "명 추가!");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		//4. 쿼리문 실행 - ps.executeUpdate()
	}
}
