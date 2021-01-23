class Node {
	Node next = null;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}

public class TestLinkedList {
	Node head = null;
	
	//��
	public void addHead(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	//ɾ
	public void delete(int index) {
		Node node = head;
		if(index < 0 || index > length()) {
			System.out.println("�������ݷ�Χ��");
		}
		else if(index == 0) {
			node = node.next;
		}
		else {
			for(int i = 1; i < index; i++) {
				node = node.next;
			}
			node.next = node.next.next;
		}
	}
	
	//��
	public void insert(int index, int data) {
		Node node = new Node(data);
		Node p = head;
		if(index < 0 || index > length()) {
			System.out.println("�������ݷ�Χ��");
		}
		else if(index == 0) {
			node.next = head;
			head = node;
		}
		else {
			for(int i = 1; i< index; i++) {
				p = p.next;
			}
			
			node.next = p.next;
			p.next = node;
		}
	}
	
	//��
	public int search(int index) {
		Node p = head;
		if(index < 0 || index > length()) {
			System.out.println("�������ݷ�Χ��");
		}
		else {
			for(int i = 1; i< index; i++) {
				p = p.next;
			}
		}
		
		return (p.data);
	}
	
	//��ӡ
	public void print() {
		Node print = head;
		while(print != null) {
			System.out.print(print.data + " ");
			print = print.next;
		}
		System.out.println();
	}
	
	//���㳤��
	public int length() {
		int length = 0;
		Node tmp = head;
		while(tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	public static void main(String[] args) {
		TestLinkedList list = new TestLinkedList();
		
		list.addHead(2);
		list.addHead(3);
		list.print();
		
		list.delete(1);
		list.print();
		
		list.insert(0,1);
		list.print();
		
		list.search(1);
		list.print();
	}
}