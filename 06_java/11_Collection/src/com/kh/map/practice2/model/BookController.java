package com.kh.map.practice2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;



public class BookController {

	Book b = new Book();
	Member m = new Member();
	private ArrayList<Member> list = new ArrayList<Member>();
	private ArrayList<Integer> bookCount = new ArrayList<Integer>();
	
	//check -2값
	{
		for(int i = 0; i < 7; i++) {
			bookCount.add(0);
		}
	}
	
	
	
	
	String saveName = null;
	
	// 로그인 확인 메서드
	public boolean logIn(String name, int age) 
	{
//		list.add(new Member("채은",24, 0, null));			
		for(int i = 0; i < list.size() +1 ; i++)
		{
			if(list.size() != 0)
			{
				System.out.println(list.get(0).getName());
				System.out.println(list.get(0).getAge());
				//로그인 성공
				if(list.get(i).getName().equals(name)
					&&list.get(i).getAge() == age)
				{
					System.out.println("로그인에 성공하셨습니다");
					saveName = name;
					return true;
				}
				//이름은 있는데 나이가 다름
				else if(list.get(i).getName().equals(name)
						&&list.get(i).getAge() != age)
				{
					System.out.println("나이가 다릅니다.");
					return false;
				}//이름도 나이도 없음
				else if(!list.get(i).getName().equals(name)
						&& list.get(i).getAge() != age)
				{
					System.out.println("회원가입에 성공하셨습니다.");
					saveName = name;
					list.add(new Member(name,age, 0, null));
					return true;
				}
			}
			System.out.println("회원가입에 성공하셨습니다.");
			list.add(new Member(name,age, 0, null));
			saveName = name;
			return true;
		}
		System.out.println("오류");
		return false;
	}
	
	public void myPage() 
	{
		for(Member li : list)
		{
			if(li.getName().equals(saveName))
			{
				System.out.println(li);
			}
		}
	}
	public void rentalBook(int check) 
	{
		
	}
	
	
	public void logOut() 
	{
		saveName = null;
	}
}
