package p3;

import p2.Node;
import p2.Tree;

public class BinarySearchTree extends Tree {

	public BinarySearchTree() {
		super(null);
	}
	public BinarySearchTree(Node root) {
		super(root);
	}

	private boolean add(int i) {
		if(root==null) {
			root = new Node(i);
			return true;
		}
		if(i<(int)root.getData()) {
			BinarySearchTree temp = new BinarySearchTree(root.getLeft());
			temp.add(i);
			root.setLeft(temp.getRoot());
		}else {
			BinarySearchTree temp = new BinarySearchTree(root.getRight());
			temp.add(i);
			root.setRight(temp.getRoot());
		}
		return true;
	}

	private boolean delete(int i) {
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(100);
		tree.add(50);
		tree.add(75);
		tree.add(150);
		tree.add(125);
		System.out.println(tree.Preorder());
	}
}