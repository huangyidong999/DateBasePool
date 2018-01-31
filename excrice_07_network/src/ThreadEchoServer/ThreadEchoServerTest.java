package ThreadEchoServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ThreadEchoServerTest {
	public static void main(String[] args) {
		// �������������򣬷������׽��ֶ˿�����Ϊ8189
		try(ServerSocket s = new ServerSocket(8189))
		{
			// ��¼���ʵĿͻ�����
			int i = 1;
			while(true){
				// �������׽��� s �����׽��ּ���
				Socket incoming = s.accept();
				System.out.println("Spawning" + i);
				// Ϊ��ǰ���ӵ��׽��ֽ����̣߳�����߳��ܹ��������������
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
