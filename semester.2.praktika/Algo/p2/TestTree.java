/**
 * 
 */
package p2;

//import Tree.Tree;
//import Tree.Node;

/**
 * @author Tina Geweniger
 *
 * Testprogramm für Praktikum 3
 * 
 * - zur Validierung der Tree- und Node-Klasse 
 * - Klassen selbst müssen noch implementiert werden
 * 
 * 
 * Interface für Tree
 * 
 * class Tree {
 *    Tree(Node rootNode)
 *    Node GetRoot()
 *    void SetRoot(Node rootNode)
 *    String Preorder()
 *    String Inorder()
 *    String Postorder()
 *    }
 *    
 *    
 * Interface für Node
 * 
 * class Node {
 * 	  Node()
 *    Node(String data) 
 *    Node GetLeftChild()
 *    Node GetRightChild()
 *    void SetLeftChild (Node ln)
 *    void SetRightChild (Node rn)
 *    Boolean HasLeftChild()
 *    Boolean HasRightChild()
 *    Boolean IsLeaf()
 *    void SetData(String data)
 *    String GetData() 
 * }
 * 
 */
public class TestTree {

	public TestTree() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		/* Hinweise:
		 *    - Implementieren Sie erst Konstruktoren für Node, als Daten reicht es Strings zu akzeptieren.
		 *    - Der Konstruktor für Tree hat ein Parameter vom Type Node. Das ist die Wurzel des Baumes.
		 *    - Die Funktionen SetLeftChild() und SetRightChild() weisen einem Knoten rechtes und linkes Kind zu.
		 *    - Der Rückgabewert der Routinen PreOrder(), InOrder() und LeftOrder() sollte ein String sein. 
		*/	
			
		// Knoten anlegen
/*		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		
		
		// Baum anlegen  (Baum aus Praktikum 3, Aufgabe 3.2)
		Tree tree = new Tree(nodeE);
		
		nodeE.SetLeftChild(nodeD);
		nodeE.SetRightChild(nodeH);
		
		nodeD.SetLeftChild(nodeB);
		
		nodeB.SetLeftChild(nodeA);
		nodeB.SetRightChild(nodeC);
		
		nodeH.SetLeftChild(nodeF);
		
		nodeF.SetRightChild(nodeG);
		
		
		// Baum traversieren
		System.out.println("Preorder:  " + tree.Preorder());
		System.out.println("Inorder:   " + tree.Inorder());
		System.out.println("Postorder: " + tree.Postorder());
*/		
	}

}
