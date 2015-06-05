package pl.edu.pw.fizyka.pojava.lissajous;

/**
 * @author Kara
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;


public class InfoFrame extends JFrame {

	InfoPanel infopanel; // czytanie z wewnatrz paczki

	public InfoFrame() throws HeadlessException {
		super("Informacje");

		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(700, 690));
		this.setMaximumSize(new Dimension(700, 690));
		this.setLayout(new BorderLayout());

		infopanel = new InfoPanel();
		this.getContentPane().add(infopanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * pack() powoduje dopasowanie okna do layoutów
		 */
		pack();

		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		InfoFrame infoWindow = new InfoFrame();
		infoWindow.setVisible(true);
	}

}