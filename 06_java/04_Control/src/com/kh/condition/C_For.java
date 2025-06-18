package com.kh.condition;

import java.util.Random;
import java.util.Scanner;

public class C_For {

	Scanner sc = new Scanner(System.in);

	/*
	 * for 문 for(초기식; 조건식; 증감식;) { 실행코드 }
	 * 
	 * -주어진 횟수만큼 코드를 반복실행하는 구문 -초기 식 : 반복문이 수행될 때 단 한번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값
	 * 대입 -조건식 :결과가 true 이면 실행, false 이면 실행하지 않고 반복문을 빠져나감 -증감식 : 반복문에서 사용하는 변수의 값을
	 * 증감, 주로 증감 연산자 사용
	 */
	// 1~5 출력
	public void method1() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	public void method2() {
		int j = 5;
		for (int i = 1; i <= 5; i++) {
			System.out.println(j);
			j--;
		}
	}

	// 1~10사이의 홀수만 출력
	public void method3() {
		// 방법1
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
		System.out.println("");
		// 방법2
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("");
		// 방법3
		// continue
//		continue 문은 반복문 안에서 사용
//		반복문 안에서 continue 를 만나면 "현재 구문" 종료
//		반복문을 빠져나가는건 아님! 다음 반복 계속 수행
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0)
				continue;
			System.out.println(i);
		}
		System.out.println("");
	}

	// 1~10까지의 합계
	public void method4() {
		int num = 0;
		for (int i = 1; i <= 10; i++) {
			num += i;
		}
		System.out.println(num);
	}

	// 1부터 사용자가 입력한 수까지의 합계
	public void method5() {
		System.out.println("숫자 입력 : ");
		int a = sc.nextInt();
		int num = 0;
		for (int i = 1; i <= a; i++) {
			num += i;
		}
		System.out.println(num);
	}

	// 1부터 랜덤값까지의 합계
	public void method6() {
		double random = Math.random();
		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2;// 2부터 10까지
		int random4 = random2.nextInt(2, 11);
		int ran2 = (int) (random * 9 + 2);

		System.out.println("랜덤값 : " + ran2);
		int num = 0;
		for (int i = 1; i <= ran2; i++) {
			num += i;
		}
		System.out.println(num);
	}

	// 사용자에게 입력 > hello;
	public void method7() {
		System.out.println("문자 입력 : ");
		String a = sc.nextLine();
		for (int i = 0; i <= a.length() - 1; i++)
			System.out.println(a.charAt(i));
		// 다른방법
//		향상된 for 문
//		변수 : 배열의 값을 하나씩 가지고옴
//		문자열 : 문자의 배열, 여러개의 문자가 배열을 이룬 것이 문자열
//		ToCharArray : 모든 문자가 들어있는 char[] 형식의 데이터 반환 배열
//		charAt(int index) : 인데스에 있는 문자를 char 형식으로 반환

		// Char arr[] = a.toCharArray();
//		for(데이터타입 변수 : 배열){
//	
//		}
		for (char ch : a.toCharArray()) {
			System.out.println(ch);
		}
	}

	// 중첨 for 문
	// *****
	// *****
	// *****
	// *****

	public void method8() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	// 1****
	// *2***
	// **3**
	// ***4*
	// ****5

	public void method9() {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == j) {
					System.out.print(i);
				} else {
					System.out.print("*");
				}

			}
			System.out.println();
		}
	}

	// *
	// **
	// ***
	// ****
	// *****
	public void method10() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}


	// *
	// **
	// ***
	// ****
	// *****
	public void method11() {

		for (int i = 0; i <= 5; i++) {
			for (int j = 4; j >= 0; j--) {
				if (i > j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
		c.method11();
//		c.method12();
	}

}
