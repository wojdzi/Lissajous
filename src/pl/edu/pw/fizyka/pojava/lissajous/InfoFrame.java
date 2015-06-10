package pl.edu.pw.fizyka.pojava.lissajous;

/**
 * @author Kara
 * @edit Wojtek
 */

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.*;

public class InfoFrame extends JFrame {

	private static final long serialVersionUID = 6299828070585088298L;

	InfoPanel infoPanel;

	public InfoFrame(boolean eng) throws HeadlessException {
		super("Information");

		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(705, 695);
		this.setLayout(new BorderLayout());

		infoPanel = new InfoPanel(eng);
		this.getContentPane().add(infoPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

}