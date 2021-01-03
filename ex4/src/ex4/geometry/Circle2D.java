package ex4.geometry;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;

	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		if (rad <= -1) {
			this._radius = 1;
			System.err.println("The radius can't be negative!!");
		} else {
			this._radius = rad;
		}
	}

	/**
	 * @return the center point of the circle.
	 */
	public Point2D center() {
		return _center;
	}

	/**
	 * @return the radius of the circle.
	 */
	public double radius() {
		return _radius;
	}

	/**
	 * @return the radius of the circle.
	 */
	public double getRadius() {return this._radius;}

	@Override
	public String toString()
	{ return _center.toString() + "," + this._radius;}

	/**
	 * Checks if point is in the circle or not
	 * @param ot - a query 2D point
	 * @return true if the point is in the circle, else return false.
	 */
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}

	/**
	 * @return the center of mass at the circle.
	 */
	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}

	/**
	 * @returnm the area of the circle.
	 */
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}

	/**
	 * @return the perimeter of the circle.
	 */
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

	/**
	 * Move the point of the circle, to another point.
	 * @param vec - a vector from the 0,0
	 */
	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}

	/**
	 * @return copy of the shape.
	 */
	@Override
	public GeoShape copy() {
		return new Circle2D(this._center, this._radius);
	}

	/**
	 * @return array of the main points at the circle.
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Circle2D circle2D = (Circle2D) o;
		return Double.compare(circle2D._radius, _radius) == 0 &&
				Objects.equals(_center, circle2D._center);
	}
}