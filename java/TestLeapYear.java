import java.util.Scanner;

public class TestLeapYear {
	public static void main(String[] args) {
		System.out.println("��������ݣ�");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(LeapYear.isLeapYear(n)) {
			System.out.println(n + "��������");
		 }
		 else {
		 	System.out.println(n + "�겻������");
		 }
	}
}
		
class LeapYear {
	public static boolean isLeapYear(int n) {
		return (n % 4 == 0 && n % 100 != 0) || (n % 100 == 0 && n % 400 == 0);
	}
}