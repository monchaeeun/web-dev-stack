package com.kr.operator;

public class G_Compound {

	/* 
	 복합 대입 연산자
	 -산술연산자와 대입연산자를 결합한 상태
	 -연산처리 속도가 빨라짐
	 
	 += , -=, /= , %=
		 int a = 1;
		 
		 a+=3; ==  //a + 3;
		 a-=3 == //a - 3;
		 a*=3 == //a * 3;
		 a/=3 == //a / 3;
		 a%=3 == //a % 3;
		  
	  ++a; or a++; ->a= a+1; -> a+=1;
	  --a; or a--; ->a= a-1; -> a-=1;
	*/
	public static void main(String[] args) 
	{
		int num = 12;
		num += 3;
		System.out.println(num);//5
		
		num -= 5;
		System.out.println(num);//10
		num *= 6;
		System.out.println(num);//60
		num /= 3;
		System.out.println(num);//20
		num %= 3;
		System.out.println(num + "\n");//2
		
		
		String str = "Hello";
		str  += ", Java!";
		System.out.println(str);
	}

}
