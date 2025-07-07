package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;
import vo.Rent;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member member_info = new Member();

	private MemberController cc = new MemberController();
	private RentController rc = new RentController();
	private BookController bc = new BookController();

	private List<Book> bookList = new ArrayList<>();

	public static void main(String[] args) {

		BookRentApp app = new BookRentApp();
		while (true) {
			app.menu();
		}

	}
	// 1. 전체 책 조회 - 로그인 X
	// 2. 회원가입 - 로그인 X
	// 3. 로그인 - 로그인 X

	// 관리자로 로그인 했을 때
	// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
	// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
	// 3. 로그아웃 - 로그인 O

	// 1. 회원탈퇴 - 로그인 O (관리자 X)
	// 2. 책 대여 - 로그인 O
	// 3. 내가 대여한 책 조회 - 로그인 O
	// 4. 대여 취소 - 로그인 O

	// 일반회원이 들어왔을 때
	// 1. 회원탈퇴 - 로그인 O (관리자 X)
	// 2. 로그아웃 - 로그인 O
	// 3. 책 대여 - 로그인 O
	// 4. 내가 대여한 책 조회 - 로그인 O
	// 5. 대여 취소 - 로그인 O

	public void menu() {
		try {
			System.out.println("*******메뉴*******");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.print("선택 > ");
			int check = Integer.parseInt(sc.nextLine());
			switch (check) {
			case 1:
				printBookAll();
				break;
			case 2:
				register();
				break;
			case 3:
				
				login();
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다.");
			menu();
		}
	}

	// 책 조회
	public void printBookAll() {
		ArrayList<Book> book = bc.printBookAll();
		System.out.println("********************책 목록********************");
		for (Book b : book) {
			System.out.println("책 번호 - " + b.getBookNo() + " | " + b.getTitle() + " | " + b.getAuthor() + " | "
					+ b.getAccessAge() + "살 이하 금지");
		}
	}

	// 회원가입
	public void register() {
		System.out.println("이름: ");
		String name = sc.nextLine();
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = sc.nextLine();
		Member join = new Member(id, name, pwd, age);

		cc.register(join);

	}

	// 로그인
	public void login() {
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = sc.nextLine();
		Member member = cc.login(id, pwd);
		member_info = member;
		main(member_info);

	}

	public void adminPage() {
		System.out.println("******관리자 페이지******");
		System.out.println("1.책 등록");
		System.out.println("2.책 삭제");
		System.out.println("3.로그아웃");
		System.out.print("선택 > ");
		int check = Integer.parseInt(sc.nextLine());
		switch (check) {
		case 1:
			registerBook();
			break;
		case 2:
			sellBook();
			break;

		default:
			logout();
			break;
		}
	}

	public void registerBook() {
		System.out.println("******** 책 등록 ********");
		System.out.print("책 제목 : ");
		String title = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.nextLine();
		System.out.print("연령제한 나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		bc.registerBook(title, author, age);
		adminPage();
	}

	public void sellBook() {
		printBookAll();
		System.out.println("지울 책의 번호를 선택하세요.");
		System.out.print("선택 > ");
		int check = Integer.parseInt(sc.nextLine());
		bc.sellBook(check);
		adminPage();

	}

	// 로그인 화면
	public void main(Member member_info) {

		if (member_info.getId().equals("admin") && member_info.getPwd().equals("1234")) {
			adminPage();
		} else {
			System.out.println("****" + member_info.getName() + "님, 안녕하세요!****");
			System.out.println("1. 회원 탈퇴");
			System.out.println("2. 로그아웃");
			System.out.println("3. 책 대여");
			System.out.println("4. 내가 대여한 책 조회");
			System.out.println("5. 대여 취소");
			System.out.print("선택 > ");

			int check = Integer.parseInt(sc.nextLine());

			switch (check) {
			case 1:
				delete();
				break;
			case 2:
				logout();
				break;
			case 3:
				rentBook();
				main(member_info);
				break;
			case 4:
				printRentBook();
				main(member_info);
				break;
			case 5:
				deleteRent();
				main(member_info);
				break;
			}
		}

	}

	public void delete() {
		System.out.println("정말로 회원탈퇴를 하실건가요?(회원정보가 지워집니다)");
		System.out.println("1. 네");
		System.out.println("2. 아니요");
		System.out.println("선택 > ");

		int check = Integer.parseInt(sc.nextLine());

		switch (check) {
		case 1:
			cc.delete(member_info.getId());
			member_info = null;

			break;
		case 2:
			System.out.println("다시 메인화면으로 이동합니다!");
			main(member_info);
			break;

		default:
			System.out.println("잘못 입력하셨습니다.");
			delete();
			break;
		}
	}

	// 로그아웃
	public void logout() {
		System.out.println("로그아웃되었습니다.");
		member_info = null;
		menu();
	}

	// 책 대여
	public void rentBook() {
		printBookAll();
		System.out.println("대여할 책의 번호를 선택하세요.");
		System.out.println("선택 > ");
		int check = Integer.parseInt(sc.nextLine());

		rc.rentBook(member_info.getId(), check);

	}

	public void printRentBook() {
		ArrayList<Rent> list = rc.printRentBook(member_info.getId());
		System.out.println("*******" + member_info.getName() + "님의 대여한 책 목록" + "*******");
		for (Rent li : list) {
			System.out.println("책 번호 - " + li.getBookNo());
			System.out.println("책 이름 - " + li.getBook().getTitle());
			System.out.println("대여 날짜 - " + li.getRentDate());
			System.out.println("나이제한 - " + li.getBook().getAccessAge() + "세 미만 금지");
			System.out.println("__________________________________________");
		}

	}

	public void deleteRent() {
		printRentBook();
		System.out.println("삭제할 대여책을 선택하세요.");
		System.out.println("선택 > ");
		int check = Integer.parseInt(sc.nextLine());
		rc.deleteRent(check);

	}
}
