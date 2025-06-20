package com.kh.practice1;

import com.kh.practice1.model.UserInfo;

public class Application {
	public static void main(String[] args) {
		
		UserInfo user = new UserInfo();
		user.changeName("뭉뭉이");
		System.out.println(user.printName()); 
	}

}
