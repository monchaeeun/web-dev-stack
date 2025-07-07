package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		// 1. 드라이버 로딩
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			
			Class.forName(p.getProperty("driver"));
			
			Connection connect = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"), p.getProperty("password"));
			PreparedStatement ps = connect.prepareStatement("DELETE FROM user_info WHERE USER_NO = ?");
			ps.setInt(1, 9);
			System.out.println(ps.executeUpdate()+ "명 삭제!");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		// 2. 디비 연결
		//3. PreparedStatement - DELETE (user_no)
	}

}
