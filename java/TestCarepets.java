interface Carepets {
	public void eat();
	public void play();
}

abstract class Name {
	private String name;
	Name(String name) {
		this.name = name;
	}
	public String getName(String name) {
		return name;
	}
}

class One implements Carepets{
	public void eat() { 
		System.out.println("sausage");
	}
	
	public void play() {
		System.out.println("lawn");
	}
}


public class TestCarepets {
	public static void main(String[] args) {
		Carepets c = new One();
		c.eat();
		c.play();
	}
}