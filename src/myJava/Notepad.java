package myJava;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


import java.awt.*;  
import javax.swing.*;
import javax.swing.border.Border;

import javax.swing.*;
import javax.swing.border.Border;
/**
 * This class has several features like editing text file, saving text file, creating new text file.
 * @author Sachin Bagalakoti
 *
 */
public class Notepad extends JFrame {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JMenuBar menuBar;
	JMenu file;
	JMenu edit;
	JMenuItem open, newFile,save, exit;
	JMenuItem undo,paste, selectAll ;
	JMenuItem color;
	JMenuItem aboutNotepad;
	JMenu format;
	JMenu help;
	JFileChooser fileChooser;
	JTextArea textArea;
	Clipboard clip ;

	/**
	 * This is constructor sets GUI to Notepad class
	 * The Menu list has following parameters
	 * @param file which has <i>new,open,save,exit</i> Menulist
	 * @param edit which has <i>undo,paste,selectAll</i> MenuList
	 * @param format which helps in changing background and foreground color of editor and text respectively.
	 * @param help which has menulist <i>about Notepad</i>
	 */
	Notepad() {
		frame = new JFrame("Notepad");
		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		help = new JMenu("Help");

		newFile = new JMenuItem("New");
		open = new JMenuItem("Open");		
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		undo = new  JMenuItem("Undo                 Ctrl+Z");
		paste = new JMenuItem("Paste                Ctrl+V");
		selectAll = new JMenuItem("Select All       Ctrl+A");
		color = new JMenuItem("Set Background Color");
		JMenuItem foreground = new JMenuItem("Set Foreground Color");
		aboutNotepad = new JMenuItem("About Notepad");

		textArea = new JTextArea();
		fileChooser = new JFileChooser();
		menuBar = new JMenuBar();

		///setting border to textArea
		Border border = BorderFactory.createLineBorder(new Color(184,56,28),5);
		textArea.setBorder(border);
		JScrollPane sp = new JScrollPane(textArea);

		frame.setLayout(new BorderLayout());
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(sp);
		file.add(open);
		file.add(newFile);
		file.add(save);
		file.add(exit);
		edit.add(undo);
		edit.add(paste);
		edit.add(selectAll);
		help.add(aboutNotepad);
		format.add(color);
		format.add(foreground);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(help);

		color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color c=JColorChooser.showDialog(color, "Set Msg Area Color", Color.white);  
				textArea.setBackground(c);
			}
		});

		foreground.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color c = JColorChooser.showDialog(foreground, "Set Font Color", null);
			}
		});

		frame.setJMenuBar(menuBar);

		OpenListener openL = new OpenListener();
		NewListener NewL = new NewListener();
		SaveListener saveL = new SaveListener();
		ExitListener exitL = new ExitListener();
		abtListener abt = new abtListener();
		aboutNotepad.addActionListener(abt);
		open.addActionListener(openL);
		newFile.addActionListener(NewL);
		save.addActionListener(saveL);
		exit.addActionListener(exitL);

		PasteListener pasteL = new PasteListener();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	/**
	 * 
	 * This class opens editable file to edit onto window.
	 *
	 */
	class OpenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(frame)) {
				File file = fileChooser.getSelectedFile();
				textArea.setText("");
				Scanner in = null;
				try {
					in = new Scanner(file);
					while(in.hasNext()) {
						String line = in.nextLine();
						textArea.append(line+"\n");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					in.close();
				}
			}
		}
	}
	/**
	 * This class saves edited file to directory pointed by user.
	 *
	 */
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(frame)) {
				File file = fileChooser.getSelectedFile();
				PrintWriter out = null;
				try {
					out = new PrintWriter(file);
					String output = textArea.getText();
					//System.out.println(output);
					out.println(output);
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						out.flush();
					} catch(Exception ex1) 
					{	
					}
					try {
						out.close();
					} catch(Exception ex1) {

					}
				}
			}
		}
	}

	/**
	 * Opens(<i>or cleas</i> current screen) new window for text editing.
	 *
	 */
	class NewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");

		}
	}
	/**
	 * 
	 * @return exits from Notepad.
	 */
	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}


	/**
	 * This class is to paste the content of text onto window screen.
	 */
	class PasteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Transferable cliptran = clip.getContents(Notepad.this);
			try
			{
				String sel = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
				textArea.replaceRange(sel,textArea.getSelectionStart(),textArea.getSelectionEnd());
			}
			catch(Exception exc)
			{
				System.out.println("not string flavour");
			}

		}
	}
	/**
	 * This is main class,it applies lookAndFeel to Notepad(<b>nimbus L&F</b>)
	 *
	 */

	public static void main(String args[]) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	
		}catch(Exception e)
		{

		}
		new Notepad();
	}

	/**
	 * This class is to display <b>about text</b>
	 *
	 */
	class abtListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(Notepad.this, aboutText,"About Notepad", JOptionPane.INFORMATION_MESSAGE);
		}
	}


	String aboutText=
			"<html><big>Notepad By JFrame</big><hr><hr>"
					+"<p align=right>Prepared by Sachin.B"
					+"<hr><p align=left><br><br>"
					+"<strong>Thanx for using Notepad+</strong><br>"
					+"This project covers many topics of java PL , which was curriculum course 15CS45 .<p align=center>"
					+"<hr><em><big>sachinbagalakoti08@gmail.com</big></em><hr><html>";
}