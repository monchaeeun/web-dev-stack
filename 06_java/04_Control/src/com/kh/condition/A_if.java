package com.kh.condition;

import java.util.Scanner;

public class A_if 
{	/*
		-if 문
		if(조건식1)
		{
			조건식1이 참(true)일 때 실행
		} 
		else if(조건식2)
		{
			조건식2이 참(true)일 때 실행
		}
		else
		{
			조건식이 거짓(false)일 때 실행
		}
		- 조건식에는 비교연산자, 논리연산자를 주로 사용
		-else if 는 제한이 없다
 	*/
	
	Scanner sc = new Scanner(System.in);
	public void method1() 
	{
		// 입력받은 성적이 60점 이상이면 "합격입니다"출력
		// 아니면 "불합격입니다." 출력
		System.out.print("성적 입력 : ");
		int a = sc.nextInt();
		if(a>= 60)
		{
			System.out.println("합격입니다.");
		}
		else
		{
			System.out.println("불합격입니다.");
		}
		//삼항연산자
		System.out.println(a>=60? "합격입니다." : "불합격입니다.");  
	}
	public void method2() 
	{
		//본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다" 출력
		
		String name = "문채은";
		System.out.print("이름 입력 : ");
		String a = sc.nextLine();
		System.out.println("a : "+ System.identityHashCode(a));
		System.out.println("문채은 : "+ System.identityHashCode("문채은"));
		
		// equals() : 문자열 비교
		if(a.equals(name))
		{
			System.out.println("본인입니다.");
		}
		else {
			System.out.println("본인이 아닙니다.");
		}
	}
	public void method3() 
	{
		/*
		if -  else if - else
		-사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력
		 */
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		char grade = '\u0000';
		if(score < 0 || score > 100) 
		{	System.out.println("잘못입력하셨습니다.");
			return;
		}
		else if(score >= 90) { grade = 'A';}
		else if(score >= 80) { grade = 'B';}
		else if(score >= 70) {grade = 'C';}
		else if(score >= 60) {grade = 'D';}
		else {grade = 'F';}
		System.out.println(grade +"등급");
	}
	
//	세 정수를 입력했을 때 짝수만 출력
//	num1 = 3
//	num2 = 4
//	num3 = 8
	public void method4() 
	{
		System.out.print("num1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("num2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("num3 입력 : ");
		int num3 = sc.nextInt();
		
		if(num1 %2 == 0){System.out.println(num1);}
		if(num2 %2 == 0){System.out.println(num2);}
		if(num3 %2 == 0){System.out.println(num3);}	
	}
	
	public static void main(String[] args) 
	{
		A_if a = new A_if();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}
	
	

}
