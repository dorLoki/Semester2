package p5;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapeTest {
	private Shape s1;
	private Shape s2;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Shape() {

			@Override
			public Drawable move(int x, int y) {
				return null;
			}

			@Override
			public void draw() {
			}
		};
	}

	@Test
	void testShape() {
		assertNotNull(s1);
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
}
