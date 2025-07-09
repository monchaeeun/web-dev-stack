package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/work","root","qwer1234");
	}
	
/***********************************************************************************/
	// 4. 회원가입
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		ps.executeUpdate();
	}
	
	// 5. 전체 추력
	public ArrayList<Member> printAll() throws SQLException
	{
		Connection connect = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Member> list = new ArrayList<>();
		while (rs.next()) {
			Member member = new Member(rs.getString("id"), rs.getString("name"),rs.getString("pwd"), rs.getInt("age"));
			list.add(member);
		}
		return list;
	}
	
	public Member search(String id) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if (rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
			System.out.println("memberDAO 멤버 리스트 상태 : " + member);
			return member;
		}
		return null;

	}
	//로그인
	public Member login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if (rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
			System.out.println("memberDAO 멤버 리스트 상태 : " + member);
			return member;
		}
		return null;

	}

}