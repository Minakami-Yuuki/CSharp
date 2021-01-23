//创建头节点
class Node {
    Node next =null;
    int data;
 
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedQueue {
	private Node front, rear;
	
	//创建两个头和尾指针
	public LinkedQueue() {
		this.front = this.rear = null;
	}
	
	public boolean isEmpty() {
		return this.front == null && this.rear == null;
	}
	
	//队列尾部插入元素
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
	
	//返回队首元素但不进行移除
	public int peek() {
		return this.isEmpty() ? null : this.front.data;
	}
	
	//返回队首元素并进行移除
	public int pop() {
		int x = this.front.data;
		this.front = this.front.next;
		if(this.front == null) {
			this.rear = null;
		}
		
		return x;
	}
	
	//从头指针处遍历打印整个队列
	public void printLink(){
		Node curNode = front;
   	while(curNode !=null){
			System.out.print(curNode.data+" ");
			curNode = curNode.next;
    	}
    System.out.println();
	}
   
  //验证
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