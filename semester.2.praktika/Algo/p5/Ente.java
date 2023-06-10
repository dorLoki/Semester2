package p5;

public class Ente {

	public Ente() {
		for (int i = 1; i < 11; i++) {
			for(int j = 1;j<11;j++) {
				System.out.print(brute(i, j)+"\t");
			}
			System.out.println();
		}
		System.out.println();
		printArray(ente(10, 10));
	}

	public static void main(String[] args) {
		new Ente();
	}

	private int brute(int length, int width) {
		return (int)bruteForce(0, 0, length, width);
	}

	private double bruteForce(int posX, int poxY, int length, int width) {
		if (posX == length - 1) {
			if (poxY == width - 1) {
				return 1;
			}
			return bruteForce(posX, poxY + 1, length, width);
		}
		if (poxY == width - 1) {
			return bruteForce(posX + 1, poxY, length, width);
		}
		return bruteForce(posX + 1, poxY, length, width) + bruteForce(posX, poxY + 1, length, width);

	}

	private double calc(int x) {
		return ((factorial(2 * x)) / (Math.pow(factorial(x), 2)));
	}

	private double factorial(int x) {
		double res = 1;
		for (double i = 1; i <= x; i++) {
			res = res * i;
		}
		return res;
	}

	private int[][] ente(int length, int width) {
		int[][] map = new int[length][width];
		for (int i = 0; i < length; i++) {
			map[i][0] = 1;
		}
		for (int i = 0; i < width; i++) {
			map[0][i] = 1;
		}
		for (int i = 1; i < length; i++) {
			for (int j = 1; j < width; j++) {
				map[i][j] = map[i-1][j]+map[i][j-1];
			}
		}
		return map;
	}
	
	private void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+"\t");
			}
			System.out.print('\n');
		}
	}
}
