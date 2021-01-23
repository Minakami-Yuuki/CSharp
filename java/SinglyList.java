public class SinglyList<T> extends Object {
	public Node<T> head;																//����ͷָ�룬��ָ��ͷ���;
	
	public SinglyList() {														//���ع��췽��������������; O(1)
		this.head = new Node<T>();
	}
	
	public SinglyList(T[] values) {									//�ӿյ�����ĩβ����ֵ;
		this();																						//������һ�����췽��������ȡ���еĿ�����;
		Node<T> last = this.head;													//����һ��βָ��last����ĩβ��ͷ����ֵ;
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				last.next = new Node<T>(values[i], null);					//������ĩβ���뵱ǰvaluesֵ������lastĩָ���ƶ�ָ����һ�����;
				last = last.next;
			}
		}
	}
	
	//�ж������Ƿ�Ϊ��;
	public boolean isEmpty() {
		return this.head.next == null;
	}
	
	//��������;
	
	
	public static void main(String[] args) {
		for(int i = 0; i < values.length; i++) {
			System.out.println(values[i].data);
		}
	}
}

	//����������;
class Node<T> {
	public T data;								//�����򣬴������Ԫ��;
	public Node<T> next;					//��ַ�����ú�̽��;
	public Node(T date, Node<T> next) {				//���ع����㣬ʹ��ֱ�ָ��Ϊ����Ԫ�غͺ�̽��;
		this.data = data;
		this.next = next;
	}
	
	public Node() {				//Ĭ��Ϊ��;
		this(null, null);
	}
}