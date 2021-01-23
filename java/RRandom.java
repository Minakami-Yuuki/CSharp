import java.util.Scanner;

public class RRandom {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		String a[] = new String[n];
		for(int i = 0; i < n; i++) {
			Scanner sc = new Scanner(System.in);
			a[i] = sc.nextLine();
		}
		for(int i = 0; i < n; i++) {3
			System.out.print(a[i]);
		}
		
		System.out.println();
		
		for(int j = n-1; j >= 0; j--) {
			System.out.print(a[j]);
		}
	}
}
