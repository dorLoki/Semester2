package p2;

public class TreeTesting {

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
