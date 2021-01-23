class Node {
	Node next = null;
	Node prior = null;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedStack {
	private Node front, rear;
	
	public LinkedStack() {
		this.rear = null;
		this.front = null;
	}
	
	public boolean isEmpty() {
		return this.rear == null && this.front == null;
	}
	
	//��ջ
	public boolean add(int x) {
		Node p = new Node(x);
		if(this.front == null) {
			this.front = p;
		}
		else {
			this.rear.next = p;
		}
		this.rear = p;
		return true;
	}
	
	//��ջ����ɾ��
	public int peek() {
		return this.isEmpty() ? null : this.rear.data;
	}
	
	//��ջ��ɾ��
	public int pop() {
		int x = this.rear.data;
		this.rear = this.rear.next;
		if(this.front == null) {
			this.rear = null;
		}
		
		return x;
	}
	
	//ͷָ�������ӡ����ջ
	public void printLink(){
		Node curNode = front;
   	while(curNode != null){
			System.out.print(curNode.data+" ");
			curNode = curNode.next;
    	}
    System.out.println();
	}

//��֤
	public static void main(String[] args) {
		LinkedStack lk = new LinkedStack();

		lk.add(1);
		lk.add(2);
		lk.add(3);
		lk.add(4);
		lk.add(5);
		lk.printLink();
		
		System.out.println(lk.peek());
		lk.printLink();
		System.out.println(lk.pop());
		lk.printLink();
	}
}