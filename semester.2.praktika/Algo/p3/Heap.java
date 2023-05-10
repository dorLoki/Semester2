package p3;

import p2.Tree;

public class Heap extends Tree {
	int[] keys = new int[100];
	int p = 1;

	public Heap() {
		super(null);
	}

	public boolean add(int i) {
		keys[p]=i;//TODO p>keys.length -> double keys array
		assureHeap(p);
		p++;
		return true;
	}

	private boolean assureHeap(int pos) {
		int parent = (pos-1)/2;
		if(parent == 0) {
			return true;
		}
		if(keys[parent]<keys[pos]) {
			int temp = keys[parent];
			keys[parent] = keys[pos];
			keys[pos] = temp;
			return assureHeap(parent);
		}
		return true;
	}

	public boolean delete(int i) {
		return false;
	}

	public static void main(String[] args) {
		Heap tree = new Heap();
		tree.add(50);
		tree.keys();
		tree.add(125);
		tree.keys();
		tree.add(100);
		tree.keys();
		tree.add(75);
		tree.keys();
	}

	private boolean keys() {
		for(int i = 1;i<keys.length;i++) {
			if(keys[i]!=0) {
				System.out.print(keys[i]+" ");
			}else {
				System.out.print("\n\n");
				return true;
			}
			if (((i+1) & i) == 0 && i != 0) {
				System.out.println("");
			}
		}
		System.out.print("\n");
		return true;
	}
}
