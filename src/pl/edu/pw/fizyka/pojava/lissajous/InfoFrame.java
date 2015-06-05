package pl.edu.pw.fizyka.pojava.lissajous;

/**
 * @author Kara
 * @edit Wojtek
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.*;

public class InfoFrame extends JFrame {

	private static final long serialVersionUID = 6299828070585088298L;
	// private ImageIcon info;
	// InfoPanel1 infopanel //czytanie z pliku
	InfoPanel infopanel; // czytanie z wewnatrz paczki

	public InfoFrame() throws HeadlessException {
		super("Informacje");

		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(700, 690));
		this.setMaximumSize(new Dimension(700, 690));
		this.setLayout(new BorderLayout());

		// infopanel = new InfoPanel();
		infopanel = new InfoPanel();
		this.getContentPane().add(infopanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		InfoFrame infoWindow = new InfoFrame();
		infoWindow.setVisible(true);
	}

}