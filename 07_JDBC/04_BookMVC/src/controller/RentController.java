package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.RentDAO;
import vo.Rent;

public class RentController {

	//로그인된 경우만 접근 가능! -> view에서 조건 걸어서 안보이게 하면 됨!
	RentDAO dao = new RentDAO();
	
	
	
	
	// 7. 책 대여
	public void rentBook(String id, int bookNo)
	{
		try {
			boolean haveBook = dao.isHave(id, bookNo);
			boolean over = dao.isOver(id);
			boolean ageCheck = dao.isAge(id, bookNo);
			if(haveBook == true)
			{
				System.err.println("이미 대여중인 책입니다.");
			}
			else if(over == true)
			{
				System.out.println("이미 5권이상 대여중입니다.");
			}
			else if(ageCheck == true)
			{
				System.out.println("연령이 적절하지 않습니다.");
			}
			else
			{
				System.out.println("책을 대여할 수 있습니다!");
				dao.rentBook(id, bookNo);				
			}
			
		} catch (SQLException e) {
			
			
		}
		
		
		//한 사람당 대여할 수 있는 책은 총 5권
		
		//중복 책 대여 불가능
		
		//나이 제한 걸리는 책도 불가능
		
		//각 책들마다 가능한 대여가 2권까지만(각 책당 2권만 있다는 설정)
	}
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id)
	{
		try {
			ArrayList<Rent> list  = null;
			list = dao.printRentBook(id);
			return list;
		} catch (SQLException e) {
			System.out.println("오류!");
			e.printStackTrace();
		}
		return null;
	}
	
	// 9. 대여 취소
	public void deleteRent(int rentNo)
	{
		try {
			dao.deleteRent(rentNo);
			System.out.println("대여를 취소했습니다.");
		} catch (SQLException e) {
			System.out.println("대여한 책 목록이 없습니다.");
			e.printStackTrace();
		}
	}
}
