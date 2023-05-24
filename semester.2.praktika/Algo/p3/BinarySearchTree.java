package p3;

import java.util.ArrayList;
import java.util.Arrays;

import p2.Node;
import p2.Tree;

public class BinarySearchTree extends Tree {

	public BinarySearchTree() {
		super(null);
	}

	public BinarySearchTree(Node root) {
		super(root);
	}

	public boolean insert(int value) {
		Node node = root;
		while (node != null) {
			if (value < (int) node.getData()) {
				if (node.getLeft() == null) {
					node.setLeft(new Node(value));
					return true;
				}
				node = node.getLeft();
			} else {
				if (value > (int) node.getData()) {
					if (node.getRight() == null) {
						node.setRight(new Node(value));
						return true;
					}
					node = node.getRight();
				} else {
					return false;
				}
			}
		}
		root = new Node(value);
		return true;
	}

	public boolean delete(int value) {
		if (root == null) {
			return false;
		}
		if (value == (int) root.getData()) {
			switch (root.getChildren()) {
			case 0:
				root = null;
				return true;
			case 1:
				if (root.hasLeft()) {
					root = root.getLeft();
				} else {
					root = root.getRight();
				}
				return true;
			case 2:
				Node min = findMinimumNode(root);
				root.setData((int) min.getData());
				root.setLeft(min.getRight());
				return true;
			}
		}
		Node node = root;
		Node prev = new Node();
		boolean left = false;
		while (node != null) {
			if (value < (int) node.getData()) {
				prev = node;
				left = true;
				node = node.getLeft();
			} else {
				if (value > (int) node.getData()) {
					prev = node;
					left = false;
					node = node.getRight();
				} else {
					switch (node.getChildren()) {
					case 0:
						if (left) {
							prev.setLeft(null);
						} else {
							prev.setRight(null);
						}
						return true;
					case 1:
						if (node.hasLeft()) {
							if (left) {
								prev.setLeft(node.getLeft());
							} else {
								prev.setRight(node.getLeft());
							}
							return true;
						}
						if (left) {
							prev.setLeft(node.getRight());
						} else {
							prev.setRight(node.getRight());
						}
						return true;
					case 2:
						Node min = findMinimumNode(node);
						if (left) {
							prev.getLeft().setData((int) min.getData());
							prev.getLeft().setLeft(min.getRight());
						} else {
							prev.getRight().setData((int) min.getData());
							prev.getRight().setLeft(min.getRight());
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	public void remove(int val) {
		if (root != null) {
			root = remove(root, val);
		}
	}

	private Node remove(Node node, int value) {
		if (node == null) {
			return null;
		}
		if (value < (int) node.getData())
			node.setLeft(remove(node.getLeft(), value));
		else if (value > (int) node.getData())
			node.setRight(remove(node.getRight(), value));
		else {
			if (node.getLeft() == null)
				return node.getRight();
			else if (node.getRight() == null)
				return node.getLeft();

			node.setData(findMinimumValue(node.getRight()));
			node.setRight(remove(node.getRight(), (int) node.getData()));
		}
		return node;

	}

	private int findMinimumValue(Node node) {
		int minValue = (int) node.getData();
		while (node.getLeft() != null) {
			minValue = (int) node.getLeft().getData();
			node = node.getLeft();
		}
		return minValue;
	}

	private Node findMinimumNode(Node node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public static void main(String[] args) {
		ArrayList<Integer> addList = new ArrayList<Integer>(Arrays.asList(50, 125, 100, 75, 150, 151, 101, 149, 149));
		ArrayList<Integer> delList = new ArrayList<Integer>(Arrays.asList(149, 50, 150, 75, 101, 100, 125, 151, 151));
		BinarySearchTree tree = new BinarySearchTree();
		// Adding
		addList.forEach((n) -> {
			System.out.println("Adding:" + n);
			tree.insert(n);
			System.out.println(tree.Inorder());
		});
		// Deleting
		delList.forEach((n) -> {
			System.out.println("Deleting:" + n);
			tree.delete(n);
			System.out.println(tree.Inorder());
		});
	}
}
