package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import p2.Node;
import p2.Tree;

public class HeapNew extends Tree {
	boolean minTree = false;
	int p = 1;
	private Node[] nodes = new Node[2];

	public HeapNew(boolean minTree) {
		super(null);
	}

	private String remove() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean insert(int i) {
		if (p == 1) {
			Node n = new Node(i);
			nodes[p] = n;
			root = n;
			p++;
			return true;
		}
		if (nodes.length <= p) {
			Node[] temp = new Node[p * 2];
			for (int j = 0; j < p; j++) {
				temp[j] = nodes[j];
			}
			nodes = temp;
		}
		nodes[p] = new Node(i);
		if (p / 2 != 0) {
			if (p % 2 == 0) {
				nodes[p / 2].setLeft(nodes[p]);
			} else {
				nodes[p / 2].setRight(nodes[p]);
			}
		}
		assureHeap(p);
		p++;
		return true;
	}

	private boolean assureHeap(int pos) {
		int parent = pos / 2;
		while (nodes[parent] != null) {
			if (minTree && (int) nodes[parent].getData() > (int) nodes[pos].getData()
					|| !minTree && (int) nodes[parent].getData() < (int) nodes[pos].getData()) {
				int temp = (int) nodes[parent].getData();
				nodes[parent] = nodes[pos];
				nodes[pos].setData(temp);
				pos = parent;
				parent = parent / 2;
			} else {
				return true;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		HeapNew tree = new HeapNew(false);
		tree.Levelorder();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(50, 70));
		// ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(150, 101, 151,
		// 149, 75, 100, 125, 50));
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			int i = (Integer) iterator.next();
			System.out.println("Insert " + i + ":");
			tree.insert(i);
			System.out.println(tree.Levelorder());
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Delete " + tree.remove() + ":");
			System.out.println(tree.Inorder());
		}
	}
}
