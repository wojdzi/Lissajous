package pl.edu.pw.fizyka.pojava.lissajous;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Kara
 *
 */

public class AnimationWindow extends JFrame {
	
	private static final long serialVersionUID = -796465131835138251L;
	Animation panel;
	JPanel buttons;
	JButton start, stop, pauza;

	public AnimationWindow() {
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		panel = new Animation();

		buttons = new JPanel(new FlowLayout());

		start = new JButton("Start");
		start.addActionListener(new StartAction());
		buttons.add(start);

		stop = new JButton("Stop");
		stop.addActionListener(new StopAction());
		buttons.add(stop);

		add(panel, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}

	class StartAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel.start();
		}
	}

	class StopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.stop();
		}
	}

	public static void main(String[] args) {
		AnimationWindow Window = new AnimationWindow();
		Window.setVisible(true);
	}
}
