package p5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Polygon extends Shape {
	private ArrayList<Point> points;

	public Polygon() {
		points = new ArrayList<Point>();
	}

	@Override
	public void draw() {
		getWhiteBoard().removeShape(representation);
		representation = getWhiteBoard().drawPolygon(points.stream().mapToDouble(p -> p.getX()).toArray(),
				points.stream().mapToDouble(p -> p.getY()).toArray());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(points);
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
		Polygon other = (Polygon) obj;
		return Objects.equals(points, other.points);
	}
}