package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;


/**
 * 
 * 
 * @author Karolina
 * @edit Wojtek
 */

public class Lissajous extends JPanel {

	int a = 0;
	int b = 0;
	int red = 0, green = 0, blue = 0;
	int A = 1;
	int B = 1;
	double d = (Math.PI / 2);

	/**
	 * @author Wojtek
	 */
	public void setValues(int xx, int yy, int rr, int bb, int gg, int bigA,
			int bigB, int delta) {
		a = xx;
		b = yy;
		red = rr;
		green = gg;
		blue = bb;
		A = bigA;
		B = bigB;
		d = delta;

	}

	/**
	 * @author Karolina
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		/**
		 * uzywane do malowania danego obszaru nie calosci po usunięciu tej
		 * linijki layout jest zaubrzony i figury rysują się jedna na drugiej
		 */

		int xx, yy;

		g.setColor(new Color(red, green, blue));
		for (int ii = 0; ii < 500000; ii++) {

			xx = (int) ((A * (Math.sin(a * ii + d) + 1) / B) * (0.5 * getSize().width));
			yy = (int) ((B * (Math.sin(b * ii) + 1) / A) * (0.5 * getSize().height));
			g.drawLine(xx, yy, xx, yy);

		}
	}

}
