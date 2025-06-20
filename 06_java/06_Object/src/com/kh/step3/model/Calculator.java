package com.kh.step3.model;

public class Calculator {
	/*
	 * 메서드(method) - 어떤 기능을 수행하는 명령문의 집합 - 입력값(Parameter)을 받아서, 결과값(return)을 돌려줄
	 * 수있음. - 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음. - 하나의 메서드는 한가지 기능만 수행하도록 작성하는
	 * 것이 좋음.(SRP)원칙 - return 반환값이 없는 경우 리턴 타입이 void 리턴 타입 메서드명(파라미터, ...) { 실행문;
	 * return 반환값; }
	 */

	// 더하기
	public int a;
	public int b;

	public int add() {
		return a + b;
	}

	// 빼기
	public int minus() {
		return a - b;
	}

	// 곱하기
	public int multiply(int a, int b) {
		return a * b;
	}
	/*
	 * 인스턴스(객체) 메서드 : 인스턴스 변수나 인스턴스 메서드와 관련된 작업을 하는 메서드 클래스(static) 메서드 : static 변수나
	 * static 메서드와 관련된 작업을 하는 메서든
	 */

	// 나누기 몫,나머지
	public static String divid(int a, int b) {

		return "몫은 " + quotient(a, b) + " ,나머지는" + remainder(a, b);
	}

	// 두 수의 몫을 구하는 기능
	public static int quotient(int a, int b) {
		return a / b;
	}

	// 두 수의 나머지를 구하는 기능
	public static double remainder(int a, int b) {
		return a % b;
	}

	/*
	 * 팩토리얼! 
	 * 1! = 1; 
	 * 2! = 2*1 = 2 
	 * 3! = 3*2*1 = 6 
	 * n! = (n-1) * (n-2)...*1
	 */

	public int factorial(int num) {
		int result = 1;
		for (int i = num; i > 0; i--) {
			result *= i;
		}
		return result;
	}
	public int factorial2(int n)
	{
		/*
		 * 재귀법, 재귀 함수 (Recursion Function)
		 * - 메서드 내에서 자기자신을 반복적으로 호출
		 * - 반복문으로 바꿀 수 있으며 때때로 반복문보다 성능이 나쁠 때도 있음
		 * - 이해하면 간결한 코드 작성 가능
		 * */
		int result = 1;
		if(n!=1) result = n * factorial2(n-1);
		return result;
	}
}
