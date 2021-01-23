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
		
		Collections.shuffle(l1);    //�����������;
		System.out.println(l1);
		
		Collections.reverse(l1);
		System.out.println(l1);    //��������;
		
		Collections.sort(l1);    //����(һ���Ǵ�С����);
		System.out.println(l1);
		
		System.out.println(Collections.binarySearch(l1, "a5"));     //���ַ�����;
		
		l1.add(3, "a100");    //��3��λ�ò��� 'a100';
		System.out.print(l1 + " ");
		System.out.println();
		
		l1.add(6, "a200");    //��6��λ�ò��� 'a200';
		System.out.print(l1 + " ");
		System.out.println();
		
		System.out.println((String) l1.get(2) + " ");    //����ԭ������2λ�õ�Ԫ��;
		System.out.println(l1.indexOf("a4"));
		
		l1.remove(1);    //�Ƴ�1λ�õ�Ԫ��;
		System.out.println(l1);
	}
}