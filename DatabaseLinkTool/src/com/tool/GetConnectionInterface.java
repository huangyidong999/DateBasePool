package com.tool;

import java.sql.Connection;
/**
 * 
 * @author Lucifer
 * ����Ի�ȡ������ķ������г���
 *
 */
interface GetConnectionInterface {
	
	/**
	 * ������ݿ�����
	 * @return
	 */
	Connection getConnection();
	/**
	 * �ر����ݿ�������ز���
	 */
	void close();
}
