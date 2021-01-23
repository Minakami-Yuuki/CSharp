import java.util.Scanner;

public class GetArray2 {
	public static void main(String[] args) {
		System.out.println(getArray());
	}
	
	public static double[] getArray() {
		double[] doubleArray = new double[6];
		for(int i = 0; i < 6; i++) {
			Scanner sc = new Scanner(System.in);
			double n = sc.nextDouble();
			doubleArray[i] = n;
		}
		return doubleArray;
	}
}
