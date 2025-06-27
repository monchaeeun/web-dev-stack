package com.kh.map.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.map.practice2.model.Book;
import com.kh.map.practice2.model.BookController;
import com.kh.map.practice2.model.Member;

public class Application {
	ArrayList<Book> books = new ArrayList<>();
	{	
		books.add(new Book("디스 이즈 이탈리아", false, 0));
		books.add(new Book("리얼 런던", true, 0));
		books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
		books.add(new Book("사퀴트리 샌드위치", false, 0));
		books.add(new Book("원피스 111", true, 15));
		books.add(new Book("귀멸의 칼날 23", false, 19));
		books.add(new Book("진격의 거인 Before the fall 16", false, 19));
		
		
	}
	public static void main(String[] args) {
		BookController b = new BookController();
		Application a = new Application();
		Scanner sc = new Scanner(System.in);
		
		 
		a.Start();
		/*
		 * -> 회원가입 
		 * -> 로그인 조건 : 이름과 나이가 일치한 경우
		 * -> 기존에 회원중 이름이 있으면 "이미 존재하는 이름입니다. 다시 입력해주세요."
		 * 
		 * 이름 : 
		 * 나이 : 
		 * 
		 * ===메뉴===
		 * 1. 마이 페이지 -> 본인 정보 출력(대여한 책)
		 * 2. 도서 대여하기 
		 * 	-> 1. 한 사람당 대여할 수 있는 책을 총 3권
		 * 			"더이상 대여할 수 없습니다."
		 * 	-> 2. 해당 사람이 대여한 책은 대여 불가능
		 * 			"이미 대여한 책 입니다."
		 * 	-> 3. 나이 제한에 걸리는 책들 대여 불가능
		 * 			"나이 제한으로 대여 불가능 합니다."
		 * 	-> 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
		 * 	(선택사항)5. 각 책들마다 가능한 대여가 3권까지만.
		 * 				HashMap - > getOrDefault(키, 초기값)
		 * 	-> 대여 가능한 경우 "성공적으로 대여되었습니다." return 값
		 * 3. 로그아웃
		 * 4. 프로그램 종료
		 * 
		 * */
	}
	public void Start() {
		BookController b = new BookController();
		Application a = new Application();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("====로그인====");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		b.logIn(name, age);
		a.menu();
		
	}
	//3. 렌탈 페이지
	public void rentalPage() 
	{
		
		BookController b = new BookController();
		b.ad();
		Scanner sc = new Scanner(System.in);
		int i = 1;
		for(Book bk :books)
		{
			System.out.println(i + ". "+bk.getTitle());
			i++;
		}
		System.out.print("대여할 책을 선택하세요 ->");
		int check = Integer.parseInt(sc.nextLine());
		boolean myBook = b.checkList(books.get(check-1));
		if(!myBook)
		{
		 System.out.println(b.rentalBook(books.get(check-1), check-1));				
		}
		else
		{
			System.out.println("책을 이미 대여하였습니다.");
		}

	
	}

	public void menu() 
	{	
		Application a = new Application();
		BookController b = new BookController();
		Scanner sc = new Scanner(System.in);
		System.out.println("=====메뉴=====");
		System.out.println("1. 마이 페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 로그아웃");
		System.out.println("4. 프로그램 종료");
		System.out.print("->");
		int click = Integer.parseInt(sc.nextLine());
		switch (click) {
		case 1: 
		{
			b.myPage();
			break;
		}
		case 2: 
		{
			a.rentalPage();
			break;
		}
		case 3: 
		{	b.logOut();
			a.Start();
			break;
		}
		case 4: 
		{
			System.out.println("시스템을 종료합니다.");
			break;
		}
		default:
			System.out.println("잘못 선택하셨습니다.");
		}
	}
}
