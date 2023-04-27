package p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessAnimal {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
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
					String data = (String) currNode.getData();
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
			strAnswer = reader.readLine();
			if (!strAnswer.equalsIgnoreCase("j") && !strAnswer.equalsIgnoreCase("n"))
				System.out.println("Fehlerhafte Eingabe");
		}
		return strAnswer;
	}
}
