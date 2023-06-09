package p5;

public class Dollar {
	public Dollar() {
		int[] array = { 2, 10, 15, 20, 25, 30 };
		for (int i : array) {
			long start = System.currentTimeMillis();
			System.out.println("f(" + i + ")=" + dollar(i) + "  \trec:" + count + "   \tZeit:"
					+ (System.currentTimeMillis() - start) + "ms");
		}
		for (int i : array) {
			long start = System.currentTimeMillis();
			System.out.println("f(" + i + ")=" + dollarDyn(i) + "  \trec:" + count + "   \tZeit:"
					+ (System.currentTimeMillis() - start) + "ms");
		}
	}

	private int count = 0;

	private int dollar(int n) {
		count = 0;
		return dollarTemp(n);
	}

	private int dollarTemp(int n) {
		count++;
		if (n <= 2) {
			return 1;
		}
		return dollarTemp(dollarTemp(n - 1)) + dollarTemp(n - dollarTemp(n - 1));
	}

	int[] res = new int[31];

	private int dollarDyn(int n) {
		count = 0;
		res = new int[n+1];
		res[1] = 1;
		res[2] = 1;
		return dollarDynTemp(n);
	}

	private int dollarDynTemp(int n) {
		count++;
		if (res[n] != 0) {
			return res[n];
		}
		int i = dollarDynTemp(dollarDynTemp(n - 1)) + dollarDynTemp(n - dollarDynTemp(n - 1));
		res[n] = i;
		return i;
	}

	public static void main(String[] args) {
		new Dollar();
	}
}
