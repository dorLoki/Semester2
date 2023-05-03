package p5;

import java.util.Objects;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		return this;
	}

	/**
	 * Clones a point object and return a new point and assures that this new point
	 * is equal to this point.
	 * 
	 * @return a clone of the point object.
	 */
	public Point copy() {
		return new Point(this.x, this.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}
