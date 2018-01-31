package uRLConnectionTest;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
/**
 * 
 * @author Lucifer
 * �ó�����Զ�URL������һЩʵ�顣���к�����������������һ��URL�Լ��û��������루��ѡ��
 * ���������
 * ��Ϣͷ�е����м���ֵ
 * һЩ�����ķ���ֵ
 * ��������Դ��ǰʮ����Ϣ
 */
public class URLConncetionTest {
	public static void main(String[] args) {
		
		try{
		String urlName;
		if(args.length > 0) urlName = args[0];
		else urlName = "http://www.baidu.com";
		
		URL url = new URL(urlName);
		// ������һ��URLConnection��������������������Դ֮�������
		URLConnection connection = url.openConnection();
		
		// �������֣����룬������������������Щ�Ļ�
		if(args.length > 2)
		{
			String username = args[1];
			String password = args[2];
			String input  = username + ":" +password;
			Base64.Encoder encoder = Base64.getEncoder();
			String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
			connection.setRequestProperty("Authorization", "Basic" + encoding);
		}
		// ��������connect����������Զ����Դ����ȡ��Ӧͷ��Ϣ
		connection.connect();
		
		// ���ͷ������
		
		// getHeaderFields������������Ӧ��һ��ӳ�����ͬ�ļ���Ӧ������ֵ������ͬһ���б���
		Map<String,List<String>> headers = connection.getHeaderFields();
		for(Map.Entry<String, List<String>> entry : headers.entrySet())
		{
			String key = entry.getKey();
			for(String value : entry.getValue())
				System.out.println(key + ": " +value);
		}
		// �Ϸ��ķ�����õ�������Ӧ�ı��ĵ�������Ϣ������Ϊ�˷����������Ҳ����ͨ�����÷��������
		// ��һЩ������Ϣ��ֵ�Ĳ鿴��
		System.out.println("-------------");
		System.out.println("getContentionType: " + connection.getContentType());
		System.out.println("getContentLength: " + connection.getContentLength());
		System.out.println("getContentEncoding: " + connection.getContentEncoding());
		System.out.println("getDate : " + connection.getDate());
		System.out.println("getExpirarion : " + connection.getExpiration());
		System.out.println("getLastModifed : " + connection.getLastModified());
		System.out.println("-------------");
		
		// ���ǻ�ȡ��Ӧ���ĵı������
		String encoding = connection.getContentEncoding();
		if(encoding == null) encoding = "UTF-8";
		// URLconnection�����getInputStream ���ش�URL��Դ��ȡ��Ϣ���� ͬ�� ���ǻ��и�д�����
		// �������Ƿ��ص���URL��Դ�� ����HTMLҳ��д������
		try(Scanner in = new Scanner(connection.getInputStream(),encoding)){
			// ���10 ��
			for(int n = 1 ;in.hasNextLine() && n <=10;n++)
				System.out.println(in.nextLine());
			if(in.hasNextLine()) System.out.println(" ... ");
		}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
