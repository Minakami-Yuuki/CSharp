enum Student {
	С��(MALE),С��(FEMALE);
	}
	public void get(Student stu) {
		System.out.println(stu.name + "���Ա���" + stu.Sextype);
	}
}

public class TestStudent {
	public static void main(String[] args) {
		Student yi = new Student();
		Student er = new Student();
		yi.set("С��","MALE");
		er.set("С��","FEMALE");
		yi.get(yi);
		er.get(er);
	}
}