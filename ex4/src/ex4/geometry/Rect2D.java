package ex4.geometry;

import java.util.Objects;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape {
	private Point2D r;
	private Point2D l;

	/**
	 * Constructor that get 2 points.
	 * @param right
	 * @param left
	 */
	public Rect2D(Point2D right, Point2D left) {
		this.r = new Point2D(right);
		this.l = new Point2D(left);
	}

	/**
	 * @return the right point of the rectangle (the biggest point).
	 */
	public Point2D getRight() {
		return this.r;
	}

	/**
	 * @return the left point of the rectangle (the smallest point).
	 */
	public Point2D getLeft() {
		return this.l;
	}

	/**
	 * Checks if point is in the rectangle or not
	 * @param ot - a query 2D point
	 * @return true if the point is in the rectangle, else return false.
	 */
	@Override
	public boolean contains(Point2D ot) {
		return ((this.r.x() >= ot.x()) && (this.r.y() >= ot.y())
				&& (ot.x() >= this.l.x()) && (ot.y() >= this.l.y()));
	}

	/**
	 * @return the center of mass at the rectangle.
	 */
	@Override
	public Point2D centerOfMass() {
		return new Point2D((this.r.x() + this.l.x())/2, (this.r.y() + this.l.y())/2);
	}

	/**
	 * @return the area of the rectangle.
	 */
	@Override
	public double area() {
		return ((this.r.x() - this.l.x()) * (this.r.y() - this.l.y()));
	}

	/**
	 * @return the perimeter of the rectangle.
	 */
	@Override
	public double perimeter() {
		return ((2*(this.r.x() - this.l.x())) + (2*(this.r.y() - this.l.y())));
	}

	/**
	 * Move the point of the rectangle, to another point.
	 * @param vec - a vector from the 0,0
	 */
	@Override
	public void move(Point2D vec) {
		this.r.move(vec);
		this.l.move(vec);
	}

	/**
	 * @return copy of the shape.
	 */
	@Override
	public GeoShape copy() {
		return new Rect2D(this.r,this.l);
	}

	/**
	 * @return array of the main points at the circle.
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.r);
		ans[1] = new Point2D(this.l);
		return ans;
	}
	
	@Override
	public String toString() {
		return this.r + "," + this.l;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rect2D rect2D = (Rect2D) o;
		return Objects.equals(r, rect2D.r) &&
				Objects.equals(l, rect2D.l);
	}
}
