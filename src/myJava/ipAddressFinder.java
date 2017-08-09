package myJava;

import javax.swing.*;
/**
 * This class finds <b>I</b>nternet <b>P</b>rotocol Address of website inputed by user.(use www intead of http)
 * @author Sachin Bagalakoti
 */

import java.awt.Color;
import java.awt.event.*;  
import java.net.*;  
/**
 * This class finds <b>I</b>nternet <b>P</b>rotocol address of input web address.
 * @author Sachin Bagalakoti
 *
 */
public class ipAddressFinder extends JFrame implements ActionListener{  
	JLabel label;  
	JTextField textField;  
	JButton b;  
	/**
	 * This is constructor , to give GUI to app.
	 */
	ipAddressFinder(){  
		super("IPAPP :)");  
		getContentPane().setBackground(Color.LIGHT_GRAY);

		label=new JLabel("Enter Website URL:");  
		label.setBounds(50,70,150,20);;  

		textField=new JTextField();  
		textField.setBounds(50,100,200,30);  

		b=new JButton("Find IP");  
		b.setBounds(50,145,100,20);  
		b.addActionListener(this); 
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);

		add(label);  
		add(textField);  
		add(b);  

		setSize(300,250);  
		setLayout(null);  
		setVisible(true);  
	}  
	/**
	 * This method(listener) finds IP address of input website address.
	 */
	public void actionPerformed(ActionEvent e){  
		String url=textField.getText();  
		try {  

			InetAddress ia=InetAddress.getByName(url);  
			String ip=ia.getHostAddress();  
			JOptionPane.showMessageDialog(this,"IP of "+url+" is: "+ip);  

		} catch (UnknownHostException e1) {  
			JOptionPane.showMessageDialog(this,e1.toString()+"\nNote:Make Sure You Are Connected Internet.");  
		}  
	}  
	/**
	 * main method to call constructor
	 * @param args
	 */
	public static void main(String[] args) {  
		new ipAddressFinder();  
	}  
}  