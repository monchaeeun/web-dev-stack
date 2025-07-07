package com.kh.socket2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {

	Socket socket;
	Scanner sc = new Scanner(System.in);
	
	//ChattClient에 있는 socket 을 연결
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			//입 출력 ps 생성 getOutputStream : 내보냄
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			while(true) {
				//내가 작성한 내용 print
				ps.println(sc.nextLine());
				//flush() -> ps 비움
				//데이터를 강제로 내보냄
				ps.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}





