package com.kh.practice2.model;

import java.util.DuplicateFormatFlagsException;
import java.util.Scanner;

import com.kh.practice2.exception.DuplicateIdExdeption;
import com.kh.practice2.exception.RecordNotFoundException;



public class MemberController {
	// 공간만 만들기
//	Member[] member = new Member[3];
	// 객체부터 생성

	Scanner sc = new Scanner(System.in);
	private Member[] member = { new Member(), new Member(), new Member() };
	private int count = 0;
	int num = 0;

	// 갯수 체크
	public int countMember() {
		return member.length;
	}

	// 아이디 자리 체크(0,1,2), 자리가 없을 경우 -1 리턴
	public int idCheck(String id) {
		num = 0;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getId() != null && member[i].getId().equals(id)) {
//				System.out.println("중복 있음");
				num = i;
				return num;
			} else {
				num = -1;
			}
		}
		return num;
	}
	public int idCheck2(String id) throws RecordNotFoundException{
		num = 0;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getId() != null && member[i].getId().equals(id)) {
				num = i;
				return num;
			} else {
				
				num = -1;
			}
		}
		throw new RecordNotFoundException();
	}
	
	public int updateCheck(String id) throws DuplicateIdExdeption{
		num = 0;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getId() != null && member[i].getId().equals(id)) {				
				throw new DuplicateIdExdeption();
			} else {
				num = -1;
			}
		}
		return num;
	}

	public void checkSameId() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			try {
				if (updateCheck(id) >= 0) {
					System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
					continue;
				}
			} catch (DuplicateIdExdeption e) {
				
				e.printStackTrace();
			}
			member[countNum()].setId(id);
			break;
		}
	}

	// 횟수 세기
	public int countNum() {
		return count;
	}

	// 횟수 증가
	public int plusCount() {
		count++;
		return count;
	}

	// 1번
	public void createInfo() {
		System.out.print("이름 : ");
		member[countNum()].setName(sc.nextLine());

		System.out.print("비밀번호 : ");
		member[countNum()].setPwd(sc.nextLine());

		System.out.print("이메일 : ");
		member[countNum()].setEmail(sc.nextLine());

		System.out.print("성별(M/F) : ");
		member[countNum()].setGender(sc.nextLine().charAt(0));

		System.out.print("나이 : ");
		member[countNum()].setAge(Integer.parseInt(sc.nextLine()));
		plusCount();

	}

	// 2번
	public void changeInfo() {
		System.out.print("아이디 : ");
		String changeInfo = sc.nextLine();
		try {
			if (idCheck2(changeInfo) >= 0) {

				int i = idCheck2(changeInfo);

				System.out.println("수정할 회원의 이름 : ");
				String newName = sc.nextLine();
				member[i].setName(newName);

				System.out.println("수정할 이메일 : ");
				String newEmail = sc.nextLine();
				member[i].setEmail(newEmail);

				System.out.println("수정할 비밀번호: ");
				String newPwd = sc.nextLine();
				member[i].setPwd(newPwd);

			}
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
			changeInfo();
		}
	}

	// 3번 전체 회원정보 출력
	public void printInfo() {
		for (int i = 0; i < countMember(); i++) {
			if (member[i].getId() != null) {

				System.out.println("아이디 : " + member[i].getId());
				System.out.println("비밀번호 : " + member[i].getPwd());
				System.out.println("이름 : " + member[i].getName());
				System.out.println("이메일 : " + member[i].getEmail());
				System.out.println("나이 : " + member[i].getAge());
				System.out.println();
			}

		}
	}
	//캡슐화(getter - setter)
	public Member[] getMember() {
		return member;
	}
}
