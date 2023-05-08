package p5;

import java.awt.Color;
import java.util.Objects;

import teaching.WhiteBoard;

public abstract class Shape implements Drawable {

	protected Object representation;
	private static WhiteBoard whiteBoard = new WhiteBoard();
	private Color color;
	private boolean solid;

	public Shape() {

	}

	public Color getColor() {
		return color;
	}

	public static WhiteBoard getWhiteBoard() {
		return whiteBoard;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	@Override
	public abstract void draw();

	@Override
	public abstract Drawable move(int x, int y);

	@Override
	public int hashCode() {
		return Objects.hash(color, representation, solid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		return Objects.equals(color, other.color) && Objects.equals(representation, other.representation)
				&& solid == other.solid;
	}
}
