package ViewTest;
import java.util.*;
import java.util.Map.Entry;
public class ViewTest {
	public static void main(String[] args) {
		HashMap<Integer , String > hashmap = new HashMap<>();
		hashmap.put(1, "��һ��");
		hashmap.put(2, "���ⶫ");
		hashmap.put(3, "������");
		
		// ��ȡ����key
		Set<Integer> key = hashmap.keySet();
		Iterator a = key.iterator();
		while(a.hasNext()){
			System.out.print(a.next() + " ");
		}
		System.out.println(" ----------");
		// ��ȡֵ
		Collection<String> value = hashmap.values();
		Iterator b = value.iterator();
		while(b.hasNext()){
			System.out.print(b.next() + " ");
		}
		
		System.out.println("------------");
		// ���ؼ�ֵ��
		Set<Entry<Integer, String>> entry =   hashmap.entrySet();
		Iterator<Entry<Integer,String>> c = entry.iterator();
		while(c.hasNext()){
			Entry<Integer, String> entry1 = c.next();
			int i = entry1.getKey();
			String j = entry1.getValue();
			System.out.println(i+"  "+j);
		}
		
	}
}
