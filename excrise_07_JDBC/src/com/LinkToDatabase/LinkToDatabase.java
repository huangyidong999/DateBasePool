package com.LinkToDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * �������Ҫ�ǽ���������ӵ����ݿ� ��Ҫ���� ���� ���ݿ�URL �û��� ����
 * @author Lucifer
 *
 */
public class LinkToDatabase {
	public static void main(String[] args) {
		try {
			runTest();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void runTest() throws SQLException, IOException
	{
		Connection conn = getConnection(); 
		 Statement stat = conn.createStatement();
		 
		 stat.executeUpdate("CREATE TABLE Greetings(Message CHAR(20))");
		 stat.executeUpdate("INSERT INTO Greetings VALUES('hello world!')");
		 
		 ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
		 	if(result.next()){
		 		System.out.println(result.getString(1));
		 	}
		 	stat.executeUpdate("DROP TABLE Greetings");
	}
	
	public static Connection getConnection() throws SQLException,IOException
	{
		// ����ѡ�����ݿ������Ĳ���
		String drivers = "com.mysql.jdbc.Driver";
		// �������ݿ��URL �û��� �� ����
		String url="jdbc:mysql://127.0.0.1:3306/test_db";
		String user="root";
		String password="123456";
		
		return DriverManager.getConnection(url, user, password);
	}
}
