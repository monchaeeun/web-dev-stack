package com.kh.polymorphism.model;

public class EmployeeController {
	
	Employee em = new Employee("문채은",3000000);
	Employee en = new Enginier("최다인",3500000,"자바",300000);
	Employee ma = new Manager("김은진",4000000,"개발팀");
	Employee se = new Secretary("전영현",4500000,"문채은");
	Employee[] emp = {em,en,ma,se};

	//찾는 사람 인덱스
		public Employee find(String findName)
		{	
			for(Employee employee : emp)
			{
				if(employee.getName().equals(findName))
				{
					return  employee;
				}			
			}
			return null;
		}
	//연봉
		public int Salarys(Employee findInfo) {
			if(findInfo instanceof Enginier)
			{
				Enginier engineer = (Enginier)findInfo;
				return  engineer.getSalary() * 12;
			}
			else {
				return findInfo.getSalary();
			}
		}

	//총 원급 계산
	public int sumSalary(Employee[] emp) {
		int num = 0;
		for(Employee employee : emp)
		{
		  num += employee.getSalary();
		}
		return num;
	}
	public Employee[] getEmp() {
		return emp;
	}
	
	

}
