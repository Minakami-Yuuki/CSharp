import java.util.*;
import java.util.ArrayList;


public class BasicGeneric {
	public static void main(String[] args) {
		List<String> c = new ArrayList<String>();
		c.add("aaa");
		c.add("bbb");
		c.add("ccc");
		for(int i = 0; i < c.size(); i++) {
			String s = c.get(i);
			System.out.println(s);
		}
		
		Collection<String> c2 = new HashSet<String>();
		c.add("aaa"); c.add("bbb"); c.add("ccc");
		for(Iterator<String> it = c2.iterator() ; it.hasNext();) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
/*
class MyName implements Comparable<MyName> {
	int age;
	
	public int compareTo(MyName nm) {
		if(this.age > nm.age) {
			return 1;
		}
		if(this.age < nm.age) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
*/