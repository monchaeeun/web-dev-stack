package com.kh.condition;

import java.util.Scanner;

public class D_While {

	Scanner sc = new Scanner(System.in);

	/*
	 * - While 문 While (조건식) { 조건이 true 일 경우 계속 실행 }
	 */
//	1~5까지 출력
	public void method1() {
		int i = 1;
		while (i <= 5) {
			System.out.println(i);
			i++;
		}
	}

//	무한루프 & break 문
//	 - switch , 반복문의 실행을 중지하고 빠져나갈 때
//	 - 반복문이 중첩되는 겨우 break 문이 포함되어 있는 반복문에서만 빠져나간
	public void method2() {
		while (true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			if (num == 0) {
				System.out.println("중지");
				break;
			} else
				System.out.println(num);
		}

	}

	/*
	 * do { - 조건과 상관없이 무조건 1번은 실행 실행코드 }while();
	 * 
	 */
	public void method3() {
		int num = 1;
		do {
			System.out.println(num);
		} while (num == 0);

	}

	/*
	 * 숫자 맞히기 게임 - 1과 100사이의 값의 정답을 저희가 정하고 컴퓨터(random)가 맞히도록! 몇번만에 끝냈는지 출력! 해당 숫자보다
	 * 정답이 높으면 up! 낮으면 Down!
	 */
	public void method4() {
		System.err.print("1~100중의 값 입력 : ");
		int num = sc.nextInt();
		int count = 0;

		int max = 100;
		int min = 1;

		while (true) {

			int com = (int) (Math.random() * (max - min + 1) + min);
			System.err.println("사용자의 값 : " + num);
			System.err.println("컴퓨터의 값 : " + com + "\n");
			if (num > com) {
				++count;
				System.err.println("값이 너무 작습니다." + "\n");
				min = com + 1;
			} else if (num < com) {
				max = com - 1;
				System.err.println("값이 너무 큽니다." + "\n");

			} else if (num == com) {
				System.err.println("정답!");
				System.err.println("도전횟수 : " + count);
				break;
			}

		}

		/*
		 * 숫자 맞히기 게임 - 1과 100사이의 값의 정답을 저희가 맞히도록! 몇번만에 끝냈는지 출력! 해당 숫자보다 정답이 높으면 up! 낮으면
		 * Down!
		 */
	}

	public void method5() {
		int count = 0;
		int max = 100;
		int min = 1;
		int com = (int) (Math.random() * (max - min + 1) + min);

		while (true) {
			++count;
			System.err.print("1~100중의 값 입력 : ");
			int num = sc.nextInt();
			if (num > com) {
				System.err.println("값이 너무 큽니다." + "\n");
			} else if (num < com) {
				System.err.println("값이 너무 작습니다." + "\n");

			} else if (num == com) {
				System.err.println("정답! : " + com);
				System.err.println("도전횟수 : " + count);
				break;
			}
		}

	}
//	_________________________________
//	1.예금 | 2.출금 | 3. 잔고 | 4. 종료
//	_________________________________
//	선택 > 1
//	예금액 > 10000
//	_________________________________
//	1.예금 | 2.출금 | 3. 잔고 | 4. 종료
//	_________________________________
//	선택 > 2
//	출금액 > 50000(예금액 - 출금액)(if 0 > 예금-출금 : 출금할 수 없습니다)
//	_________________________________
//	1.예금 | 2.출금 | 3. 잔고 | 4. 종료
//	_________________________________
//	선택 > 3
//	잔고확인 > 10000
//	_________________________________
//	1.예금 | 2.출금 | 3. 잔고 | 4. 종료
//	_________________________________
//	선택 > 4
//	프로그램 종료
//	_________________________________

	public void method6() {
		int money = 0;
		boolean check = true;
		while (check) {
			System.out.println("1.예금 | 2.출금 | 3. 잔고 | 4. 종료");
			System.out.println("선택 > ");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.println("예금액 > ");
				int in = sc.nextInt();
				money += in;
			} else if (select == 2) {
				System.out.println("출금액 > ");
				int out = sc.nextInt();
				if (money - out < 0) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
				money -= out;

			} else if (select == 3) {
				System.out.println("잔고 > " + money);
			} else if (select == 4) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 \n");
			}
		}
	}

	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
		d.method6();

	}

}
