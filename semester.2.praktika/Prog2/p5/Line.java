package p5;

import java.util.ArrayList;
import java.util.Arrays;

public class Line extends Polygon {

	public Line(Point p1, Point p2) {
		setPoints(new ArrayList<Point>(Arrays.asList(p1, p2)));
	}
}
