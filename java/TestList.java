import java.util.*;

public class TestList {
	public static void main(String[] args) {
		List l1 = new LinkedList();
		List l2 = new LinkedList();
		for(int i = 0; i <= 5; i++) {
			l1.add("a" + i);
		}
		
		System.out.print(l1 + " ");
		System.out.println();
		
		Collections.shuffle(l1);    //随机乱序排列;
		System.out.println(l1);
		
		Collections.reverse(l1);
		System.out.println(l1);    //逆序排列;
		
		Collections.sort(l1);    //排序(一般是从小到大);
		System.out.println(l1);
		
		System.out.println(Collections.binarySearch(l1, "a5"));     //二分法查找;
		
		l1.add(3, "a100");    //在3的位置插入 'a100';
		System.out.print(l1 + " ");
		System.out.println();
		
		l1.add(6, "a200");    //在6的位置插入 'a200';
		System.out.print(l1 + " ");
		System.out.println();
		
		System.out.println((String) l1.get(2) + " ");    //查找原序列在2位置的元素;
		System.out.println(l1.indexOf("a4"));
		
		l1.remove(1);    //移除1位置的元素;
		System.out.println(l1);
	}
}