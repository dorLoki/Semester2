package p5;

public class Ente {

	public Ente() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		for(int i = 1;i<20;i++) {
			new Ente().brute(i, i);
		}
	}

	private int[][] map;

	private void brute(int i, int j) {
		map = new int[i][j];
		System.out.println(bruteForce(0, 0));
	}


	private int bruteForce(int m, int n) {
		if (m == map.length - 1) {
			if(n == map[0].length - 1) {
				return 1;
			}
			return bruteForce(m, n + 1);
		}
		if(n==map[0].length-1) {
			return bruteForce(m + 1, n);
		}
		return bruteForce(m + 1, n) + bruteForce(m, n + 1);
		
	}
	
	//dyn: entweder nachbarn aktuallisieren

}
