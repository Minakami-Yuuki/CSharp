import java.io.*;

public class TestBufferStream1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("d:/java/TestBufferStream1.java");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int a = 0;
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.mark(100);
			for(int i = 0; i < 10 && (a = bis.read()) != -1; i++) {
				System.out.print(a + " ");
			}
			System.out.println();
			bis.reset();
			for(int i = 0; i < 10 && (a = bis.read()) != -1; i++) {
				System.out.print((char)a + " ");
			}
			bis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}