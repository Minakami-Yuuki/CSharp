public class method{
	public static void main(String [] args){
		
		int i = 1;
		int j = 2;
		float f1 = 0.1f;
		float f2 = 123;
		long l1 = 12345678;
		long l2 = 8888888888L;
		double d1 = 2e20;
		double d2 = 124;
		byte b1 = 1;
		byte b2 = 2;
		int b3 = 129;
		j = j+10;
		i = i/10;
		i = (int)(i*0.1);
		char c1 = 'a'; char c2 = 12;
		
		byte b = (byte)(b1-b2);
		char c = (char)(c1+c2-1);
		float f3 = (float)f1+f2;
		float f4 = (float)(f1+f2*0.1);
		double d =d1*i+j;
		float f = (float)(d1*5+d2);
		System.out.println(b);
		System.out.println(c);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(d);
		System.out.println(f);

	}
}