package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * 
 * @author Karolina
 * @edit Wojtek
 */

public class Lissajous extends JPanel {

	private static final long serialVersionUID = 4083114230878689697L;
	int smallA = 0;
	int smallB = 0;
	int red = 0, green = 0, blue = 0;
	int aa = 1;
	int bb = 1;
	double dd = Math.PI / 2;

	/**
	 * @author Wojtek
	 */
	public void setValues(int xx, int yy, int rr, int bl, int gg, int bigA,
			int bigB, int delta) {
		smallA = xx;
		smallB = yy;
		red = rr;
		green = gg;
		blue = bl;
		aa = bigA;
		bb = bigB;
		dd = delta;

	}

	/**
	 * @author Karolina
	 * 
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		/**
		 * super uzywane do malowania danego obszaru nie calosci po usunięciu
		 * tej linijki layout jest zaubrzony i figury rysują się jedna na
		 * drugiej
		 */

		int xx, yy;

		g.setColor(new Color(red, green, blue));
		for (int ii = 0; ii < 500000; ii++) {

			xx = (int) ((aa * (Math.sin(smallA * ii + dd) + 1) / bb) * (0.5 * getSize().width));
			yy = (int) ((bb * (Math.sin(smallB * ii) + 1) / aa) * (0.5 * getSize().height));
			g.drawLine(xx, yy, xx, yy);

		}
	}

}
