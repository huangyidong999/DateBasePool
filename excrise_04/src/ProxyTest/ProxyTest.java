package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
	public static void main(String[] args) {
		Object[] elements = new Object[1];
		
		for(int i = 0;i < elements.length;i++){
			Integer value = i+1;
			InvocationHandler handler = new TraceHandler(value);
			// ������ ������������������ �������  һ��Class��������   ����һ�����ô�����
			// �����null����������ʹ��Ĭ�����������  �ڶ������� ָ�������Ǵ�������Ҫʵ�ֵĽӿ�
			Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
			System.out.println("-------- :" + proxy.getClass().getName());
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length);
		int result = Arrays.binarySearch(elements, key);
		if(result >= 0) System.out.println(elements[result]);
	}
	
}
