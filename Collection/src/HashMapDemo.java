import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<Integer, Student> map = new HashMap<>();
		
		Student s1 = new Student("张三",2);
		Student s2 = new Student("李四",3);
		Student s3 = new Student("王二",4);
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()){
			int a = it.next();
			System.out.println(a);
			System.out.println(map.get(a));
		}
		System.out.println("\n");
		Set<Entry<Integer,Student>> entrySet = map.entrySet();
		for (Entry<Integer, Student> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
