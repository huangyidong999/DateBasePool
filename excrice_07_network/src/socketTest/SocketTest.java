package socketTest;

import java.io.*;
import java.net.*;
import java.util.*;

public class SocketTest {
	public static void main(String[] args) throws IOException {
		// ���ﴴ���׽��֣������˲�������������ת����IP��ַ�����Ͷ˿ں�13���׽��ֶ���Ϊs
		try(Socket s = new Socket("time-a.nist.gov", 13);
				// ���ｫ�׽��ֶ���s�ȵ���getInputStreamת������������
				// Ȼ���ٵ��������࣬����һ��UTF-8������������ in
				Scanner in = new Scanner(s.getInputStream(),"UTF-8");)
		{
			// ���in������һ�� �������
			while(in.hasNextLine()){
				String line = in.nextLine();
				System.out.println(line);
			}
		}
		
	}
}
