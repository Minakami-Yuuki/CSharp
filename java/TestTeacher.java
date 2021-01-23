class Person {
	private String name;
	private String location;
	
	Person(String name) {
		this.name = name;
		this.location = "Beijing";
	}
	
	Person(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public String info() {
		return "Name: " + name +
		"Location: " + location;
	}
}

class Teacher extends Person {
	private String capital;
	
	Teacher(String name, String capital) {
		this(name, "Beijing\t\t", capital);
	}
	
	Teacher(String n, String l, String capital) {
		super(n, l);
		this.capital = capital;
	}
	
	public String info() {
		return super.info() + "Capital :\t\t" + capital;
	}
} 

class Student extends Person {
	private String school;
	
	Student(String name, String school) {
		this(name, "Beijing\t\t", school);
	}
	
	Student(String n, String l, String school) {
		super(n, l);
		this.school = school;
	}
	
	public String info() {
		return super.info() + 
		"School :\t" + school;
	}
}

public class TestTeacher {
	public static void main(String[] args) {
		Person p1 = new Person("A\t");
		Person p2 = new Person("B\t", "Shanghai\t\t");
		Student s1 = new Student("C\t", "Tinghua Univerity");
		Student s2 = new Student("D\t", "Beijing\t\t", "Beijing Univerity");
		Teacher t1 = new Teacher("E\t", "Bachalor\t\t");
		Teacher t2 = new Teacher("F\t", "Shanghai\t", "Master");
		
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(t1.info());
		System.out.println(t2.info());
	}
}