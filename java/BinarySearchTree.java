
 public class BinarySearchTree<T extends Comparable<? super T>> {
 
     private static class BinaryNode<T> {
         T element;
         BinaryNode<T> left;
         BinaryNode<T> right;
 
         public BinaryNode(T element) {
             this(element, null, null);
          }
 
          public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
             this.element = element;
              this.left = left;
              this.right = right;
          }
  
          public String toString() {
              return element.toString();
          }
      }
  
      private BinaryNode<T> root;
  
      public BinarySearchTree() {
         root = null;
      }
  
      public void insert(T ele) {
          root = insert(ele, root);// 每次插入操作都会'更新'根节点.
      }
  
      private BinaryNode<T> insert(T ele, BinaryNode<T> root) {
          if (root == null)
             return new BinaryNode<T>(ele);
          int compareResult = ele.compareTo(root.element);
          if (compareResult > 0)
              root.right = insert(ele, root.right);
          else if (compareResult < 0)
              root.left = insert(ele, root.left);
          else
              ;
          return root;
      }
  
      public int height() {
          return height(root);
     }
  
     private int height(BinaryNode<T> root) {
          if (root == null)
             return -1;// 叶子节点的高度为0,空树的高度为1
  
          return 1 + (int) Math.max(height(root.left), height(root.right));
     }
  
      public int numberOfNodes(BinarySearchTree<T> tree){
        return nubmerOfNodes(tree.root);
     }
      
      //计算树中节点个数
     private int nubmerOfNodes(BinaryNode<T> root){
          int nodes = 0;
          if(root == null)
              return 0;
          else{
              nodes = 1 + nubmerOfNodes(root.left) + nubmerOfNodes(root.right);
          }
          return nodes;
     }
      
      
      public int numberOfLeafs(BinarySearchTree<T> tree){
          return numberOfLeafs(tree.root);
     }
     //计算树中叶结点的个数
      private int numberOfLeafs(BinaryNode<T> root){
         int nodes = 0;
         if(root == null)
          return 0;
         else if(root.left == null && root.right == null)
              return 1;
          else
              nodes = numberOfLeafs(root.left) + numberOfLeafs(root.right);
          return nodes;
      }
      
      public int numberOfFulls(BinarySearchTree<T> tree){
          return numberOfFulls(tree.root);
          // return numberOfLeafs(tree.root) > 0 ? numberOfLeafs(tree.root)-1 : 0;// n(2)=n(0)-1
      }
      //计算树中度为2的节点的个数--满节点的个数
      private int numberOfFulls(BinaryNode<T> root){
          int nodes = 0;
          if(root == null)
            return 0;
         else if(root.left == null && root.right == null)
             return 0;
         else if(root.left == null && root.right != null)
             nodes = numberOfFulls(root.right);
         else if(root.left != null && root.right == null)
            nodes = numberOfFulls(root.left);            
         else
             nodes = 1 + numberOfFulls(root.left) + numberOfFulls(root.right);
         return nodes;
     }
     
     
     public static void main(String[] args) {
         BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
         //double averHeight = intTree.averageHeigth(1, 6, intTree);
         //System.out.println("averageheight = " + averHeight);
         
         /*-----------All Nodes-----------------*/
         int totalNodes = intTree.numberOfNodes(intTree);
         System.out.println("total nodes: " + totalNodes);
         
         /*-----------Leaf Nodes-----------------*/
         int leafNodes = intTree.numberOfLeafs(intTree);
         System.out.println("leaf nodes: " + leafNodes);
         
         /*-----------Full Nodes-----------------*/
        int fullNodes = intTree.numberOfFulls(intTree);
         System.out.println("full nodes: " + fullNodes);
     }
 
     /*public double averageHeigth(int tree_numbers, int node_numbers, BinarySearchTree<Integer> tree) {
         int tree_height, totalHeight = 0;
         for(int i = 1; i <= tree_numbers; i++){
             int[] randomNumbers = C2_2_8.algorithm3(node_numbers);
             //build tree
             for(int j = 0; j < node_numbers; j++)
             {
                 tree.insert(randomNumbers[j]);
                 System.out.print(randomNumbers[j] + " ");
             }
             System.out.println();
             tree_height = tree.height();
             System.out.println("height:" + tree_height);
     
             totalHeight += tree_height;
 //            tree.root = null;//for building next tree
         }
     return (double)totalHeight / tree_numbers;
     }*/
 }