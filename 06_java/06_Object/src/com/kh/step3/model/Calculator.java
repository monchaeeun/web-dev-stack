package com.kh.step3.model;

public class Calculator {
	/*
	 * 메서드(method) - 어떤 기능을 수행하는 명령문의 집합 - 입력값(Parameter)을 받아서, 결과값(return)을 돌려줄 수
	 * 있음. - 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음. - 하나의 메서드는 한가지 기능만 수행하도록 작성하는
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
	// 나누기 몫,나머지
		public static String divid(int a, int b) {
			
			return "몫은 " + a/b + " ,나머지는" +a%b ;
		}

}
