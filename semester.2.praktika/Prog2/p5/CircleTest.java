package p5;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class CircleTest {
	@Test
	void testMove() {
		Circle c1 = new Circle(10, new Point(0, 0));
		c1.move(10, 20);
		assertEquals(c1.getCenter(), new Point(10, 20));
	}

	@Test
	void testCircle() {
		Point p1 = new Point(0, 0);
		Circle c1 = new Circle(0, p1);
		assertNotNull(c1);
		assertEquals(c1.getCenter(), p1);
		assertEquals(c1.getRadius(), 0);
		assertThrowsExactly(NullPointerException.class, () -> {
			new Circle(0, null);
		});
	}

	@Test
	void testDraw() {
		Circle c1 = new Circle(10, new Point(0, 0));
		c1.draw(Color.black, true);
		assertEquals(c1.getColor(), Color.black);
		assertTrue(c1.isSolid());
		c1.draw(Color.green, false);
		assertEquals(c1.getColor(), Color.green);
		assertFalse(c1.isSolid());
	}

	@Test
	void testGetCenter() {
		Circle c1 = new Circle(10, new Point(0, 0));
		assertNotNull(c1.getCenter());
	}
	@Test
	void testGetRadius() {
		Circle c1 = new Circle(10, new Point(0, 0));
		assertEquals(c1.getRadius(), 10);
	}

	@Test
	void testHashCode() {
		Circle c1 = new Circle(0, new Point(0, 0));
		Circle c2 = new Circle(0, new Point(0, 0));
		assertNotSame(c1, c2);
		assertTrue(c1.equals(c2) && c2.equals(c1));
	}

	@Test
	void testEqualsObject() {
		Circle c1 = new Circle(0, new Point(0, 0));
		Circle c2 = new Circle(0, new Point(0, 0));
		Circle c3 = new Circle(0, new Point(0, 0));
		// reflexive
		assertTrue(c1.equals(c1));
		// transitive
		assertTrue(c1.equals(c2) && c2.equals(c3) && c1.equals(c3));
		// symmetric
		assertTrue(c1.equals(c2) && c2.equals(c1));
		// Null
		assertFalse(c1.equals(null));
		// consistent
		for (int i = 0; i < 10; i++) {
			assertTrue(c1.equals(c2));
		}
	}
}
