package p5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHashCode() {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		assertNotSame(p1, p2);
		assertTrue(p1.equals(p2) && p2.equals(p1));
	}

	@Test
	void testPoint() {
		Point p1 = new Point(1, 2);
		assertEquals(p1.getX(), 1);
		assertEquals(p1.getY(), 2);
	}

	@Test
	void testGetX() {
		Point p1 = new Point(10, 20);
		assertEquals(p1.getX(), 10);
	}

	@Test
	void testGetY() {
		Point p1 = new Point(10, 20);
		assertEquals(p1.getY(), 20);
	}

	@Test
	void testMove() {
		Point p1 = new Point(0, 0);
		p1.move(10, 20);
		assertEquals(p1.getX(), 10);
		assertEquals(p1.getY(), 20);

	}

	@Test
	void testCopy() {
		Point p1 = new Point(0, 0);
		Point p2 = p1.copy();
		assertNotSame(p1, p2);
		assertEquals(p1, p2);
	}

	@Test
	void testEqualsObject() {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(0, 0);
		assertTrue(p1.equals(p1));
		assertTrue(p1.equals(p2) && p2.equals(p1));
		assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
		assertFalse(p1.equals(null));
		assertNotSame(p1, p2);
		assertTrue(p1.hashCode() == p2.hashCode());
	}

}
