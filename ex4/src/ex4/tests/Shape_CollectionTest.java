package ex4.tests;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Collection;
import ex4.geometry.*;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Shape_CollectionTest {

    @Test
    void get(){
        Point2D p1 = new Point2D(0,1);
        Point2D p2 = new Point2D(2,3);
        Point2D p3 = new Point2D(5,6);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GeoShape s = new Segment2D(p1, p3);
        GUI_Shape gui = new GUIShape(t);
        GUI_Shape gui1 = new GUIShape(s);
        GUI_Shape_Collection c = new Shape_Collection();
        c.add(gui);
        c.add(gui1);
        assertEquals(gui, c.get(0));
        assertEquals(gui1, c.get(1));
    }

    @Test
    void size(){
        Point2D p1 = new Point2D(-1,1);
        Point2D p2 = new Point2D(0,3);
        Point2D p3 = new Point2D(5,6);
        GeoShape c = new Circle2D(p1, 5.1);
        GeoShape r = new Rect2D(p2, p3);
        GUI_Shape gui = new GUIShape(c);
        GUI_Shape gui1 = new GUIShape(r);
        GUI_Shape_Collection collection = new Shape_Collection();
        collection.add(gui);
        collection.add(gui1);
        assertEquals(2, collection.size());
    }

    @Test
    void removeElementAt(){
        Point2D p1 = new Point2D(2,3);
        Point2D p2 = new Point2D(4.2,2);
        Point2D p3 = new Point2D(5,6);
        GeoShape c = new Circle2D(p1, 5.1);
        GeoShape s = new Segment2D(p2, p3);
        GUI_Shape gui = new GUIShape(c);
        GUI_Shape gui1 = new GUIShape(s);
        GUI_Shape_Collection collection = new Shape_Collection();
        collection.add(gui);
        collection.add(gui1);
        assertEquals(2, collection.size());
        collection.removeElementAt(1);
        assertEquals(gui, collection.get(0));
        assertEquals(1, collection.size());
    }

    @Test
    void addAt(){
        GUI_Shape_Collection collection = new Shape_Collection();
        Point2D p1 = new Point2D(-3.2, 2);
        Point2D p2 = new Point2D(2.1, 4);
        Point2D p3 = new Point2D(4,1);
        GeoShape point = new Point2D(p3);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GUI_Shape gui = new GUIShape(t);
        GUI_Shape gui1 = new GUIShape(point);
        collection.addAt(gui1, 0);
        collection.addAt(gui, 1);
        assertEquals(gui1, collection.get(0));
        assertEquals(gui, collection.get(1));
        collection.addAt(gui1, 1);
        assertEquals(gui1, collection.get(1));
    }

    @Test
    void add(){
        GUI_Shape_Collection collection = new Shape_Collection();
        Point2D p1 = new Point2D(-3, 2);
        Point2D p2 = new Point2D(2, 4);
        GeoShape r = new Rect2D(p1, p2);
        GeoShape c = new Circle2D(p1, 4.3);
        GeoShape s = new Segment2D(p1, p2);
        GeoShape p = new Point2D(p2);
        GUI_Shape gui1 = new GUIShape(r);
        GUI_Shape gui2 = new GUIShape(c);
        GUI_Shape gui3 = new GUIShape(s);
        GUI_Shape gui4 = new GUIShape(p);
        collection.add(gui1);
        collection.add(gui2);
        collection.add(gui3);
        collection.add(gui4);
        assertEquals(4, collection.size());
    }

    @Test
    void copy(){
        GUI_Shape_Collection collection = new Shape_Collection();
        Point2D p1 = new Point2D(-3, 2);
        Point2D p2 = new Point2D(2, 4);
        GeoShape r = new Rect2D(p1, p2);
        GeoShape c = new Circle2D(p1, 4.3);
        GeoShape s = new Segment2D(p1, p2);
        GeoShape p = new Point2D(p2);
        GUI_Shape gui1 = new GUIShape(r);
        GUI_Shape gui2 = new GUIShape(c);
        GUI_Shape gui3 = new GUIShape(s);
        GUI_Shape gui4 = new GUIShape(p);
        collection.add(gui1);
        collection.add(gui2);
        collection.add(gui3);
        collection.add(gui4);
        GUI_Shape_Collection col = collection.copy();
        assertEquals(col.size(), collection.size());
        assertEquals(gui1, col.get(0));
        assertEquals(gui2, col.get(1));
        assertEquals(gui3, col.get(2));
        assertEquals(gui4, col.get(3));
    }

    @Test
    void removeAll(){
        GUI_Shape_Collection collection = new Shape_Collection();
        Point2D p1 = new Point2D(-1, 2);
        Point2D p2 = new Point2D(2, 4);
        GeoShape s = new Segment2D(p1, p2);
        GeoShape r = new Rect2D(p1, p2);
        GUI_Shape gui = new GUIShape(s);
        GUI_Shape gui2 = new GUIShape(r);
        collection.add(gui);
        collection.add(gui2);
        assertEquals(2, collection.size());
        collection.removeAll();
        assertEquals(0, collection.size());
    }

    @Test
    void saveAndLoad(){
        GUI_Shape_Collection collection = new Shape_Collection();
        Point2D p1 = new Point2D(1,2);
        Point2D p2 = new Point2D(2,4);
        Point2D p3 = new Point2D(4,6);
        GeoShape p = new Point2D(p1);
        GeoShape s = new Segment2D(p1, p2);
        GeoShape c = new Circle2D(p3, 2.5);
        GeoShape r = new Rect2D(p2, p3);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GUI_Shape gui1 = new GUIShape(p);
        GUI_Shape gui2 = new GUIShape(s);
        GUI_Shape gui3 = new GUIShape(c);
        GUI_Shape gui4 = new GUIShape(r);
        GUI_Shape gui5 = new GUIShape(t);
        collection.add(gui1);
        collection.add(gui2);
        collection.add(gui3);
        collection.add(gui4);
        collection.add(gui5);
        collection.save("Shapes.txt");
        GUI_Shape_Collection collection1 = collection.copy();
        collection1.load("Shapes.txt");
        assertEquals(collection, collection1);
    }

    @Test
    void getBoundingBox(){
        GUI_Shape_Collection collection = new Shape_Collection();
        Point2D p1 = new Point2D(1,2);
        Point2D p2 = new Point2D(2,4);
        Point2D p3 = new Point2D(4,6);
        GeoShape p = new Point2D(p1);
        GeoShape s = new Segment2D(p1, p2);
        GeoShape c = new Circle2D(p3, 2.5);
        GeoShape r = new Rect2D(p2, p3);
        GeoShape t = new Triangle2D(p1, p2, p3);
        GUI_Shape gui1 = new GUIShape(p);
        GUI_Shape gui2 = new GUIShape(s);
        GUI_Shape gui3 = new GUIShape(c);
        GUI_Shape gui4 = new GUIShape(r);
        GUI_Shape gui5 = new GUIShape(t);
        collection.add(gui1);
        collection.add(gui2);
        collection.add(gui3);
        collection.add(gui4);
        collection.add(gui5);
        Point2D p4 = new Point2D(4,8.5);
        Point2D p5 = new Point2D(1, 2);
        Rect2D rect = new Rect2D(p4, p5);
        assertEquals(rect, collection.getBoundingBox());
        collection.save("shape.txt");
        GUI_Shape_Collection sc = collection.copy();
        sc.load("shape.txt");

    }

}
