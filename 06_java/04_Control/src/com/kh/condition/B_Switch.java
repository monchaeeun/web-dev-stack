package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	Scanner sc = new Scanner(System.in);
	/* 
	 	switch 문
	  	switch(조건식){
	  		case 값1 :
	  			조건식의 결과가 값1과 같은 경우 실행
	  			break;
	  		case 값2 :
	  			조건식의 결과가 값2과 같은 경우 실행
	  			break;
	  		default : 
	  			조건식의 결과가 일치하는 case 문이 없을 때 실행
	  	}
	 	
	 	- case 문의 수는 제한이 없다.
	 	- 조건식의 결과는 정수, 문자, 문자열이어야 한다.
	 	- default 문은 생략 가능하다.
	*/
	public void method1() 
	{	
//		숫자를 입력받아 
//		1일 경우 "빨간색 입니다"
//		2일 경우 "파란색 입니다"
//		3일 경우 "초록색 입니다"
//		잘못 입력했을 경우 "잘못 입력했습니다."
		System.out.print("입력값 a : ");
		String re  = "";
		int a = sc.nextInt();

		switch(a){
		case 1 :
			System.out.println("빨간색 입니다.");
			break;
		case 2 :
			System.out.println("파란색 입니다.");
			break;
		case 3 :
			System.out.println("초록색 입니다.");
			break;
		default : 
			System.out.println("잘못입력하셨습니다.");
			break;	
	}			
}
	
	public void method2() {
//		주민번호를 입력받아 "남자"인지 "여자"인지 출력(그 외에는 "사람이 아닙니다")
//		주민번호 입력 : 000000-0000000
//		남자
		System.out.println("주민번호 입력 : ");
		String a = sc.nextLine();
		System.out.println(a.substring(7,8)); 
		switch(a.charAt(7)) 
		{	
			case '1': 
				System.out.println("남자");
				break;
			case '2' : 
				System.out.println("여자");
				break;
			case '3' : 
				System.out.println("남자");
				break;
			case '4' : 
				System.out.println("여자");
				break;
			default : 
				System.out.println("사람이 아닙니다.");
		}
		//다른 방법
		switch(Integer.parseInt(a)) 
		{	
			case 1:
			case 3:	
				System.out.println("남자");break;
			case 2 :
			case 4 :	
				System.out.println("여자");break; 
			default : 
				System.out.println("사람이 아닙니다.");
		}
		
	}
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
		b.method2();
		
	}

}
