import java.util.Scanner;

public class TestLeapYear {
	public static void main(String[] args) {
		System.out.println("请输入年份：");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(LeapYear.isLeapYear(n)) {
			System.out.println(n + "年是闰年");
		 }
		 else {
		 	System.out.println(n + "年不是闰年");
		 }
	}
}
		
class LeapYear {
	public static boolean isLeapYear(int n) {
		return (n % 4 == 0 && n % 100 != 0) || (n % 100 == 0 && n % 400 == 0);
	}
}