package com.CloneTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneEmployee implements Cloneable{
	private String name;
	private double salary;
	private Date hireDay;
	
	public CloneEmployee(String name, double salary){
		this.name = name;
		this.salary = salary;
		hireDay = new Date();
	}
	/**
	 * ������ǳ��¡��Ҫʵ��Cloneable �ӿ� ����дclone����
	 */
	public CloneEmployee clone() throws CloneNotSupportedException
	{
		// ����Object��clone()����
		CloneEmployee cloned = (CloneEmployee)super.clone();
		
		// ���û�н���Щ�ɱ��ʵ������п�¡����������ǳ��¡ �� clone�ɱ�� ��
		cloned.hireDay = (Date) hireDay.clone();
		
		return cloned;
	}
	
	public void serHireDay(int year, int month, int day){
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	public String toString(){
		return "Employee[name = " + name + ",salary = " + salary + ",hireDay = " + 
	 hireDay;
	}
}
