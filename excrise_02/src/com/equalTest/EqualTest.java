package com.equalTest;

import java.util.ArrayList;

public class EqualTest {
	/**public static void main(String[] args) {
		Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
		Employee bob = new Employee("Bob Brandson", 50000, 1987, 10, 1);
		if(alice1.equals(alice2)){
			System.out.println("����");
		}
	}**/
	public static void main(String[] args) {
		//ע����ArrayList�ķ���Ԫ�� ȡ��Ԫ�� ɾ��Ԫ�� �鿴��С��size���ķ���
		ArrayList<Employee> staff = new ArrayList<>();
	
		staff.add(new Employee("Carl Cracker",75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker",50000, 1989, 10, 15));
		staff.add(new Employee("Toner Tester",40000, 1990, 11, 15));
		
		
		
		for(Employee e : staff){
			e.raiseSalary(5);
		}
		
		for(Employee e:staff){
			System.out.println("name="+ e.getName());
		}
	}
}
