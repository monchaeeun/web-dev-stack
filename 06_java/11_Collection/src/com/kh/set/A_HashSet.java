package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.list.model.Person;

public class A_HashSet {
	/*
	 * Set 특징
	 *  - 중복 제거
	 *  - 순서 없음
	 * */
	public void method1() 
	{
		Set<String> s = new HashSet<String>();
		s.add("전현무");
		s.add("박나래");
		s.add("기안84");
		s.add("키");
		s.add("박나래"); // 여러 번 추가해도 중복 제거! 
		
		System.out.println(s);
		System.out.println("몇 명이 들어있나요? " + s.size());
		System.out.println("기안84가 포함되어 있나요? " + s.contains("기안84"));
		
		s.remove("박나래"); // 삭제
		System.out.println(s);
		
		s.clear(); // 전체삭제
		System.out.println("비어있는가? " + s.isEmpty());
	}
	public void method2() 
	{
		HashSet<Person> set = new HashSet<>();
		set.add(new Person("전현무","삼성동",47));
		set.add(new Person("박나래","이태원동",39));
		set.add(new Person("기안84","과천시",40));
		set.add(new Person("키","한남동",33));
		set.add(new Person("키","한남동",33));
		
		for(Person p : set)
		{
			System.out.println(p.getName());
		}
		System.out.println();
		/*
		 * Iterator
		 *  - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 *  - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 */
		Iterator<Person> it = set.iterator();
		
		while(it.hasNext())// 읽어올 요소가 있는지 확인
		{
			System.out.println(it.next());//박나래 - 다음 요소를 읽어옴
			System.out.println(it.next());//전현무
			System.out.println(it.next());//기안84
			System.out.println(it.next());//키	
		}
	}
	
	public static void main(String[] args)
	{
		A_HashSet a= new A_HashSet();
		//a.method1();
		a.method2();
	}
}
