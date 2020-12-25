package ex4.geometry;
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
	
	@Override
	public boolean contains(Point2D ot) {
		double area1 = ((this.p1.x() * (this.p2.y() - ot.y())) +
				(this.p2.x() * (ot.y() - this.p1.y())) + 
				(ot.x() * (this.p1.y() - this.p2.y())))/2;
		double area2 = ((this.p2.x() * (this.p3.y() - ot.y())) +
				(this.p3.x() * ot.y() - this.p2.y()) + 
				(ot.x() * (this.p2.y() - this.p3.y())))/2;
		double area3 = ((this.p3.x() * (ot.y() - this.p1.x())) + 
				(ot.x() * (this.p1.y() - this.p3.y())) +
				(this.p1.x() * (this.p3.y() - ot.y())))/2;
		if(area1 > this.area() || area2 > this.area() || area3 > this.area())
			return false;
		return true;
	}
	
	@Override
	public Point2D centerOfMass() {
		Point2D way = new Point2D((this.p1.x() + this.p2.x())/2, (this.p1.y() + this.p2.y())/2);
		return new Point2D((way.x() + this.p3.x())/3,(way.y() + this.p3.y())/3);
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		double d = perimeter()/2;
		double len1 = this.p1.distance(this.p2);
		double len2 = this.p2.distance(this.p3);
		double len3 = this.p3.distance(this.p1);
		return Math.sqrt(d * (d - len1) * (d - len2) * (d - len3));
	}

	@Override
	public double perimeter() {
		double len1 = this.p1.distance(this.p2);
		double len2 = this.p2.distance(this.p3);
		double len3 = this.p3.distance(this.p1);
		return len1 + len2 + len3;
	}

	@Override
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Triangle2D(this.p1, this.p2, this.p3);
	}

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
}