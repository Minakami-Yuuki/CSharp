public class TestOverlord {
	public static void main(String[] args) {
		Test p = new Test();
		Test p1 = new Test(23);
		Test p2 = new Test(23, 100);
	}
}

class Test {
	Test () {
		id = 0;
		age = 20;
	}
	
	Test (int _age) {
		id = 0;
		age = _age;
	}
	
	Test (int _id, int _age) {
		id = _id;
		age = _age;
	}
	
}