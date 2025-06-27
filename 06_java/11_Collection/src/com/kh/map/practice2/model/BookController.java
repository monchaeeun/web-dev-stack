package com.kh.map.practice2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.kh.map.practice2.Application;

public class BookController {
	private static final int ArrayList = 0;
	private static final int Book = 0;
	Book b = new Book();
	Member m = new Member();
	public ArrayList<Member> list = new ArrayList<Member>();
	public ArrayList<Integer> bookCount = new ArrayList<Integer>();
	String saveName = null;
	int saveUser;
	// 책 권수 카운트하는 리스트 생성
	{
		for (int i = 0; i < 7; i++) {
			bookCount.add(0);
		}
	}

	// 로그인 확인 메서드
	
	public void logIn(String name, int age) 
	{
		for (int i = 0; i < 1; i++) {
			if (list.size() != 0) {
				// 로그인 성공
				if (list.get(i).getName().equals(name) && list.get(i).getAge() == age) {
					System.out.println("로그인에 성공하셨습니다");
					saveUser = i;
					saveName = name;
				}
					
				// 이름은 있는데 나이가 다름
				else if (list.get(i).getName().equals(name) && list.get(i).getAge() != age) {
					System.out.println("나이가 다릅니다.");
					
				} // 이름도 나이도 없음
				else
				{
					Member m = new Member();
					m.setName(name);
					m.setAge(age);
					list.add(m);
					
					System.out.println(m.getName());
					System.out.println(m.getAge());
					System.out.println(list);
					System.out.println("회원가입에 성공하셨습니다.");
					saveName = name;
					saveUser = i;
				}
			}
			else
			{
				Member m = new Member();
				m.setName(name);
				m.setAge(age);
				list.add(m);
				System.out.println(m.getName());
				System.out.println(m.getAge());
				System.out.println(list);
				System.out.println("회원가입에 성공하셨습니다.");
				saveName = name;
				saveUser = i;
			}
		}
		
	}

	public void myPage() {
		for (Member li : list) {
			if (li.getName().contains(saveName)) {
				System.out.println(li);
			} else {
				System.out.println("정보가 없습니다.");
			}
		}
	}
	
	public void ad() 
	{	
		System.out.println(list);
	}

	// 책이 내 리스트에 있는지 확인
	public boolean checkList(Book book) {

		if (list.get(saveUser) != null &&  list.get(saveUser).getBookList().contains(book))
		{
			return true;
		}

		return false;
	}

	// 일단 책이 내 북 리스트에 있는지 확인
	// 없는 경우 rentalBook 실행
	// 있는경우는 이미 대여한 책 입니다.

	public String rentalBook(Book book, int check) {
		// 책 대여 가능할 때
		if (bookCount.get(check) < 3) {
			// 나이제한 걸렸을때
			if (book.getAccessAge() > list.get(saveUser).getAge()) {
				return "나이 제한";

				// 나이제한 안걸렸을때
			} else {
				bookCount.set(check, bookCount.get(check) + 1);
				list.get(saveUser).getBookList().add(book);
				return "북 리스트에 저장되었습니다.";

			}
			// 책 대여 불가능할때
		} else if (bookCount.get(check) >= 3) {
			// 책에 쿠폰이 있을 때
			if (b.isCoupon()) {
				bookCount.set(check, bookCount.get(check) + 1);
				list.get(saveUser).getBookList().add(book);
				return "북 리스트에 저장되었습니다.";

			} else if (!b.isCoupon()) {
				return "더이상 대여할 수 없습니다.";
			}
		}
		return "오류 발생";
	}

	public void addBooks(Book book) {
		list.get(saveUser).getBookList().add(book);
	}

	public void logOut() {
		saveName = null;
	}
}
