package p4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AsyncTest extends Canvas {

	private JFrame frame;

	private int size = 1600;

	private int[] array;

	public static void main(String[] args) {
		new AsyncTest();
	}

	private Thread sortThread;

	private Thread displayThread;

	private int[] arrayNumbers = { 89, 72, 70, 17, 9, 51, 61, 4, 53, 16, 15, 35, 18, 45, 63, 92, 11, 1, 99, 74, 81, 53,
			22 };

	public AsyncTest() {
		displaySetup();
		//array=arrayNumbers;
		shuffleArray();
		displayThread = display();
		displayThread.start();
		sortThread = bubblesort();
		sortThread.start();
	}


	private Thread bubblesort() {
		return new Thread(() -> {
			while (true) {
				long startTime = System.nanoTime();
				long sleepTime = 0;
				int n = array.length;
				boolean swapped;

				for (int i = 0; i < n - 1; i++) {
					swapped = false;

					for (int j = 0; j < n - i - 1; j++) {
						if (array[j] > array[j + 1]) {
							int temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
							swapped = true;
							long sleep = System.nanoTime();
							while (System.nanoTime() < sleep + 50000) {

							}
							sleepTime += 50000;
						}
					}
					if (!swapped) {
						break;
					}
				}
				long totalTime = System.nanoTime() - startTime;
				System.out.println("Sortierung abgeschlossen in " + (totalTime / 1000000) + " ms | Realtime:"
						+ ((totalTime - sleepTime) / 1000000) + "ms");
				//shuffleArray();
			}
		});
	}

	private Thread display() {
		return new Thread(() -> {
			while (true) {
				render();
			}
		});
	}

	private int scale = 3;

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		for(int i = 0; i<array.length;i++) {
			g.fillRect(100 + i, 900 - (array[i] / scale), 1, (array[i]) / scale);
		}
		g.dispose();
		bs.show();
	}

	private void shuffleArray() {
		array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		Random random = new Random();
		for (int i = size - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	private void displaySetup() {
		frame = new JFrame("SortVisualizer");
		frame.setSize(new Dimension(1800, 1000));
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.requestFocus();
	}
}