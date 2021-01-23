public class TesttoString {
	public static void main(String[] args) {
		Dog d = new Dog();
		
		System.out.println("Dog :" + d);//.toString
	}
}

class Dog {
	public String toString() {
		return "I'm not a cat.";
	}
}