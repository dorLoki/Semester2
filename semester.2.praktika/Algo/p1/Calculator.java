package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * UPN-Calculator Calculator zur Berechnung einfacher mathematischer Ausdrücke
 * in umgekehrter polnischer Notation (UPN)
 * 
 * @author Tina Geweniger
 * @version 1.0
 */

public class Calculator {

	// Attribute
	private String strAufgabe = "";
	private int iResult;
	private String strError;

	/**
	 * Konstruktor zum Anlegen eines Calculator-Objektes
	 * 
	 * @param aufgabe zu lösende Aufgabe im UPN-Format (einstellige antürliche
	 *                Zahlen, Grundrechenarten +,-,*,/, keine Trennzeichen)
	 */
	public Calculator(String aufgabe) {
		this.strAufgabe = aufgabe;
		this.iResult = 0;
		this.strError = "";
	}

	/**
	 * Getter für Ergebnis
	 * 
	 * @return Ergebnis der Berechnung (nur gültig, falls Solve mit TRUE
	 *         zurückgekehrt ist)
	 */
	public int GetResult() {
		return iResult;
	}

	/**
	 * Getter für Fehler
	 * 
	 * @return Fehlermeldung (nur gültig, falls Solve mit FALSE zurückgekehrt ist)
	 */
	public String GetError() {
		return strError;
	}

	/**
	 * Löst eine Aufgabe, die in umgekehrter polnischer Notation angegeben wurde. Es
	 * können nur einstellige, natürliche Zahlen und die Grundrechenarten +,-,* und
	 * / verarbeitet werden. Die Aufgabe wird ohne Trennzeichen als fortlaufender
	 * String eingegeben (z. B. 34+2*)
	 * 
	 * @return TRUE, falls Aufgabe erfolgreich gelöst werden konnte, mit GetResult()
	 *         kann dann auf das Ergebnis der Aufgabe zugegriffen werden FALSE bei
	 *         Fehler, GetError() gibt den Fehler zurück
	 * 
	 * @see GetResult()
	 * @see GetError()
	 */
	public boolean Solve() {
		Stack<String> stack = new Stack<String>();
		int a = 0;
		int b = 0;
		while (!strAufgabe.equals("")) {
			switch (strAufgabe.charAt(0)) {
			case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0':
				stack.push(strAufgabe.substring(0, 1));
				break;
			case '+':
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				a = Integer.parseInt(stack.pop());
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				b = Integer.parseInt(stack.pop());
				stack.push(Integer.toString(b + a));
				break;
			case '-':
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				a = Integer.parseInt(stack.pop());
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				b = Integer.parseInt(stack.pop());
				stack.push(Integer.toString(b - a));
				break;
			case '/':
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				a = Integer.parseInt(stack.pop());
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				b = Integer.parseInt(stack.pop());
				if (a == 0) {
					strError = "Division durch Null";
					return false;
				}
				stack.push(Integer.toString(b / a));
				break;
			case '*':
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				a = Integer.parseInt(stack.pop());
				if (stack.isEmpty()) {
					strError = "Falsche Zeicheneingabe";
					return false;
				}
				b = Integer.parseInt(stack.pop());
				stack.push(Integer.toString(b * a));
				break;
			case '%':
				strError = "nicht unterstützter Operator";
				return false;
			default:
				strError = "Ungültiges Zeichen";
				return false;
			}
			strAufgabe = strAufgabe.substring(1, strAufgabe.length());
		}
		if (!stack.isEmpty()) {
			iResult = Integer.parseInt(stack.pop());
			if (!stack.isEmpty()) {
				strError = "Falsche Zeicheneingabe";
				return false;
			}
			return true;
		} else {
			strError = "Falsche Zeicheneingabe";
			return false;
		}
	}

	/**
	 * @param args none
	 * @throws IOException Ausnahmebehandlung für Eingabefehler
	 */
	public static void main(String[] args) throws IOException {

		// Begrüßungstext
		System.out.println("*** UPN-Taschenrechner ***\n");
		System.out.println(
				"Dieses Programm berechnet einen einfachen mathematischen Ausdruck, \nder in umgekehrter polnischer Notation eingegeben wird.\n");
		System.out.println("Type 'quit' to finish.\n");

		// Initialisierungen für reader (von Kommandozeile) und Aufgabe
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strAufgabe = "";

		// Schleife
		while (true) {
			// Aufforderung zur Eingabe der Aufgabe
			System.out.print("Geben Sie die Aufgabe ein:  ");

			// Einlesen der Aufgabe von Kommandozeile
			strAufgabe = reader.readLine();

			// Abbruch der Schleife, falls "quit" eingegeben wurde
			if (strAufgabe.equalsIgnoreCase("quit"))
				break;

			// Neues Calculator-Objekt anlegen und mit Aufgabe initialisieren
			Calculator calc = new Calculator(strAufgabe);

			// Lösen (Rückgabe: true, falls kein Syntaxfehler)
			if (calc.Solve()) {

				// Ausgabe des Ergebnisses bei Erfolg
				System.out.printf("Das Ergebnis ist:           %d\n\n", calc.GetResult());
			} else {

				// Ausgabe der Fehlermeldung bei Syntaxfehler
				System.out.printf("Fehler:                     %s\n\n", calc.GetError());
			}
		}

		// Endezeile
		System.out.println("\n***************************\n");
	}

}
