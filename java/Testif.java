public class Testif {
	public static void main(String [] args) {
		long a = 56;
		if (a < 20) {
			System.out.println("<20");
		}
		else if (a < 40) {
			System.out.println(">=20 && <40");
		}
		else if (a < 60) {
			System.out.println(">=40 && <60");
		}
		else {
			System.out.println(">=60");
		}
	}
}