package p3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import p2.Node;

class BinarySearchTreeTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testBinarySearchTree() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(null, tree.getRoot());
	}

	@Test
	void testBinarySearchTreeNode() {
		BinarySearchTree tree = new BinarySearchTree(new Node(100));
		assertEquals(100, tree.getRoot().getData());
	}

	@Test
	void testInsert() {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50);
		assertEquals(50, tree.getRoot().getData());

		tree.insert(25);
		assertEquals(25, tree.getRoot().getLeft().getData());

		tree.insert(75);
		assertEquals(75, tree.getRoot().getRight().getData());

		tree.insert(75);
		assertEquals(0, tree.getRoot().getRight().getChildren());
		assertEquals(0, tree.getRoot().getLeft().getChildren());
		assertEquals(2, tree.getRoot().getChildren());
		assertEquals(50, tree.getRoot().getData());
		assertEquals(25, tree.getRoot().getLeft().getData());
		assertEquals(75, tree.getRoot().getRight().getData());
	}

	@Test
	void testDelete_empty() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.delete(50);
		assertEquals(null, tree.getRoot());
	}
	
	@Test
	void testDelete_not_in_tree() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.delete(0);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(0, tree.getRoot().getChildren());
	}

	@Test
	void testDelete_noChild() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.delete(50);
		assertEquals(null, tree.getRoot());
	}
	
	@Test
	void testDeleteRootCase2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.delete(50);
		assertEquals(25, tree.getRoot().getData());
		assertEquals(1, tree.getRoot().getChildren());
		assertEquals(75, tree.getRoot().getRight().getData());
	}

	@Test
	void testDelete_left_child() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.delete(50);
		assertEquals(25, tree.getRoot().getData());
		assertEquals(0, tree.getRoot().getChildren());
	}

	@Test
	void testDelete_right_child() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.delete(50);
		assertEquals(75, tree.getRoot().getData());
		assertEquals(0, tree.getRoot().getChildren());
	}

	@Test
	void testDelete_left_childs() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(35);
		tree.delete(25);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getRight());
		assertEquals(35, tree.getRoot().getLeft().getData());
		assertEquals(0, tree.getRoot().getLeft().getChildren());

	}
	
	@Test
	void testDelete_left_child2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(15);
		tree.delete(15);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getRight());
		assertEquals(25, tree.getRoot().getLeft().getData());
		assertEquals(0, tree.getRoot().getLeft().getChildren());
	}
	@Test
	void testDelete_right_child2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.insert(85);
		tree.delete(85);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft());
		assertEquals(75, tree.getRoot().getRight().getData());
		assertEquals(0, tree.getRoot().getRight().getChildren());
	}
	
	@Test
	void testDelete_right_childs() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.insert(85);
		tree.delete(75);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft());
		assertEquals(85, tree.getRoot().getRight().getData());
		assertEquals(0, tree.getRoot().getRight().getChildren());
	}
	
	@Test
	void testDelete_left_childs2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(15);
		tree.delete(25);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getRight());
		assertEquals(15, tree.getRoot().getLeft().getData());
		assertEquals(0, tree.getRoot().getLeft().getChildren());
	}
	
	@Test
	void testDelete_right_childs2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.insert(66);
		tree.delete(75);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft());
		assertEquals(66, tree.getRoot().getRight().getData());
		assertEquals(0, tree.getRoot().getRight().getChildren());
	}
	
	@Test
	void testDelete_2_child_right(){
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.insert(66);
		tree.insert(100);
		tree.delete(75);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft());
		assertEquals(66, tree.getRoot().getRight().getData());
		assertEquals(100, tree.getRoot().getRight().getRight().getData());
	}
	
	@Test
	void testDelete_2_child_left(){
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(20);
		tree.insert(30);
		tree.delete(25);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getRight());
		assertEquals(20, tree.getRoot().getLeft().getData());
		assertEquals(30, tree.getRoot().getLeft().getRight().getData());
	}
	
	
	

	@Test
	void testRemove_empty() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.remove(50);
		assertEquals(null, tree.getRoot());
	}

	@Test
	void testRemove_noChild() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.remove(50);
		assertEquals(null, tree.getRoot());
	}

	@Test
	void testRemove_left_child() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.remove(50);
		assertEquals(25, tree.getRoot().getData());
		assertEquals(0, tree.getRoot().getChildren());
	}

	@Test
	void testRemove_right_child() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.remove(50);
		assertEquals(75, tree.getRoot().getData());
		assertEquals(0, tree.getRoot().getChildren());
	}

	@Test
	void testRemove_left_childs() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(25);
		tree.insert(35);
		tree.remove(25);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getRight());
		assertEquals(35, tree.getRoot().getLeft().getData());
		assertEquals(0, tree.getRoot().getLeft().getChildren());

	}

	@Test
	void testRemove_right_childs() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(75);
		tree.insert(85);
		tree.remove(75);
		assertEquals(50, tree.getRoot().getData());
		assertEquals(null, tree.getRoot().getLeft());
		assertEquals(85, tree.getRoot().getRight().getData());
		assertEquals(0, tree.getRoot().getRight().getChildren());
	}

}
