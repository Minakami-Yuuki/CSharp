import java.util.Scanner;

public class TestScore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("学生成绩为：");
		int testScore = sc.nextInt();
		System.out.println("该学生成绩等级为：" + Demo1.getGrade(testScore));
		
	}
}

class Demo1 {
	public static char getGrade(int testScore) {
		if(testScore >= 90 && testScore < 100) {
			return 'A';
		}
		else if(testScore >= 80 && testScore < 90) {
			return 'B';
		}
		else if(testScore >= 70 && testScore < 80) {
			return 'C';
		}
		else if(testScore >= 60 && testScore < 70) {
			return 'D';
		}
		else {
			return 'E';
		}
	}
}