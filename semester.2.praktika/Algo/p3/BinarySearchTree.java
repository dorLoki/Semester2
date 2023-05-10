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
		if (root == null) {
			root = new Node(i);
			return true;
		}
		if (i < (int) root.getData()) {
			BinarySearchTree temp = new BinarySearchTree(root.getLeft());
			temp.add(i);
			root.setLeft(temp.getRoot());
		} else {
			BinarySearchTree temp = new BinarySearchTree(root.getRight());
			temp.add(i);
			root.setRight(temp.getRoot());
		}
		return true;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(50);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(125);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(100);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(75);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(150);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(151);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(101);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
		System.out.println("-----------------");
		tree.add(149);
		System.out.println(tree.Levelorder());
		System.out.println("Inorder:" + tree.Inorder());
	}
}
