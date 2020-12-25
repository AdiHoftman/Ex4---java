package ex4.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;

public class Point2DTest {
	
	@Test
	void add(){
		Point2D a = new Point2D(3,5);
		Point2D b = new Point2D(6,8);
		b = new Point2D(b.add(a));
		Point2D c = new Point2D(4,3);
		Point2D d = new Point2D(5, 10);
		d = new Point2D(d.add(c));
		assertEquals(new Point2D(9,13), b);
		assertEquals(b, d);
	}

	@Test
	void distance() {
		Point2D a = new Point2D(2,4);
		Point2D b = new Point2D(5,6);
		double dist = a.distance(b);
		assertEquals(Math.sqrt(13), dist);
	}
}
