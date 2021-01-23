public class TestVar3 {
	public static void main(String[] agrs) { 
		Date days[];
		days = new Date[3];
		
		for(int i = 0; i < 3; i++) {
			days[i] = new Date(2004, 4 , i + 1);
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
}