package ex4.tests;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Segment2DTest {

    @Test
    void contains(){
        Point2D p1 = new Point2D(4,8);
        Point2D p2 = new Point2D(1,-2.5);
        Point2D p3 = new Point2D(3,4);
        Point2D p4 = new Point2D(2,1);
        Segment2D s = new Segment2D(p1, p2);
        assertFalse(s.contains(p3));
        assertTrue(s.contains(p4));
    }

    @Test
    void centerOfMass(){
        Point2D p1 = new Point2D(7.6, 5.4);
        Point2D p2 = new Point2D(-2.2, 1.5);
        Point2D p3 = new Point2D(2.6999999999999997, 3.45);
        Segment2D s = new Segment2D(p1, p2);
        assertEquals(p3, s.centerOfMass());
    }

    @Test
    void perimeter(){
        Point2D p1 = new Point2D(3.5, 4);
        Point2D p2 = new Point2D(-2, 1.2);
        Point2D p3 = new Point2D(3.5, 4);
        Segment2D s = new Segment2D(p1, p2);
        assertEquals(s.perimeter(), 12.3434193, 0.1);
        Segment2D s1 = new Segment2D(p1, p3);
        assertEquals(s1.perimeter(), 0);
    }

    @Test
    void move(){
        Point2D p1 = new Point2D(6.5,9);
        Point2D p2 = new Point2D(3,4.5);
        Point2D p3 = new Point2D(6,7);
        Point2D p4 = new Point2D(10.75, 13.75);
        Segment2D s = new Segment2D(p1, p2);
        s.move(p3);
        assertEquals(p4, s.centerOfMass());
    }

    @Test
    void copy(){
        Point2D p1 = new Point2D(4.5, 6);
        Point2D p2 = new Point2D(2,3);
        Segment2D s = new Segment2D(p1, p2);
        GeoShape g = s.copy();
        assertEquals(s, g);
    }

    @Test
    void getPoints(){
        Point2D p1 = new Point2D(5,6);
        Point2D p2 = new Point2D(1,2);
        Segment2D s = new Segment2D(p1, p2);
        Point2D[] p = new Point2D[2];
        p[0] = new Point2D(p1);
        p[1] = new Point2D(p2);
        assertArrayEquals(p, s.getPoints());
    }
}
