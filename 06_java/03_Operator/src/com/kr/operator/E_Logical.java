package com.kr.operator;

import java.util.Scanner;

public class E_Logical {

	/* 
	 	논리연산자
	 	-두 개의 논리값을 연산해주는 연산자
	 	-논리연산한 결과마저 논리값
	 	
	 	논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘다 true일 경우만 결과값이 true
	 	논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중 하나라도 true일 경우 결과값이 true
	 
	 
	  */
	//전역변수 : 전체적으로 쓸 수 있음
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.practice();
		}
	
	public void method1() 
	{
		//사용자가 입력한 값이 1~100 사이의 값인지 확인
		System.out.println("정수값 a : ");
		int a = sc.nextInt();
		System.out.println(a);
		
		boolean result = 1 <= a && a <=100;
		if(result)
		{
			System.out.println("정수값 a는 1 ~ 100 사이입니다.");
		}
		else
		{
			System.out.println("정수값 a는 1 ~ 100 사이가 아닙니다.");
		}
	}
	public void method2() 
	{
		int num = 10;
		boolean result = false;
		
//		*short cut evaluation
		
//		&&
//		true && true == true
//		true && false == false
//		false &7 true == false
//		false && false == false
		
//		&& 연산자는 앞의 값이 false 면, 뒤의 값이 계산안됨
		result = (num < 5) && (++num > 0);//false
		System.out.println(num);// 10	
		
//		   ||
//		   true || ture == true
//		   false || true == true
//		   true || false == true
//		   false || false == false
		
//		|| 연산자는 앞의 값이 true 면, 뒤의 값이 계산안됨
		result = (num < 20) || (++num > 0);
		System.out.println(result);
		System.out.println(num);
	}
	
//	문제
//	사용자가 입력한 문자 값이 알파벳인지 확인하기
//	A~Z : 65~90, a~z : 97 ~ 122
	
	public void practice()
	{
		System.out.println("입력 값 : ");
		char num = sc.nextLine().charAt(0);
		boolean result1 = 65 <=num && num <= 90;
		boolean result2 = 97 <=num && num <= 122;
		
		if(result1 || result2)
		{
			System.out.println("알파벳 입니다.");
			System.out.println(!result1 || !result2);
		}
		else 
		{
			System.out.println("알파벳이 아닙니다.");
			System.out.println(!result1 || !result2);
		}
		
	}
}
