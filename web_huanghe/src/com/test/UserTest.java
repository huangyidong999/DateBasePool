package com.test;

import com.DAO.UserDao;
import com.bean.User;

public class UserTest {
	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		User user = new User("huangyidong","2923370475@qq.com","student","xuexiao","13093998958","���");
		int i = userdao.registUser(user);
		if(i>0){
			System.out.println("ע��ɹ�");
		}else{
			System.out.println("ע��ʧ��");
		}
	}
	
	}
