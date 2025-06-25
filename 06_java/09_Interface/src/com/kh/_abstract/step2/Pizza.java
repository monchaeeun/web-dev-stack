package com.kh._abstract.step2;

public abstract class Pizza {
	
	protected int price;
	protected String brand;
	
	public Pizza(int price, String brand) {
		
		this.price = price;
		this.brand = brand;
	}
	public abstract void getPrice();
	public void dough()
	{
		getPrice();
		System.out.println("피자 반죽과 함께 도우를 빚는다");
	}
	public abstract void topping();
	public void bake() {
		topping();
		System.out.println("피자를 180도에서 10분간 구운다.");
	}
	public void cutting() {
		System.out.println("피자를 8등분한다.");
	}
	public void pack() 
	{
		System.out.println("피자를 포장한다");
	}
	
}


