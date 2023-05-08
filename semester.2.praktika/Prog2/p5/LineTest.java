package p5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {
	@Test
	void testLine() {
		Line l1 = new Line(new Point(0, 1), new Point(1, 2));
		assertNotNull(l1);
	}
}
