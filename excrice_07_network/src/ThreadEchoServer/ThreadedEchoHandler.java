package ThreadEchoServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ThreadedEchoHandler implements Runnable{
	private Socket incoming;
	
	public ThreadedEchoHandler(Socket incomingSocket)
	{
		incoming = incomingSocket;
	}
	
	public void run()
	{
		// ����׽��ֽ��ܺͷ��͵��������������  ����ȥ��д�õ�EchoServer
		try(InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream())
		{
			Scanner in = new Scanner(inStream, "UTF-8");
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(outStream, "UTF-8"),true);
			out.println("Hello! Enter BYE to exit.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
