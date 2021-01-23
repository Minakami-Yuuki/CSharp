//����ͷ�ڵ�
class Node {
    Node next =null;
    int data;
 
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedQueue {
	private Node front, rear;
	
	//��������ͷ��βָ��
	public LinkedQueue() {
		this.front = this.rear = null;
	}
	
	public boolean isEmpty() {
		return this.front == null && this.rear == null;
	}
	
	//����β������Ԫ��
	public boolean add(int x) {
		Node q = new Node(x);
		if(this.front == null) {
			this.front = q;
		}
		else {
			this.rear.next = q;
		}
		this.rear = q;
		return true;
	}
	
	//���ض���Ԫ�ص��������Ƴ�
	public int peek() {
		return this.isEmpty() ? null : this.front.data;
	}
	
	//���ض���Ԫ�ز������Ƴ�
	public int pop() {
		int x = this.front.data;
		this.front = this.front.next;
		if(this.front == null) {
			this.rear = null;
		}
		
		return x;
	}
	
	//��ͷָ�봦������ӡ��������
	public void printLink(){
		Node curNode = front;
   	while(curNode !=null){
			System.out.print(curNode.data+" ");
			curNode = curNode.next;
    	}
    System.out.println();
	}
   
  //��֤
	public static void main(String[] args) {
		LinkedQueue qq = new LinkedQueue();
		
		qq.add(1);
		qq.add(2);
		qq.add(3);
		qq.add(4);
		qq.add(5);
		qq.printLink();
		
		System.out.println(qq.peek());
		qq.printLink();
		System.out.println(qq.pop());
		qq.printLink();
	}
}