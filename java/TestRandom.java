import java.util.*;

public class TestRandom {
	public static void main(String[] args) {
		Random r = new Random();
		
		int number = r.nextInt(100) + 1;
		//引入随机数
		
		while(true) {
		//循环比较随机数和输入的数值是否相等	
			Scanner sc = new Scanner(System.in);
			System.out.println("所要猜的数值(1-100):");
			int a = sc.nextInt();
			if(a > number) {
				System.out.println("猜大了");
			}
			else if(a < number) {
				System.out.println("猜小了");
			}
			else {
				System.out.println("猜对了");
				break;
				//猜对后跳出循环结束程序
			}
		}
	}
}