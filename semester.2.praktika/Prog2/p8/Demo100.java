package p8;


public class Demo100 implements Runnable {
	Thread thread;

	public Demo100() {
		thread = new Thread(this);
		thread.start();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			new Demo100();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(thread.getId());
		}
		
	}
}
