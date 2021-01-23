public class IntArray {
	public static void main(String[] args) {
		String s[] = {"Microsoft", "IBM", "APPLE", "Sun", "Oracle"};
		String sbak[] = new String[6];
		System.arraycopy(s, 0, sbak, 0, s.length);
		
		for(int i = 0; i < sbak.length; i++) {
			System.out.print(sbak[i] + " ");
			//一维数组的拷贝;
		}
		
		System.out.println();
	
		int intArray[][] = {{1, 2}, {1, 2, 3}, {3, 4}};
		int intArraybak[][] = new int[3][];
		System.arraycopy(intArray, 0, intArraybak, 0, intArray.length);
		
		for(int i = 0; i < intArraybak.length; i++) {
			for(int j = 0; j < intArraybak[i].length; j++) {
				System.out.print(intArray[i][j] + " ");
			}
		}
		System.out.println();
	}
}