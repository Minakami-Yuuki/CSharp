import java.io.*;

public class TestWriter {
	public static void main(String[] args) {
		int a = 0;
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("d:/java/TestReader.java");
			out = new FileWriter("d:/java/TR.java");
			while ((a = in.read()) != -1) {
				out.write(a);
			}
			System.out.println("�ļ����Ƴɹ�");
			
			in.close();
			out.close();
		}catch (FileNotFoundException e2) {
			System.out.println("ϵͳ�Ҳ���ָ���ļ�");
			System.exit(-1);
		}catch (IOException e1) {
			System.out.println("�ļ����ƴ���");
			System.exit(-1);
		}
	}
}