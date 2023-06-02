package p4;

public class Sort {

	public Sort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// Vorbelegung entsprechend Aufgabe 4.1
		int[] arrayNumbers = { 89, 72, 70, 17, 9, 51, 61, 4, 53, 16, 15, 35, 18, 45, 63, 92, 11, 1, 99, 74, 81, 53,
				22 };

		// Vorbelegung mit Zufallszahlen
		// int[] arrayNumbers = GetRandomArray(10000);

		// *** Bubblesort ***

		// Kopie anlegen
		int[] arrayBubble = arrayNumbers.clone();

		// Ausgabe vor Sortierung
		PrintArray(arrayBubble);

		// Stoppuhr starten
		long startTime = System.currentTimeMillis();

		// Sortieren
		long counter[] = BubbleSort(arrayBubble);

		// Stoppuhr stoppen
		long endTime = System.currentTimeMillis();

		// Ausgabe nach Sortierung
		PrintArray(arrayBubble);

		// Ausgabe Zeit und Zählungen
		System.out.println("Zeit in Millisekunden: " + (endTime - startTime));
		System.out.println("Anzahl der Vergleiche für Bubblesort: " + counter[0]);
		System.out.println("Anzahl der Vertauschungen für Bubblesort: " + counter[1]);

		// *** ... weitere Sortieralgorithmen ...

	}

	public static long[] BubbleSort(int[] arr) {

		long cntCompare = 0;
		long cntAction = 0;

		for (int n = arr.length; n >= 2; n--) {
			for (int i = 0; i <= n - 2; i++) {

				// Vergleichsoperationen zählen
				cntCompare++;

				if (arr[i] > arr[i + 1]) {

					// vertauschen
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;

					// Vertauschungen zählen
					cntAction++;

					// Zwischenstand nach jeder Umsortierung (Kommentar entfernen)
					// PrintArray(arr);
				}
			}
		}

		long returnValues[] = { cntCompare, cntAction };
		return returnValues;
	}

	// Hilfsfunktion zur formatierten Ausgabe des Arrays
	private static void PrintArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(arr[i]);
		}
		System.out.println("");
	}

	// Hilfsfunktion zum zufälligen Befüllen eines Arrays
	// Zufallswerte zwischen 0 .. size
	private static int[] GetRandomArray(int size) {

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * arr.length);
		}

		return arr;
	}

}
