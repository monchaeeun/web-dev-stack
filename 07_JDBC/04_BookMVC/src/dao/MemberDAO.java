package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Client;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
public static MemberDAO instance = new MemberDAO();
	
	public MemberDAO getinstance()
	{
		return instance;
	}
	
	public MemberDAO()
	{
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance()
	{
		return instance;
	}

	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 오버로딩!
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}
	/************************************************************************/
	
	
	
	public boolean checkMember(Member member) throws SQLException
	{
		Connection connect = getConnect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		if(!rs.next())
		{
			return false;
		}
		while(rs.next())
		{
			if(rs.getString("id").equals(member.getId()))
			{
				//회원이 이미 존재하는 경우
				return true;
			}
		}
		//회원이 존재하지 않는 경우
		return false;
	}
	
	
	// 4. 회원가입
	public void register(Member member) throws SQLException
	{
		Connection connect = getConnect();
		String query = "INSERT INTO member(id, name, pwd,age) VALUES(?,?,?,?)";
		PreparedStatement ps = getConnect().prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		
		ps.executeUpdate();
		
		close(ps, connect);
	}
	
	// 5. 로그인
	public Member login(String id,String pwd) throws SQLException
	{
		Connection connect = getConnect();
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		PreparedStatement ps = getConnect().prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		
		//회원이 이미 존재하는 경우 로그인 성공
		if(rs.next())
		{
			Member member = new Member(rs.getString("id"),rs.getString("name"),rs.getString("pwd"), rs.getInt("age"));
			return member;
			
		}
		//회원이 존재하지 않는 경우
		close(rs, ps, connect);
		return null;
	}
	
	// 6. 회원 탈퇴(삭제)
	public void delete(String id) throws SQLException
	{
		Connection connect = getConnect();
		String query = "DELETE FROM member WHERE id = ?";
		PreparedStatement ps = getConnect().prepareStatement(query);
		ps.setString(1, id);
		ps.executeUpdate();
		
		//회원이 존재하지 않는 경우
		close(ps, connect);
	}
}
