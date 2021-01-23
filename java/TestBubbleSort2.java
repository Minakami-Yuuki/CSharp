public class TestBubbleSort2 {
	public static void main(String[] args) {
		Date days[] = new Date[5];
		days[0] = new Date(2006, 5, 4);
		days[1] = new Date(2006, 7, 6);
		days[2] = new Date(2008, 5, 4);
		days[3] = new Date(2004, 5, 9);
		days[4] = new Date(2004, 5, 4);
		
		bubbleSort(days);
		
		for(int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
	}
	
	public static void bubbleSort(Date days[]) {
		int k;
		Date temp;
		for(int i = 0; i < days.length; i++) {
			k = i;
			for(int j = k + 1;j < days.length; j++) {
				if(days[k].compare(days[j]) > 0) {
					k = j;
				}
				
				if(k != i) {
					temp = days[k];
					days[k] = days[i];
					days[i] = temp;
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