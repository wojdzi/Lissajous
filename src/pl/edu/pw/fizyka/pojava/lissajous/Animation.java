package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * @author Kara
 * @edit Wojtek
 */

public class Animation extends JPanel implements Runnable {

	private static final long serialVersionUID = -1035237221865682731L;
	private Thread thread;
	private double xx = 50, yy = 50;
	private static final double ovalRadius = 5;
	private int ii;
	private List<Integer> curveX = new ArrayList<Integer>();
	private List<Integer> curveY = new ArrayList<Integer>();

	@Override
	public void paintComponent(Graphics gr) { // Karolina
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);

		g.setColor(Color.BLACK);
		int xPosition = (int) (xx * getWidth()) / 2 + getWidth() / 2 - (int) ovalRadius;
		int yPosition = (int) (yy * getHeight()) / 2 + getHeight() / 2
				- (int) ovalRadius;

		// Wojtek
		g.fillOval(xPosition, yPosition, (int) ovalRadius * 2, (int) ovalRadius * 2);
		curveX.add(xPosition + (int) ovalRadius);
		curveY.add(yPosition + (int) ovalRadius);
		int count = curveX.size();
		for (int jj = 4; jj < count; ++jj) {
			g.drawLine(curveX.get(jj), curveY.get(jj), curveX.get(jj - 1),
					curveY.get(jj - 1));
		}

	}

	void ovalMovement() {
		xx = Math.sin(3 * 2 * Math.PI * ii / 1000);
		yy = Math.sin(4 * 2 * Math.PI * ii / 1000);
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(16);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ii++;
			ovalMovement();
			repaint();
		}
	}

	public void start() {

		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		// Zatrzymywanie watku to przypisywanie mu nulla
		if (thread != null) {
			thread = null;
		}
	}

}