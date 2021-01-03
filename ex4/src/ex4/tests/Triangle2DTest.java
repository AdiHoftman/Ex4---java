package ex4.tests;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Triangle2DTest {

    @Test
    void contains() {
        Point2D p1 = new Point2D(4,5);
        Point2D p2 = new Point2D(2,1);
        Point2D p3 = new Point2D(6,3);
        Point2D p4 = new Point2D(5,4);
        Point2D p5 = new Point2D(3,4);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        assertTrue(t.contains(p4));
        assertFalse(t.contains(p5));
    }

    @Test
    void centerOfMass(){
        Point2D p1 = new Point2D(-1,5.2);
        Point2D p2 = new Point2D(2, 2);
        Point2D p3 = new Point2D(3,7);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        Point2D p4 = new Point2D(1.1666666666666667,3.533333333333333);
        assertEquals(p4, t.centerOfMass());
    }

    @Test
    void area(){
        Point2D p1 = new Point2D(-2.5, 2.4);
        Point2D p2 = new Point2D(4,5);
        Point2D p3 = new Point2D(9 ,10);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        assertEquals(t.area(), 9.75000000000003);
    }

    @Test
    void perimeter(){
        Point2D p1 = new Point2D(3, 4);
        Point2D p2 = new Point2D(6,8);
        Point2D p3 = new Point2D(9 ,10);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        assertEquals(t.perimeter(), 17.09083264970256);
    }

    @Test
    void move(){
        Point2D p1 = new Point2D(1, 0);
        Point2D p2 = new Point2D(4,2);
        Point2D p3 = new Point2D(6 ,4);
        Point2D p4 = new Point2D(8,5);
        Point2D p5 = new Point2D(8.166666666666666,5);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        t.move(p4);
        assertEquals(t.centerOfMass(), p5);
    }

    @Test
    void copy(){
        Point2D p1 = new Point2D(-5.5, 3);
        Point2D p2 = new Point2D(-2,2);
        Point2D p3 = new Point2D(0 ,0);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        GeoShape g = t.copy();
        assertEquals(t, g);
    }

    @Test
    void getPoints(){
        Point2D p1 = new Point2D(-5, 4);
        Point2D p2 = new Point2D(-2,1);
        Point2D p3 = new Point2D(0 ,-2);
        Triangle2D t = new Triangle2D(p1, p2, p3);
        Point2D[] p = new Point2D[3];
        p[0] = new Point2D(p1);
        p[1] = new Point2D(p2);
        p[2] = new Point2D(p3);
        assertArrayEquals(p, t.getPoints());
    }
}
