package ex4.tests;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class Circle2DTest {

    @Test
    void centerAndRadius(){
        Point2D p = new Point2D(1,3);
        Circle2D c = new Circle2D(p, 10);
        assertEquals(p, c.center());
        assertEquals(10,c.getRadius());
    }

    @Test
    void contains(){
        Point2D p = new Point2D(-1,-5);
        Circle2D c = new Circle2D(p,5);
        Point2D p1 = new Point2D(5,0);
        Point2D p2 = new Point2D(2,-4);
        assertFalse(c.contains(p1));
        assertTrue(c.contains(p2));
    }

    @Test
    void centerOfMass(){
        Point2D p = new Point2D(2,6);
        Circle2D c = new Circle2D(p,2);
        assertEquals(c.centerOfMass(), p);
    }

    @Test
    void area(){
        Point2D p = new Point2D(4,5);
        Circle2D c = new Circle2D(p,3);
        assertEquals(Math.PI * 9 , c.area());
    }

    @Test
    void perimeter(){
        Point2D p = new Point2D(3,8);
        Circle2D c = new Circle2D(p, 4);
        assertEquals(Math.PI * 8, c.perimeter());
    }

    @Test
    void move(){
        Point2D p = new Point2D(4,8);
        Circle2D c = new Circle2D(p, 5);
        Point2D p1 = new Point2D(5,6);
        Point2D p2 = new Point2D(9,14);
        c.move(p1);
        assertEquals(p2, c.centerOfMass());
    }

    @Test
    void copy(){
        Point2D p = new Point2D(3,-9);
        Circle2D c = new Circle2D(p, 6);
        GeoShape g = c.copy();
        assertEquals(c, g);
    }

    @Test
    void getPoints(){
        Point2D point = new Point2D(3,4);
        Circle2D c = new Circle2D(point, 7);
        System.out.println(Arrays.toString(c.getPoints()));
    }
}
