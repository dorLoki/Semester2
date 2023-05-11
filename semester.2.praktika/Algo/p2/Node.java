package p2;

public class Node {
	private Object data;
	private Node left;
	private Node right;

	public Node() {
	}

	public Node(String data) {
		this.data = data;
	}

	public Node(Integer data) {
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
	public void setData(int data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}

	public int getChildren() {
		int res = 0;
		if (hasRight()) {
			res++;
		}
		if (hasLeft()) {
			res++;
		}
		return res;
	}

	public int findMinVal() {
		int t = (int)data;
		if(hasLeft()) {
			int tl = left.findMinVal();
			t = tl<t?tl:t;
		}
		if(hasRight()) {
			int tr = right.findMinVal();
			t = tr<t?tr:t;
		}
		return t;
	}
	public Node findMin() {
		return null;
	}
}