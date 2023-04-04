package p2;

public class TreeTesting {

	private class Tree {
		private Node root;

		public Tree(Node root) {
			this.root = root;
		}

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}

		public String Preorder() {
			return root != null ? root.getData()+new Tree(root.left).Preorder()+new Tree(root.right).Preorder():"";
		}

		public String Inorder() {
			return null;
		}

		public String Postorder() {
			return null;
		}
	}

	private class Node {
		private String data;
		private Node left;
		private Node right;

		public Node() {

		}

		public Node(String data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public boolean hasLeft() {
			return left == null ? false : true;
		}

		public boolean hasRight() {
			return right == null ? false : true;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}
	}

	public TreeTesting() {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");

		Tree tree = new Tree(nodeE);

		nodeE.setLeft(nodeD);
		nodeE.setRight(nodeH);

		nodeD.setLeft(nodeB);

		nodeB.setLeft(nodeA);
		nodeB.setRight(nodeC);

		nodeH.setLeft(nodeF);

		nodeF.setRight(nodeG);

		System.out.println("Preorder:  " + tree.Preorder());
		System.out.println("Inorder:   " + tree.Inorder());
		System.out.println("Postorder: " + tree.Postorder());
	}
	
	public static void main(String[] args) {
		new TreeTesting();
	}

}
