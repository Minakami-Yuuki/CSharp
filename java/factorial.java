public class factorial {
	public static void main(String [] args) {
		long a = 1;
		long result = 0;
		for(int i = 1; i <= 10; i++) {
			a *= i;
			result += a;
		}
		System.out.println("result =" + result);
	}
}