public class TestMethod {
		public static void main(String[] args) {
		m();
		int a = m1(4);
		int b = m2(3, 3);
		double f = m3(5);
		double d = m4(4, 6);
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);		
		System.out.println("f = "+ f);
		System.out.println("d = "+ d);
	}
	
	public static void m() {
		System.out.println("Hello");
		System.out.println("Welcome to my program.");
	}
	
	public static int m1(int i) {
		if(i<5) {
			return 1;
		}
		else {
			return 0;
		}
	}
		
	public static int m2(int i, int j) {
			if(i < j) {
				return 1;
			}
			else if(j < i) {
				return 2;
			}
			else {
				return 0;
			}
		}
		
	public static double m3(int i) {
  	 return (i*0.1);
		}
		
	public static double m4(int i, int j) {
			return (i*j*0.5);
		}
}