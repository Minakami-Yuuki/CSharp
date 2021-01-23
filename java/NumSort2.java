public class NumSort2 {    //doc冒泡排序;
	public static void main(String[] args) {
		int a[] = new int [args.length];
		for(int i = 0; i < args.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		
		print(a);
		selectionSort(a);
		print(a);
		
	}
	
	private static int[] selectionSort(int a[]) {
		int len = a.length;
		for(int i = 0; i <= len - 1; i++) {    //冒泡排序只需要n个数中n-1次;
			for(int j = 0; j < len - 1; j++) {
				if((a[j]) > (a[j+1])) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	
	private static void print(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}