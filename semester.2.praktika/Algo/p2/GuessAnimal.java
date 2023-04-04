package p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import Tree.Tree;
//import Tree.TreeNode;

/**
 * @author Tina Geweniger
 *
 * Grundgerüst Tier-Rate-Spiel im Praktikum 3
 * 
 * - Nutzen Sie die bereits implementierte Tree- und Node-Klasse
 * - überall wo // ... steht, muss noch Code ergänzt werden
 * 
 * Beispiel eines Durchlaufs:
 */

/****
 * Tiere raten ***
 * 
 * Bei diesem klassischen Frage-Antwort-Spiel versucht der Computer ein vom
 * Spieler ausgedachtes Tier zu erraten. Unbekannte Tiere werden dazugelernt.
 * 
 * Antworten immer mit 'j' or 'n'.
 * 
 * 
 * Ist es ein großes Tier? j Die Antwort ist: Elefant Richtig? n Glückwunsch! Du
 * hast gewonnen!
 * 
 * Lass mich dazulernen!
 * 
 * Welches Tier sollte ich erraten? Nashorn Mit welcher Frage hätte ich das Tier
 * erraten können? Hat das Tier ein Horn? Danke! Schon gelernt.
 * 
 * Noch ein Spiel? j
 * 
 * Ist es ein großes Tier? j Hat das Tier ein Horn? j Die Antwort ist: Nashorn
 * Richtig? j Juhu! Ich habe gewonnen!
 * 
 * Noch ein Spiel? n
 * 
 ***************************/

public class GuessAnimal {

	// Initialisierungen für reader (von Kommandozeile)
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public GuessAnimal() {
	}

	public static void main(String[] args) throws IOException {
		// Begrüßungstext
		System.out.println("*** Tiere raten ***\n");
		System.out.println(
				"Bei diesem klassischen Frage-Antwort-Spiel versucht der Computer \nein vom Spieler ausgedachtes Tier zu erraten. Unbekannte Tiere \nwerden dazugelernt.\n");
		System.out.println("Antworten immer mit 'j' or 'n'.\n");

		Node t1 = new Node("Hund");
		Node t2 = new Node("Pinguin");
		Node f1 = new Node("Hat es 4 Beine?");
		f1.setLeft(t1);
		f1.setRight(t2);
		Tree t = new Tree(f1);

		do {
			System.out.print("\n");
			Node currNode = t.getRoot();
			while (!currNode.isLeaf()) {
				System.out.println(currNode.getData());
				currNode = GetAnswer().equalsIgnoreCase("j") ? currNode.getLeft() : currNode.getRight();
			}
			if (currNode.isLeaf()) {
				System.out.println("Ist die Antwort:" + currNode.getData());
				System.out.print("Richtig? ");
				if (GetAnswer().equalsIgnoreCase("j"))
					System.out.println("Juhu! Ich habe gewonnen!");
				else {
					System.out.println("Glückwunsch! Du hast gewonnen!");
					System.out.print("\nLass mich dazulernen! \n\nWelches Tier sollte ich erraten?  ");
					Node tempTier = new Node(reader.readLine());
					System.out.print("Mit welcher Frage hätte ich das Tier erraten können?  ");
					String data = currNode.getData();
					currNode.setData(reader.readLine());
					currNode.setLeft(tempTier);
					currNode.setRight(new Node(data));
					System.out.print("Danke! Schon gelernt.\n");
				}
			}
			System.out.print("\nNoch ein Spiel? ");

		} while (GetAnswer().equalsIgnoreCase("j"));
		System.out.println("\n***************************\n");
	}

	private static String GetAnswer() throws IOException {

		String strAnswer = "";

		while (!strAnswer.equalsIgnoreCase("j") && !strAnswer.equalsIgnoreCase("n")) {

			// Anwort eingeben
			strAnswer = reader.readLine();

			// verifizieren
			if (!strAnswer.equalsIgnoreCase("j") && !strAnswer.equalsIgnoreCase("n"))
				System.out.println("Fehlerhafte Eingabe");
		}

		return strAnswer;
	}
}
