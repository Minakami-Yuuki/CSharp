public class TestEnum {
	public enum OpenDoor { me, mywife};
	
	public static void main(String[] args) {
		OpenDoor m = OpenDoor.mywife;
		switch(m) {
			case me:
			System.out.println("�ѿ���");
			break;
			case mywife:
			System.out.println("�ѿ���");
			break;
			default :
			System.out.println("�޷�ʶ�����");
		}
		
		System.out.println("���Ϊ��" + m);n
	}
}