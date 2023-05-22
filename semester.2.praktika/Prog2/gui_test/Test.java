package gui_test;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Test extends Canvas implements KeyListener {
	private static final long serialVersionUID = 5970183453607311898L;

	public Test() {
		this.addKeyListener(this);
		JFrame frame = new JFrame();
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setSize(getPreferredSize());
		frame.setVisible(true);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Test");
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new Test();
	}
}
