package com.kh.overriding;

import java.util.Scanner;

import com.kh.inheritance.model.parent.Product;
import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VipCustomer;

public class Apprication { 
	
	/*
	 * SOLID 의 o
	 * Open / Closed Principle (개방 - 폐쇄 원칙)
	 * - 기존 코드를 변경하지 않고 확장 가능하게
	 * 
	 */
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//이름
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		//일반 회원 vs VIP 인지
		System.out.print("일반 회원 or VIP 둘 중 하나 선택 : ");
		String grade = sc.nextLine();
		
		//가격
		System.out.print("가격 입력: ");
		int  price = Integer.parseInt(sc.nextLine());
		
		
		
		Customer customer5 = null;
		
		if(grade.equals("VIP"))
		{
			customer5 = new VipCustomer(name);
		}
		else {
			customer5 = new Customer(name);
		}
		customer5.calc(price);
		System.out.println(customer5);
		//Product 로 상품 연결
		Product product = new Product();
		product.setBrand("LG");
		customer5.setProduct(product);
		System.out.println(customer5.getProduct().getBrand());
		
		
		Customer customer1 = new Customer("서지은");
		customer1.calc(price);
		System.out.println(customer1);
		
		VipCustomer customer2 = new VipCustomer("김은진");
		customer2.calc(price);
		System.out.println(customer2);

		//동명이인은 없다고 가정
		Customer customer3 = new Customer("서지은");
		VipCustomer customer4 = new VipCustomer("김은진");
				
		boolean result3 = customer1.equals(customer3);
		boolean result4 = customer2.equals(customer4);
				
		System.out.println(result3);
		System.out.println(result4);
		// 100000
		//~님의 등급은 ~~이며. 지불해야하는 금액은 ~원이며, 적립된 포인트는 ~~점 입니다.
	}
}
