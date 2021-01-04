package ex4;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.awt.geom.Rectangle2D;

import ex4.geometry.*;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Shape_Collection implements GUI_Shape_Collection, Comparator<GUI_Shape> {
    private ArrayList<GUI_Shape> gui_shape;
    private double x, y;

    public Shape_Collection() {
        this.gui_shape = new ArrayList<>();
    }

    public Shape_Collection(Shape_Collection s) {
        this.gui_shape = new ArrayList<GUI_Shape>(s.getArrayList());
    }

    public ArrayList<GUI_Shape> getArrayList() {
        return this.gui_shape;
    }

    @Override
    public GUI_Shape get(int i) {
        return this.gui_shape.get(i);
    }

    @Override
    public int size() {
        if (!this.gui_shape.isEmpty())
            return this.gui_shape.size();
        return 0;
    }

    @Override
    public GUI_Shape removeElementAt(int i) {
        return this.gui_shape.remove(i);
    }

    @Override
    public void addAt(GUI_Shape s, int i) {
        this.gui_shape.add(i, s);
    }

    @Override
    public void add(GUI_Shape s) {
        if (!this.gui_shape.contains(s))
            this.gui_shape.add(s);
    }

    @Override
    public GUI_Shape_Collection copy() {
        return new Shape_Collection(this);
    }

    @Override
    public void sort(Comparator comp) {
        this.gui_shape.sort(comp);
    }

    @Override
    public void removeAll() {
        this.gui_shape = new ArrayList<>();
    }

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

    @Override
    public void load(String file) {
        try {
            File file1 = new File(file);
            Scanner load = new Scanner(file1);
            while (load.hasNextLine()) {
                String next = load.nextLine();
                for (int i = 0; i < this.gui_shape.size(); i++) {
                    next += this.gui_shape.get(i);
                }
            }
            load.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Rect2D getBoundingBox() {
        ArrayList<Point2D> p = new ArrayList<>();
        for (int i = 0; i < this.gui_shape.size(); i++) {
            for (Point2D point : this.gui_shape.get(i).getShape().getPoints())
                p.add(point);
        }
        double lp = Double.MAX_VALUE;
        double rp = Double.MIN_VALUE;
        double bp = Double.MAX_VALUE;
        double tp = Double.MIN_VALUE;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).x() >= rp)
                rp = p.get(i).x();
            if (p.get(i).x() <= lp)
                lp = p.get(i).x();
            if (p.get(i).y() >= tp)
                tp = p.get(i).y();
            if (p.get(i).y() <= bp)
                bp = p.get(i).y();
        }
        Point2D pointR = new Point2D(rp, tp);
        Point2D pointL = new Point2D(lp, bp);
        return new Rect2D(pointR, pointL);
    }

    @Override
    public String toString() {
        return "" + this.gui_shape;
    }

    @Override
    public int compare(GUI_Shape o1, GUI_Shape o2) {
        if (o1.getTag() > o2.getTag()) return -1;
        return 1;
    }
}