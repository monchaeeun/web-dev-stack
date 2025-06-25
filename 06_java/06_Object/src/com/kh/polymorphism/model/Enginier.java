package com.kh.polymorphism.model;

public class Enginier extends Employee{

	private String tech;
	private int bonus;
	
	
	public Enginier() {
	}
	
	public Enginier(String name, int salary,String tech, int bonus) {
		super(name, salary);
		this.tech = tech;
		this.bonus = bonus;
		
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	//재정의
	@Override
	public String toString() {
		return "Enginier [tech=" + tech + ", bonus=" + bonus + ", getName()=" + getName() + ", getSalary()="
				+ getSalary() + "]";
	}
	
	
	
	
	
}
