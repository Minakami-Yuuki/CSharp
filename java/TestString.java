public class TestString {
	public static void main(String[] args) {
		String s = "sljkdfjskdAGSDFHESFHDSGF23846237846237856!!!____skjdfhsijhf32432";
		int big = 0, small = 0, num = 0, others =0;

		/*
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//��һ�ַ���;
			if(c >= 'a' && c <= 'z') {
				small ++;
			}
			
			else if(c >= 'A' && c <= 'Z') {
				big ++;
			}
			
			else if(c >= '0' && c <= '9') {
				num ++;
			}
			
			else {
				others ++;
			}
		}
		*/
		
		/*
		//�ڶ��ַ���;
		String sL = "abcdefghijklmnopqrstuvwxyz";
		String sU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String sN = "0123456789";
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(sL.indexOf(c) != -1) {
				small ++;
			}
			
			else if(sU.indexOf(c) != -1) {
				big ++;
			}
			
			else if(sN.indexOf(c) != -1) {
				num ++;
			}
			
			else {
				others ++;
			}
		}
		*/
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLowerCase(c)) {
				small ++;
			}
			else if(Character.isUpperCase(c)) {
				big ++;
			}
			else if(Character.isDigit(c)) {
				num ++;
			}
			else {
				others ++;
			}
		}
		
		System.out.println("��д��ĸ��" + big);
		System.out.println("Сд��ĸ��" + small);
		System.out.println("���֣�" + num);
		System.out.println("������" + others);
	}
}