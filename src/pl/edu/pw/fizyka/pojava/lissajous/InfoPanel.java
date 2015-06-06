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
			if(eng == false){
			packedImage = ImageIO.read(this.getClass().getResourceAsStream(
					"info.png"));
			}
			else{
				packedImage = ImageIO.read(this.getClass().getResourceAsStream(
						"info2.png"));
			}
			
			/*
			 * Linia powyzej jest najwazniejsza. W tym momencie plik info.png
			 * znajduje sie w katalogu glownym paczki. Jesli zostanie
			 * przeniesiony do jakiegos podfolderu, trzeba bedzie mu oczywiscie
			 * zmienic takze sciezke.
			 */

		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		panelWidth = packedImage.getWidth() + 5; // dobrze, zeby byly jeszcze
													// jakies marginesy
		panelHeight = packedImage.getHeight() + 5; // po bokach i na gorze/dole
													// okna
		Dimension dimension = new Dimension(panelWidth, panelHeight);
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// narysowanie obrazu z dysku
		g2d.drawImage(packedImage, 0, 0, this);
	}

}