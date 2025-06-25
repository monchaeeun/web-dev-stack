package com.kh.polymorphism;
import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

//FQCN(Full Qualified Class Name) 어떤 위치.클래스명
import com.kh.polymorphism.model.*;

public class Application {
	
	/*
	 * 다형성(Polymorphism)
	 * - 하나의 객체 변수가 여러가지 모양과 모습을 가지는 능력
	 * - 부모 타입으로 자식 객체를 생성하는 것
	 * 
	 * Liskov Substitution Principle, LSP
	 * - 부모 객체는 자식 객체로 교체해도 문제 없다.
	 * - 다형성이 제대로 설계되었는지 판단하는 기중 중 하나
	 * */
	public static void main(String[] args)
	{
		EmployeeController controller = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		//다형성
//		Employee em = new Employee("문채은",3000000);
//		Employee en = new Enginier("최다인",3500000,"자바",300000);
//		Employee ma = new Manager("김은진",4000000,"개발팀");
//		Employee se = new Secretary("전영현",4500000,"문채은");
		
//		System.out.println(em);
//		System.out.println(en);
//		System.out.println(ma);
//		System.out.println(se);
//		System.out.println();
		
		//다형성 + 객체 배열
//		Employee em = new Employee("문채은",3000000);
//		Employee en = new Enginier("최다인",3500000,"자바",300000);
//		Employee ma = new Manager("김은진",4000000,"개발팀");
//		Employee se = new Secretary("전영현",4500000,"문채은");
//		Employee[] emp = {em,en,ma,se};
		
//		for(Employee employee : emp)
//		{
//			System.out.println(employee);
//		}
		System.out.print("찾는 사람의 이름 입력 : ");
		String findName = sc.nextLine();
		
		Employee findInfo = controller.find(findName);
		
		//특정 자식 객체 찾는 방법!
		if(findInfo!=null) {
			//1. 이름으로 사람 찾기
			System.out.println("찾는 사람 : "+ controller.find(findName).getName());
			//2. 찾은 사람의 연봉은?		 
			System.out.println(controller.Salarys(findInfo));	
		}else
		{
			System.out.println("찾는 사람을 찾을 수 없습니다. ");
		}
		
		//3. 전체 총 월급
		System.out.println("총 월급 : " + controller.sumSalary(controller.getEmp())+ "원");
		
		
		
	}
}
