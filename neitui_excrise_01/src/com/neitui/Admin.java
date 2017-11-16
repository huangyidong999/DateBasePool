package com.neitui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.WeakHashMap;

public class Admin {
	public Space A = new Space("A");
	public Space B = new Space("B");
	public Space C = new Space("C");
	public Space D = new Space("D");
	
	private static Admin single = null;
	//��Map�ӿ���ΪHashMap������
	private Map<User,Space> work = new HashMap();
	private Map<User,Space> weakwork = new WeakHashMap();
	
	//�����û��Ĺ���Ա���õ���ģʽ
	private Admin(){}
	public Admin getInstance()
	{
		if(single == null)
			single = new Admin();
		return single;
	}
	public boolean putUser(User aUser)
	{
		if(this.conflict(aUser)){
		work.put(aUser, aUser.getSpace());
		return true;
		}
		return false;
	}
	//����ӳ�䣬�������������ɾ��
	public void deleteUser(User aUser)
	{
		work.remove(aUser);
		weakwork.put(aUser, aUser.getSpace());
	}
	//������ͼ�������Ӽ����ж��Ƿ������������
	public boolean conflict(User aUser)
	{
		 Set<User> users = work.keySet();
		 for(User userTemp : users){
			 if(userTemp.getSpace().equals(aUser.getSpace()))
					 {
				 		if(userTemp.getaOrderTime().equals(aUser.getaOrderTime())){
				 			if(aUser.getBegin() < userTemp.getBegin()&& aUser.getEnd()<userTemp.getEnd())
				 				return false;
				 			if(userTemp.getBegin() < aUser.getBegin() && userTemp.getEnd() < aUser.getEnd())
				 				return false;
				 			if(userTemp.getBegin() < aUser.getBegin() && userTemp.getEnd()>aUser.getEnd())
				 				return false;
				 			if(aUser.getBegin() < userTemp.getBegin() && userTemp.getEnd() < aUser.getEnd())
				 				return false;
				 		}
					 }
		 }
		 return true;
	}
	public void userMoney(Space aSpace){
		SortedSet<User> sortA = new TreeSet<>();
		System.out.println("����"+aSpace.getName());
		for(Map.Entry<User, Space>entry : work.entrySet()){
			User userNow = entry.getKey();
			Space spaceNow = entry.getValue();
			if(userNow.getSpace().equals(aSpace)){
				//���ü��㷽�������ҵ���������Ӧ����money�ķ���
				int temp = Calculation.cal(userNow);
				userNow.setCost(temp);
				sortA.add(userNow);
				spaceNow.setAllMoney(temp);
			}
		}
		for(User a : sortA){
			System.out.println(a.getOrderTime()+" "+a.getTime()+" "+a.getCost());
		}
		System.out.println("С��" + aSpace.getName() +" "+aSpace.getAllMoney());
	}
	public static void main(String[] args) {
		Admin admin = new Admin();
		User aUser = new User(1,"2012-06-01",admin.A,false,"9:00~10:00");
		aUser.setaOrderTime();
		admin.putUser(aUser);
		admin.userMoney(admin.A);
	}
}
