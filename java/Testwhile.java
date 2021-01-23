public class Testwhile {
	public static void main(String[] args) {
		long i = 0;
		while(i < 10) {
			System.out.print(i);
			i++;
		}
		
		System.out.println("\n");
		
		i = 0;
		do {
			i++;
			System.out.print(i);
		} while(i < 10);
	}
}