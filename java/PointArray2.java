import java.util.Scanner;

public class PointArray2 {
	public static double [][] getArray(int n){
		Scanner input = new Scanner(System.in);
		double[][] a = new double [n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				//��������;
				a[i][j] = input.nextDouble();
			}
		}
		return a;
	}

	//���������ľ���;
	public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�����ĸ���");
		int n = input.nextInt();
		System.out.println("����" + n + "��������꣺");
		double [][] a = getArray(n);

		//�жϲ��ҳ����������о��������������;
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
		System.out.println("�������ĵ���(" + a[b][0] + ", " + a[b][1] + ", " + a[b][2] + ")��(" + a[c][0] + ", " + a[c][1] + ", " + a[c][2] + ")");
		System.out.println("�������ĵ�֮�����̾���Ϊ��" + shortDistance);
	}
}	
