package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import java.util.Objects;
import ex4.geometry.*;

public class GUIShape implements GUI_Shape{
	private GeoShape geoShape;
	private int tag;
	private boolean filled;
	private Color color;

	/**
	 * Constructor that get empty all the variable.
	 */
	public GUIShape(){
		this.geoShape = null;
		this.filled = false;
		this.color = new Color(000,000, 000);
		this.tag = 0;
	}

	/**
	 * Constructor that get GeoShape.
	 * @param geo
	 */
	public GUIShape(GeoShape geo){
		this.geoShape = geo;
		this.filled = false;
		this. color = new Color(000,000, 000);
		this.tag = 0;
	}

	/**
	 * Main constructor.
	 * @param geo
	 * @param f
	 * @param c
	 * @param t
	 */
	public GUIShape(GeoShape geo,boolean f ,Color c, int t){
		this.geoShape = geo.copy();
		this.filled = f;
		this.color = c;
		this.tag = t;
	}

	/**
	 * @return the shape of GUIShape.
	 */
	@Override
	public GeoShape getShape() {
		return this.geoShape;
	}

	/**
	 * Change the shape of GUIShape.
	 * @param g
	 */
	@Override
	public void setShape(GeoShape g) {
		this.geoShape = g;
	}

	/**
	 * @return true if the shape is filled.
	 */
	@Override
	public boolean isFilled() {
		return this.filled;
	}

	/**
	 * Change true or false if the shape is filled or not.
 	 * @param filled
	 */
	@Override
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * @return the color of the shape.
	 */
	@Override
	public Color getColor() {
		return this.color;
	}

	/**
	 * Change the color of the shape.
	 * @param cl
	 */
	@Override
	public void setColor(Color cl) {
		this.color = cl;
	}

	/**
	 * @return the tag of the shape.
	 */
	@Override
	public int getTag() {
		return this.tag;
	}

	/**
	 * Change the tag of the shape.
	 * @param tag
	 */
	@Override
	public void setTag(int tag) {
		this.tag = tag;
	}

	/**
	 * 
	 * @return a copy GUI_Shape.
	 */
	@Override
	public GUI_Shape copy() {
		return new GUIShape(this.geoShape, this.filled, this.color, this.tag);
	}

	@Override
	public String toString() {
		return "GUIShape," +
				((int)this.color.getRGB()&0xffffff ) +
				"," + this.filled +
				"," + this.tag +
				"," + this.geoShape.getClass().getSimpleName() +
				"," + this.getShape() + "\n";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GUIShape guiShape = (GUIShape) o;
		return tag == guiShape.tag &&
				filled == guiShape.filled &&
				Objects.equals(geoShape, guiShape.geoShape) &&
				Objects.equals(color, guiShape.color);
	}
}