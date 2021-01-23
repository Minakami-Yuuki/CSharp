public class caculate	{
	public static void main(String [] args)	{
		int i1 = 10; int i2 = 20;
		int i = (i2++);
		System.out.print("i=" + i);
		System.out.println("\ti2=" + i2);
		i = (++i2);
		System.out.print("i=" + i);
		System.out.println("\ti2=" + i2);
		i = (--i1);
		System.out.print("i=" + i);
		System.out.println("\ti1=" + i1);
		i = (i1--);
		System.out.print("i=" + i);
		System.out.println("\ti1=" + i1);
	}
}