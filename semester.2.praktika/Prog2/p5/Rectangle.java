package p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Rectangle extends Polygon {
	private int lengthX;
	private int lengthY;
	private Point bottomLeft;

	public Rectangle(Point p, int lengthX, int lengthY) {
		this.lengthX = lengthX;
		this.lengthY = lengthY;
		this.bottomLeft = p;
		setPoints(new ArrayList<Point>(Arrays.asList(bottomLeft)));
	}
	public int getLengthX() {
		return lengthX;
	}
	public int getLengthY() {
		return lengthY;
	}
	public void draw() {
		getWhiteBoard().removeShape(representation);
		representation = getWhiteBoard().drawRectangle(bottomLeft.getX(), bottomLeft.getY(), lengthX, lengthY);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bottomLeft, lengthX, lengthY);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return Objects.equals(bottomLeft, other.bottomLeft) && lengthX == other.lengthX && lengthY == other.lengthY;
	}
}
