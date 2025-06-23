package com.kh.array.practice2.model;

public class MemberController {
	// 공간만 만들기
//	Member[] member = new Member[3];
	// 객체부터 생성
	public Member[] member = { new Member(), new Member(), new Member() };
	int count = 0;
	int num = 0;
	boolean check;

	// 갯수 체크
	public int countMember() {
		return member.length;
	}

	// 아이디 체크 -> 배열을 전부 확인하고 아이디가 있는지 체크
//	이자리 int 로 바꾸고 else 자리에 return -1;
	public boolean idCheck(String id) {
		for (int i = 0; i < member.length; i++) {
			if (member[i].getId() != null && member[i].getId().equals(id)) {
//				System.out.println("중복 있음");
				check = true;
				break;
			} else {
//				System.out.println("중복 없음");
				check = false;
			}
		}
		return check;

	}
	//중복 아이디 위치 체크
	public int idCheck2(String changeInfo) {
		num = 0;
		for (int i = 0; i < member.length; i++) {
			if (member[i].getId() != null) {
				if (member[num].getId().equals(changeInfo)) {
					break;
				}
			}
			
			num++;
		}
		return num;
	}

	// 횟수 체크
	public int countNum() {
		return count;
	}
	// 횟수 증가
	public int plusCount() {
		count++;
		return count;
	}
}
