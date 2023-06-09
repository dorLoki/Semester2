package p4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sort {

	public Sort() {
		// aufgabe4_1();
//		try {
//			aufgabe4_2();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		int[] array = getRandomArray(1000);
		sleepSort(array);
		if(!checkSort(testArray)) {
			System.out.println("failed");
		}else {
			System.out.println("succes");
		}
		//printArray(array);
		//printArray(testArray);

	}

	public void aufgabe4_1() {
		int[] array = { 89, 72, 70, 17, 9, 51, 61, 4, 53, 16, 15, 35, 18, 45, 63, 92, 11, 1, 99, 74, 81, 53, 22 };
		// BubbleSort
		int[] temp = array.clone();
		long startTime = System.currentTimeMillis();
		long counter[] = bubbleSort(temp);
		long endTime = System.currentTimeMillis();
		printArray(temp);
		System.out.println("Zeit in Millisekunden: " + (endTime - startTime));
		System.out.println("Anzahl der Vergleiche für Bubblesort: " + counter[0]);
		System.out.println("Anzahl der Vertauschungen für Bubblesort: " + counter[1]);
		// selectionSort
		temp = array.clone();
		startTime = System.currentTimeMillis();
		counter = selectionSort(temp);
		endTime = System.currentTimeMillis();
		printArray(temp);
		System.out.println("Zeit in Millisekunden: " + (endTime - startTime));
		System.out.println("Anzahl der Vergleiche für SelectionSort: " + counter[0]);
		System.out.println("Anzahl der Vertauschungen für SelectionSort: " + counter[1]);
		// insertionSort
		temp = array.clone();
		startTime = System.currentTimeMillis();
		counter = insertionSort(temp);
		endTime = System.currentTimeMillis();
		printArray(temp);
		System.out.println("Zeit in Millisekunden: " + (endTime - startTime));
		System.out.println("Anzahl der Vergleiche für InsertionSort: " + counter[0]);
		System.out.println("Anzahl der Vertauschungen für InsertionSort: " + counter[1]);
		// sleepSort
		temp = array.clone();
		startTime = System.currentTimeMillis();
		counter = sleepSort(temp);
		endTime = System.currentTimeMillis();
		printArray(testArray);
		System.out.println("Zeit in Millisekunden: " + (endTime - startTime));
		System.out.println("Anzahl der Vergleiche für SleepSort: " + 0);
		System.out.println("Anzahl der Vertauschungen für SleepSort: " + testArray.length);
	}

	public void aufgabe4_2() throws IOException {
		BufferedWriter bf = new BufferedWriter(new FileWriter(new File("./test.txt")));

		System.out.println("----Vergleiche-----\nBubbleSort: \n1000 Elemente:");
		bf.append("----Vergleiche-----\nBubbleSort: \n1000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000);
			long startTime = System.currentTimeMillis();
			long counter[] = bubbleSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.flush();

		}
		bf.flush();
		System.out.println("\n10000 Elemente:");
		bf.append("\n10000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(10000);
			long startTime = System.currentTimeMillis();
			long counter[] = bubbleSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n100000 Elemente:");
		bf.append("\n100000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(100000);
			long startTime = System.currentTimeMillis();
			long counter[] = bubbleSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n1000000 Elemente:");
		bf.append("\n1000000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000000);
			long startTime = System.currentTimeMillis();
			long counter[] = bubbleSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\nSelectionSort: \n1000 Elemente:");
		bf.append("\nSelectionSort: \n1000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000);
			long startTime = System.currentTimeMillis();
			long counter[] = selectionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n10000 Elemente:");
		bf.append("\n10000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(10000);
			long startTime = System.currentTimeMillis();
			long counter[] = selectionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n100000 Elemente:");
		bf.append("\n100000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(100000);
			long startTime = System.currentTimeMillis();
			long counter[] = selectionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n1000000 Elemente:");
		bf.append("\n1000000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000000);
			long startTime = System.currentTimeMillis();
			long counter[] = selectionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\nInsertionSort: \n1000 Elemente:");
		bf.append("\nInsertionSort: \n1000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000);
			long startTime = System.currentTimeMillis();
			long counter[] = insertionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n10000 Elemente:");
		bf.append("\n10000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(10000);
			long startTime = System.currentTimeMillis();
			long counter[] = insertionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n100000 Elemente:");
		bf.append("\n100000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(100000);
			long startTime = System.currentTimeMillis();
			long counter[] = insertionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n1000000 Elemente:");
		bf.append("\n1000000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000000);
			long startTime = System.currentTimeMillis();
			long counter[] = insertionSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\nSleepSort: \n1000 Elemente:");
		bf.append("\nSleepSort: \n1000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000);
			long startTime = System.currentTimeMillis();
			long counter[] = sleepSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n10000 Elemente:");
		bf.append("\n10000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(10000);
			long startTime = System.currentTimeMillis();
			long counter[] = sleepSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n100000 Elemente:");
		bf.append("\n100000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(100000);
			long startTime = System.currentTimeMillis();
			long counter[] = sleepSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
		}
		bf.flush();
		System.out.println("\n1000000 Elemente:");
		bf.append("\n1000000 Elemente:");
		for (int i = 0; i < 3; i++) {
			int[] array = getRandomArray(1000000);
			long startTime = System.currentTimeMillis();
			long counter[] = sleepSort(array);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");
			bf.append(
					"\nVergleiche:" + counter[0] + " Aktionen:" + counter[1] + " Zeit:" + (endTime - startTime) + "ms");

		}
		bf.flush();
		bf.close();
	}

	public long[] bubbleSort(int[] arr) {
		long cntCompare = 0;
		long cntAction = 0;
		for (int n = arr.length; n >= 2; n--) {
			for (int i = 0; i <= n - 2; i++) {
				cntCompare++;
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					cntAction++;
				}
			}
		}
		long returnValues[] = { cntCompare, cntAction };
		return returnValues;
	}

	public long[] selectionSort(int[] arr) {
		long cntCompare = 0;
		long cntAction = 0;

		int idxInsert = 0;
		int idxMin;
		while (idxInsert < arr.length - 1) {
			idxMin = idxInsert;
			for (int i = idxInsert + 1; i < arr.length; i++) {
				cntCompare++;
				if (arr[i] < arr[idxMin]) {
					idxMin = i;
				}
			}
			cntAction++;
			int temp = arr[idxInsert];
			arr[idxInsert] = arr[idxMin];
			arr[idxMin] = temp;
			idxInsert++;
		}

		long returnValues[] = { cntCompare, cntAction };
		return returnValues;
	}

	public long[] insertionSort(int[] arr) {
		long cntCompare = 0;
		long cntAction = 0;

		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int j = i;
			while (j > 0) {
				cntCompare++;
				if (arr[j - 1] >= value) {
					cntAction++;
					arr[j] = arr[j - 1];
					j = j - 1;
				} else {
					break;
				}
			}
			cntAction++;
			arr[j] = value;
		}

		long returnValues[] = { cntCompare, cntAction };
		return returnValues;
	}

	public  long[] sleepSort(int[] arr) {
		pointer = 0;
		testArray = new int[arr.length];
		long cntCompare = 0;
		long cntAction = 0;
//		long t = System.nanoTime();

		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < arr.length; i++) {
			final int j = i;
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(arr[j] * 100); // eventuell höher stellen - 60ms für 1000 Threads starten
					test(arr[j]);
					System.out.println(arr[j]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			});
			threads.add(thread);
			thread.start();
		}
//		long t2 = System.nanoTime();
//		System.out.println(t2-t);
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long returnValues[] = { cntCompare, cntAction };
		return returnValues;
	}

	private int pointer = 0;
	private int[] testArray;

	public  void test(int i) {
		testArray[pointer] = i;
		pointer++;
	}synchronized

	public boolean checkSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// Hilfsfunktion zur formatierten Ausgabe des Arrays
	private void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(arr[i]);
		}
		System.out.println("");
	}

	// Hilfsfunktion zum zufälligen Befüllen eines Arrays
	// Zufallswerte zwischen 0 .. size
	private int[] getRandomArray(int size) {

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * arr.length);
		}
		return arr;
	}

	public static void main(String[] args) {
		new Sort();
	}

}
