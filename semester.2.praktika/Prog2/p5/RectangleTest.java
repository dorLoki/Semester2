package p5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {
	@Test
	void testRectangle() {
		Rectangle r1 = new Rectangle(new Point(0, 0), 10, 20);
		assertNotNull(r1);
		assertEquals(r1.getLengthX(), 10);
		assertEquals(r1.getLengthY(), 20);
	}
	@Test
	void testGetLengthX() {
		Rectangle r1 = new Rectangle(new Point(0, 0), 1, 0);
		assertEquals(r1.getLengthX(), 1);
	}
	@Test
	void testGetLengthY() {
		Rectangle r1 = new Rectangle(new Point(0, 0), 0, 1);
		assertEquals(r1.getLengthY(), 1);
	}

	@Test
	void testHashCode() {
		Rectangle r1 = new Rectangle(new Point(0, 0), 10, 10);
		Rectangle r2 = new Rectangle(new Point(0, 0), 10, 10);
		assertNotSame(r1, r2);
		assertTrue(r1.equals(r2) && r2.equals(r1));
	}

	@Test
	void testEqualsObject() {
		Rectangle r1 = new Rectangle(new Point(0, 0), 10, 10);
		Rectangle r2 = new Rectangle(new Point(0, 0), 10, 10);
		Rectangle r3 = new Rectangle(new Point(0, 0), 10, 10);
		// reflexive
		assertTrue(r1.equals(r1));
		// transitive
		assertTrue(r1.equals(r2) && r2.equals(r3) && r1.equals(r3));
		// symmetric
		assertTrue(r1.equals(r2) && r2.equals(r1));
		// Null
		assertFalse(r1.equals(null));
		// consistent
		for (int i = 0; i < 10; i++) {
			assertTrue(r1.equals(r2));
		}
	}
}
