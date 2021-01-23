public class TestBubbleSort {
	public static void main(String[] args) {
		Date days[] = new Date[5];
		days[0] = new Date(2006, 5, 4);
		days[1] = new Date(2006, 7, 6);
		days[2] = new Date(2008, 5, 4);
		days[3] = new Date(2004, 5, 9);
		days[4] = new Date(2004, 5, 4);
		Date d = new Date(2006, 7, 6);
		
		bubbleSort(days);
		
		for(int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
		System.out.println();
		
		System.out.println(binarySearch(days, d));
	}
	
	public static int binarySearch(Date days[], Date d) {
		if(days.length == 0) {
			return -1;
		}
		
		int startPos = 0;
		int endPos = days.length - 1;
		int m = (startPos + endPos) / 2;
		
		while(startPos <= endPos) {
			if(d.compare(days[m]) == 0) {
				return m;
			}
			
			if(d.compare(days[m]) > 0) {
				startPos = m + 1;
			}
			if(d.compare(days[m]) < 0) {
				endPos = m - 1;
			}
			
			m = (startPos + endPos) / 2;
		}
		
		return -1;
	}
	
	public static void bubbleSort(Date days[]) {
		int len = days.length;
		for(int i = len - 1; i >= 1; i--) {
			for(int j = 0; j <= i - 1; j++) {
				if(days[j].compare(days[j+1]) > 0) {
					Date temp = days[j];
					days[j] = days[j+1];
					days[j+1] = temp;
				}
			}
		}
	}
}
	
class Date {
	int year, month, day;
	Date(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
		public int compare(Date date) {
		return year > date.year ? 1
		: year < date.year ? -1 
		: month > date.month ? 1
		: month < date.month ? -1
		: day > date.day ? 1
		: day < date.day ? -1
		: 0 ;
	}

	public String toString() {
		return "Year:Month:Day -- " + year + "-" + month + "-" + day;
	}
}