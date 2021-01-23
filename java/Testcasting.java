class Animal {
	public String name;
	Animal(String name) {
		this.name = name;
	}
}
	
class Cat extends Animal {
	public String eyesColor;
	Cat (String n, String c) {
		super(n);
		eyesColor = c;
	}
}

class Dog extends Animal {
	public String furColor;
	Dog(String n, String c) {
		super(n);
		furColor = c;
	}
}

public class Testcasting {
	public static void main(String[] args) {
		Testcasting test = new Testcasting();
		Animal a = new Animal("name");
		Cat c = new Cat("BigYellow", "Yellow");
		Dog d = new Dog("SmallBlack", "Black");
		
		test.f(a);
		test.f(c);
		test.f(d);
	}

	public void f(Animal a) {
		System.out.println("Name = " + a.name);
	
		if(a instanceof Cat) {
			Cat cat = (Cat) a;
			System.out.println("\t" + cat.eyesColor + "eyes");
		}
	
		else if(a instanceof Dog) {
			Dog dog = (Dog) a;
			System.out.println("\t" + dog.furColor + "fur");
		}
	}
}


