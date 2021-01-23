import java.util.*;

public class TestContains {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("Hello");
		c.add(new Integer(100));
		c.add(new Name("f1", "l1"));
		c.add(new Name("f2", "l2"));
		c.add(new Name("f3", "l3"));
		c.add(new Name("ffff1", "llll1"));
		c.add(new Name("fff2", "lll2"));
		c.remove("Hello");
		c.remove(new Integer(100));
		System.out.println(c.remove(new Name("f1", "l1")));
		System.out.println();
		
		for(Iterator i = c.iterator(); i.hasNext();) {
			Name name = (Name) i.next();
			if(name.getFirstName().length() < 3) {
				i.remove();
			}
			System.out.println(c);
		}
		
		/*
		Iterator i = c.iterator();
		while(i.hasNext()) {
			Name n = (Name) i.next();
			System.out.println(n.getFirstName() + " " + n.getLastName());
		}
		System.out.println(c);
		*/
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