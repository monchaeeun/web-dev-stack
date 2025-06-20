package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;


public class Application {
	
	public static void main(String[] args)
	{
		SnackController snack = new SnackController();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("스낵류를 입력하세요");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.println(snack.saveData(kind, name, flavor, numOf, price));
		
		System.out.println(snack.confirmData());
	}

}
