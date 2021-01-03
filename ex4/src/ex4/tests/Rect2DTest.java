package ex4.tests;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Rect2DTest {

    @Test
    void rightLeft(){
        Point2D p1 = new Point2D(1,4);
        Point2D p2 = new Point2D(-2,1);
        Rect2D r = new Rect2D(p1,p2);
        assertEquals(p1, r.getRight());
        assertEquals(p2, r.getLeft());
    }

    @Test
    void contains(){
        Point2D point1 = new Point2D(1,2);
        Point2D point2 = new Point2D(1,2);
        Point2D point3 = new Point2D(-1,1);
        Point2D point4 = new Point2D(1,2);
        Rect2D rect = new Rect2D(point1, point2);
        assertFalse(rect.contains(point3));
        Point2D p1 = new Point2D(-2,6);
        Point2D p2 = new Point2D(-5,4);
        Rect2D r = new Rect2D(p1,p2);
        Point2D p3 = new Point2D(-4, 4);
        Point2D p4 = new Point2D(-5,3);
        assertTrue(r.contains(p3));
        assertFalse(r.contains(p4));
        assertEquals(point1.centerOfMass(), point4.centerOfMass());
    }

    @Test
    void centerOfMass() {
        Point2D point1 = new Point2D(1,2);
        Point2D point2 = new Point2D(1,2);
        Rect2D rect = new Rect2D(point1, point2);
        assertEquals(point1, rect.centerOfMass());
        Point2D p1 = new Point2D(5,7);
        Point2D p2 = new Point2D(1,4);
        Rect2D r = new Rect2D(p1, p2);
        Point2D p3 = new Point2D(3,5.5);
        assertEquals(p3, r.centerOfMass());
    }

    @Test
    void area(){
        Point2D p1 = new Point2D(3,7);
        Point2D p2 = new Point2D(-2.4, 3.2);
        Rect2D r = new Rect2D(p1, p2);
        assertEquals(20.52, r.area());
    }

    @Test
    void perimeter(){
        Point2D p1 = new Point2D(-0.7, -10);
        Point2D p2 = new Point2D(-3, -15.7);
        Rect2D r = new Rect2D(p1, p2);
        assertEquals(16, r.perimeter(), 0.01);
    }

    @Test
    void move(){
        Point2D p1 = new Point2D(5,10);
        Point2D p2 = new Point2D(1,7);
        Point2D p3 = new Point2D(3,9);
        Point2D p4 = new Point2D(6,17.5);
        Rect2D r = new Rect2D(p1, p2);
        r.move(p3);
        assertEquals(p4, r.centerOfMass());
    }

    @Test
    void copy(){
        Point2D p1 = new Point2D(2,-4.3);
        Point2D p2 = new Point2D(0, -6);
        Rect2D r = new Rect2D(p1, p2);
        GeoShape g = r.copy();
        assertEquals(r, g);
    }

    @Test
    void getPoints(){
        Point2D p1 = new Point2D(1,0.3);
        Point2D p2 = new Point2D(-2, -3);
        Rect2D r = new Rect2D(p1, p2);
        Point2D[] p = new Point2D[2];
        p[0] = new Point2D(p1);
        p[1] = new Point2D(p2);
        assertArrayEquals(p, r.getPoints());
    }
}
