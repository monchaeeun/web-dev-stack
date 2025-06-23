package com.kh.practice2.view;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

// View : html, CSS, JavaScript
//첫번째 프로젝트 : JSP
//두번째 프로젝트 :  React
public class SnackView {

	Scanner sc = new Scanner(System.in);
	Snack snackData = new Snack();//자바 스크립트에서도 객체로 값을 한꺼번에 담아서 보냄
	
	String kind;
	String name;
	String flavor;
	int numOf;
	int price; 
	
	public void input() {
		
		
		System.out.println("스낵류를 입력하세요");
		System.out.print("종류 : ");
//		kind = sc.nextLine();
		snackData.setKind(sc.nextLine());
		System.out.print("이름 : ");
//		name = sc.nextLine();
		snackData.setName(sc.nextLine());
		System.out.print("맛 : ");
//		flavor = sc.nextLine();
		snackData.setFlavor(sc.nextLine());
		System.out.print("개수 : ");
//	    numOf = Integer.parseInt(sc.nextLine());
	  snackData.setNumOf(Integer.parseInt(sc.nextLine()));
		System.out.print("가격 : ");
//		price = Integer.parseInt(sc.nextLine());
		snackData.setPrice(Integer.parseInt(sc.nextLine()));
	}
	public void result() {
		SnackController snack = new SnackController();
		//System.out.println(snack.saveData(kind, name, flavor, numOf, price));
		System.out.println(snack.saveData(snackData));
		System.out.println(snack.confirmData());
	}
}
