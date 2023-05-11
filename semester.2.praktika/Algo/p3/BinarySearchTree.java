package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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

	public boolean delete(int val) throws Exception {
		Node node = root;
		while (node != null) {
			int search = (int) node.getData();
			if (search == val) {
				return del(node);
			}
			if (search < val) {
				node = node.getLeft();
			} else {

				node = node.getRight();
			}
		}
		return false;
	}

	private boolean del(Node node) throws Exception {
		switch (node.getChildren()) {
		case 0:
			node = null;
			break;
		case 1:
			if (node.hasLeft()) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
			break;
		case 2:
			Node smallest = node.findMin();
			break;
		default:
			throw new Exception("error while deleting");
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(50, 125, 100, 75, 150, 151, 101, 149));
		BinarySearchTree tree = new BinarySearchTree();
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			int i = (Integer) iterator.next();
			tree.add(i);
			System.out.println("Inorder:" + tree.Inorder());
			System.out.println("Preorder:" + tree.Preorder());
			System.out.println("Postorder:" + tree.Postorder());
			System.out.println("-----------------");
		}
	}
}
