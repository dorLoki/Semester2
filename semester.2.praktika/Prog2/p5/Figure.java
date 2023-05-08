package p5;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Figure implements Drawable {
	private List<Drawable> shapes;

	public Figure() {
		shapes = new ArrayList<Drawable>();
	}

	public Figure addShape(Drawable drawable) {
		shapes.add(drawable);
		return this;
	}

	@Override
	public void draw() {
		for (Iterator<Drawable> iterator = shapes.iterator(); iterator.hasNext();) {
			Drawable drawable = iterator.next();
			drawable.draw();
		}
	}

	@Override
	public Drawable move(int dx, int dy) {
		for (Iterator<Drawable> iterator = shapes.iterator(); iterator.hasNext();) {
			Drawable drawable = iterator.next();
			drawable.move(dx, dy);
		}
		return this;
	}

	public static Figure snowMan() {
		Figure f = new Figure();

		Circle c1 = new Circle(120, new Point(375, 130));
		c1.setColor(Color.black);
		f.addShape(c1);

		Circle c2 = new Circle(80, new Point(375, 330));
		c2.setColor(Color.black);
		f.addShape(c2);

		Circle c3 = new Circle(50, new Point(375, 460));
		c3.setColor(Color.black);
		f.addShape(c3);
		f.addShape(new Line(new Point(455, 330), new Point(505, 380)));
		f.addShape(new Line(new Point(295, 330), new Point(245, 380)));

		Circle c4 = new Circle(6, new Point(375, 50));
		c4.setColor(Color.black);
		c4.setSolid(true);
		f.addShape(c4);

		Circle c5 = new Circle(6, new Point(375, 130));
		c5.setColor(Color.black);
		c5.setSolid(true);
		f.addShape(c5);

		Circle c6 = new Circle(6, new Point(375, 210));
		c6.setColor(Color.black);
		c6.setSolid(true);
		f.addShape(c6);

		Circle c7 = new Circle(6, new Point(375, 290));
		c7.setColor(Color.black);
		c7.setSolid(true);
		f.addShape(c7);

		Circle c8 = new Circle(6, new Point(375, 370));
		c8.setColor(Color.black);
		c8.setSolid(true);
		f.addShape(c8);

		Circle c9 = new Circle(6, new Point(375, 445));
		c9.setColor(Color.yellow);
		c9.setSolid(true);
		f.addShape(c9);

		Circle c10 = new Circle(6, new Point(355, 475));
		c10.setColor(Color.black);
		c10.setSolid(true);
		f.addShape(c10);

		Circle c11 = new Circle(6, new Point(395, 475));
		c11.setColor(Color.black);
		c11.setSolid(true);
		f.addShape(c11);

		f.addShape(new Rectangle(new Point(375, 525), 65, 30));
		f.addShape(new Line(new Point(330, 510), new Point(420, 510)));

		return f;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shapes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figure other = (Figure) obj;
		return Objects.equals(shapes, other.shapes);
	}

}
