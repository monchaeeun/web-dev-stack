package com.kr.operator;

public class B_InDecrease {

	public static void main(String[] args) 
	{
//		증감 연산자 
//		(증감 연산자) 값; 또는 (감소연산자);
//		값을 1 증가시키거나 1 감소시키는 연산자
//		++ : 값 1 증가
//		-- : 값 1 감소
//		(증감연산자) 값 : 전위 연산으로 먼저 즐감 연산을 수행하고 다른 연산을 수행
//		값(증감연산자) : 후위 연산으로 먼저 다른 연산을 수행하고 증감 연산을 수행
//		
		B_InDecrease b = new B_InDecrease();
		
//		b.method1();
		b.method2();
		
	}
	public void method1(){
		
		int a = 10;
		System.out.println("1회 수행 후 값 : " + ++a);
		System.out.println("1회 수행 후 값 : " + ++a);
		System.out.println("전위연산자 적용 후 : " + a +"\n");
		 a = 10;
		System.out.println("2회 수행 후 값 : " + a++);
		System.out.println("3회 수행 후 값 : " + a++);
		System.out.println("후위 연산자 적용 후 : " + a);
		
		
	}
	public void method2(){
		// 지역변수라서 위의 메서드와 겹쳐도 됨
		int a = 20;
		int result = a++ * 3; // 20*30
		
		System.out.println(a);//21
		System.out.println(result + "\n");//60
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		
		System.out.println(num1++);//11
		System.out.println((++num1)+(num2++));//12+20
		System.out.println((++num1)+(--num2)+(num3--) + "\n");//12+20+30 = 62
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
	

}
