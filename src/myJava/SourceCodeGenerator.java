package myJava;

import java.awt.*;  

import java.awt.event.*;  
import java.io.InputStream;  
import java.net.*;  
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.StyledEditorKit.BoldAction;
/**
 * This class generates source code of web page.
 * @author Sachin Bagalakoti
 *
 */
public class SourceCodeGenerator extends JFrame implements ActionListener{  
    JTextField tf;  
    JTextArea ta;  
    JButton b;  
    JLabel l;  
    /**
     * @param tf textField to enter web address(<i>http address</i>).
     * @param b button to generate source code.
     * @param ta textArea to display source code.
     */
    SourceCodeGenerator(){  
    
    	super("SourceCodeGenerator");
    	getContentPane().setBackground(Color.LIGHT_GRAY);
        l=new JLabel("Enter internet address:");  
        l.setBounds(50,50,250,20);  
          
        tf=new JTextField("http://vtu.ac.in");  
        tf.setBounds(50,90,250,30);  
          
        b=new JButton("PRINT SOURCECODE");  
        b.setBounds(50, 140,180,30);  
        b.addActionListener(this);  
          
        ta=new JTextArea();  
        JScrollPane sp=new JScrollPane(ta);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        ta.setBorder(border);
        sp.setBounds(50,200,350,250);  
          
        add(l);add(tf);add(b);add(sp);  
        setSize(500,500);  
        setLayout(null);  
        setVisible(true);  
    }  
    /**
     * method to get source code of web page.
     */
    public void actionPerformed(ActionEvent e){  
        String s=tf.getText();  
        if(s==null){}  
        else{  
            try{  
            URL u=new URL(s);  
            URLConnection uc=u.openConnection();  
          
            InputStream is=uc.getInputStream();  
            int i;  
            StringBuilder sb=new StringBuilder();  
            while((i=is.read())!=-1){  
                sb.append((char)i);  
            }  
            String source=sb.toString();  
            ta.setText(source);  
            }catch(Exception ex){JOptionPane.showMessageDialog(this,ex + "\nNote:Make Sure You Are Connected Internet.");}  
        }  
    }  
    /**
     * main method to call constructor
     * L&F : nimbus
     * @param args
     */
    public static void main(String[] args) {  
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
        new SourceCodeGenerator();  
    }  
}  