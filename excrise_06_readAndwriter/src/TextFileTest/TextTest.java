package TextFileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TextTest {
	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		// ������������
		staff[0] = new Employee("��һ��",10000);
		staff[1] = new Employee("���ⶫ",20000);
		staff[2] = new Employee("�����",30000);
		
		// д��ͨ��д������ д��staff������ �� �����PrintWriter�Լ��ڲ���ʵ��FileOutputStream
		try(PrintWriter out = new PrintWriter("Employee.dat","UTF-8"))
		{
			// ����WriteData �����ı�д������Ĵ�С���ٸ��������С�ֱ����WriteEmpolyee
			// ���ո�ʽд���������
			writeData(staff, out);
		} 
		
		// ͨ�������� Scanner������employee.dat��UTF-8��������  ������ʽ�ĵ�����
		// FileInputStream�� ��������� 
		try(Scanner in = new Scanner(new FileInputStream("employee.dat"),"UTF-8"))
		{
			// �������readData���ļ����������� �Ȼ�ȡ�ļ���һ�б���Ķ���������n����Ȼ����������һ��
			// ����readEmployeeÿ�ζ�ȡһ������ ѭ��n�� ÿ�α������ݵ�����newStaff��
			Employee[] newStaff = readData(in);
			
			for(Employee e:newStaff)
				System.out.println(e);
		}
	}
	
	private static void writeData(Employee[] employees, PrintWriter out)throws IOException{
		out.println(employees.length);
		
		for(Employee e:employees)
			writeEmployee(out, e);
	}
	
	public static void writeEmployee(PrintWriter out, Employee e){
		out.println(e.getName() + "|" + e.getSalary());
	}
	
	private static Employee[] readData(Scanner in){
		// �õ������С
		int n = in.nextInt();
		in.nextLine();
		
		Employee[] employees = new Employee[n];
		for(int i = 0; i < n; i++)
		{
			employees[i] = readEmployee(in);
		}
		return employees;
	}
	
	public static Employee readEmployee(Scanner in){
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		int salary = Integer.parseInt(tokens[1]);
		return new Employee(name, salary);
	}
}
