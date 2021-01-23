class Node<AnyType> {
    public  AnyType data;
    public  Node<AnyType> next;
    public Node(AnyType data,Node<AnyType> next){
        this.data=data;
        this.next=next;
    }
}

public class SinglyList1<AnyType> {

    //��Ԫ�ڵ�
    private Node<AnyType> first;

    //ͷָ��
    private Node<AnyType> head;

    //������
    int thesize;

    //��ʼ������
    public boolean initlist(){
        thesize=0;
        first=new Node<>(null,null);
        head=new Node<>(null,first);
        return true;
    }

    //�ж������Ƿ�Ϊ��
    public boolean isEmpty(){
        return thesize==0;
    }

    //��ȡ�ڵ�
    public Node<AnyType> getNode(int i){
        Node<AnyType> renode=head;
        for(int j=-2;j<i;j++){
            renode=renode.next;
        }
        return renode;
    }

    //��ĩβ���Ԫ��
    public void add(AnyType a){
        Node<AnyType> renode=new Node<>(a,null);
        getNode(thesize-1).next=renode;
        thesize++;
    }

    //ɾ��iλ�ýڵ㣬������ɾ��������
    public AnyType remove(int i){
        if(i==thesize-1){
            AnyType a=getNode(thesize-1).data;
            getNode(thesize-2).next=null;
            return a;
        }
        Node<AnyType> prev=getNode(i-1);
        AnyType a=prev.next.data;
        prev.next=prev.next.next;
        thesize--;
        return  a;
    }

    //��iλ�ò����½ڵ�
    public void insert(int i,AnyType a){
        Node<AnyType> prev=getNode(i-1);
        Node<AnyType> renode=new Node<>(a,prev.next);
        prev.next=renode;
        thesize++;
    }

    //��ȡiλ�ýڵ������
    public AnyType get(int i){
        return getNode(i).data;
    }

    //Ϊiλ��Ԫ�����¸�ֵ
    public void set(int i,AnyType a){
        getNode(i).data=a;
    }

    //��������ڵ����
    public int length(){
        return thesize;
    }

    //�������
    public void clear(){
        initlist();
    }

    //��ӡ����
    public void print(){
        for(int i=0;i<thesize;i++){
            System.out.println(getNode(i).data);
        }
    }

}