import java.util.Scanner;

public class PointArray2 {
	public static double [][] getArray(int n){
		Scanner input = new Scanner(System.in);
		double[][] a = new double [n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				//输入数组;
				a[i][j] = input.nextDouble();
			}
		}
		return a;
	}

	//计算两点间的距离;
	public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("输入点的个数");
		int n = input.nextInt();
		System.out.println("输入" + n + "个点的坐标：");
		double [][] a = getArray(n);

		//判断并找出输入坐标中距离最近的两个点;
		int b= 0, c =1;
		double shortDistance = distance(a[b][0], a[b][1], a[b][2], a[c][0], a[c][1], a[c][2]);
		for(int i =0; i < a.length; i++) {
			for(int j = i +1; j < a.length; j++) {
				double distance = distance(a[i][0], a[i][1], a[i][2], a[j][0], a[j][1], a[j][2]);
				if(shortDistance > distance) {
					b = i;
					c = j;
					shortDistance = distance;
				}
			}
		}
		System.out.println("间距最近的点是(" + a[b][0] + ", " + a[b][1] + ", " + a[b][2] + ")和(" + a[c][0] + ", " + a[c][1] + ", " + a[c][2] + ")");
		System.out.println("间距最近的点之间的最短距离为：" + shortDistance);
	}
}	
