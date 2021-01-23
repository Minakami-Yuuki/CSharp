import java.util.*;

public class TestStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack1 = new Stack<Character>();
		char c = 0;
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			stack1.push(c);
		}
		for(int i = 0; i < str.length(); i++)
			System.out.print(stack1.pop());
	}
}