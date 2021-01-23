
/*
�������;
*/
class Node {
    Node next =null;
    int data;
 
    public Node(int data) {
        this.data = data;
    }
}

/*
��������������ʼ��һ��ͷ���
*/
public class SingleLinkedList{
    Node head= null;
    
/*
������ͷ���������
*/
    public void addHead(int data){
        Node node = new Node(data);
        node.next=head;
        head=node;
    }
    
/*
������β���������
*/
    public void addLast(int data){
        Node node = new Node(data);
        Node temp = head;
 
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next=node;
    }
    
/*
������ĳ����������
*/
    public void insert(int index,int data){
        Node node = new Node(data);
        Node temp = head;
        if (index<0||index>length()){
            System.out.println("��λ���޶�Ӧ����");
        }
        else if(index==0){
            node.next=head;
            head=node;
        }
        else {
            for (int i=1;i<index;i++){
                temp=temp.next;
            }
            /*
            Node nextNode = temp.next;
            
            temp.next = node;
 
            node.next = nextNode;
            */
            
            node.next = temp.next;
            
            temp.next = node;
        }
    }
    
/*
ɾ����������
*/
    public void delete(int index){
        Node temp = head;
        if (index<0||index>length()){
            System.out.println("��λ���޶�Ӧ����");
        }else if(index==0){
            head=head.next;
        }
        else {
            for (int i=1;i<index;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }
    
/*
����
*/
		public void reverse() {
				Node p = head;
				Node front = null;
				Node q = null;
				while(p != null) {
					q = p.next;
					p.next = front;
					front = p;
					p = q;
				}
				this.head = front;
		}
    
/*
��ӡ
*/
    public void printLink(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.data+" ");
            curNode = curNode.next;
        }
        System.out.println();
    }

/*
����������
*/
    public int length(){
        int length=0;
        Node tmp = head;
        while (tmp!=null){
            length++;
            tmp=tmp.next;
        }
        return length;
    }

		public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        
        list.addHead(3);
        list.addHead(2);
        list.addHead(1);
        
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        
        list.printLink();
        
        list.insert(1,888);
        list.printLink();
        
        list.delete(1);
        list.printLink();
        
        list.reverse();
        list.printLink();
        
        System.out.println("������Ϊ��" + list.length());
 
    }
 
}
 

 
 
 
