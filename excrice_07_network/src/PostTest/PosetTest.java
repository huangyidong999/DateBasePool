package PostTest;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

/**
 * �� urlConnection ������֪������δӷ������ж�ȡ���ݣ����ν�������ν�����������POST����ʽ
 * ���͸�������
 * @author Lucifer
 *
 */
public class PosetTest {
	public static void main(String[] args) throws IOException {
		// ���ǿ���������û������������Ҫ�Ĳ��������û���ʹ� propertites�ļ��ж�ȡ
		String propsFilename = args.length > 0 ? args[0] : "post/post.properties";
		Properties props = new Properties();
		// �������� �����ļ����ļ�������propsFileName��
		try(InputStream in = Files.newInputStream(Paths.get(propsFilename)))
				{
					// ����������������
					props.load(in);
				}
		// ȡ�����ݣ�ɾ�� �洢�е� ��ע����ʲô���ݵ������ַ���
		String urlString = props.remove("url").toString();
		Object userAgent = props.remove("User-Agent");
		Object redirects = props.remove("redirects");
		// ���Ҫ��һ��
		CookieHandler.setDefault(new CookieManager (null,CookiePolicy.ACCEPT_ALL));
		// ��������������doPost����
		String result = doPost(new URL(urlString),props,
				userAgent == null ? null : userAgent.toString(),
				redirects == null ? -1 : Integer.parseInt(redirects.toString())
				);
		System.out.println(result);
	}
	
	// ����Ǻ��ģ������Լ�д��doPost����
	public static String doPost(URL url, Map<Object, Object>nameValuePairs, String userAgent,
			int redirects) throws IOException
	{
		// ��url����
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		// �������userAgent��Ϊ�� ��Ϊ�򿪵�URL���������ø�����
		
		if(userAgent != null)
			connection.setRequestProperty("User-Agent", userAgent);
		
		// ������ ���redirectsΪ�� �᷵��-1 �������������ж�redirects�����Ƿ�Ϊ�գ�������һ��
		// setInstanceFollowRedirects�ķ�����������δ����ض���true��ϵͳ�Զ�������ת�����Ƕ���
		// �ж����ת���������ֻ�ܴ����һ��  �� false�����Լ��ֶ�������ת�����ǿ����õ�һЩ�Ƚ����õ�����
		// ����cookie Location֮��ġ�
		
		if(redirects >= 0)
			connection.setInstanceFollowRedirects(false);
		
		// ΪURL���������׼�������������post���͵�����
		connection.setDoOutput(true);
		// ����һ������������õ� �ո� URL ���� connection������ͨ�������ǲ������������������
		try(PrintWriter out = new PrintWriter(connection.getOutputStream()))
		{
			// ����ͨ��һ�� first���͵Ĳ������ͱ����������Ƕ�Map���ϣ����ǲ������ģ���ѭ��ֻ�ܽ���
			// һ�Σ�����ͨ���������������ӳ���еĵ�һ�����ݵļ���ֵ��
			boolean first = true;
			// ��ȡ����ǰ���úõ�ӳ���ļ�
			for(Map.Entry<Object, Object> pair : nameValuePairs.entrySet())
			{
				if(first) first = false;
				else out.print('&');
				String name = pair.getKey().toString();
				String value = pair.getValue().toString();
				out.print(name);
				out.print('=');
				out.print(URLEncoder.encode(value, "UTF-8"));
			}
		}
		// ���Ƿ����˸�URL��ǰʹ�õı����ʽ
		String encoding = connection.getContentEncoding();
		if(encoding == null) encoding = "UTF-8";
		// ���˵������ض���
		if(redirects > 0)
		{
			// ��ȡhttp����Ӧ��  ��һ���� 301���������ƶ��� 302����ʱ�ƶ��� 303�ǲ鿴����λ��
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_MOVED_PERM
					|| responseCode == HttpURLConnection.HTTP_MOVED_TEMP
					|| responseCode == HttpURLConnection.HTTP_SEE_OTHER)
			{
				// ��ȡָ����Ӧͷ�ֶε�ֵ������ѡ����header�е�Location���Ե����ݣ��£�����
				// ��������ض����ض��ĵ�ַ����������á�
				String location = connection.getHeaderField("Location");
				if(location != null)
				{
					// �������´�URL ���µ���doPost����
					URL base = connection.getURL();
					connection.disconnect();
					return doPost(new URL(base, location),nameValuePairs, userAgent, redirects - 1);
				}
			}
		}
		else if(redirects == 0)
		{
			throw new IOException("Too many redircts");
		}
		StringBuilder response = new StringBuilder();
		// �����Ƕ�ȡURL�����connection�Ե�����
		try(Scanner in = new Scanner(connection.getInputStream(), encoding))
		{
			while(in.hasNextLine())
			{
				response.append(in.nextLine());
				response.append("\n");
			}
		}
		catch(IOException e)
		{
			// ���˵��ȡ�з����˴��󣬾���ӵ�response�ַ�����
			InputStream err = connection.getErrorStream();
			if(err == null)throw e;
			try(Scanner in = new Scanner(err))
			{
				response.append(in.nextLine());
				response.append("\n");
			}
		}
		return response.toString();
	}
}
