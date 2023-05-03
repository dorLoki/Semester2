package p5;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapeTest {
	private Shape s1;
	private Shape s2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Shape() {

			@Override
			public Drawable move(int x, int y) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void draw() {
				// TODO Auto-generated method stub

			}
		};
		s2 = new Shape() {

			@Override
			public Drawable move(int x, int y) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void draw() {
				// TODO Auto-generated method stub

			}
		};
	}

	@Test
	void testShape() {
		assertNotEquals(s1, s2);
	}

	@Test
	void testGetColor() {
		assertNull(s1.getColor());
		s1.setColor(Color.black);
		assertEquals(s1.getColor(), Color.black);

	}

	@SuppressWarnings("static-access")
	@Test
	void testGetWhiteBoard() {
		assertEquals(s1.getWhiteBoard(), s2.getWhiteBoard());
	}

	@Test
	void testIsSolid() {
		assertFalse(s1.isSolid());
		s1.setSolid(true);
		assertTrue(s1.isSolid());
		s1.setSolid(false);
		assertFalse(s1.isSolid());

	}

	@Test
	void testSetColor() {
		s1.setColor(Color.black);
		assertEquals(s1.getColor(), Color.black);
		s1.setColor(Color.green);
		assertEquals(s1.getColor(), Color.green);

	}

	@Test
	void testSetSolid() {
		s1.setSolid(true);
		assertTrue(s1.isSolid());
		s1.setSolid(false);
		assertFalse(s1.isSolid());
	}

	@Test
	void testDraw() {
		// TODO
	}

	@Test
	void testMove() {
		// TODO
	}

}
