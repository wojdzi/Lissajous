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
			if (!eng) {
				packedImage = ImageIO.read(this.getClass().getResourceAsStream(
						"info.png"));
			} else {
				packedImage = ImageIO.read(this.getClass().getResourceAsStream(
						"infoang.png"));
			}

		} catch (IOException e) {
			System.err.println("Błąd odczytu obrazka");
		}

		panelWidth = packedImage.getWidth();
		panelHeight = packedImage.getHeight();
		Dimension dimension = new Dimension(panelWidth, panelHeight);
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.drawImage(packedImage, 5, 5, this);
	}

}