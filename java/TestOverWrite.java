class Person {
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getInfo() {
		return "Name: " + name + "\n" + "Age" + age;
	}
	
}

class Student extends Person {
	private String school;
	
	public void setSchool() {
		this.school = school;
	}
	
	public String getSchool() {
		return school;
	}
	
	public String getInfo() {
		return "Name: " + getName() + "\n" + "Age" + getAge();
	}
	
}

public class TestOverWrite {
	public static void main(String[] args) {
		
		Person person = new Person();
		Student student = new Student();
		
		person.setName("None");
		person.setAge(20);
		student.setName("NOBODY");
		student.setAge(18);
		
		System.out.println(person.getInfo());
		System.out.println(student.getInfo());
	}
}