package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = -3784277794487952881L;
	/**
	 * @author Kara
	 * @edit Wojtek
	 */

	BufferedImage packedImage;
	int panelWidth;
	int panelHeight;

	public InfoPanel(boolean eng) {

		try {
			if (eng == false) {
				packedImage = ImageIO.read(this.getClass().getResourceAsStream(
						"info.png"));
			} else {
				packedImage = ImageIO.read(this.getClass().getResourceAsStream(
						"infoang.png"));
			}

		} catch (IOException e) {
			System.err.println("Błąd odczytu obrazka");
			e.printStackTrace();
		}

		panelWidth = packedImage.getWidth() + 5;
		panelHeight = packedImage.getHeight() + 5;
		Dimension dimension = new Dimension(panelWidth, panelHeight);
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(packedImage, 0, 0, this);
	}

}