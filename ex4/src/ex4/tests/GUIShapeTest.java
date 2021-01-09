package ex4.tests;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.geometry.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GUIShapeTest {

    @Test
    void getShape(){
        Point2D p = new Point2D(-2, 1);
        GeoShape c = new Circle2D(p, 2);
        GUI_Shape gui = new GUIShape(c);
        assertEquals(c, gui.getShape());
        Point2D p1 = new Point2D(2,5);
        Point2D p2 = new Point2D(5,7);
        GeoShape r = new Rect2D(p2, p1);
        GUI_Shape gui2 = new GUIShape(r);
        assertEquals(r, gui2.getShape());
    }

    @Test
    void setShape(){
        Point2D p1 = new Point2D(0,0);
        Point2D p2 = new Point2D(2,2);
        Point2D p3 = new Point2D(4,1);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GUI_Shape gui = new GUIShape();
        gui.setShape(t);
        assertEquals(t,gui.getShape());
    }

    @Test
    void isFilled(){
        Point2D p1 = new Point2D(3,5.2);
        Point2D p2 = new Point2D(7,9);
        GeoShape p = new Point2D(3,5.2);
        GeoShape r = new Rect2D(p1, p2);
        GUI_Shape gui = new GUIShape(r);
        assertFalse(gui.isFilled());
        gui.setShape(p);
        assertFalse(gui.isFilled());
    }

    @Test
    void setFilled(){
        Point2D p = new Point2D(1,2);
        GeoShape c = new Circle2D(p, 5);
        GUI_Shape gui = new GUIShape(c);
        assertFalse(gui.isFilled());
        gui.setFilled(true);
        assertTrue(gui.isFilled());
    }

    @Test
    void getColor(){
        Point2D p1 = new Point2D(3,5);
        Point2D p2 = new Point2D(6,7);
        Point2D p3 = new Point2D(9,5);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GUI_Shape gui = new GUIShape(t);
        Color color = new Color(000,000,000);
        assertEquals(color, gui.getColor());
    }

    @Test
    void setColor(){
        Point2D p1 = new Point2D(3,5);
        Point2D p2 = new Point2D(6,7);
        Point2D p3 = new Point2D(9,5);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GUI_Shape gui = new GUIShape(t);
        Color color = new Color(000,000,000);
        assertEquals(color, gui.getColor());
        Color c = new Color(100, 100, 100);
        gui.setColor(c);
        assertEquals(c, gui.getColor());
    }

    @Test
    void getTag(){
        Point2D p1 = new Point2D(1,2);
        Point2D p2 = new Point2D(4.2, 5);
        GeoShape r = new Rect2D(p2, p1);
        GUI_Shape gui = new GUIShape(r);
        assertEquals(0, gui.getTag());
    }

    @Test
    void setTag(){
        Point2D p1 = new Point2D(1,2);
        Point2D p2 = new Point2D(4.2, 5);
        GeoShape r = new Rect2D(p2, p1);
        GUI_Shape gui = new GUIShape(r);
        assertEquals(0, gui.getTag());
        gui.setTag(2);
        assertEquals(2, gui.getTag());
    }

    @Test
    void copy(){
        Point2D p1 = new Point2D(3,5);
        Point2D p2 = new Point2D(0,1);
        GeoShape s = new Segment2D(p1, p2);
        GUI_Shape gui = new GUIShape(s);
        GUI_Shape gui2 = gui.copy();
        assertEquals(gui, gui2);
    }


}
