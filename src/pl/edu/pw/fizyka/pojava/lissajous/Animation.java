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
	private static final double R = 5;
	private int i;
	private List<Integer> curveX = new ArrayList<Integer>();
	private List<Integer> curveY = new ArrayList<Integer>();

	@Override
	public void paintComponent(Graphics gr) { // Karolina
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);

		g.setColor(Color.BLACK);
		int xPosition = (int) (xx * getWidth()) / 2 + getWidth() / 2 - (int) R;
		int yPosition = (int) (yy * getHeight()) / 2 + getHeight() / 2
				- (int) R;

		// Wojtek
		g.fillOval(xPosition, yPosition, (int) R * 2, (int) R * 2);
		curveX.add(xPosition + (int) R);
		curveY.add(yPosition + (int) R);
		int count = curveX.size();
		for (int j = 4; j < count; ++j) {
			g.drawLine(curveX.get(j), curveY.get(j), curveX.get(j - 1),
					curveY.get(j - 1));
		}

	}

	void ovalMovement() {
		xx = Math.sin(3 * 2 * Math.PI * i / 1000);
		yy = Math.sin(4 * 2 * Math.PI * i / 1000);
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(16);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
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