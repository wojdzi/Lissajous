package pl.edu.pw.fizyka.pojava.lissajous;

/**
 * GUI wykonane przy pomocy Window Buildera dla IDE Eclipse
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -8502293635697957795L;
	protected static final Graphics Graphics = null;
	private JPanel contentPane;

	private int figureNumber = 0;
	private boolean eng = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		super("Lissajous");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final JButton btnFigure3 = new JButton("Figura 3");
		final JButton btnFigure2 = new JButton("Figura 2");
		final JButton btnFigure1 = new JButton("Figura 1");

		final JSlider redSlider = new JSlider();
		redSlider.setMinimum(0);
		redSlider.setMaximum(255);
		redSlider.setValue(0);
		final JLabel lblCzerwony = new JLabel("czerwony");
		final JSlider blueSlider = new JSlider();
		blueSlider.setMinimum(0);
		blueSlider.setMaximum(255);
		blueSlider.setValue(0);
		final JLabel lblNiebieski = new JLabel("niebieski");
		final JSlider greenSlider = new JSlider();
		greenSlider.setMinimum(0);
		greenSlider.setMaximum(255);
		greenSlider.setValue(0);
		final JLabel lblZielony = new JLabel("zielony");

		final JRadioButton rdbtnOneColor = new JRadioButton("jednolity kolor");
		rdbtnOneColor.setSelected(true);
		rdbtnOneColor.setVisible(false);
		final JRadioButton rdbtnGradColor = new JRadioButton("gradient koloru");
		rdbtnGradColor.setVisible(false);

		final JLabel lblParametryDoWyboru = new JLabel(
				"Parametry wybierane przez użytkownika:");

		final JSpinner spinnerA = new JSpinner();
		spinnerA.setValue(1);
		JLabel lblA = new JLabel("A");
		final JSpinner spinnerB = new JSpinner();
		spinnerB.setValue(1);
		JLabel lblB = new JLabel("B");
		final JSpinner spinnerD = new JSpinner();
		spinnerD.setValue(1);
		JLabel label = new JLabel("\u03B4");
		final JSpinner aspinner = new JSpinner();
		aspinner.setValue(0);
		JLabel lblSmallA = new JLabel("a");
		final JSpinner bspinner = new JSpinner();
		bspinner.setValue(0);
		JLabel lblSmallB = new JLabel("b");

		JButton btnStart = new JButton("START");

		final JButton btnClear = new JButton("Wyczyść");

		final JButton btnInfo = new JButton("Informacje");

		final JButton btnEnglish = new JButton("English");

		final JButton btnSave = new JButton("Zapisz");

		final JButton btnAnimate = new JButton("Animacja");

		JPanel panel = new JPanel();

		GroupLayout glContentPane = new GroupLayout(contentPane);
		glContentPane
				.setHorizontalGroup(glContentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								glContentPane
										.createSequentialGroup()
										.addGap(16)
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 543,
												Short.MAX_VALUE)
										.addGap(18)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																glContentPane
																		.createParallelGroup(
																				Alignment.LEADING)
																		.addGroup(
																				glContentPane
																						.createSequentialGroup()
																						.addComponent(
																								rdbtnOneColor)
																						.addGap(18)
																						.addComponent(
																								rdbtnGradColor))
																		.addGroup(
																				glContentPane
																						.createSequentialGroup()
																						.addComponent(
																								btnFigure1)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								btnFigure2)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								btnFigure3)))
														.addComponent(
																lblParametryDoWyboru)
														.addGroup(
																glContentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblSmallA)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				aspinner,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblA)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				spinnerA,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																glContentPane
																		.createSequentialGroup()
																		.addComponent(
																				label)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				spinnerD,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																glContentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblSmallB)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				bspinner,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblB)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				spinnerB,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																glContentPane
																		.createSequentialGroup()
																		.addGroup(
																				glContentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								btnInfo)
																						.addComponent(
																								btnClear)
																						.addComponent(
																								btnAnimate))
																		.addGap(18)
																		.addGroup(
																				glContentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								glContentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												btnStart)
																										.addComponent(
																												btnEnglish))
																						.addComponent(
																								btnSave)))
														.addGroup(
																glContentPane
																		.createSequentialGroup()
																		.addGroup(
																				glContentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblZielony)
																						.addComponent(
																								lblCzerwony)
																						.addComponent(
																								lblNiebieski))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				glContentPane
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								greenSlider,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								blueSlider,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								redSlider,
																								GroupLayout.DEFAULT_SIZE,
																								176,
																								Short.MAX_VALUE))))
										.addContainerGap()));
		glContentPane
				.setVerticalGroup(glContentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								glContentPane
										.createSequentialGroup()
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnFigure3)
														.addComponent(
																btnFigure2)
														.addComponent(
																btnFigure1))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																rdbtnOneColor)
														.addComponent(
																rdbtnGradColor))
										.addGap(11)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																redSlider,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCzerwony))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																blueSlider,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNiebieski))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																greenSlider,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblZielony))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblParametryDoWyboru)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																spinnerA,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblA)
														.addComponent(
																aspinner,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblSmallA))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																spinnerB,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblB)
														.addComponent(
																bspinner,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblSmallB))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																spinnerD,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnStart)
														.addComponent(btnClear))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnAnimate)
														.addComponent(btnSave))
										.addPreferredGap(
												ComponentPlacement.RELATED,
												142, Short.MAX_VALUE)
										.addGroup(
												glContentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnEnglish)
														.addComponent(btnInfo)))
						.addGroup(
								glContentPane
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 478,
												Short.MAX_VALUE)
										.addContainerGap()));

		/**
		 * Dodaje panel z figurami do okna głównego
		 */

		final Lissajous figurePanel = new Lissajous();

		GroupLayout gl_panel = new GroupLayout(panel);
		figurePanel.setBorder(new LineBorder(Color.black));
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(figurePanel,
				GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(figurePanel, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		contentPane.setLayout(glContentPane);

		/**
		 * nowe okna Karolina
		 */
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimationWindow animateWindow = new AnimationWindow();
				animateWindow.setVisible(true);

			}
		});

		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoFrame info = new InfoFrame(eng);
				info.setVisible(true);

			}
		});
		/**
		 * action listenery figur i czyszczenie Karolina
		 */

		ActionListener clear = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				figurePanel.setValues(0, 0, 0, 0, 0, 0, 0, 0);
				figurePanel.repaint();
				figureNumber = 0;
			}
		};
		btnClear.addActionListener(clear);

		ActionListener figure3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				figurePanel.setValues(1, 2, redSlider.getValue(),
						blueSlider.getValue(), greenSlider.getValue(), 1, 1, 0);
				figurePanel.repaint();
				bspinner.setValue(2);
				aspinner.setValue(1);
				spinnerA.setValue(1);
				spinnerB.setValue(1);
				spinnerD.setValue(0);
				figureNumber = 3;
			}
		};
		btnFigure3.addActionListener(figure3);

		ActionListener figure2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				figurePanel.setValues(2, 3, redSlider.getValue(),
						blueSlider.getValue(), greenSlider.getValue(), 1, 1, 0);
				figurePanel.repaint();
				bspinner.setValue(3);
				aspinner.setValue(2);
				spinnerA.setValue(1);
				spinnerB.setValue(1);
				spinnerD.setValue(0);
				figureNumber = 2;
			}
		};
		btnFigure2.addActionListener(figure2);

		ActionListener figure1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				figurePanel.setValues(3, 4, redSlider.getValue(),
						blueSlider.getValue(), greenSlider.getValue(), 1, 1, 0);
				figurePanel.repaint();
				bspinner.setValue(4);
				aspinner.setValue(3);
				spinnerA.setValue(1);
				spinnerB.setValue(1);
				spinnerD.setValue(0);
				figureNumber = 1;
			}
		};
		// Wojtek
		btnFigure1.addActionListener(figure1);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int A = (int) spinnerA.getValue();
				int B = (int) spinnerB.getValue();
				int a = (int) aspinner.getValue();
				int b = (int) bspinner.getValue();
				int d = (int) spinnerD.getValue();
				figurePanel.setValues(a, b, redSlider.getValue(),
						blueSlider.getValue(), greenSlider.getValue(), A, B, d);
				figurePanel.repaint();
				figureNumber = 4;
			}
		});

		/**
		 * Zapis do pliku i zmiana języka Wojtek
		 */
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BufferedImage image = new BufferedImage(figurePanel.getWidth(),
						figurePanel.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics2D = image.createGraphics();

				figurePanel.paint(graphics2D);
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG Images", "jpg");
				filechooser.setFileFilter(filter);
				int result = filechooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File saveFile = filechooser.getSelectedFile();
					try {
						ImageIO.write(image, "png", saveFile);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		// Wojtek
		ActionListener angielski = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnEnglish.getText() == "English") {
					lblCzerwony.setText("Red");
					lblNiebieski.setText("Blue");
					lblZielony.setText("Green");
					btnEnglish.setText("Polski");
					btnFigure1.setText("Curve 1");
					btnFigure2.setText("Curve 2");
					btnFigure3.setText("Curve 3");
					rdbtnOneColor.setText("Plain Color"); // nieuzywane
					rdbtnGradColor.setText("Gradient Color"); // nieuzywane
					btnClear.setText("Clear");
					btnInfo.setText("Information");
					eng = true;
					btnAnimate.setText("Animation");
					btnSave.setText("Save");
					lblParametryDoWyboru
							.setText("Parameters values selected by the user:");
				} else {
					lblCzerwony.setText("Czerwony");
					lblNiebieski.setText("Niebieski");
					lblZielony.setText("Zielony");
					btnEnglish.setText("English");
					btnFigure1.setText("Figura 1");
					btnFigure2.setText("Figura 2");
					btnFigure3.setText("Figura 3");
					btnClear.setText("Wyczyść");
					rdbtnOneColor.setText("Jednolity Kolor"); // nieuzywane
					rdbtnGradColor.setText("Gradient Koloru"); // nieuzywane
					btnInfo.setText("Informacje");
					eng = false;
					btnAnimate.setText("Animacja");
					btnSave.setText("Zapisz");
					lblParametryDoWyboru
							.setText("Parametry wybierane przez użytkownika:");
				}
			}
		};
		btnEnglish.addActionListener(angielski);
		/**
		 * change listenery do kolorów Wojtek
		 */

		ChangeListener slideRed = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				revalidate();
				switch (figureNumber) {
				case 0:
					figurePanel.setValues(0, 0, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(),
							(int) spinnerA.getValue(),
							(int) spinnerB.getValue(),
							(int) spinnerD.getValue());
					break;
				case 1:
					figurePanel.setValues(3, 4, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 2:
					figurePanel.setValues(2, 3, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 3:
					figurePanel.setValues(1, 2, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 4:
					figurePanel.setValues((int) aspinner.getValue(),
							(int) bspinner.getValue(), redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(),
							(int) spinnerA.getValue(),
							(int) spinnerB.getValue(),
							(int) spinnerD.getValue());
					break;
				}
				figurePanel.repaint();

			}

		};
		redSlider.addChangeListener(slideRed);

		ChangeListener slideGreen = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				revalidate();
				switch (figureNumber) {
				case 0:
					figurePanel.setValues(0, 0, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(),
							(int) spinnerA.getValue(),
							(int) spinnerB.getValue(),
							(int) spinnerD.getValue());
					break;
				case 1:
					figurePanel.setValues(3, 4, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 2:
					figurePanel.setValues(2, 3, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 3:
					figurePanel.setValues(1, 2, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 4:
					figurePanel.setValues((int) aspinner.getValue(),
							(int) bspinner.getValue(), redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(),
							(int) spinnerA.getValue(),
							(int) spinnerB.getValue(),
							(int) spinnerD.getValue());
					break;
				}
				figurePanel.repaint();
			}

		};
		greenSlider.addChangeListener(slideGreen);

		ChangeListener slideBlue = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				revalidate();
				switch (figureNumber) {
				case 0:
					figurePanel.setValues(0, 0, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(),
							(int) spinnerA.getValue(),
							(int) spinnerB.getValue(),
							(int) spinnerD.getValue());
					break;
				case 1:
					figurePanel.setValues(3, 4, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 2:
					figurePanel.setValues(2, 3, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 3:
					figurePanel.setValues(1, 2, redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(), 1,
							1, 0);
					break;
				case 4:
					figurePanel.setValues((int) aspinner.getValue(),
							(int) bspinner.getValue(), redSlider.getValue(),
							blueSlider.getValue(), greenSlider.getValue(),
							(int) spinnerA.getValue(),
							(int) spinnerB.getValue(),
							(int) spinnerD.getValue());
					break;

				}
				figurePanel.repaint();
			}

		};
		blueSlider.addChangeListener(slideBlue);

	}

}
