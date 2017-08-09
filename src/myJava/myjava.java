package myJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/*
 * Image Source:Google;
 */

/**
 * <h1>myJava</h1>
 * <h3>This App contains collection of useful applications</h3>
 * these are :
 * <ul>
 * 	 <li>Notepad</li>
 * 	 <li>Calculator</li>
 *   <li>IP address Finder</li>
 *   <li>Word Count Tool</li>
 *   <li>Puzzle Game</li>
 *   <li>Source Code Generator</li>
 * </ul>
 * This is main class(main Theme) which shows way to different apps.
 * @author Sachin Bagalakoti
 * @version 1.0
 * @since 27.07.2017
 */

public class myjava extends JFrame
{
	private JPanel contentPane;

	/**
	 * This main method calls constructor 
	 * @param args returns nothing
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myjava frame = new myjava();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Buttons are associated with different apps , from button_0 to button_6.
	 * For Every Buttons(total 6) , listners are associated to redirect to application from main Theme.
	 * with the help of BOX class , group of 3 buttons are aligned at top and bottom of window(AppletViewer).
	 */
	public myjava() {
		// TODO Auto-generated constructor stub
		setTitle("Myjava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(685,430);

		///Coloring background and applying LookAndFeel
		getContentPane().setBackground(new Color(204, 229, 255));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}

		JButton button_0 = new JButton("");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Notepad.main(new String[]{});
			}
		});
		button_0.setIcon(new ImageIcon(myjava.class.getResource("/notepad.jpg")));

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculatorApp.main(new String[]{});
			}
		});
		button_1.setIcon(new ImageIcon(myjava.class.getResource("/calculator.jpg")));
		//button_1.setBounds(220, 10, 190, 190);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipAddressFinder.main(new String[]{});
			}
		});
		button_2.setIcon(new ImageIcon(myjava.class.getResource("/ip.jpg")));
		//button_2.setBounds(430, 10, 190, 190);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CountCharWord.main(new String[]{});
			}
		});
		button_3.setIcon(new ImageIcon(myjava.class.getResource("/wct.jpg")));
		//button_3.setBounds(10, 220, 190, 190);

		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberPuzzle.main(new String[]{});
			}
		});
		button_4.setIcon(new ImageIcon(myjava.class.getResource("/Puzzle Game.jpg")));
		//button_4.setBounds(220, 220, 190, 190);

		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SourceCodeGenerator.main(new String[]{});
			}
		});
		button_5.setIcon(new ImageIcon(myjava.class.getResource("/Source Code Generator.jpg")));
		//button_7.setBounds(430, 220, 190, 190);
		Box iconPanel1 = new Box(BoxLayout.X_AXIS);
		iconPanel1.add(button_0);
		iconPanel1.add(button_1);
		iconPanel1.add(button_2);
		add(iconPanel1,BorderLayout.BEFORE_FIRST_LINE);

		Box iconPanel2 = new Box(BoxLayout.X_AXIS);
		iconPanel2.add(button_3);
		iconPanel2.add(button_4);
		iconPanel2.add(button_5);
		add(iconPanel2,BorderLayout.AFTER_LAST_LINE);
	}

}
