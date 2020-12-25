package ex4.geometry;

import ex4.Ex4_Const;
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
		this.r = new Point2D(right);
		this.l = new Point2D(left);
	}
	
	@Override
	public boolean contains(Point2D ot) {
		return ((this.r.x() >= ot.x()) && (this.l.x() <= ot.x()) && (this.r.y() >= ot.y()) && (this.l.y() <= ot.y()));
	}

	@Override
	public Point2D centerOfMass() {
		return new Point2D((this.r.x() + this.l.x())/2, (this.r.y() + this.l.y())/2);
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return 0;
	}

	@Override
	public void move(Point2D vec) {
		this.r.move(vec);
		this.l.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment2D(this.r, this.l);
	}
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
}