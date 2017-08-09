package myJava;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 * This class calculates result against input operation and value.
 * @author Sachin Bagalakoti
 *
 */
public class calculatorApp extends JFrame implements ActionListener {

	JPanel row[] = new JPanel[5];
	JButton button[] = new JButton[19];
	String buttons[] = {
			"7", "8", "9", "+", "4", "5", "6", "-", "1", "2",
			"3", "*", ".", "/", "C", "√", "+/-", "=", "0"
	};
	Dimension dispDim = new Dimension(300, 35);
	Dimension regDim = new Dimension(45, 40);
	Dimension longDim = new Dimension(100,40);
	Dimension zeroDim = new Dimension(90, 40);

	Boolean func[] = new Boolean[4];
	Font font = new Font("Times new Roman", Font.BOLD, 15);
	double []temp = {0,0};

	JTextArea display = new JTextArea();

	/**
	 * This constructor called by main method.
	 * GUI required for calculator is developed in this constructor along with them listeners are attached to perform task.
	 * @param display  for Display area of Calculator
	 */
	public calculatorApp() {
		// TODO Auto-generated constructor stub
		super("Calculator");
		getContentPane().setBackground(Color.LIGHT_GRAY);

		setVisible(true);
		setResizable(true);
		setSize(380, 300);

		GridLayout grid = new GridLayout(5, 5);
		setLayout(grid);

		FlowLayout f = new FlowLayout();

		///for horizontal grid arrangement
		for (int i=0;i<5;i++)
		{
			row[i] = new JPanel();
			row[i].setLayout(f);
		}

		///set all func operation false
		for (int i=0;i<4;i++)
			func[i] = false;

		///set buttons
		for (int i=0;i<19;i++)
		{
			button[i] = new JButton(buttons[i]);
			button[i].addActionListener(this);
			button[i].setFont(font);
			button[i].setBackground(Color.GRAY);
			button[i].setForeground(Color.white);
		}

		///for border :: display
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		display.setBorder(border);

		display.setBackground(new Color(153,255,235));
		display.setForeground(Color.BLACK);
		display.setPreferredSize(dispDim);
		display.setEditable(false);
		display.setFont(font);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		for (int i=0;i<14;i++)
		{
			button[i].setPreferredSize(regDim);
		}
		for (int i=14;i<18;i++)
		{
			button[i].setPreferredSize(longDim);
		}
		button[18].setPreferredSize(zeroDim);

		///Adding all components :
		row[0].add(display);
		add(row[0]);

		for (int i=0;i<4;i++)
			row[1].add(button[i]);
		row[1].add(button[14]);
		add(row[1]);

		for (int i=4;i<8;i++)
			row[2].add(button[i]);
		row[2].add(button[15]);
		add(row[2]);

		for (int i=8;i<12;i++)
			row[3].add(button[i]);
		row[3].add(button[16]);
		add(row[3]);

		row[4].add(button[18]);
		for (int i=12;i<14;i++)
			row[4].add(button[i]);
		row[4].add(button[17]);
		add(row[4]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button[0])
			display.append("7");
		if (e.getSource() == button[3])
		{
			temp[0] = Double.parseDouble(display.getText());
			func[0] = true;
			display.setText("");
		}
		if (e.getSource() == button[1])
			display.append("8");
		if (e.getSource() == button[2])
			display.append("9");
		if (e.getSource() == button[4])
			display.append("4");
		if (e.getSource() == button[5])
			display.append("5");
		if (e.getSource() == button[6])
			display.append("6");
		if (e.getSource() == button[7]) {
			temp[0] = Double.parseDouble(display.getText());

			func[1] = true;
			display.setText("");
		}
		if (e.getSource() == button[8])
			display.append("1");
		if (e.getSource() == button[9])
			display.append("2");
		if (e.getSource() == button[10])
			display.append("3");
		if (e.getSource() == button[11]) {
			temp[0] = Double.parseDouble(display.getText());

			func[2] = true;
			display.setText("");
		}
		if (e.getSource() == button[12])
			display.append(".");
		if (e.getSource() == button[13]) {
			temp[0] = Double.parseDouble(display.getText());

			func[3] = true;
			display.setText("");
		}
		if (e.getSource() == button[14])
			clear();
		if (e.getSource() == button[15])
			getSqrt();
		if (e.getSource() == button[16])
			getPosNeg();
		if (e.getSource() == button[17])
			getResult();
		if (e.getSource() == button[18])
			display.append("0");

	}
	/**
	 * this method is to clear display screen of Calculator.
	 */
	void clear()
	{
		try{
			for (int i=0;i<4;i++)
				func[i] = false;
			temp[0] = temp[1] = 0;
			display.setText("");
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	/**
	 * This method finds square-root of entered number , and displays onto <b>display</b> screen .
	 */
	void getSqrt()
	{
		try{
			double res = Math.sqrt(Double.parseDouble(display.getText()));
			display.setText(Double.toString(res));
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	/**
	 * This method is to set negative and positive sign to input.
	 */
	public void getPosNeg() {
		try {
			double value = Double.parseDouble(display.getText());
			if (value != 0) {
				value = value * (-1);
				display.setText(Double.toString(value));
			} else {
			}
		} catch (NumberFormatException e) {
		}
	}
	/**
	 * This method evaluates basic arithmetic operations(<i>+,-,*,/</i> and displays result onto <b>display</b> area.
	 */
	public void getResult() {
		double result = 0;
		temp[1] = Double.parseDouble(display.getText());
		String temp0 = Double.toString(temp[0]);
		String temp1 = Double.toString(temp[1]);
		try {
			if (temp0.contains("-")) {
				String[] temp00 = temp0.split("-", 2);
				temp[0] = (Double.parseDouble(temp00[1]) * -1);
			}
			if (temp1.contains("-")) {
				String[] temp11 = temp1.split("-", 2);
				temp[1] = (Double.parseDouble(temp11[1]) * -1);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (func[0] == true)
				result = temp[0] + temp[1];
			else if (func[1] == true)
				result = temp[0] - temp[1];
			else if (func[2] == true)
				result = temp[0] * temp[1];
			else if (func[3] == true)
				result = temp[0] / temp[1];

			display.setText(Double.toString(result));
			for (int i = 0; i < 4; i++)

				func[i] = false;
		} catch (NumberFormatException e) {
		}
	}
	/**
	 * This is main method to call constructor.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try 
		{ 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		} 
		catch(Exception e){ 
		}
		new calculatorApp();
	} 
}
