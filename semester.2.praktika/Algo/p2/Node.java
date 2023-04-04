package p2;

public class Node {
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
	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}
}