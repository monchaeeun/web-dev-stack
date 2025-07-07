package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.ServerInfo;
import vo.Person;

public class PersonController {

	Scanner sc = new Scanner(System.in);
	// 리턴 타입이나 파라미터 자유롭게 변경 가능
	// 메서드 추가 가능

	public PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
	// 고정적으로 반복 -- 디비 연결
	// 2. 디비 연결
	public Connection getConnect() throws SQLException 
	{
		 DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	public void close(PreparedStatement ps, Connection connect) throws SQLException
	{
		ps.close();
		connect.close();
		
	}
	public void close(PreparedStatement ps, Connection connect, ResultSet rs) throws SQLException
	{
		rs.close();
		ps.close();
		connect.close();
		
	}
	
	// person 테이블에 데이터 추가 = INSERT
	public void addPerson(String name, int age, String address) throws SQLException {
		//이름, 나이, 주소가 모두 같은 경우 "이미 정보가 있습니다." -> 가입 x 
		//for 문으로 select 해서 
		
			String query = "INSERT INTO person(name, age, addr) VALUES(?,?,?)";
			PreparedStatement ps = getConnect().prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, address);

			ps.executeUpdate();
			System.out.println("추가되었습니다!");
		
			//close(ps, connect);
		}

	

	// person 테이블에 있는 데이터 전체 보여주기 = SELECT
	public List<Person> searchAllPerson() throws SQLException {
		
			String query = "SELECT * FROM  person";
			PreparedStatement ps = getConnect().prepareStatement(query);
			ResultSet re = ps.executeQuery();
			
			List<Person> personList = new ArrayList<Person>();
			while(re.next())
			{
				Person person = new Person(re.getInt("id"), re.getString("name"), re.getInt("age"),re.getString("addr"));
				personList.add(person);
			}
			return personList;
		} 
	
	//동일인물이 있는지 체크
	public boolean checkPerson(String name, int age, String address) throws SQLException
	{
		String query = "SELECT name, age addr FROM  person WHERE name = ? AND age = ? AND addr = ?";
		PreparedStatement ps = getConnect().prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, address);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) // <- 존재하면 true, 존재하지 않으면 false
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public void searchPerson(int user_no) throws SQLException {
		
		
			String query = "SELECT * FROM  person";
			PreparedStatement ps = getConnect().prepareStatement(query);
			ResultSet re = ps.executeQuery();
			
			if(re.next())
			{
				if(re.getInt("id") == user_no )
				{
					String name = re.getString("name");
					int age = re.getInt("age");
					String addr = re.getString("addr");
					System.out.println("id - "+ re.getInt("id") + "| "+  name + " | " + age+"살" + " | "+ addr);
				}
				else
				{
					System.out.println("불러오기에 실패하였습니다.");
				}
			}
		}

	
	public boolean checkPerson(int id) throws SQLException 
	{
		
			
			String query = "SELECT * FROM  person";
			PreparedStatement ps = getConnect().prepareStatement(query);
			ResultSet re = ps.executeQuery();	
			if(re.next())
			{
				if(re.getInt("id") == id )
				{
					return true;
				}
				
			}
		
		return false;
	}
	

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(int id, String name, int age, String address) throws SQLException {
		
			String query = "SELECT * FROM  person";
			PreparedStatement ps = getConnect().prepareStatement(query);
			ResultSet re = ps.executeQuery();
			
			if(re.next())
			{
				String query1 = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
				PreparedStatement ps2 = getConnect().prepareStatement(query1);
				ps2.setString(1, name);
				ps2.setInt(2, age);
				ps2.setString(3, address);
				ps2.setInt(4, id);
				ps2.executeUpdate();
				
				System.out.println("수정되었습니다.");
			}
			else
			{
				System.out.println("수정에 실패했습니다.");
			}
		 

	}

	// person 테이블에 데이터 삭제
	public void removePerson(int id) throws SQLException 
	{
		
	
			String query = "SELECT * FROM  person";
			PreparedStatement ps = getConnect().prepareStatement(query);
			ResultSet re = ps.executeQuery();
			
			if(re.next())
			{
				if(re.getInt("id") == id )
				{
					String query1 = "DELETE FROM person WHERE id = ?";
					PreparedStatement ps2 = getConnect().prepareStatement(query1);
					ps2.setInt(1, id);
					ps2.executeUpdate();
				}
				else
				{
					System.out.println("해당하는 인물이 없습니다.");
				}
			}
		} 
	
}
