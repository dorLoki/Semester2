package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import p2.Tree;

public class Heap extends Tree {
	private int[] keys = new int[200];
	private int p = 1;
	private boolean minTree;

	public Heap(boolean minTree) {
		super(null);
		this.minTree = minTree;
		if (minTree) {
			Arrays.fill(keys, Integer.MAX_VALUE);
		} else {
			Arrays.fill(keys, Integer.MIN_VALUE);
		}
	}

	public boolean add(int i) {
		keys[p] = i;// TODO p>keys.length -> double keys array
		assureHeap(p);
		p++;
		return true;
	}

	private boolean assureHeap(int pos) {
		int parent = pos / 2;
		if (parent == 0) {
			return true;
		}
		if (minTree && keys[parent] > keys[pos] || !minTree && keys[parent] < keys[pos]) {
			int temp = keys[parent];
			keys[parent] = keys[pos];
			keys[pos] = temp;
			return assureHeap(parent);
		}
		return true;
	}

	public int delete() {
		int res = 0;
		if (p > 1) {
			p--;
			res = keys[1];
			keys[1] = keys[p];
			if (minTree) {
				keys[p] = Integer.MAX_VALUE;
			} else {
				keys[p] = Integer.MIN_VALUE;
			}
			assureHeapRoot();
			return res;
		}
		return -1;
	}

	private boolean assureHeapRoot() {
		int i = 1;
		int next = -1;
		if (!minTree) {
			next = keys[i * 2] < keys[i * 2 + 1] ? i * 2 + 1 : i * 2;
			while (keys[next] != Integer.MIN_VALUE) {
				if (keys[i] < keys[next]) {
					int temp = keys[next];
					keys[next] = keys[i];
					keys[i] = temp;
					i = next;
					next = keys[i * 2] < keys[i * 2 + 1] ? i * 2 + 1 : i * 2;
				} else {
					return true;
				}
			}
		} else {
			next = keys[i * 2] > keys[i * 2 + 1] ? i * 2 + 1 : i * 2;
			while (keys[next] != Integer.MAX_VALUE) {
				if (keys[i] > keys[next]) {
					int temp = keys[next];
					keys[next] = keys[i];
					keys[i] = temp;
					i = next;
					next = keys[i * 2] > keys[i * 2 + 1] ? i * 2 + 1 : i * 2;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Heap tree = new Heap(false);
		tree.levelorder();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(50, 125, 100, 75, 150, 151, 101, 149));
		// ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(150, 101, 151,
		// 149, 75, 100, 125, 50));
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			int i = (Integer) iterator.next();
			tree.add(i);
			System.out.println("Insert " + i + ":");
			tree.levelorder();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Delete " + tree.delete() + ":");
			tree.levelorder();
		}
	}

	private boolean levelorder() {
		if (p == 1) {
			System.out.println("\b");
		}
		for (int i = 1; i < keys.length; i++) {
			if (keys[i] != Integer.MAX_VALUE && keys[i] != Integer.MIN_VALUE) {
				System.out.print(keys[i] + " ");
			} else {
				System.out.print("\n\n");
				return true;
			}
			if (((i + 1) & i) == 0) {
				System.out.println("");
			}
		}
		System.out.print("\n" + "n:" + p + "\n");
		return true;
	}
	
	public void toTree() {
		
	}
}
