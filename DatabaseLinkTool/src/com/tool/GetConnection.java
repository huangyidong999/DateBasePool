package com.tool;

import java.sql.Connection;

import com.bean.DatabaseParameters;
/** 
 * @author Lucifer
 * @version 1.0
 * @time 2017.9.8
 * ͨ������ɱ�֤��getconnection����ֻ�ܵ���һ��
 */
public class GetConnection {  
	private GetConnection(){
	}
	
	private static boolean valid = true;
	public static DatabaseParameters databaseparameters =  new DatabaseParameters();
	/**
	 * 
	 * @param par
	 * @return
	 * ������ݼ�������
	 */
	public static Connection getconnection(GetConnectionInterface par){ 
		if(valid){
			valid = false;
			return par.getConnection();
		}
		return null;
	}
}
