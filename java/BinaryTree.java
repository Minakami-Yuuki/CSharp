import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/*
interface BinaryTTree {
	boolean isEmpty();
	int count();
	int height();
	BinaryNode<T> getRoot();
	BinaryNode<T> getParent(BinaryNode<T> node);
	void preOrder(BinaryTree<T> p);
	void inOrder(BinaryTree<T> p);
	void postOrder(BinaryTree<T> p);
	void insert();
	BinaryNode search(T element);
	void insert(BinaryNode<T> p, T element, boolean leftChild);
	void remove(BinaryNode<T> p, boolean leftChild);
	void clear;
}*/

//��������ڵ���
class BinaryNode<T> {
	public String data;		//��������
	public BinaryNode<T> left, right ;		//ָ�����Һ���
	
	public BinaryNode(String data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return "value = " + data + "\n" +"leftChild = " + left + "\n" + "rightChild = " + right ;
	}
	
	public String toString2() {
		return "Patent = " + data;
	}
}

public class BinaryTree<T> {
	protected static BinaryNode<String> root;
	public BinaryTree(BinaryNode<String> root) {
		BinaryTree.root = root;
	}
	//���ö�������㹹�캯�����������
	public static void main(String[] args) {
		BinaryTree<String> biTree = new BinaryTree<String>(root);
		BinaryNode<String> child_f, child_c, child_a, child_b, child_d;
		//��Ҷ�����ж���,��������������Ҷ�ඨ��
		child_d = new BinaryNode<String>("D", new BinaryNode<String>("H", null, null), null);
		//D��G�ĸ���,��G��D��������,Dû��������
		child_f = new BinaryNode<String>("F", null, null);
		//F��H�ĸ���,��H��F��������,Fû��������
		child_c = new BinaryNode<String>("C", child_f, new BinaryNode<String>("G", null, null));
		//C��E|F�ĸ���,��E��C��������,F��C��������
		child_b = new BinaryNode<String>("B", child_d, new BinaryNode<String>("E", null, null));
		//B��D�ĸ���,��D��B��������,Bû��������
		child_a = new BinaryNode<String>("A", child_b, child_c);
		//A��B|C�ĸ���,��B��A��������,C��A��������
		BinaryTree.root = child_a;
		//�����ܽ��Ϊ��A B C D E F G H ����ȫ������
		
		//����
		System.out.println("PreOrder:");
		biTree.preOrder(root);			//ǰ��
		System.out.println();
		
		System.out.println("InOrder:");
		biTree.inOrder(root);			//�и�
		System.out.println();
		
		System.out.println("PostOrder:");
		biTree.postOrder(root);			//���
		System.out.println("\n");
		
		//�������
		System.out.println("Caculate Count��" + biTree.count());
		
		//������������(�߶�)
		System.out.println("Caculate Depth��" + biTree.depth());
		
		System.out.println();
		
		//��������
		System.out.println("Search Value:");
		System.out.println(biTree.search(root, "H").toString() + "\n");
		
		//���Ҹ����
		System.out.println("Search Parent:");
		System.out.println(biTree.getParent(root, "H").toString2() + "\n");
		
		//��ʽջ�ǵݹ����������ȫ������
		System.out.print("prestack��");
		biTree.preStack();
		System.out.println();
		
		//��ʽջ�ǵݹ����������ȫ������
		System.out.print("instack��");
		biTree.inStack();
		System.out.println();
		
		//��ʽջ�ǵݹ����������ȫ������
		System.out.print("poststack��");
		biTree.postStack();
		System.out.println();
		
		//��ʽ���зǵݹ��α�����ȫ������
		System.out.print("LevelorderQueue:");
		biTree.Queue();
		System.out.println("\n");
		
		//����
		System.out.println("Insert Element:");
		System.out.println(biTree.insert(root.left.left, "I", false) + "\n");
		
		//ɾ���ڵ�
		System.out.print("Remove��");
		biTree.remove(root, true);
		System.out.println();
	}
	
	//�п�
		public boolean isEmpty() {
			return root == null;
		}
	
