public interface Valuable {
	public double getMonkey();
}

interface Protectable {
	public void beProtectable();
}

interface A extends Protectable {
	public void m();
}

abstract class Animal {
	private String name;
	abstract void enjoy();
}

class GoldenMonkey extends Animal implements Valuable, Protectable {
	public double getMonkey() {
		return 10000;
	}
	
	public void beProtectable(){
		System.out.println("Live in the house.");
	} 
	
	public void enjoy() {
		
	}
	
	public void test() {
		Valuable v = new GoldenMonkey();
		v.getMonkey();
		Protectable p = (Protectable) v;
		p.beProtectable();
	}
	
}

class Hen implements A {
	public void beProtectable(){
		
	}
	
	public void m(){
		
		
	}
}

