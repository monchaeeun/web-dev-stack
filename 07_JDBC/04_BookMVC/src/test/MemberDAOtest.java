package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentDAO;
import vo.Book;
import vo.Member;
import vo.Rent;

class MemberDAOtest {

	private RentDAO dao;
	private BookDAO book;
	private MemberDAO member;
	// @BeforeEach : 각 테스트 메서드가 실행되기 전에 무조건 실행
	//보통 DAO나 SERVICE 객체 초기화
	@BeforeEach
	void setUp() {
		dao = RentDAO.getInstance();
		member = MemberDAO.getInstance();
		book = BookDAO.getInstance();
	}
	
	@AfterEach
	// AfterEach : 각 테스트 메서드가 실행된 후에 무조건 실행
	void setDown() throws SQLException
	{
		dao.getConnect().prepareStatement("DELETE FROM rent").executeUpdate();
		member.getConnect().prepareStatement("DELETE FROM member").executeUpdate();
		book.getConnect().prepareStatement("DELETE FROM book").executeUpdate();
		}
	
	Member addMember(String id) throws SQLException 
	{
		Member m = new Member(id,"테스트01","pass01",1);
		member.register(m);
		return member.login(id, "pass01");
	}
	
	Book addBook() throws SQLException {
		book.registerBook("오늘 낙원에서 만나자", "하태완", 15);
		ArrayList<Book> list = book.printBookAll();
		return list.get(0);
	}
	
	
	@Test
	void testRent() throws SQLException 
	{
		Member member = addMember("test01");
		Book book = addBook();
		
		dao.rentBook(member.getId(), book.getBookNo());
	}
	@Test
	void testPrint() throws SQLException
	{
		Member member = addMember("test02");
		Book book = addBook();
		dao.rentBook(member.getId(), book.getBookNo());
		
		ArrayList<Rent> list = dao.printRentBook(member.getId());
		System.out.println(list);
		assertEquals(list.size(), 1);
	}
	
	@Test
	void testDelete() throws SQLException
	{
		Member member = addMember("test03");
		Book book = addBook();
		dao.rentBook(member.getId(), book.getBookNo());
		ArrayList<Rent> list = dao.printRentBook(member.getId());
		dao.deleteRent(list.get(0).getRentNo());
	}

}
