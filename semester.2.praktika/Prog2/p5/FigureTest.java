package p5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FigureTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFigure() {
		Figure f1 = new Figure();
		Figure f2 = new Figure();
		assertEquals(f1, f2);
	}

	@Test
	void testAddShape() {
		fail("Not yet implemented");
	}

	@Test
	void testDraw() {
		fail("Not yet implemented");
	}

	@Test
	void testMove() {
		fail("Not yet implemented");
	}

	@Test
	void testSnowMan() {
		fail("Not yet implemented");
	}

}
