public class SinglyList<T> extends Object {
	public Node<T> head;																//创建头指针，并指向头结点;
	
	public SinglyList() {														//重载构造方法，创建空链表; O(1)
		this.head = new Node<T>();
	}
	
	public SinglyList(T[] values) {									//从空单链表末尾插入值;
		this();																						//引用另一个构造方法，即提取其中的空链表;
		Node<T> last = this.head;													//创建一个尾指针last，从末尾向开头传输值;
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				last.next = new Node<T>(values[i], null);					//在链表末尾放入当前values值，并将last末指针移动指向下一个结点;
				last = last.next;
			}
		}
	}
	
	//判断链表是否为空;
	public boolean isEmpty() {
		return this.head.next == null;
	}
	
	//插入数据;
	
	
	public static void main(String[] args) {
		for(int i = 0; i < values.length; i++) {
			System.out.println(values[i].data);
		}
	}
}

	//创建单链表;
class Node<T> {
	public T data;								//数据域，存放数据元素;
	public Node<T> next;					//地址域，引用后继结点;
	public Node(T date, Node<T> next) {				//重载构造结点，使其分别指定为数据元素和后继结点;
		this.data = data;
		this.next = next;
	}
	
	public Node() {				//默认为空;
		this(null, null);
	}
}