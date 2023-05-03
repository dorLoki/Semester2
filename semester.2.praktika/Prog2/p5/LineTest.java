package p5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLine() {
		Line l1 = new Line(new Point(0, 1), new Point(1, 2));
		ArrayList<Point> a = new ArrayList<Point>();
		a.add(new Point(0, 1));
		a.add(new Point(1, 2));
		assertEquals(a, l1.getPoints());
	}
}
