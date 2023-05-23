package p8;

public class RunIt implements Runnable {
	private Thread thread;

	public RunIt() {
		thread = new Thread(this);
		thread.setDaemon(false);
		// wenn daemon -> thread stirbt wenn main fertig mit sleep ist
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("ich lebe nocht!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
