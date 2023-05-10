package p2;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	protected Node root;

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
		return root != null
				? " " + root.getData() + " " + new Tree(root.getLeft()).Preorder()
						+ new Tree(root.getRight()).Preorder()
				: "";
	}

	public String Inorder() {
		return root != null
				? new Tree(root.getLeft()).Inorder() + " " + root.getData() + " " + new Tree(root.getRight()).Inorder()
				: "";
	}

	public String Postorder() {
		return root != null
				? new Tree(root.getLeft()).Postorder() + new Tree(root.getRight()).Postorder() + " " + root.getData()
						+ " "
				: "";
	}

	public String Levelorder() {
		String res = "";
		int n = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			if ((n & (n - 1)) == 0 && n != 0) {
				res += '\n';
			}
			n++;
			Node temp = q.poll();
			if (temp != null) {
				res += " " + temp.getData();
				if (temp.getLeft() != null) {
					q.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.add(temp.getRight());
				}
			}
		}
		return res;
	}
}