package ex4.geometry;

import ex4.Ex4_Const;

import java.util.Objects;

/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	private Point2D r;
	private Point2D l;
	
	public Segment2D(Point2D right, Point2D left) {
		if (left.x() > right.x()) {
			this.l = new Point2D(right);
			this.r = new Point2D(left);
		}
		else {
			this.r = new Point2D(right);
			this.l = new Point2D(left);
		}
	}

	/**
	 * Checks if point is in the segment or not
	 * @param ot - a query 2D point
	 * @return true if the point is in the segment, else return false.
	 */
	@Override
	public boolean contains(Point2D ot) {
		return this.l.distance(ot) + ot.distance(this.r) == this.l.distance(this.r);
	}

	/**
	 * @return the center of mass at the segment.
	 */
	@Override
	public Point2D centerOfMass() {
		if(this.r == this.l) return new Point2D(this.r);
		return new Point2D((this.r.x() + this.l.x())/2, (this.r.y() + this.l.y())/2);
	}

	/**
	 * @returnm the area of the segment, the area is always zero.
	 */
	@Override
	public double area() {
		return 0;
	}

	/**
	 * @return the perimeter of the segment.
	 */
	@Override
	public double perimeter() {
		return 2*(r.distance(l));
	}

	/**
	 * Move the point of the segment, to another point.
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
		return new Segment2D(this.r, this.l);
	}

	/**
	 * @return array of the main points at the segment.
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
		return this.r.toString() + "," + this.l.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Segment2D segment2D = (Segment2D) o;
		return Objects.equals(r, segment2D.r) &&
				Objects.equals(l, segment2D.l);
	}
}