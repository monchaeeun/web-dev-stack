package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import config.ServerInfo;
import controller.PersonController;
import vo.Person;

public class PersonView {

	public static void main(String[] args) {
		PersonController pc = new PersonController();
		Scanner sc = new Scanner(System.in);

		//테스트 용도!
		System.out.println("****메뉴****");
		System.out.println("1. 추가");
		System.out.println("2. 전체 인원 출력");
		System.out.println("3. 특정 인원 출력");
		System.out.println("4. 특정 인원 수정");
		System.out.println("5. 특정 인원 삭제");
		int answer = Integer.parseInt(sc.nextLine());
		switch (answer) {
		case 1: 
		{
			try {
				System.out.println("****인물 추가****");
				System.out.println("추가할 이름 : ");
				String name = sc.nextLine();
				System.out.println("추가할 나이 : ");
				int age = Integer.parseInt( sc.nextLine());
				System.out.println("추가할 주소 : ");
				String address = sc.nextLine();
				boolean check = pc.checkPerson(name, age, address);
				if(check == true)
				{
					pc.addPerson(name, age,address);
				}
				else
				{
					System.out.println("이미 동일한 회원이 존재합니다.");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			break;
		}
		case 2: 
		{
			try {
				System.out.println("****전체 출력****");
				List<Person> list = pc.searchAllPerson();
				for(Person li : list)
				{
					System.out.println(li.getId() + " | "+ li.getName() + " | "+ li.getAge()+"살" + " | "+ li.getAddr());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case 3: 
		{
			try {
				System.out.println("****특정 인원 출력****");
				System.out.println("출력할 사람의 번호 : ");
				int user_no = Integer.parseInt( sc.nextLine());
				pc.searchPerson(user_no);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			break;
		}
		case 4: 
		{
			try {
				System.out.println("****인물 정보 수정****");
				System.out.println("수정할 인물의 번호 : ");
				int check = Integer.parseInt(sc.nextLine());
				boolean isPerson;
				isPerson = pc.checkPerson(check);
				if(isPerson)
				{
					System.out.println("수정할 이름 : ");
					String name = sc.nextLine();
					System.out.println("수정할 나이 : ");
					int age = Integer.parseInt( sc.nextLine());
					System.out.println("수정할 주소 : ");
					String address = sc.nextLine();
					pc.updatePerson(check, name, age, address);
				}
				else
				{
					System.out.println("해당 인물이 존재하지 않습니다.");
				}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			break;
		}
		case 5: 
		{
			
			try {
				System.out.println("****인물 정보 삭제****");
				System.out.println("삭제 인물의 번호 : ");
				int check = Integer.parseInt(sc.nextLine());
				boolean isPerson;
				isPerson = pc.checkPerson(check);
				if(isPerson)
				{
					pc.removePerson(check);
				}
				else
				{
					System.out.println("해당 인물이 존재하지 않습니다.");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			break;
		}
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		
		}	
	}
}
