package ex4.geometry;

import java.util.Objects;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	
	public Triangle2D(Point2D _p1, Point2D _p2, Point2D _p3) {
		this.p1 = new Point2D(_p1);
		this.p2 = new Point2D(_p2);
		this.p3 = new Point2D(_p3);
	}

	/**
	 * Checks if point is in the triangle or not
	 * @param ot - a query 2D point
	 * @return true if the point is in the triangle, else return false.
	 */
	@Override
	public boolean contains(Point2D ot) {
		double area1 = area(this.p1, this.p2, ot);
		double area2 = area(this.p2, this.p3, ot);
		double area3 = area(this.p3, this.p1, ot);
		double area = area(this.p1, this.p2, this.p3);
		return area1 + area2 + area3 == area;
	}

	/**
	 * This method get 3 Point2D's of the triangle and return the area of it.
	 * @param point1
	 * @param point2
	 * @param point3
	 * @return the area.
	 */
	private double area(Point2D point1, Point2D point2, Point2D point3) {
		if(this.p1 == this.p2 && this.p2 == this.p3 && this.p1 == this.p3) return 0;
		return Math.abs((point1.x()*(point2.y()-point3.y()) + point2.x()*(point3.y()-point1.y())+
				point3.x()*(point1.y()-point2.y()))/2);
	}

	/**
	 * @return the center of mass at the triangle.
	 */
	@Override
	public Point2D centerOfMass() {
		Point2D way = new Point2D((this.p1.x() + this.p2.x())/2, (this.p1.y() + this.p2.y())/2);
		return new Point2D((way.x() + this.p3.x())/3,(way.y() + this.p3.y())/3);
	}

	/**
	 * @returnm the area of the triangle.
	 */
	@Override
	public double area() {
		double d = perimeter()/2;
		double len1 = this.p1.distance(this.p2);
		double len2 = this.p2.distance(this.p3);
		double len3 = this.p3.distance(this.p1);
		return Math.sqrt(d * (d - len1) * (d - len2) * (d - len3));
	}

	/**
	 * @return the perimeter of the triangle.
	 */
	@Override
	public double perimeter() {
		double len1 = this.p1.distance(this.p2);
		double len2 = this.p2.distance(this.p3);
		double len3 = this.p3.distance(this.p1);
		return len1 + len2 + len3;
	}

	/**
	 * Move the point of the triangle, to another point.
	 * @param vec - a vector from the 0,0
	 */
	@Override
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
	}

	/**
	 * @return copy of the shape.
	 */
	@Override
	public GeoShape copy() {
		return new Triangle2D(this.p1, this.p2, this.p3);
	}

	/**
	 * @return array of the main points at the triangle.
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		ans[0] = new Point2D(this.p1);
		ans[1] = new Point2D(this.p2);
		ans[2] = new Point2D(this.p3);
		return ans;
	}
	@Override
	public String toString() {
		return this.p1 + "," + this.p2 + "," + this.p3;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle2D that = (Triangle2D) o;
		return Objects.equals(p1, that.p1) &&
				Objects.equals(p2, that.p2) &&
				Objects.equals(p3, that.p3);
	}
}