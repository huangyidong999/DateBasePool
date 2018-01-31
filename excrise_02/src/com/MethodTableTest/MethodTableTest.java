package com.MethodTableTest;
import java.lang.reflect.*;

/**
 * �������ʾ�����ͨ����������ɶ�����һ����ķ�������
 * @author Lucifer
 *
 */
public class MethodTableTest {
	public static double square(double x){
		return x*x;
	}
	
	public static void printTable(double from, double to, int n, Method f){
		System.out.println(f);
		double dx = (to -from) / (n - 1);
		
		for(double x = from; x <= to; x += dx){
			try{
				// �������������˷��������÷���f���·����Ѿ���÷������ģ������Ǿ�̬�������Ե�һ����������
				// Ϊnull�����������д���ڶ�������Ϊʵ�ʲ����б�
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f", x, y);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		try{
			// getMethod��һ����������Ҫ���õķ��������ڶ����������Ǹ�������Ҫ�Ĳ���(ע�⣡����ֻ�����ͣ�)
			Method square = MethodTableTest.class.getMethod("square", double.class);
			Method sqrt = Math.class.getMethod("sqrt", double.class);
			printTable(1,10,10,square);
			printTable(1,10,10,sqrt);
		}catch(Exception e){
			
		}
		
	}
}
