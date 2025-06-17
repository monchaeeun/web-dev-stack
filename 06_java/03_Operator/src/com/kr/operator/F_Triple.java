package com.kr.operator;

import java.util.Scanner;

public class F_Triple {
	/*
 			3항 연산자
 			
 			조건식 ? 값1 : 값2;
 			
 			- 조건식에는 주로 비교,논리 연산자가 사용된다.
 			- 조건식의 결과가 true이면 값1을 반환한다.
 			- 조건식의 결과가 false이면 값2를 반환한다.
  
  
  
  
  */
	public static void main(String[] args) 
	{
		F_Triple f = new F_Triple();
		//f.practice1();
		f.practice3();

	}

	Scanner sc = new Scanner(System.in);
	public void method1()
	{
//		입력받은 정수가 양수인지 음수인지 판단	
		System.out.println("입력 :");
		int num = sc.nextInt();
//		+) 0인 경우는 0입니다		
		String result = num > 0 ? "양수" :"음수";	
		result = num == 0 ? "0입니다" : result;
		System.out.println(result);
}
//	문제
//	사용자한테 2개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 크거나 같은경우
//	"결과가 100 이상입니다." 아닌경우 "결과가 100보다 작습니다 출력"
	
	public void practice1() 
	{
		System.out.print("입력값 a : ");
		int a = sc.nextInt();
		System.out.print("입력값 b : ");
		int b = sc.nextInt();
		
		boolean result = (a*b) >= 100;
		
		String text = result ? "결과가 100 이상입니다" : "결과가 100보다 작습니다.";
		System.out.println(text);
	}
//	문제
//	사용자한테 문자 하나 입력받아서 입력한 문자가 대문자면 "알파벳 대문자 입니다"
//	소문자이면 "알파벳 대문자 입니다", 둘 다 아니라면 "알파벳이 아니네요.."
//	A~Z : 65~90, a~z : 97 ~ 122
	public void practice2() 
	{
		System.out.print("입력값 : ");
		char a = sc.nextLine().charAt(0);
		boolean re1 = 65<= a && a <= 90;
		boolean re2 = 97 <= a && a <= 122;
		
		String result = re1? "알파벳 대문자입니다." : re2? "알파벳 소문자 입니다." : "알파벳이 아니네요..";
		System.out.println(result);
		
	}
	
//	문제 3 
//	사용자에게 숫자를 입력받아서 해당 숫자가 알파벳 범위 안에 들어간다면
//  "알파벳 D 입니다" 그게 아니면 "알파벳이 아닙니다".
	
	public void practice3() 
	{
		System.out.print("입력 값 : ");
		int a = sc.nextInt();
		
		boolean re1 = 'A' <= a && a <= 'Z';
		boolean re2 = 'a' <= a && a <= 'z';
		
		String result = re1? "알파벳 " + (char)a + " 입니다." 
				: re2? "알파벳"+ (char)a + " 입니다." 
						: "알파벳이 아닙니다";
		System.out.println(result);
	}
}
