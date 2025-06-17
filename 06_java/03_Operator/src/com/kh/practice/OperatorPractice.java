package com.kh.practice;

import java.util.Scanner;

import javax.swing.Spring;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
//		o.method1();
//		o.method2();
//		o.method3();
//		o.method4();
//		o.method5();
//		o.method6();
//		o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원 수 : ");
		int a = sc.nextInt();
		System.out.print("연필 수 : ");
		int b = sc.nextInt();
		System.out.println("1인당 나눠가진 연필 개수 : " + (b/a));
		System.out.println("남은 연필의 개수 : " + (b%a));
		
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("숫자를 입력하세요 : ");
		int a = sc.nextInt();
		//소수점(double, float)이 아님을 이용해서 버리기
		System.out.println(a/100*100);
		
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("숫자a를 입력하세요 : ");
		int a = sc.nextInt();
		System.out.println("숫자b를 입력하세요 : ");
		int b = sc.nextInt();
		System.out.println("숫자c를 입력하세요 : ");
		int c = sc.nextInt();
		System.out.println(a==b&&b==c);
		
		
		
		
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("숫자를 입력하세요 : ");
		int a = sc.nextInt();
		if(a %2 == 0)System.out.println("짝수다");
		else System.out.println("짝수가 아니다");
		
		
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.println("주민번호를 입력하세요 : ");
		String a = sc.nextLine();
		switch(a.charAt(7)) 
		{
			case '1':
			case '3':
				System.out.println("남자");
				break;
			case '2':
			case '4':
				System.out.println("여자");
				break;
		}
		
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.println("나이를 입력하세요 : ");
		int a = sc.nextInt();
		if(a <= 13)System.out.println("어린이 입니다");
		else if(a <= 19)System.out.println("청소년 입니다");
		else if(a > 19)System.out.println("성인 입니다");
			
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		
		System.out.println("사과의 개수를 입력하세요 : ");
		int a = sc.nextInt();
		System.out.println("바구니에 들어갈수 있는 사과의 개수를 입력하세요 : ");
		int b = sc.nextInt();
		int re = a/b;
		if(b%a != 0)
		{
			re += 1;
		}
		System.out.println("필요한 바구니 개수 : " + re);
	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.println("초단위를 입력하세요 : ");
		int ch = sc.nextInt();
		//300초 => 5분
		
		
		int seconds = ch%60;
		int b = ch/60;
		int hours = b / 60;
		int minute = hours%60;

		System.out.println("입력된 초: "+ ch + "초");
		System.out.println(hours + "시간"+ minute + "분"+ seconds + "초");
		
	}
	
}