import java.util.*;

public class TestRandom {
	public static void main(String[] args) {
		Random r = new Random();
		
		int number = r.nextInt(100) + 1;
		//���������
		
		while(true) {
		//ѭ���Ƚ���������������ֵ�Ƿ����	
			Scanner sc = new Scanner(System.in);
			System.out.println("��Ҫ�µ���ֵ(1-100):");
			int a = sc.nextInt();
			if(a > number) {
				System.out.println("�´���");
			}
			else if(a < number) {
				System.out.println("��С��");
			}
			else {
				System.out.println("�¶���");
				break;
				//�¶Ժ�����ѭ����������
			}
		}
	}
}