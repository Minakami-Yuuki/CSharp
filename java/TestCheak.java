public class TestCheak {
	public static void main(String[] args) {
		String s = "gojavahijavanojavayesjavaaaaaaajavajavajava";
		String sToFind = "java";
		int count = 0;
		int index = -1;
		
		while((index = s.indexOf(sToFind)) != -1) {
			s = s.substring(index + sToFind.length());
			count ++;
		}
		
		System.out.println(count);
	}
}