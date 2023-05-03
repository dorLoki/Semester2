package p5;

import java.util.ArrayList;
import java.util.Iterator;

public class Polygon extends Shape {
	private ArrayList<Point> points;

	public Polygon() {
		points = new ArrayList<Point>();
	}

	@Override
	public void draw() {
		getWhiteBoard().removeShape(representation);
		representation = getWhiteBoard().drawPolygon(points.stream().mapToDouble(p->p.getX()).toArray(), points.stream().mapToDouble(p->p.getY()).toArray());
	}

	@Override
	public Polygon move(int dx, int dy) {
		for (Iterator<Point> iterator = points.iterator(); iterator.hasNext();) {
			Point point = (Point) iterator.next();
			point.move(dx, dy);
		}
		return this;
	}

	public void setPoints(ArrayList<Point> arrayList) {
		points = arrayList;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}
}