	//�ȸ����ʽ
	public void preOrder(BinaryNode<T> p) {
		if(p != null) {
			System.out.print(p.data + " ");
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	//�и����ʽ
	public void inOrder(BinaryNode<T> p) {
		if(p != null) {
			inOrder(p.left);
			System.out.print(p.data + " ");
			inOrder(p.right);
		}
	}
	//������ʽ
	public void postOrder(BinaryNode<T> p) {
		if(p != null) {
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data + " ");
		}
	}
	
	//���������
	public int count() {
		return count(root);
	}
	public int count(BinaryNode<String> p) {
		if(p != null) {
			 return 1 + count(p.left) + count(p.right);
		}
		else {
			 return 0;
		}
	}
	
	//������������(�߶�)
	public int depth() {
		return depth(root);
	}
	public int depth(BinaryNode<String> p) {
		if(p != null) {
			int leftdepth = depth(p.left);
			int rightdepth = depth(p.right);
			return (leftdepth >= rightdepth) ? leftdepth+1 : rightdepth+1;
		}
		else {
			return 0;
		}
	}
	
	//���Ҿ�����ֵ
	public BinaryNode<T> search(BinaryNode<T> p, String value) {
		BinaryNode<T> find = null;
		if(p != null && value != null) {
			if(p.data.equals(value)) {
				find =  p;
			}
			else {
				find = (BinaryNode<T>) search(p.left, value);
				if(find == null) {
					find = (BinaryNode<T>) search(p.right, value);
				}
			}
		}
		
		return find;
	}
	
	//���Ҹ����
	public BinaryNode<T> getParent(BinaryNode<T> p, String value) {
		BinaryNode<T> find = null;
		if(p != null) {
			if(p.data == value) {
				return null;
			}
			else if(p.left.data == value || p.right.data == value) {
				find = p;
			}
			else {
				find = getParent(p.left, value);
				if(find == null) {
					find = getParent(p.right, value);
				}
			}
		}
		
		return find;
	}
	
	//������
	public BinaryNode<T> insert(BinaryNode<T> p, String value, boolean leftChild) {
		if(p != null) {
			BinaryNode<T> q = new BinaryNode<T>(value, p.left, p.right);
			if(leftChild) {
				q.left = p.left;
				p.left = q;
			}
			else {
				q.right = p.right;
				p.right = q;
			}
		}
		return p;
	}
	
	//��ʽջ�ǵݹ����������ȫ������
	public void preStack() {
		Stack<BinaryNode<String>> stack = new Stack<BinaryNode<String>>();
		BinaryNode<String> p = root;
		while(p != null || !stack.isEmpty()) {
			if(p != null) {
				System.out.print(p.data + " ");
				stack.push(p);
				p = p.left;
			}
			else {
				System.out.print("^ ");
				p = stack.pop();
				p = p.right;
			}
		}
		System.out.println("^");
	}
	
	//��ʽջ�ǵݹ����������ȫ������
	public void inStack() {
		Stack<BinaryNode<String>> stack = new Stack<BinaryNode<String>>();
		BinaryNode<String> p = root;
		while(p != null || !stack.isEmpty()) {
			if(p != null) {
				stack.push(p);
				p = p.left;
			}
			else {
				p = stack.pop();
				System.out.print(p.data + " ");
				p = p.right;
			}
		}
		System.out.println();
	}
	
	//��ʽջ�ǵݹ���������ȫ������
	public void postStack() {
		Stack<BinaryNode<String>> stack = new Stack<BinaryNode<String>>();
		BinaryNode<String> p = root;
		while(p != null || !stack.isEmpty()) {
			if(p != null) {
				stack.push(p);
				p = p.left;
			}
			else {
				p = stack.pop();
				System.out.print(p.data + " ");
				p = p.right;
			}
		}
		System.out.println();
	}
	
	//���еķǵݹ��α���
	public void Queue() {
		if(BinaryTree.root == null) {
			return ;
		}
		LinkedBlockingQueue<BinaryNode<String>> que = new LinkedBlockingQueue<BinaryNode<String>>();
		que.add(root);
		while(!que.isEmpty()) {
			BinaryNode<String> p = que.poll();
			System.out.print(p.data + " ");
			if(p.left != null) {
				que.add(p.left);
			}
			if(p.right != null) {
				que.add(p.right);
			}
		}
	}
	
	//ɾ�����
	public BinaryNode<T> remove(BinaryNode<T> p, boolean leftChild) {
		if(p == null) {
			return null;
		}
		while (p != null) {
			if(leftChild) {
				p.left = null;
			}
			else {
				p.right = null;
			}
		}
		
		return p;
	}
}
