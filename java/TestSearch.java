public class TestSearch {
	public static void main(String[] args) {
		int a[] = {1, 2, 5, 6, 8, 15, 48, 98, 99};
		int i = 8;
		System.out.println(Search(a,i));
		System.out.println(binarySearch(a,i));
	}
	
	//普通排序查找;
	public static int Search(int a[], int num) {
		for(int i=0; i<a.length; i++) {
			if(a[i] == num) {
				return i;
			}
		}
		
		return -1;
	}
	
	//二分法居中查找;
	public static int binarySearch(int a[], int num) {
		if(a.length == 0) {
			return -1;
		}
		
		int startPos = 0;
		int endPos = a.length - 1;
		int m = (startPos + endPos) / 2;
		
		while(startPos <= endPos) {
			if(num == a[m]) {
				return m;
			}
			
			if(num > a[m]) {
				startPos = m + 1;
			}
			if(num < a[m]) {
				endPos = m - 1;
			}
			
			m = (startPos + endPos) / 2;
		}
		
		return -1;
	}
}