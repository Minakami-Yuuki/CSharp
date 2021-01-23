public class TestEnum {
	public enum OpenDoor { me, mywife};
	
	public static void main(String[] args) {
		OpenDoor m = OpenDoor.mywife;
		switch(m) {
			case me:
			System.out.println("已开门");
			break;
			case mywife:
			System.out.println("已开门");
			break;
			default :
			System.out.println("无法识别身份");
		}
		
		System.out.println("身份为：" + m);n
	}
}