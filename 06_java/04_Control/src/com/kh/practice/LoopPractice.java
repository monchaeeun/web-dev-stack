package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
		l.method5();
		l.method6();

	}

	/*
	 * 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오. 사용자 입력 : 5 5 4 3 2 1
	 */
	public void method1() {
		System.out.print("입력 : ");
		int a = Integer.parseInt(sc.nextLine());
		int re = a;
		for (int i = 0; i < re; i++) {
			System.out.println(a);
			a -= 1;
		}

	}

	// 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
	public void method2() {
		int num = 0;
		int re = 0;
		int count = 0;
		while (true) {
			++count;
			++num;
			if (num % 2 == 1) {
				re += num;
			} else {
				re -= num;
			}

			if (re == 100) {
				break;
			}
		}
		System.out.println("총 횟수 : " + count);

	}

	/*
	 * 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요.
	 * 
	 * 문자열 : banana 문자 : a banana 안에 포함된 a 개수 : 3
	 * 
	 */
	public void method3() {
		System.out.print("문자열 입력 : ");
		String a = sc.nextLine();
		System.out.print("검색 문자 입력 : ");
		String b = sc.nextLine();
		int count = 0;
		for (int i = 0; i <= a.length() - 1; i++) {
			if (a.charAt(i) == b.charAt(0)) {
				count++;
			}
		}
		System.out.println(a + "안에 포함된 " + b + "개수 : " + count);

	}

	/*
	 * 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10) 7 3 4 2 3 4 0
	 */
	public void method4() {

		while (true) {
			int ran = (int) (Math.random() * 10);
			System.out.println(ran);
			if (ran == 0) {
				System.out.println("정답!");
				break;
			}

		}

	}

	/*
	 * 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)
	 * 
	 * 1 : 3 2 : 2 3 : 1 4 : 0 5 : 4 6 : 0
	 * 
	 */
	public void method5() {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		for (int i = 0; i < 10; i++) {
			int ran = (int) (Math.random() * 6 + 1);

			switch (ran) {
			case 1:
				count1 += 1;
				break;
			case 2:
				count2 += 1;
				break;
			case 3:
				count3 += 1;
				break;
			case 4:
				count4 += 1;
				break;
			case 5:
				count5 += 1;
				break;
			case 6:
				count6 += 1;
				break;
			}
		}
		System.out.println("1 : " + count1);
		System.out.println("2 : " + count2);
		System.out.println("3 : " + count3);
		System.out.println("4 : " + count4);
		System.out.println("5 : " + count5);
		System.out.println("6 : " + count6);

	}

	/*
	 * 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고,
	 * 사용자에게는 직접 가위바위보를 받으세요. 사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.
	 * 
	 * 당신의 이름을 입력해주세요 : 김미경 가위바위보 : 가위 컴퓨터 : 가위 김미경 : 가위 비겼습니다.
	 * 
	 * 가위바위보 : 가위 컴퓨터 : 바위 김미경 : 가위 졌습니다 ㅠㅠ
	 * 
	 * 가위바위보 : 보 컴퓨터 : 바위 김미경 : 보 이겼습니다 ! 비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
	 */
	public void method6() {

		int win = 0;
		int dr = 0;
		int lose = 0;
		while (true) {
			System.out.print("사용자 입력(가위| 바위| 보) : ");
			String a = sc.nextLine();
			int ran = (int) (Math.random() * 3 + 1);
			System.out.println("사용자 : " + a);
			if (ran == 1) {

				System.out.println("컴퓨터 : 가위");
				if (a.equals("가위")) {
					System.out.println("비겼습니다.");
					dr++;
				} else if (a.equals("바위")) {
					System.out.println("이겼습니다.");
					win++;
					break;
				} else if (a.equals("보")) {
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				}
			} else if (ran == 2) {
				System.out.println("컴퓨터 : 바위");
				if (a.equals("가위")) {
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				} else if (a.equals("바위")) {
					System.out.println("비겼습니다.");
					dr++;
				} else if (a.equals("보")) {
					System.out.println("이겼습니다.");
					win++;
					break;

				}
			} else if (ran == 3) {
				System.out.println("컴퓨터 : 보");
				if (a.equals("가위")) {
					System.out.println("이겼습니다.");
					win++;
					break;

				} else if (a.equals("바위")) {
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				} else if (a.equals("보")) {
					System.out.println("비겼습니다.");
					dr++;
				}
			}
		}

		System.out.println("진 횟수 : " + lose);
		System.out.println("이긴 횟수 : " + win);
		System.out.println("비긴 횟수 : " + dr);
	}
}
