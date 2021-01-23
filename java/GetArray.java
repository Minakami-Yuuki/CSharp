import java.util.Scanner;

public class GetArray {
	public static void main(String[] args) {
		Double[][] doubleArray = new Double[2][3];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				Scanner sc = new Scanner(System.in);
				double n = sc.nextDouble();
				doubleArray[i][j] = n;
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j =0; j < 3; j++) {
				System.out.println("doubleArray[" + i + "][" + j + "]" + "is " + doubleArray[i][j]);
			}		
		}
	}
}
