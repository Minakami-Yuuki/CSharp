import java.io.*;

public class TestPrintStream2 {
	public static void main(String[] args) {
		String filename = args[0];
		if(filename != null) {
			list(filename, System.out);    //把filename放到System.out的命令行输出之中;
		}
	}
		
	public static void list(String f, PrintStream ps) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
			while ((s = br.readLine()) != null) {
				ps.println(s);
			}
			br.close();
		}catch(IOException e) {
			ps.println("无法读取文件");
			e.printStackTrace();
		}
	}
}