package controller;


import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import dao.MemberDAO;
import vo.Book;

public class BookController {

	BookDAO dao = new BookDAO();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll(){
		
		ArrayList<Book> bookList = null;
		try 
		{
			bookList = dao.printBookAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	// 2. 책 등록
	public boolean registerBook(String title,String author, int age) 
	{
		boolean isbook = true;
		try {
			isbook = dao.isBook(title,author,age);
			if(isbook == false)
			{
				dao.registerBook(title, author, age);
				System.out.println("책이 등록되었습니다!");
				return isbook;
			}
			else
			{
				System.out.println("이미 책이 있습니다.");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isbook;
		//책이 있는지 체크해서 있으면 true, 없으면 false
	}
	
	// 3. 책 삭제
	public boolean sellBook(int bookNo)
	{
		//빌려있는 책은 못사게!
		//책이 있는지 체크해서 있으면 true, 없으면 false
		boolean isBook = true;
		try {
			isBook = dao.isBook(bookNo);
			if(isBook == true)
			{
				dao.sellBook(bookNo);
				return isBook;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
