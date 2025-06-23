package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.view.SnackView;

// POJO 식 개발(Plain old Java Object)
public class Application {
	
	public static void main(String[] args)
	{
		SnackView view = new SnackView();
		view.input();
		view.result();
		
		
		
	}

}
