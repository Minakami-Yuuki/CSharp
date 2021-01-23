public class Testdivision {
	public static void main(String[] args) {
		int num = 0; int i = 1;
		while(i < 100) {
			if(i % 3 ==0) {
				System.out.print(i + " ");
				num++;
			}
				if(num == 5) {
					break;
			}
			i++;
		}
	}
}