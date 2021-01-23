import java.io.*;

public class TestObjectIO {
	public static void main(String[] args) throws Exception {
		T t = new T();
		t.k = 8;
		FileOutputStream fos = new FileOutputStream("d:/java/TestObjectIO.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("d:/java/TestObjectIO.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T tReaded = (T) ois.readObject();
		System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.b + " " + tReaded.k);
		
	}
}

class T 
	implements Serializable {  //Serializabale  可进行序列化的;
		int i = 10;
		int j = 9;
		double b = 2.23;
		transient int k = 15;   //transient 透明化的;
}