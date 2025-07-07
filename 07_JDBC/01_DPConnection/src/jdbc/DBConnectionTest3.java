package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	
	public static void main(String[] args) {
			
		// 1. 드라이버 로딩
		// 2. 데이터베이스 연결
		// 3. PreparedStatement - 쿼리 : UPDATE (user_no를 선택해서 email 수정) 
		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER, ServerInfo.PASSWORD);
			
			PreparedStatement ps = connect.prepareStatement("UPDATE user_info SET EMAIL = ? WHERE USER_NO = ?");
			ps.setString(1, "orange@gmail.com");
			ps.setInt(2, 3);
			System.out.println(ps.executeUpdate() + "명 수정!");
			
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
