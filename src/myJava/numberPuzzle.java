package myJava;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 * This class implements a puzzle game , which we need to arrange serialwise from 1 to 9.(9th one blank)
 * @author Sachin Bagalakoti
 *
 */
public class numberPuzzle extends JFrame implements ActionListener {
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JLabel label1,label2;
	static int cnt=0;
	long start,end;
	
	/**
	 * constructor to implement GUI for puzzle game.
	 */
	public numberPuzzle() {
		// TODO Auto-generated constructor stub
		super("numberPuzzleGame");
		getContentPane().setBackground(new Color(204,255,229));
		getContentPane().setForeground(Color.black);
		
		label1=new JLabel();
		label1.setBounds(230,50,180, 20);
		label2=new JLabel();
		label2.setBounds(230,100,180, 20);
		
		b1=new JButton("1");
		b1.setBounds(50,50,50,50);
		b1.setBackground(Color.LIGHT_GRAY);
		
		b2=new JButton("2");
		b2.setBounds(110,50,50,50);
		b2.setBackground(Color.LIGHT_GRAY);
		
		b3=new JButton("3");
		b3.setBounds(170,50,50,50);
		b3.setBackground(Color.LIGHT_GRAY);
		
		b4=new JButton("5");
		b4.setBounds(50,110,50,50);
		b4.setBackground(Color.LIGHT_GRAY);
		
		b5=new JButton("");
		b5.setBounds(110,110,50,50);
		b5.setBackground(Color.LIGHT_GRAY);
		
		b6=new JButton("6");
		b6.setBounds(170,110,50,50);
		b6.setBackground(Color.LIGHT_GRAY);

		b7=new JButton("7");
		b7.setBounds(50,170,50,50);
		b7.setBackground(Color.LIGHT_GRAY);
		
		b8=new JButton("8");
		b8.setBounds(110,170,50,50);
		b8.setBackground(Color.LIGHT_GRAY);
		
		b9=new JButton("4");
		b9.setBounds(170,170,50,50);
		b9.setBackground(Color.LIGHT_GRAY);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		add(label1);add(label2);add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);
		setSize(400,300);
		setLayout(null);
		setVisible(true);
	}
	/**
	 * override method for listener
	 * performs movement of numbers based on user selection of button.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(cnt==0){
			start=System.currentTimeMillis();
		}
		
		label1.setText("Total Clicks: "+ (++cnt));
		
		if(e.getSource()==b1){
			String label=b1.getText();
			if(b2.getText().equals("")){
				b2.setText(label);
				b1.setText("");
			}
			if(b4.getText().equals("")){
				b4.setText(label);
				b1.setText("");
			}
		}
		
		if(e.getSource()==b2){
			String label=b2.getText();
			if(b1.getText().equals("")){
				b1.setText(label);
				b2.setText("");
			}
			if(b3.getText().equals("")){
				b3.setText(label);
				b2.setText("");
			}
			if(b5.getText().equals("")){
				b5.setText(label);
				b2.setText("");
			}
		}
		
		if(e.getSource()==b3){
			String label=b3.getText();
			if(b2.getText().equals("")){
				b2.setText(label);
				b3.setText("");
			}
			if(b6.getText().equals("")){
				b6.setText(label);
				b3.setText("");
			}
		}
		
		if(e.getSource()==b4){
			String label=b4.getText();
			if(b1.getText().equals("")){
				b1.setText(label);
				b4.setText("");
			}
			if(b7.getText().equals("")){
				b7.setText(label);
				b4.setText("");
			}
			if(b5.getText().equals("")){
				b5.setText(label);
				b4.setText("");
			}
		}
		
		if(e.getSource()==b5){
			String label=b5.getText();
			if(b2.getText().equals("")){
				b2.setText(label);
				b5.setText("");
			}
			if(b4.getText().equals("")){
				b4.setText(label);
				b5.setText("");
			}
			if(b6.getText().equals("")){
				b6.setText(label);
				b5.setText("");
			}
			if(b8.getText().equals("")){
				b8.setText(label);
				b5.setText("");
			}
		}
		
		if(e.getSource()==b6){
			String label=b6.getText();
			if(b9.getText().equals("")){
				b9.setText(label);
				b6.setText("");
			}
			if(b3.getText().equals("")){
				b3.setText(label);
				b6.setText("");
			}
			if(b5.getText().equals("")){
				b5.setText(label);
				b6.setText("");
			}
		}
		
		if(e.getSource()==b7){
			String label=b7.getText();
			if(b4.getText().equals("")){
				b4.setText(label);
				b7.setText("");
			}
			if(b8.getText().equals("")){
				b8.setText(label);
				b7.setText("");
			}
		}
		
		if(e.getSource()==b8){
			String label=b8.getText();
			if(b9.getText().equals("")){
				b9.setText(label);
				b8.setText("");
			}
			if(b7.getText().equals("")){
				b7.setText(label);
				b8.setText("");
			}
			if(b5.getText().equals("")){
				b5.setText(label);
				b8.setText("");
			}
		}
		
		if(e.getSource()==b9){
			String label=b9.getText();
			if(b6.getText().equals("")){
				b6.setText(label);
				b9.setText("");
			}
			if(b8.getText().equals("")){
				b8.setText(label);
				b9.setText("");
			}
		}
		
		end=System.currentTimeMillis();
		long seconds=((end-start)/1000);
		label2.setText("Time: "+seconds+" Seconds");
		
		if(b1.getText().equals("1")&&b2.getText().equals("2")&&b3.getText().equals("3")&&b4.getText().equals("4")&&b5.getText().equals("5")&&b6.getText().equals("6")&&b7.getText().equals("7")&&b8.getText().equals("8")&&b9.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Congratulations, You won! Total Click: "+cnt+", Total Time: "+seconds+" seconds");
			cnt=0;
			start = end = 0;
		}
	}
	/**
	 * main class , applies nimbus L&F , and calls constructor.
	 * @param args
	 */
	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}

		new numberPuzzle();
	}

}
