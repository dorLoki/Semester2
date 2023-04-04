package p2;

public class Tree {
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
		return root != null
				? root.getData() + new Tree(root.getLeft()).Preorder() + new Tree(root.getRight()).Preorder()
				: "";
	}

	public String Inorder() {
		return root != null ? new Tree(root.getLeft()).Inorder() + root.getData() + new Tree(root.getRight()).Inorder()
				: "";
	}

	public String Postorder() {
		return root != null
				? new Tree(root.getLeft()).Postorder() + new Tree(root.getRight()).Postorder() + root.getData()
				: "";
	}
}