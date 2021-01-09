package ex4;

import java.awt.*;
import java.io.*;
import java.util.*;
import ex4.geometry.*;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Shape_Collection implements GUI_Shape_Collection {
    private ArrayList<GUI_Shape> gui_shape;

    /**
     * Constructor that get empty all the variables.
     */
    public Shape_Collection() {
        this.gui_shape = new ArrayList<>();
    }

    /**
     * Constructor that get a Shape_Collection.
     * @param s
     */
    public Shape_Collection(Shape_Collection s) {
        this.gui_shape = new ArrayList<GUI_Shape>(s.getArrayList());
    }

    /**
     * This method return ArrayList of GUI_Shape.
     * @return
     */
    private ArrayList<GUI_Shape> getArrayList() {
        return this.gui_shape;
    }

    /**
     * This method get a number and return the shape that at this index.
     * @param i - the index of the element
     * @return
     */
    @Override
    public GUI_Shape get(int i) {
        return this.gui_shape.get(i);
    }

    /**
     * @return the size of GUI_Shape.
     */
    @Override
    public int size() {
        if (!this.gui_shape.isEmpty())
            return this.gui_shape.size();
        return 0;
    }

    /**
     * This method get a number and remove an element and return it.
     * @param i - the index of the element to be removed.
     * @return
     */
    @Override
    public GUI_Shape removeElementAt(int i) {
        return this.gui_shape.remove(i);
    }

    /**
     * This method get a GUI_Shape and a number and add element at a specific index in the arrayList.
     * @param s - the gui_shape
     * @param i - the location (index) in which s should be added
     */
    @Override
    public void addAt(GUI_Shape s, int i) {
        this.gui_shape.add(i, s);
    }

    /**
     * This method get a GUI_Shape and add the element to the arrayList.
     * @param s - the gui_shape
     */
    @Override
    public void add(GUI_Shape s) {
        if (!this.gui_shape.contains(s))
            this.gui_shape.add(s);
    }

    /**
     * This method return a copy of GUI_Shape.
     * @return
     */
    @Override
    public GUI_Shape_Collection copy() {
        return new Shape_Collection(this);
    }

    /**
     * This method get a Comparator and sort the GUI_Shape.
     * @param comp a linear order over gui_sahpes as defined in java.util.Comparator
     */
    @Override
    public void sort(Comparator<GUI_Shape> comp) {
        Collections.sort(this.gui_shape, comp);
    }

    /**
     * This method remove the GUI_Shape.
     */
    @Override
    public void removeAll() {
        this.gui_shape = new ArrayList<>();
    }

    /**
     * This method get string and save the GUI_Shape in a file text.
     * @param file
     */
    @Override
    public void save(String file) {
        try {
            File file1 = new File(file);
            String s = "";
            for (int i = 0; i < this.gui_shape.size(); i++) {
                s += this.gui_shape.get(i) + ", " + "\n";
            }
            FileWriter fileW = new FileWriter(file1);
            fileW.write(s);
            fileW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method get string and load the GUI_Shape from a file text.
     * @param file - the name of the text file to create a gui shape file from.
     */
    @Override
    public void load(String file) {
        try {

            File f = new File(file);
            Scanner sc = new Scanner(f);
            this.removeAll();
            int i = 0;
            while (sc.hasNextLine()){
                String d = sc.nextLine();
                String[] s = d.split(",");
                if (s[0].equals("GUIShape")){
                    if (s[4].equals("Point2D")){
                        Point2D poi = new Point2D(Double.parseDouble(s[5]), Double.parseDouble(s[6]));
                        GUIShape g = new GUIShape(poi, Boolean.parseBoolean(s[2]),
                                new Color(Integer.parseInt(s[1])&0xffffff),
                                Integer.parseInt(s[3]));
                        this.gui_shape.add(i, g);
                    }
                    if(s[4].equals("Segment2D")){
                        Segment2D seg = new Segment2D(new Point2D(Double.parseDouble(s[5]), Double.parseDouble(s[6])), new Point2D(Double.parseDouble(s[7]), Double.parseDouble(s[8])));
                        GUIShape g = new GUIShape(seg, Boolean.parseBoolean(s[2]),
                                new Color(Integer.parseInt(s[1])&0xffffff),
                                Integer.parseInt(s[3]));
                        this.gui_shape.add(i, g);
                    }
                    if(s[4].equals("Circle2D")){
                        Circle2D cir = new Circle2D(new Point2D(Double.parseDouble(s[5]), Double.parseDouble(s[6])), Double.parseDouble(s[7]));
                        GUIShape g = new GUIShape(cir, Boolean.parseBoolean(s[2]),
                                new Color(Integer.parseInt(s[1])&0xffffff),
                                Integer.parseInt(s[3]));
                        this.gui_shape.add(i, g);
                    }
                    if(s[4].equals("Triangle2D")){
                        Triangle2D tri = new Triangle2D(new Point2D(Double.parseDouble(s[5]), Double.parseDouble(s[6])), new Point2D(Double.parseDouble(s[7]), Double.parseDouble(s[8])),new Point2D(Double.parseDouble(s[9]), Double.parseDouble(s[10])));
                        GUIShape g = new GUIShape(tri, Boolean.parseBoolean(s[2]),
                                new Color(Integer.parseInt(s[1])&0xffffff),
                                Integer.parseInt(s[3]));
                        this.gui_shape.add(i, g);
                    }
                    if(s[4].equals("Rect2D")){
                        Rect2D rec = new Rect2D(new Point2D(Double.parseDouble(s[5]),Double.parseDouble(s[6])), new Point2D(Double.parseDouble(s[7]), Double.parseDouble(s[8])));
                        GUIShape g = new GUIShape(rec, Boolean.parseBoolean(s[2]),
                                new Color(Integer.parseInt(s[1])&0xffffff),
                                Integer.parseInt(s[3]));
                        this.gui_shape.add(i, g);
                    }
                    i++;
                }
            }
        } catch(IOException e) {
            System.out.println("cannot read to file");
        }
    }

    /**
     * This method return a rectangle that it's the bound of the box.
     * @return
     */
    @Override
    public Rect2D getBoundingBox() {
        ArrayList<Point2D> arrayPoints = new ArrayList<>();
        for (int i = 0; i < this.gui_shape.size(); i++) {
            if (this.gui_shape.get(i).getShape() instanceof Circle2D) {
                Point2D center = this.gui_shape.get(i).getShape().centerOfMass();
                double rad = ((Circle2D) this.gui_shape.get(i).getShape()).getRadius();
                Point2D point0 = new Point2D(center.x() - rad, center.y() - rad);
                Point2D point1 = new Point2D(center.x() + rad, center.y() + rad);
                Point2D point2 = new Point2D(center.x() + rad, center.y() - rad);
                Point2D point3 = new Point2D(center.x() - rad, center.y() + rad);
                arrayPoints.add(point0);
                arrayPoints.add(point1);
                arrayPoints.add(point2);
                arrayPoints.add(point3);
            }
            for (Point2D point : this.gui_shape.get(i).getShape().getPoints()) {
                arrayPoints.add(point);
            }
        }
        double lP1 = Double.MAX_VALUE;
        double rP1 = Double.MIN_VALUE;
        double lP2 = Double.MAX_VALUE;
        double rP2 = Double.MIN_VALUE;

        for (int i = 0; i < arrayPoints.size(); i++) {
            if (arrayPoints.get(i).x() <= lP1) {
                lP1 = arrayPoints.get(i).x();
            }
            if (arrayPoints.get(i).y() <= lP2) {
                lP2 = arrayPoints.get(i).y();
            }
            if (arrayPoints.get(i).x() >= rP1) {
                rP1 = arrayPoints.get(i).x();
            }
            if (arrayPoints.get(i).y() >= rP2) {
                rP2 = arrayPoints.get(i).y();
            }
        }
        Point2D left = new Point2D(lP1, lP2);
        Point2D right = new Point2D(rP1, rP2);
        return new Rect2D(left, right);
    }

    @Override
    public String toString() {
        return "" + this.gui_shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape_Collection)) return false;
        Shape_Collection that = (Shape_Collection) o;
        return Objects.equals(gui_shape, that.gui_shape);
    }


}