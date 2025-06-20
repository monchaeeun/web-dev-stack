package com.kh.practice2.controller;

import java.util.Scanner;

import com.kh.practice2.model.Snack;

public class SnackController {
	Snack s = new Snack();
	Scanner sc = new Scanner(System.in);
	
	public String saveData(String kind, String name, 
			String flavor,int numOf,int price)
	{
		Scanner sc = new Scanner(System.in);
		
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);		
		
		return "저장되었습니다.";
	}
	public String confirmData() 
	{
		return s.kind + "(" + s.name + " - " + s.flavor + ") " + s.numOf + "개" + s.price +  "원";
	}

}
