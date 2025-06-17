package com.kr.operator;

public class C_Arithmetic {

	public static void main(String[] args) 
	{	
		/*  
		 산술연산자
			 + : 더하기
			 - : 빼기
			 * : 곱하기
			 / : 나누기
			 % : 나머지
		 */
		
		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();
		
	}

	public void method1() 
	{
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("+ : "+ (num1 + num2));
		System.out.println("- : "+ (num1 - num2));
		System.out.println("* : "+ (num1 * num2));
		System.out.println("/ : "+ (num1 / num2));
		System.out.println("% : "+ (num1 % num2));
		
	}
	public void method2() 
	{
		int a = 5;
		int b = 10;
		int c = (++a) + b++;//c = 16 6+10, a = 6,b = 11 
		int d= c/a;			//d = 2 16/6
		int e = c % a;		//e = 4
		int f = e++;		//f = 4, e = 5
		int g = (--b) + d--;//g = 12, b = 10, d = 1
		int h = c-- * b;	//16*10 )
//		a = 6
//		b = 11 
//		c = 15
//		d = 1
//		e = 5
//		f = 4
//		g = 12
		//h = 160
		int i = (a++) + b/(--c/f) * (g-- -d)%(++e+h);
		//(6) + 33 % (166);
		System.out.println("i값 :  : "+ i);
	}
	
	
}
