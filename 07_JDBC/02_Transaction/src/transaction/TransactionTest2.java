package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class TransactionTest2 {
	/*
	 * 지은 -> 지연 : 3만원씩 이체
	 * 지은님의 잔액이 마이너스가 될 경우 이체 취소!
	 * UPDATE 2개, SELECT 1개
	 * 
	 * */
	
	public static void main(String[] args) {
		
		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
			String query1 = "UPDATE bank SET balance = balance - ? WHERE name = ?";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			int balance = 30000;
			String send = "지은";
			String to = "지연";
			ps1.setInt(1, balance);
			ps1.setString(2, send);
			
			String query2 = "UPDATE bank SET balance = balance + ? WHERE name = ?";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			ps2.setInt(1, balance);
			ps2.setString(2, to);
			
			
			String query3 = "SELECT balance FROM bank WHERE name = ?";
			PreparedStatement ps3 = connect.prepareStatement(query3);
			ps3.setString(1, send);
			
			connect.setAutoCommit(false);
			
			ps1.executeUpdate();
			ps2.executeUpdate();
			
			ResultSet rs = ps3.executeQuery();
			if(rs.next())
			{
				if(rs.getInt("balance") < 0)
				{
					connect.rollback();
					System.out.println("잔액이 없으므로 취소!");
				}
				else
				{
					System.out.println(rs.getInt("balance") + "원 남았습니다.");					
					connect.commit();
				}
			}
			
			connect.setAutoCommit(true);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
