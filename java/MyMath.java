import java.util.Scanner;

public class MyMath {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Sum.getSum(n));
	}
}

class Sum {
	public static double getSum(int n) {
		double temp = 0;
		for(int i = 1; i <= n; i++){
			temp += i;
		}
		
		return temp;
	}
}