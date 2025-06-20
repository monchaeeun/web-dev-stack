package com.kh.practice1.model;

public class UserInfo {
	public int userNo;
	public String id;
	public String password;
	public String email;
	public String name;
	public String phone;
	public String addr;
	
//	public User_info(int userNo,String id, 
//			String password,String email, 
//			String phone,String addr) {
//		
//		this.userNo = userNo;
//		this.id = id;
//		this.password = password;
//		this.email = email;
//		this.name = name;
//		this.phone = phone;
//		this.addr = addr;
//	}
	public UserInfo(){}
	public void changeName(String name)
	{
		this.name = name;
	}
	public String printName()
	{
		return name;
	}
	

}
