package p5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FigureTest {
	@Test
	void testFigure() {
		Figure f1 = new Figure();
		assertNotNull(f1);
	}

	@Test
	void testAddShape() {
		Figure f1 = new Figure();
		assertEquals(f1.addShape(new Line(null, null)), f1);
	}

	@Test
	void testMove() {
		Figure f1 = new Figure();
		assertEquals(f1.move(0, 0), f1);
	}

	@Test
	void testSnowMan() {
		Figure f1 = new Figure();
		assertNotEquals(Figure.snowMan(), f1);
		assertEquals(Figure.snowMan(), Figure.snowMan());
	}

	@Test
	void testHashCode() {
		Figure f1 = new Figure();
		Figure f2 = new Figure();
		assertNotSame(f1, f2);
		assertTrue(f1.equals(f2) && f2.equals(f1));
	}

	@Test
	void testEqualsObject() {
		Figure f1 = new Figure();
		Figure f2 = new Figure();
		Figure f3 = new Figure();
		// reflexive
		assertTrue(f1.equals(f1));
		// transitive
		assertTrue(f1.equals(f2) && f2.equals(f3) && f1.equals(f3));
		// symmetric
		assertTrue(f1.equals(f2) && f2.equals(f1));
		// Null
		assertFalse(f1.equals(null));
		// consistent
		for (int i = 0; i < 10; i++) {
			assertTrue(f1.equals(f2));
		}
	}
}
