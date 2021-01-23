import java.io.*;

public class TestTransForm1 {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osu = new OutputStreamWriter (
			new FileOutputStream("d:/java/Transform.txt"));
			osu.write("Nintendo Switch");
			System.out.println(osu.getEncoding());    //getEncodingÊÇ×Ö·û±àÂë;
			osu.close();
			osu = new OutputStreamWriter (
			new FileOutputStream ("d:/java/Transform.txt" ,true) ,"ISO8859_1");
			osu.write("Mircosoft");
			System.out.println(osu.getEncoding());
			osu.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}