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
		if (nodes.length <= p) {
			Node[] temp = new Node[p * 2];
			for (int j = 0; j < p; j++) {
				temp[j] = nodes[j];
			}
			nodes = temp;
		}
		nodes[p] = new Node(i);
		if(p/2!=0) {
			if(p%2==0) {
				nodes[p/2].setLeft(nodes[p]);
			}else {
				nodes[p/2].setRight(nodes[p]);
			}
		}
		assureHeap(p);
		p++;
		return true;
	}

	private void assureHeap(int pos) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		HeapNew tree = new HeapNew(false);
		tree.Levelorder();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(50, 125, 100, 75, 150, 151, 101, 149));
		// ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(150, 101, 151,
		// 149, 75, 100, 125, 50));
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			int i = (Integer) iterator.next();
			System.out.println("Insert " + i + ":");
			tree.insert(i);
			tree.Levelorder();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Delete " + tree.remove() + ":");
			tree.Levelorder();
		}
	}
}
