import java.io.*;

public class TestReader {
	public static void main(String[] args) {
		FileReader in = null;
		int a = 0;
		try {
			in = new FileReader ("d:/java/TestReader.java");
			int ln = 0;
			while((a = in.read()) != -1) {
				//char ch = (char) in.read();
				System.out.println((char) a);
				/*if(++ in > 100) {
					System.out.println();
					in = 0;
				}*/
			}
				
				in.close();
			}catch(FileNotFoundException e) {
				System.out.println("ϵͳ�Ҳ���ָ���ļ�");
				System.exit(-1);
			}catch(IOException e) {
				System.out.println("�ļ���д����");
				System.exit(-1);
		}
	}
}