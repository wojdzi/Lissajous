package pl.edu.pw.fizyka.pojava.lissajous;

/**
 * @author Kara
 * @edit Wojtek
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;


import javax.swing.*;

public class InfoFrame extends JFrame {

	private static final long serialVersionUID = 6299828070585088298L;

	InfoPanel infopanel; 

	public InfoFrame(boolean eng) throws HeadlessException {
		super("Informacje");

		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(700, 690));
		this.setMaximumSize(new Dimension(700, 690));
		this.setLayout(new BorderLayout());


		infopanel = new InfoPanel(eng);
		this.getContentPane().add(infopanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}



}