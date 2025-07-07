package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Book;


public class BookDAO {
	

	public BookDAO()
	{
		try 
		{
			Class.forName(ServerInfo.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static BookDAO instance = new BookDAO();
	
	public BookDAO getinstance()
	{
		return instance;
	}
	
	public static BookDAO getInstance()
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
	
	/**
	 * @throws SQLException *****************************************************************************************************************************/
	
	//책등록 시 책이 이미 있는지 체크
	public boolean isBook(String title,String author,int accessAge) throws SQLException 
	{
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book WHERE title = ? AND author = ? AND access_age = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1,title);
		ps.setString(2,author);
		ps.setInt(3, accessAge);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
	}
	
	public boolean isBook(int bookNo) throws SQLException 
	{
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book WHERE book_No = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1,bookNo);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
	}
	
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException{
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Book> bookList = new ArrayList<Book>();

		while(rs.next()) {
			Book book = new Book();
			book.setBookNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setAccessAge(rs.getInt("access_age"));
			
			bookList.add(book);
		}

		return bookList;
	}
	
	// 2. 책 등록
	public void registerBook(String title,String author, int accessAge) throws SQLException 
	{
		Connection connect = getConnect();
		
		String query = "INSERT INTO book(title,author,access_age) VALUES(?,?,?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1,title);
		ps.setString(2,author);
		ps.setInt(3, accessAge);
		
		ps.executeUpdate();
	}
	
	
	// 3. 책 삭제
	public void sellBook(int bookNo) throws SQLException
	{
		Connection connect = getConnect();
		
		String query = "SELECT * FROM rent WHERE book_No = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1,bookNo);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			System.out.println("해당 책은 이미 대여중입니다.");
		}
		else
		{

			String query1 = "DELETE FROM book WHERE book_No = ?";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			ps1.setInt(1,bookNo);	
			ps1.executeUpdate();
			
		}
		
	}
	
	
}
