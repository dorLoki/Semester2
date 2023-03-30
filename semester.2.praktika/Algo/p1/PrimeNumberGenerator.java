package p1;

import java.util.LinkedList;
import java.util.ListIterator;

public class PrimeNumberGenerator {

	private static Boolean[] primeArray;
	private static LinkedList<Integer> primeList = new LinkedList<Integer>();
	private static LinkedList<Integer> luckyPrimeList = new LinkedList<Integer>();

	public PrimeNumberGenerator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// ******* Begrüßungstext ******** //
		System.out.println("*** Primzahlen-Generator -- Sieb des Eratosthenes ***\n");
		System.out.println(
				"Dieses Programm nutzt den nach Eratosthenes benannten \nAlgorithmus, um alle Primzahlen bis 100 zu ermitteln.\n");

		// ******* Implementierung mit Array ******** //

		// Kommentar
		System.out.println("Implementierung mit Array:");

		// Funktionsaufruf
		CreateArray();

		// Ausgabe der Primzahlen
		for (int i = 0; i <= 100; i++) {
			if (primeArray[i] == true) {
				System.out.print(i);
				System.out.print(", ");
			}

			// alternativ
			// System.out.print(primeArray[i] ? i+" " :"");
		}

		// ******* Implementierung mit LinkedList ******** //

		// Kommentar
		System.out.println("\n\nImplementierung mit LinkedList:");

		// Funktionsaufruf
		CreateLinkedList();

		// Ausgabe der Primzahlen
		System.out.println(primeList);

		// ******** Endezeile ******** //
		System.out.println("\n\n******************************************************\n");
		// TODO Auto-generated method stub

		// ******* Implementierung LuckyPrime mit LinkedList ******** //

		// Kommentar
		System.out.println("\n\nGluecklichen Primzahlen mit LinkedList:");

		// Funktionsaufruf
		lucky();

		// Ausgabe der Primzahlen
		System.out.println(luckyPrimeList);

		// ******** Endezeile ******** //
		System.out.println("\n\n******************************************************\n");
		// TODO Auto-generated method stub

	}

	// Implementierung mit Array
	private static void CreateArray() {

		// lege array mit 101 Elementen an (0-100)
		primeArray = new Boolean[101];

		// Initialisiere alle Elemente mit true
		for (int i = 0; i <= 100; i++)
			primeArray[i] = true;

		// Setze Elemente 0 und 1 auf false (keine Primzahlen)
		primeArray[0] = false;
		primeArray[1] = false;

		// Sieb des Eratosthenes
		for (int k = 2; k <= 100; k++) {
			if (primeArray[k] == true) {
				int currPrime = k;

				for (int i = 2; i * currPrime <= 100; i++)
					primeArray[i * currPrime] = false;
			}
		}
	}

	// Implementierung mit LinkedList
	private static void CreateLinkedList() {

		// Initialisieren Liste mit Zahlenb von 2-1000 (0 und 1 keine Primzahlen)
		for (int i = 2; i <= 1000; i++) {
			primeList.add(i);
		}
		// System.out.println("PrimeList:" + primeList);

		// Sieb des Eratosthenes
		for (int k = 0; k < primeList.size(); k++) {
			int currPrime = primeList.get(k);

			ListIterator<Integer> listIterator = primeList.listIterator(k);
			listIterator.next();

			while (listIterator.hasNext()) {
				if (listIterator.next() % currPrime == 0) {
					listIterator.remove();
				}
			}

			// System.out.println("Prime: " + currPrime + " PrimeList:" + primeList);
		}
	}

	private static void lucky() {
		// Initialisieren Liste mit Zahlen von 1-1000
		for (int i = 1; i <= 350; i++) {
			luckyPrimeList.add(i);
		}
		/*
		 * int i = 1;//schritt for (int j = 2; j < luckyList.size();) {
		 * ListIterator<Integer> listIterator = luckyList.listIterator();
		 * if(listIterator.hasNext()) { listIterator.next(); } listIterator.remove(); }
		 */
		ListIterator<Integer> listIterator = luckyPrimeList.listIterator();
		while (listIterator.hasNext()) {
			for (int i = 2; i > 0; i--) {
				if (listIterator.hasNext()) {
					listIterator.next();
				}
			}
			listIterator.remove();
		}
		int step = 1;
		boolean t = false;
		while (step < luckyPrimeList.size()) {
			listIterator = luckyPrimeList.listIterator();
			while (listIterator.hasNext()) {
				for (int i = luckyPrimeList.get(step); i > 0; i--) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}else {
						t = true;
					}
				}
				if(t) {
					t=!t;
				}else {
					listIterator.remove();
				}
			}
			step++;
		}
		luckyPrimeList.retainAll(primeList);
	}

}
