package intAddress;

import java.io.*;
import java.net.*;
public class InetADdressTest {
	public static void main(String[] args) throws IOException {
		String[] t = new String[1];
		t[0] = "www.baidu.com";
		// �����������������������С �����ж�length��ʵûʲô����
		if(t.length > 0)
		{
			// ����������host��  Ȼ�����InetAddress�ľ�̬����getAllByName��������������е�IP��ַ
			// ��������һ��InerAddress���� address�� �� InerAddress��һ����װ4�ֽڵ����е���
			String host = t[0];
			InetAddress[] address = InetAddress.getAllByName(host);
			// ��������������˼�ģ����������������Ȼ����������������м���б�ָܷ�
			for(InetAddress a :address)
				System.out.println(a);
		}
		else
		{
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
