package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ������ ������������������ ������� һ��Class�������� ����һ�����ô�����
 * ��Ϊ���ṩһ�����ô�������һ��ǰ�ᣬ����������ô�����������ʵ����InvocationHandler�ӿڵ������
 * �������ڴ���ʱ�򽫻��������Ĵ����������� proxy��������󣩣������������� m���Լ����������ݹ��� ����һ������ �� ���Ǵ���
 * ������������ʱ��������� �������Ǹ�1000����Ҫ���������Ȼ��ÿ�������궼���ö�̬�����newProxyInstance
 * ��ʵ���µ���Ĵ�����Ȼ�����½����ʱ��Ӧ����ʵ���� ����֮ǰ��������Comparable����
 * 
 * @author Lucifer
 *
 */
public class TraceHandler implements InvocationHandler {
	private Object target;
	public TraceHandler(Object t) {
		target = t;
	}

	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.println("." + m.getName() + "(");

		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1)
					System.out.println(", ");
			}
		}
		System.out.println(")");
		// �����ǵ����˷���invoke�����Ե����κη���
		return m.invoke(target, args);
	}
}
