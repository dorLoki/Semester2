package p5;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testDraw() {
		// TODO
	}

	@Test
	void testMove() {
		Circle c1 = new Circle(10, new Point(0, 0));
		c1.move(10, 20);
		assertEquals(c1.getCenter(), new Point(10, 20));
	}

	@Test
	void testCircle() {
		Point p1 = new Point(0, 0);
		Circle c1 = new Circle(10, p1);
		Circle c2 = new Circle(10, p1);
		assertEquals(c1.getCenter().getX(), c2.getCenter().getX());
		assertEquals(c1.getCenter().getY(), c2.getCenter().getY());
		c1.move(10, 20);
		assertNotEquals(c1.getCenter().getX(), c2.getCenter().getX());
		assertNotEquals(c1.getCenter().getY(), c2.getCenter().getY());
	}

	@Test
	void testDrawColorBoolean() {
		Circle c1 = new Circle(10, new Point(0, 0));
		c1.draw(Color.black, true);
		assertEquals(c1.getColor(), Color.black);
		assertTrue(c1.isSolid());
		c1.draw(Color.green, false);
		assertEquals(c1.getColor(), Color.green);
		assertFalse(c1.isSolid());
	}
}
