import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DDate {
	public static void main(String[] args) {
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
    Calendar today = Calendar.getInstance();
    today.setTime(date);
		System.out.println("\n" + a.format(today.getTime()) + "\n");
    
    System.out.println(add1Day() + "\n");
    System.out.println(delete1Day() + "\n");
    System.out.println(addnDay() + "\n");
    System.out.println(deletenDay() + "\n");
}
	
	public static String add1Day() {
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 1);
		return 
		a.format(today.getTime());
	}
	
	public static String delete1Day() {
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
    Calendar today = Calendar.getInstance();
    today.add(Calendar.DATE, -1);
    return 
		a.format(today.getTime());
	}
	
	public static String addnDay() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, n);
		return 
		a.format(today.getTime());
	}
	
	public static String deletenDay() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -n);
		return 
		a.format(today.getTime());
	}
}