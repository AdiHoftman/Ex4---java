package ex4.geometry;
/**
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * Ex4: you should NOT change this class!
 * @author boaz.benmoshe
 */


public class Point2D implements GeoShape{
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    private double _x,_y;

    /**
     * Constructor that get two numbers.
     * @param x
     * @param y
     */
    public Point2D(double x,double y) {
    	_x=x; _y=y;
    }

    /**
     * Constructor that get point.
     * @param p
     */
    public Point2D(Point2D p) {
       this(p.x(), p.y());
    }

    /**
     * Constructor that get string.
     * @param s
     */
    public Point2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }

    /**
     * Returns the value in the x position.
     * @return
     */
    public double x() {return _x;}

    /**
     * Returns the value in the y position.
     * @return
     */
    public double y() {return _y;}

    /**
     * Returns the value in the x position.
     * @return
     */
    public int ix() {return (int)_x;}

    /**
     * Returns the value in the y position.
     * @return
     */
    public int iy() {return (int)_y;}

    /**
     * Adds a point and return the point that was added.
     * @param p
     * @return
     */
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+y());
    	return a;
    }
    
    @Override
    public String toString(){
        return _x+","+_y;
    }

    /**
     * Calculate the distance from two points
     * and return the distance.
     * @return
     */
    public double distance(){
        return this.distance(ORIGIN);
    }

    /**
     * This method get a point and
     * calculate the distance from the point to other point
     * and return the distance.
     * @return
     */
    public double distance(Point2D p2){
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }

    public boolean equals(Object p){
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }

    /**
     * This method get point and number and check if
     * the distance between teo points is smaller from
     * the number that we get, if so, the method return true,
     * else, return false.
     * @param p2
     * @param eps
     * @return
     */
    public boolean close2equals(Point2D p2, double eps){
        return ( this.distance(p2) < eps );
    }

    /**
     * This method get point and check if the distance
     * between teo points is smaller from the number that we get,
     * if so, the method return true, else, return false.
     * @param p2
     * @return
     */
    public boolean close2equals(Point2D p2){
        return close2equals(p2, EPS);
    }
    
    /**
     * This method returns the vector between this point and the target point. The vector is represented as a Point2D.
     * @param target
     * @return
     */
    public Point2D vector(Point2D target) {
    	double dx = target.x() - this.x();
    	double dy = target.y() - this.y();
    	return new Point2D(dx,dy);
    }

    /**
     * This method get point and check if the point is equal to specific point.
     * @param ot - a query 2D point
     * @return
     */
    @Override
	public boolean contains(Point2D ot) {
		return this.equals(ot);
	}

    /**
     * @return point that it's the center of mass of itself.
     */
	@Override
	public Point2D centerOfMass() {
		// TODO Auto-generated method stub
		return new Point2D(this);
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * This method get point and change the values of point.
     * @param vec - a vector from the 0,0
     */
	@Override
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}

    /**
     * This method return a copy of point.
     * @return
     */
	@Override
	public GeoShape copy() {
		return new Point2D(this);
	}

    /**
     * This method return array that had values of point.
     * @return
     */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] =new Point2D(this);
		return ans;
	}
}