package com.kh.step4;

public class CountThread implements Runnable{

	//InputThread 에서 숫자를 입력하면 카운트다운 그자리에서 종료 
	Application process;
	public CountThread(Application process)
	{
		this.process = process;
	}
	@Override
	public void run() {
		for(int i = 10; i > 0; i--)
		{
			if(process.check)break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		if(!process.check)
		{
			System.out.println("10초 경과! 값 입력 중지!");
			System.exit(0);
		}
	}

}
