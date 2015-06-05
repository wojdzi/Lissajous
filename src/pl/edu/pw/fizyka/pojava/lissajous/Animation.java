package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Kara
 * @edit Wojtek
 */

public class Animation extends JPanel implements Runnable {
	
	private static final long serialVersionUID = -1035237221865682731L;
	public Thread thread;
	public boolean thread_suspended;
	double xx = 50, yy = 50;
	double r = 5;
	int i;
	ArrayList<Integer> curve1_x = new ArrayList<Integer>();
	ArrayList<Integer> curve1_y = new ArrayList<Integer>();

	public Animation() {
		super();
	}

	// @Override //Wojtek
	public void paintComponent(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);

		g.setColor(Color.BLACK);
		int xPosition = (int) (xx * getWidth()) / 2 + getWidth() / 2 - (int) r;
		int yPosition = (int) (yy * getHeight()) / 2 + getHeight() / 2
				- (int) r;
		g.fillOval(xPosition, yPosition, (int) r * 2, (int) r * 2);
		curve1_x.add(xPosition + (int) r);
		curve1_y.add(yPosition + (int) r);
		int count = curve1_x.size();
		for (int j = 4; j < count; ++j) {
			g.drawLine(curve1_x.get(j), curve1_y.get(j), curve1_x.get(j - 1),
					curve1_y.get(j - 1));
		}

		
	}

	void ovalMovement() {

		xx = Math.sin(Math.toDegrees(3 * 2 * Math.PI * i / 25000));
		yy = Math.sin(Math.toDegrees(4 * 2 * Math.PI * i / 25000));

		

	}

	@Override
	public void run() {

		while (thread != null) {
			try {
				Thread.sleep(50);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			ovalMovement();
			repaint();
		}
	}

	public void start() {
		// Wznawianie watku to tworzenie nowego obiektu klasy Thread dla obiektu
		// z interfejsem Runnable czyli w tym przypadku dla panelu
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
			thread_suspended = false;
		}
	}

	public void stop() {
		// Zatrzymywanie watku to przypisywanie mu nulla.
		if (thread != null)
			thread = null;
	}

}
