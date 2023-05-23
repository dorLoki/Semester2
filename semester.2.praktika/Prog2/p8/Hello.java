package p8;

public class Hello implements Runnable{

	private String text;
	private Thread thread;
	public Hello(String text) {
		this.text = text;
		this.thread = new Thread(this);
	}
	public static void main(String[] args) {
		Hello cat = new Hello("miau miau");
		Hello dog = new Hello("wuff wuff");
		cat.start();
		dog.start();
	}
	private void start() {
		thread.start();
		
	}
	public void printText() {
		System.out.println(text);
	}
	@Override
	public void run() {
		while(true) {
			printText();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
