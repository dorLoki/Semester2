package p5;

import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle extends Polygon {
	private int lenghtX;
	private int lengthY;
	private Point bottomLeft;

	public Rectangle(Point p, int lengthX, int lengthY) {
		this.lenghtX = lengthX;
		this.lengthY = lengthY;
		this.bottomLeft = p;
		setPoints(new ArrayList<Point>(Arrays.asList(bottomLeft)));
	}

	public void draw() {
		getWhiteBoard().removeShape(representation);
		representation = getWhiteBoard().drawRectangle(bottomLeft.getX(), bottomLeft.getY(), lenghtX, lengthY);
	}
}
