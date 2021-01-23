class MyException extends Exception {
	private int id;
	public MyException(String message, int id) {
		super(message);
		this.id = id;
	}
	public int getId() {
		return id;
	}
}

public class TestThrows {
	public void register(int num) throws MyException {
		if(num < 0) {
			throw new MyException("����������", 408);
		}
	}
	
	public void Manager() {
		try {
			register(-100);
		}
		
		catch(MyException e) {
			System.out.println("�Ǽ�ʧ�ܣ����������� = " + e.getId());
			e.printStackTrace();
		}
		
		System.out.println("��������");
	}

  public static void main(String[] args) {
	  TestThrows t = new TestThrows();
	  t.Manager();
  }
}