import java.util.Scanner;

public class PointArray {
	public static double [][] getArray(int n1, int n2){
		Scanner input = new Scanner(System.in);
		double[][] p = new double [n1][n2];
		for(int i = 0; i < n1; i++) {
			for(int j = 0; j < n2; j++) {
				p[i][j] = input.nextDouble();
			}
		}
		return p;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("输入点的个数：");
		int n1 = input.nextInt();
		System.out.print("输入点的维度：");
		int n2 = input.nextInt();
		double [][] p = getArray(n1,n2);
		for(int i = 0; i < n1; i++) {
			for(int j = 0; j < n2; j++) {
		    System.out.print(p[i][j] + " ");
		    if(j == 2) 
					System.out.println();
	    }
	  }
	}
}	