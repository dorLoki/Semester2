package p5;

import java.awt.Color;
import java.util.Objects;

public class Circle extends Shape {

	private int radius;
	private Point center;

	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center.copy();
	}

	@Override
	public void draw() {
		getWhiteBoard().removeShape(representation);
		representation = getWhiteBoard().drawCircle(center.getX(), center.getY(), radius, getColor(), isSolid());
	}
	
	public int getRadius() {
		return radius;
	}

	public void draw(Color color, boolean isSolid) {
		this.setColor(color);
		this.setSolid(isSolid);
		draw();
	}

	@Override
	public Drawable move(int x, int y) {
		center.move(x, y);
		return this;
	}

	public Point getCenter() {
		return center;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(center, radius);
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
		Circle other = (Circle) obj;
		return Objects.equals(center, other.center) && radius == other.radius;
	}
}
