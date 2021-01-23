public class TestEX {
	public static void main(String[] args) {
	  int [] arr = {1, 2 ,3};
		System.out.println(arr [2]);
		try {
			System.out.println(2 / 0);
		}
		catch (ArithmeticException ae) {
			System.out.println("系统正在维护，请尽快于管理员联系");
			//ae.printStackTrace();
		}
	}
}