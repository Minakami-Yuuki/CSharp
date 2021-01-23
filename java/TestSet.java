import java.util.*;

public class TestSet {
	public static void main(String[] args) {
		Set s = new HashSet();
		s.add("Hello");
		s.add("World");
		s.add(new Name("f1", "l2"));
		s.add(new Integer(100));
		s.add(new Name("f1", "l2"));
		s.add("Hello");
		
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a"); s1.add("b"); s1.add("c");
		s2.add("d"); s2.add("a"); s2.add("b");
		Set sn = new HashSet(s1);    
		sn.retainAll(s2);        //retain表示求交集;
		Set su = new HashSet(s1);
		su.addAll(s2);        //addall表示将s2的全部元素添加到su中;
		
		System.out.println(sn);
		System.out.println(su);
		System.out.print(s);
	}
}

class Name {
	private String firstName, lastName;
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
		
		public boolean equals (Object obj) {
			if(obj instanceof Name) {
				Name name = (Name) obj;
				return (firstName.equals(name.firstName)) && (lastName.equals(name.lastName));
			}
			return super.equals(obj);
		}
		public int hashCode() {
			return firstName.hashCode();
		}
	}