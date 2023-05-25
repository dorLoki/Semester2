package p4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, KeyListener {

	/**
	 * auto generated.
	 */
	private static final long serialVersionUID = -2498392265825225384L;

	private boolean FPSLock = true;

	private final int TickRate = 20;

	private boolean running;

	private int fps;

	private boolean ShowFPS = true;

	private Thread thread;

	JFrame frame;

	public Main() {
		this.addKeyListener(this);
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(900, 600));
		frame.setSize(getPreferredSize());
		frame.setVisible(true);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start();
		run();

	}

	public static void main(String[] args) {
		new Main();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		long ns = 1000000000 / 1;
		long now;
		while (running) {
			now = System.nanoTime();
			while(now+ns>System.nanoTime()) {
				
			}
			System.out.println("yes");
		}
		stop();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.red);

		g.dispose();
		bs.show();
	}

	private void tick() {
		// TODO Auto-generated method stub

	}
}
