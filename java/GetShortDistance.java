import java.util.Scanner;

public class GetShortDistance {
	
	//cmd��д���������;
	public static double [][] getArray(int n){
		Scanner input = new Scanner(System.in);
		double[][] p = new double [n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				p[i][j] = input.nextDouble();
			}
		}
		return p;
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
		double [][] p = getArray(n);
		//�����뱣������ݶ���;
		
		//�жϸ��������ľ����Ƿ�Ϊ��̾���;
		//��������ѡ����̾�������ж�;
		int p1= 0, p2 =1;
		double shortDistance = distance(p[p1][0], p[p1][1], p[p1][2], p[p2][0], p[p2][1], p[p2][2]);
		for(int i =0; i < p.length; i++) {
			for(int j = i +1; j < p.length; j++) {
				double distance = distance(p[i][0], p[i][1], p[i][2], p[j][0], p[j][1], p[j][2]);
				if(shortDistance > distance) {
					p1 = i;
					p2 = j;
					shortDistance = distance;
				}
			}
		}
		
		/*import java.util.Scanner;

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
		System.out.print("�����ĸ�����");
		int n1 = input.nextInt();
		System.out.print("������ά�ȣ�");
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
*/
		System.out.println("�������������(" + p[p1][0] + ", " + p[p1][1] + ", " + p[p1][2] + ")��(" + p[p2][0] + ", " + p[p2][1] + ", " + p[p2][2] + ")");
		System.out.println("����֮��ľ���Ϊ��" + shortDistance);
	}
}