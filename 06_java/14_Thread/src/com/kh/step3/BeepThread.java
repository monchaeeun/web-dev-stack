package com.kh.step3;

import java.awt.Toolkit;

public class BeepThread implements Runnable{

	Toolkit toolkit = Toolkit.getDefaultToolkit();
	@Override
	public void run() {
		for(int i = 0; i<5; i++)
		{
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
