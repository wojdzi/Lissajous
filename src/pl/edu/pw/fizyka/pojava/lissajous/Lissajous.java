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
	int smallAParameter = 0;
	int smallBParameter = 0;
	int redColor = 0, greenColor = 0, blueColor = 0;
	int bigAParameter = 1;
	int bigBParameter = 1;
	double deltaParameter = Math.PI / 2;

	/**
	 * @author Wojtek
	 */
	public void setValues(int xx, int yy, int red, int blue, int green,
			int bigA, int bigB, int delta) {
		smallAParameter = xx;
		smallBParameter = yy;
		redColor = red;
		greenColor = green;
		blueColor = blue;
		bigAParameter = bigA;
		bigBParameter = bigB;
		deltaParameter = delta;

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

		g.setColor(new Color(redColor, greenColor, blueColor));
		for (int ii = 0; ii < 500000; ii++) {

			xx = (int) ((bigAParameter
					* (Math.sin(smallAParameter * ii + deltaParameter) + 1) / bigBParameter) * (0.5 * getSize().width));
			yy = (int) ((bigBParameter * (Math.sin(smallBParameter * ii) + 1) / bigAParameter) * (0.5 * getSize().height));
			g.drawLine(xx, yy, xx, yy);

		}
	}

}
