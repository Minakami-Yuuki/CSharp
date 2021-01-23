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
			System.out.println("文件复制成功");
			
			in.close();
			out.close();
		}catch (FileNotFoundException e2) {
			System.out.println("系统找不到指定文件");
			System.exit(-1);
		}catch (IOException e1) {
			System.out.println("文件复制错误");
			System.exit(-1);
		}
	}
}