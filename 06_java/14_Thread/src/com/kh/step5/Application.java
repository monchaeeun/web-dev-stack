
package com.kh.step5;

public class Application {
	public static void main(String[] args)
	{
		//스레드는 공유자원을 서로 공유한다
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		User2 user2 = new User2();
		
		//공유자원 셋팅
		user1.setCalculator(cal);
		user2.setCalculator(cal);
		
		//user1.run();
		//user2.run();
		
		user1.start();
		user2.start();
	}
	
}
