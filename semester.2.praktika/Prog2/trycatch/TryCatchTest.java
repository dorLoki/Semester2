package trycatch;

public class TryCatchTest {

	public TryCatchTest() {
		// TODO Auto-generated constructor stub
	}
	public void test(int i) {
		if(i<10) {
			throw new RuntimeException("Die exception wird im gui behandelt!");
		}else {
			//mach etwas
		}
	}
	public void call_test() {
			test(9);
	}

	public static void main(String[] args) {
		TryCatchTest t = new TryCatchTest();
		t.call_test();
	}

}
