package com.IComparator;

import java.util.Arrays;

public class IComparatorTest {
	public static void main(String[] args) {
		String[] friends = {"Peter", "Paul", "Mary"};
		// ע�����ʹ��Comparator�ӿڵ�ʱ������ɾ���Ƚϵ�ʱ��Ҫ����һ��ʵ����
		// ��������
		// Comparator<String>comp = new LengthCompartor();
		// if(comp.compare(words[i], words[j]) > 0) ... ... 
		Arrays.sort(friends, new LengthCompartor());
		
		System.out.println(friends[0] +"  " +friends[1]+"  " + friends[2]);
	}
}
