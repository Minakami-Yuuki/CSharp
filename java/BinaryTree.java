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

//二叉链表节点类
class BinaryNode<T> {
	public String data;		//定义数据
	public BinaryNode<T> left, right ;		//指向左右孩子
	
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
	//利用二叉树结点构造函数构造二叉树
	public static void main(String[] args) {
		BinaryTree<String> biTree = new BinaryTree<String>(root);
		BinaryNode<String> child_f, child_c, child_a, child_b, child_d;
		//树叶类自行定义,子树父树类由树叶类定义
		child_d = new BinaryNode<String>("D", new BinaryNode<String>("H", null, null), null);
		//D是G的父树,且G是D的右子树,D没有左子树
		child_f = new BinaryNode<String>("F", null, null);
		//F是H的父树,且H是F的左子树,F没有右子树
		child_c = new BinaryNode<String>("C", child_f, new BinaryNode<String>("G", null, null));
		//C是E|F的父树,且E是C的左子树,F是C的右子树
		child_b = new BinaryNode<String>("B", child_d, new BinaryNode<String>("E", null, null));
		//B是D的父树,且D是B的左子树,B没有右子树
		child_a = new BinaryNode<String>("A", child_b, child_c);
		//A是B|C的父树,且B是A的左子树,C是A的右子树
		BinaryTree.root = child_a;
		//构造总结点为：A B C D E F G H 的完全二叉树
		
		//遍历
		System.out.println("PreOrder:");
		biTree.preOrder(root);			//前根
		System.out.println();
		
		System.out.println("InOrder:");
		biTree.inOrder(root);			//中根
		System.out.println();
		
		System.out.println("PostOrder:");
		biTree.postOrder(root);			//后根
		System.out.println("\n");
		
		//计算个数
		System.out.println("Caculate Count：" + biTree.count());
		
		//计算二叉树深度(高度)
		System.out.println("Caculate Depth：" + biTree.depth());
		
		System.out.println();
		
		//查找数据
		System.out.println("Search Value:");
		System.out.println(biTree.search(root, "H").toString() + "\n");
		
		//查找父结点
		System.out.println("Search Parent:");
		System.out.println(biTree.getParent(root, "H").toString2() + "\n");
		
		//链式栈非递归先序遍历完全二叉树
		System.out.print("prestack：");
		biTree.preStack();
		System.out.println();
		
		//链式栈非递归中序遍历完全二叉树
		System.out.print("instack：");
		biTree.inStack();
		System.out.println();
		
		//链式栈非递归中序遍历完全二叉树
		System.out.print("poststack：");
		biTree.postStack();
		System.out.println();
		
		//链式队列非递归层次遍历完全二叉树
		System.out.print("LevelorderQueue:");
		biTree.Queue();
		System.out.println("\n");
		
		//插入
		System.out.println("Insert Element:");
		System.out.println(biTree.insert(root.left.left, "I", false) + "\n");
		
		//删除节点
		System.out.print("Remove：");
		biTree.remove(root, true);
		System.out.println();
	}
	
	//判空
		public boolean isEmpty() {
			return root == null;
		}
	
	//先根表达式
	public void preOrder(BinaryNode<T> p) {
		if(p != null) {
			System.out.print(p.data + " ");
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	//中根表达式
	public void inOrder(BinaryNode<T> p) {
		if(p != null) {
			inOrder(p.left);
			System.out.print(p.data + " ");
			inOrder(p.right);
		}
	}
	//后根表达式
	public void postOrder(BinaryNode<T> p) {
		if(p != null) {
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data + " ");
		}
	}
	
	//计算结点个数
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
	
	//计算二叉树深度(高度)
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
	
	//查找具体数值
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
	
	//查找父结点
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
	
	//插入结点
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
	
	//链式栈非递归先序遍历完全二叉树
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
	
	//链式栈非递归中序遍历完全二叉树
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
	
	//链式栈非递归后序遍历完全二叉树
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
	
	//队列的非递归层次遍历
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
	
	//删除结点
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
