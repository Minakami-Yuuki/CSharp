public class TestSwitch {
	public static void main(String[] args) {
		int a = 4;
		switch(a) {
			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 9 :
				System.out.println("����");
				break;
			case 2 :
			case 4 :
			case 6 :
			case 8 :
			case 10 :
				System.out.println("ż��");
				break;
			default:
				System.out.println("�����ż��");
		}
	}
}