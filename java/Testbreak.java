public class Testbreak {
	public static void main(String[] args) {
		int stop = 4;
		for(int i=1; i<=5; i++) {
			if(i == stop) {
				break;
			}
			System.out.println("i = " + i);
		}
	}
}