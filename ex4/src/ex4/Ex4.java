package ex4;

import ex4.geometry.*;
import ex4.tests.Test_Ex4;

/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 *
 * @author boaz.benmoshe
 */
public class Ex4 implements Ex4_GUI {

    public static void main(String args[]) {
        String file = args[0];
        int sortNum = Integer.parseInt(args[1]);
        if (sortNum >= 7 || sortNum <= -1) {
            System.err.println("The number should to be between 0 to 5, try again!");
            sortNum = 0;
        }
        Ex4 ex4 = new Ex4();
        GUI_Shape_Collection gui = ex4.getShape_Collection();
        Shape_Comp comp = new Shape_Comp(sortNum);
        gui.load(file);
        gui.sort(comp);
        ex4.show();
    }

    private GUI_Shape_Collection gui_shape_collection;

    public Ex4() {
        this.gui_shape_collection = new Shape_Collection();
    }

    /**
     * This method get a GUI_Shape and initialize the GUI_Shape.
     *
     * @param g: the GUI_Shape_Collection object
     */
    @Override
    public void init(GUI_Shape_Collection g) {
        this.gui_shape_collection = g;
    }

    /**
     * This method return a collection of the GUI_Shape.
     *
     * @return
     */
    @Override
    public GUI_Shape_Collection getShape_Collection() {
        return this.gui_shape_collection;
    }

    /**
     * This method show the GUI_Shape on screen.
     */
    @Override
    public void show() {
        for (int i = 0; i < this.gui_shape_collection.size(); i++) {
            if (this.gui_shape_collection.get(i).getShape() instanceof Rect2D) {
                if (!this.gui_shape_collection.get(i).isFilled()) {
                    StdDraw.Rect2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            this.gui_shape_collection.get(i).getShape().getPoints()[1],
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.setPenRadius(0.01);
                    StdDraw.show();
                } else {
                    StdDraw.filledRect2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            this.gui_shape_collection.get(i).getShape().getPoints()[1],
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.setPenRadius(0.01);
                    StdDraw.show();
                }
            }
            if (this.gui_shape_collection.get(i).getShape() instanceof Circle2D) {
                if (!this.gui_shape_collection.get(i).isFilled()) {
                    StdDraw.Circle2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            ((Circle2D) this.gui_shape_collection.get(i).getShape()).getRadius(),
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.show();
                } else {
                    StdDraw.filledCircle2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            ((Circle2D) this.gui_shape_collection.get(i).getShape()).getRadius(),
                            this.gui_shape_collection.get(i).getColor());
                }
            }
            if (this.gui_shape_collection.get(i).getShape() instanceof Segment2D) {
                if (this.gui_shape_collection.get(i).isFilled()) {
                    StdDraw.filledSegment2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            this.gui_shape_collection.get(i).getShape().getPoints()[1],
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.show();
                } else {
                    StdDraw.Segment2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            this.gui_shape_collection.get(i).getShape().getPoints()[1],
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.show();
                }
            }

            if (this.gui_shape_collection.get(i).getShape() instanceof Triangle2D) {
                if (!this.gui_shape_collection.get(i).isFilled()) {
                    StdDraw.Triangle2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            this.gui_shape_collection.get(i).getShape().getPoints()[1],
                            this.gui_shape_collection.get(i).getShape().getPoints()[2],
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.show();
                } else {
                    StdDraw.filledTriangle2D(this.gui_shape_collection.get(i).getShape().getPoints()[0],
                            this.gui_shape_collection.get(i).getShape().getPoints()[1],
                            this.gui_shape_collection.get(i).getShape().getPoints()[2],
                            this.gui_shape_collection.get(i).getColor());
                    StdDraw.show();
                }
            }
        }
    }

    /**
     * This method return the info of the GUI_Shape.
     *
     * @return
     */
    @Override
    public String getInfo() {
        return this.gui_shape_collection.toString();
    }

    public String toString() {
        return "" + this.gui_shape_collection;
    }
}