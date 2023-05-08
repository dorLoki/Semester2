package p5;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolygonTest {
	private Polygon p1;
	private Polygon p2;
	private Polygon p3;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new Polygon();
		p2 = new Polygon();
		p3 = new Polygon();
	}

	@Test
	void testPolygon() {
		assertNotNull(p1);
		assertNotNull(p1.getPoints());
	}

	@Test
	void testMove() {
		assertEquals(p1, p1.move(0, 0));
	}

	@Test
	void testSetPoints() {
		assertEquals(p1, p2);
		p1.setPoints(new ArrayList<Point>(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(3, 3))));
		assertNotEquals(p1, p2);
	}

	@Test
	void testGetPoints() {
		assertNotNull(p1.getPoints());
		ArrayList<Point> list = new ArrayList<Point>(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(3, 3)));
		p1.setPoints(list);
		assertEquals(p1.getPoints(), list);
	}

	@Test
	void testHashCode() {
		assertNotSame(p1, p2);
		assertTrue(p1.equals(p2) && p2.equals(p1));
	}

	@Test
	void testEqualsObject() {
		// reflexive
		assertTrue(p1.equals(p1));
		// transitive
		assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
		// symmetric
		assertTrue(p1.equals(p2) && p2.equals(p1));
		// Null
		assertFalse(p1.equals(null));
		// consistent
		for (int i = 0; i < 10; i++) {
			assertTrue(p1.equals(p2));
		}
	}
}
