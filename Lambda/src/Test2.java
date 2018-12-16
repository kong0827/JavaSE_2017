import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class Test2 {
	@Test
	public void test(){
		Comparator<String> com = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				int compare =o1.compareTo(o2);
				return compare;
			}
		};
		
		TreeSet<String> tree = new TreeSet<>(com);
		tree.add("a");
		tree.add("x");
		tree.add("tom");
		tree.add("d");
		tree.add("e");
		System.out.println(tree);
		
		
	}

}
