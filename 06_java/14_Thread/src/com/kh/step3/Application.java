package com.kh.step3;

import java.awt.Toolkit;

public class Application {

	public static void main(String[] args)
	{
		
		//첫번째 작업 - 경고음 5번 울리기 ->BeepThread
		Thread beep = new Thread(new BeepThread());
		Thread text = new Thread(new TextThread());
		
		
		beep.start();
		text.start();
	}
}
