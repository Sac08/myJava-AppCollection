package myJava;

import java.awt.*;  

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;  
/**
 * This class(App) calculates number of charecter and word present in input string.
 * @author Sachin Bagalakoti
 *
 */
public class CountCharWord extends JFrame implements ActionListener{  


	JLabel message; 
	JTextArea ta;  
	JButton b;  
	JButton pad,text,quit;  
	CountCharWord(){  
		super("Count charecter");  

		getContentPane().setBackground(Color.LIGHT_GRAY);

		message = new JLabel("Paste your String data :");
		message.setBounds(50, 70, 250, 20);

		ta=new JTextArea();  
		JScrollPane sp=new JScrollPane(ta);
		sp.setBounds(50,110,320,200);  

		///setting border to text area
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		ta.setBorder(border);

		b=new JButton("Count");  
		b.setBounds(50,320, 80,30); 
		b.addActionListener(this);  

		pad=new JButton("ColorArea");  
		pad.setBounds(140,320, 110,30);  
		pad.addActionListener(this);  

		text=new JButton("ColorText");  
		text.setBounds(260,320, 110,30); 
		text.addActionListener(this);  

		quit = new JButton("Quit");
		quit.setBounds(140, 360, 110, 30);

		add(message);
		add(sp);
		add(b);
		add(pad);
		add(text);  
		add(quit);

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});

		setSize(400,400);  
		setLayout(null);//using no layout manager  
		setVisible(true);  
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);  
	}  
	/**
	 * Listener for 
	 * @param b counts char and word present in input string.
	 * @param pad background color for text area.
	 * @param text foreground color(text color).
	 */
	public void actionPerformed(ActionEvent e){  
		if(e.getSource()==b){  
			String text=ta.getText();  

			String words[]=text.split("\\s"); /// \\s ==> whitespace representation
			JOptionPane.showMessageDialog(this, "Count of words :" + words.length + " Count of chars :" + text.length());  
		}else if(e.getSource()==pad){  
			Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
			ta.setBackground(c);  
		}else if(e.getSource()==text){  
			Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
			ta.setForeground(c);  
		}

	}  	
	/**
	 * main class , applies lookAndFeel(<i>SystemL&K</i>) and calls constructor.
	 * @param args
	 */
	public static void main(String[] args) { 
		try{
			 UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e) {
			// TODO: handle exception
		}
		new CountCharWord();  
	}
}