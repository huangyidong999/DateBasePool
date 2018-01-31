package com.equalTest;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	/**
	 * ��������дequals������
	 */
	public boolean equals(Object otherObject){
		// �����ж����object�Ƿ��thisһ����ַ
		if(this == otherObject )return true;
		
		// �����ʽ��object�ǿգ����뷵��false
		if(otherObject == null)return false;
		
		// Ӧ�÷��䣬���������ƥ�䣬���ǲ������
		if(this.getClass() != otherObject.getClass())return false;
		
		// ��������֪��������һ���յ�Employee
		Employee other = (Employee) otherObject;
		
		//�������ǵ�����Ϊ��һ����ֵ
		return Objects.equals(name, other.name) && salary == other.salary
				&& Objects.equals(hireDay,other.hireDay);
	}
	
	/**
	 * �����д��equals��Ҫ��дhashcode������Ϊ��ɢ�б�hashmap��
	 * Object �� hash ����������������������������غ��ʵ�hashֵ��
	 */
	public int hashCode(){
		return Objects.hash(name,salary,hireDay);
	}
	/**
	 * �Լ�дһ��toString����
	 */
	public String toString(){
		return getClass().getName() + "[name = " + name +",salaty=" + salary +",hireday"
				+hireDay + "]";
	}
}
