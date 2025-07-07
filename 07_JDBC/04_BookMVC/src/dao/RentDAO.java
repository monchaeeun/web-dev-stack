package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;
import vo.Member;
import vo.Rent;

public class RentDAO {

	public static RentDAO instance = new RentDAO();

	public RentDAO getinstance() {
		return instance;
	}

	public RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RentDAO getInstance() {
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

	/**
	 * @throws SQLException
	 *****************************************************************************************************************************/
	// 해당 인물이 책을 5권이상 대여하고 있는지
	public boolean isOver(String id) throws SQLException {
		Connection connect = getConnect();
		String query = "SELECT * FROM rent WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		int i = 0;
		if (rs.next()) {
			++i;
		}
		if (i > 5) {
			System.out.println("5권 이상 대여는 불가능 합니다.");
			return true;
		} else {
			close(rs, ps, connect);
			System.out.println("대여 책 5권 이하!");
			return false;
		}
	}

	// 해당 인물이 해당 책을 가지고 있는지
	public boolean isHave(String id, int bookNo) throws SQLException {
		Connection connect = getConnect();
		String query = "SELECT * FROM rent WHERE book_No = ? AND id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ps.setString(2, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println("이미 대여중인 책입니다.");
			return true;
		}
		close(ps, connect);
		System.out.println("대여하고 있지 않음!");
		return false;
	}

	// 연령 제한
	public boolean isAge(String id, int bookNo) throws SQLException {
		Connection connect = getConnect();
		
		int age = 0;
		int accessAge = 0;
		
		String query = "SELECT * FROM member WHERE id = ? ";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet re = ps.executeQuery();
		
		System.out.println("멤버 나이 얻음");
		
		String query2 = "SELECT * FROM book WHERE book_No = ? ";
		PreparedStatement ps2 = connect.prepareStatement(query2);
		ps2.setInt(1, bookNo);
		ResultSet re2 = ps2.executeQuery();
		
		System.out.println("연령제한 나이 얻음");
			
			if(re.next())
			{
				System.out.println("re if문 들어옴");
				age = re.getInt("age");
				System.out.println("내 나이 : "+ age);
			}
			if(re2.next())
			{
				System.out.println("re2 if문 들어옴");
				accessAge = re2.getInt("access_age");
				System.out.println("연령 제한 : "+ accessAge);
				
			}
			if (age >= accessAge) {
				System.out.println("내 나이 : "+ age);
				System.out.println("연령 제한 : "+ accessAge);
				System.out.println("연령제한 안걸림!");
				close(ps, connect);
				return false;
			} else {
				System.out.println("내 나이 : "+ age);
				System.out.println("연령 제한 : "+ accessAge);
				System.out.println("연령제한!");
				
				close(ps, connect);
				return true;
			}
		}
		
		
	

	// 7. 책 대여
	public void rentBook(String id, int bookNo) throws SQLException {
		// 한 사람당 대여할 수 있는 책은 총 5권(id , select 로 인물 찾고 리스트로 size 만들기)

		// 중복 책 대여 불가능(rent에 만약 책 번호가 이미 있다면 불가능)

		// 나이 제한 걸리는 책도 불가능(나이가 book의 연령제한보다 낮으면 불가)

		Connection connect = getConnect();
		String query = "INSERT INTO rent(id, book_No) VALUES(?,?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		ps.executeUpdate();
		close(ps, connect);

	}

	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) throws SQLException {
		Connection connect = getConnect();

		String query = "SELECT * FROM rent JOIN member USING(id) JOIN book USING(book_No) WHERE id = ? ";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		ArrayList<Rent> rentList = new ArrayList<Rent>();

		while (rs.next()) {

			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPwd(rs.getString("pwd"));
			member.setAge(rs.getInt("age"));

			Book book = new Book();
			book.setBookNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setAccessAge(rs.getInt("access_age"));

			Rent rent = new Rent();
			rent.setRentNo(rs.getInt("rent_No"));
			rent.setBookNo(rs.getInt("book_no"));
			rent.setId(rs.getString("id"));
			rent.setRentDate(rs.getDate("rent_date").toLocalDate());

			rent.setBook(book);
			rent.setMember(member);

			rentList.add(rent);
		}

		return rentList;
	}

	// 9. 대여 취소 void 변경
	public void deleteRent(int bookNo) throws SQLException {
		Connection connect = getConnect();

		String query = "DELETE FROM rent WHERE book_No = ?";
		//책 번호
		//
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ps.executeUpdate();
	}
}
