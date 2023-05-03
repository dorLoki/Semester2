package p5;

import java.awt.Color;

public class Circle extends Shape {

	private int radius;
	private Point center;

	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
	}

	@Override
	public void draw() {
		getWhiteBoard().removeShape(representation);
		representation = getWhiteBoard().drawCircle(center.getX(), center.getY(), radius, getColor(), isSolid());
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
}
