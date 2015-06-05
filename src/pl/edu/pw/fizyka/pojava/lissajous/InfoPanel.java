package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	/**
	 * @author Kara
	 */

	BufferedImage packedImage;
	int panelWidth;
	int panelHeight;

	public InfoPanel() {
		try {
			packedImage = ImageIO.read(this.getClass().getResourceAsStream(
					"info.png"));


		} catch (IOException e) {
			System.err.println("Błąd odczytu obrazka");
			e.printStackTrace();
		}

		panelWidth = packedImage.getWidth() + 5;
		panelHeight = packedImage.getHeight() + 5;

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(packedImage, 0, 0, this);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(705, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new InfoPanel());
		frame.setVisible(true);
	}

}
