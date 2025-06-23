package com.kh.array.practice2;

import java.util.Scanner;

import com.kh.array.practice2.model.Member;
import com.kh.array.practice2.model.MemberController;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * 회원 수가 3명이 최대 등록 가능 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께 '1. 새 회원
		 * 등록 하지 못하게' 화면상 보이지 않게 처리!
		 * 
		 * 최대 등록 가능한 회원 수는 3명입니다. 현재 등록된 회원 수는 ~명입니다. 1. 새 회원 등록 -> 아이디를 입력 받았는데 기존 멤버
		 * 배열에 아이디가 있는 경우 "중복된 아이디입니다. 다시 입력해주세요." 출력 후 다시 아이디 입력부터 나올 수 있게 처리
		 * 
		 * 아이디 : 이름 : 비밀번호 : 이메일 : 성별(M/F) : 나이 :
		 */
		MemberController controller = new MemberController();

		while (true) {
			System.out.println("1. 새 회원 등록 | 2. 회원 정보 수정 | 3. 전체 회원 정보 출력 | 9. 끝내기");
			int num = Integer.parseInt(sc.nextLine());
			if (num == 1) {
				if (controller.countNum() >= 3) {
					System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
					continue;
				}
				
				//회원 등록
				System.out.println("현재 등록된 회원 수는" + controller.countNum() + "명입니다.");
				System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
				// 아이디 확인
				while (true) {
					System.out.print("아이디 : ");
					String id = sc.nextLine();
					if (controller.idCheck2(id) <= 0) {
						System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
						continue;
					}
					controller.member[controller.countNum()].setId(id);
					break;
				}

				System.out.print("이름 : ");
				String name = sc.nextLine();
				controller.member[controller.countNum()].setName(name);
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				controller.member[controller.countNum()].setPwd(pwd);
				System.out.print("이메일 : ");
				String email = sc.nextLine();
				controller.member[controller.countNum()].setEmail(email);
				System.out.print("성별(M/F) : ");
				char gender = sc.nextLine().charAt(0);
				controller.member[controller.countNum()].setGender(gender);
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				controller.member[controller.countNum()].setAge(age);
				controller.plusCount();

				// 비밀번호 수정
			} else if (num == 2) {
				System.out.print("아이디 : ");
				String changeInfo = sc.nextLine();
				if (controller.idCheck(changeInfo)) {
					int i = controller.idCheck2(changeInfo);
					System.out.println("수정할 회원의 아이디 : ");
					String newId = sc.nextLine();
					controller.member[i].setId(newId);
					System.out.println("수정할 회원의 이름 : ");
					String newName = sc.nextLine();
					controller.member[i].setName(newName);
					System.out.println("수정할 이메일 : ");
					String newEmail = sc.nextLine();
					controller.member[i].setEmail(newEmail);
					System.out.println("수정할 비밀번호: ");
					String newPwd = sc.nextLine();
					controller.member[i].setPwd(newPwd);

				} else {
					System.out.println("회원 정보가 없습니다.");
					continue;
				}

			}
			// 출력
			else if (num == 3) {

				for (int i = 0; i < controller.countMember(); i++) {
					if (controller.member[i].getId() != null) {
						System.out.println(controller.member[i].getId());
						System.out.println(controller.member[i].getPwd());
						System.out.println(controller.member[i].getName());
						System.out.println(controller.member[i].getEmail());
						System.out.println(controller.member[i].getAge());
					}

				}
			} else if (num == 9) {
				System.out.println("시스템을 종료합니다.");
				break;
			}

		}

		/*
		 * 2. 회원 정보 수정 -> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우 "회원 정보가 없습니다." 출력 후 다시 메인
		 * 화면으로
		 * 
		 * 수정할 회원의 아이디 : 수정할 이름 : 수정할 이메일 : 수정할 비밀번호 : 3. 전체 회원 정보 출력 -> 반복문 사용해서 끝! 9.
		 * 끝내기 -> 프로그램 종료 그 외의 번호 -> 잘못 입력하셨습니다. 다시 입력해주세요
		 * 
		 * 메뉴 번호 :
		 */

	}
}
