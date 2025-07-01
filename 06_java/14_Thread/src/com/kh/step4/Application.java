package com.kh.step4;

// 프로세스 = 두 스레드간의 Communication 은 프로세스 자원으로 한다.
public class Application {

	boolean check = false;
	
	public static void main(String[] args)
	{	
		Application process= new Application();
		
		Thread count = new Thread(new CountThread(process));
		Thread input = new Thread(new InputThread(process));
		
		count.start();
		input.start();
	}
}
