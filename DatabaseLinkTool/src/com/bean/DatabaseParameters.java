package com.bean;
/**
 * 
 * @author Lucifer
 * �����ͨ��ʵ�����洢���ݿ���ز��� 
 * @param userName �û���
 * @param password ���ݿ�����
 * @param drivertype ���ݿ�����
 * @param url ���ݿ��ַ
 */
public class DatabaseParameters {
	@Override
	public String toString() {
		return "DatabaseParameters [userName=" + userName + ", passWord="
				+ passWord + ", drviertype=" + drviertype + ", url=" + url + "]";
	}
	//ȱ�ٹ�������������ж�
	private String userName;
	private String passWord;
	private String drviertype;
	private String url;
	public DatabaseParameters(){
		
	}
	public DatabaseParameters(String username,String password,String drviertype,String url){
		this.userName = username; this.passWord = password; this.drviertype = drviertype;
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getDrvierType() {
		return drviertype;
	}
	public void setDrvierType(String drvier) {
		this.drviertype = drvier;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
