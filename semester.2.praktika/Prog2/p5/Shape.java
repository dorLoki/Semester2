package p5;

import java.awt.Color;

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
}
