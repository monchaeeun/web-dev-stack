package com.kh.socket2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattClient {

	public static void main(String[] args)
	{
		try {
			// 1. 소켓 생성				쌤 IP번호, 포트 번호
			Socket socket = new Socket("192.168.0.35", 3000);
			System.out.println("서버와 연결되었습니다..");
			
			SendThread send = new SendThread(socket);
			send.start();//	얘-> 를 버퍼로 받은 값(문자열처럼 한번에 출력) /얘-> 를 읽은 값(문자) /	SendThread에서 들어온 값
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//버터안에 내용이 없어질 때까지 실행
			while(br!=null)
			{
				// console 창에 출력
				System.out.println(br.readLine());
			}
			
			// 오류 발생
		} catch (UnknownHostException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("서버 종료!!");
		}
	}
}
