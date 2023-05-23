package p8;

public class ThreadStarter {

	public ThreadStarter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		RunIt r = new RunIt();
		Thread.sleep(3000);
		System.out.println("main fertig");
	}

}
