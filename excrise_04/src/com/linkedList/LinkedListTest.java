package com.linkedList;
import java.util.*;

public class LinkedListTest {
	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		List<String> b = new LinkedList<>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		// ע������û��Iterator ���� ListIterator  
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext()){
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		// ��b���ϵ�ÿһ���Ƴ�
		bIter = b.iterator();
		while(bIter.hasNext())
		{
			bIter.next(); // ������һ��
			bIter.remove();
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}
}
