package test_GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Main extends JFrame{

	private JLabel label;
	private JButton button;
	private JTextField textfield;
	private ImageIcon image;
	private JLabel imglabel;
	private Event event;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem about;
	private JMenuItem exit;
	public Main(){
		setLayout(new FlowLayout());
//		setLayout(new GridLayout(2,2));//row col
		
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		menu = new JMenu("Menu");
		menubar.add(menu);
		
		about = new JMenuItem("About");
		exit = new JMenuItem("Exit");
		menu.add(about);
		menu.add(exit);
		////////////////////////////////////
		label = new JLabel("Test label");
		add(label);
		
		textfield = new JTextField(15);
		add(textfield);
		
		button = new JButton("click");
		add(button);
		
		image = new ImageIcon(getClass().getResource("images/img.jpg"));
		imglabel = new JLabel(image);
		add(imglabel);
		/////////////////////////////////////
		event = new Event();
		button.addActionListener(event);
		about.addActionListener(event);
		exit.addActionListener(event);
		///////////////////////////////////////
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
//		this.setSize(200,125);
		this.setTitle("Test window");
		this.setLocation(400,400);
	}
	
	public class Event implements ActionListener{
		private String str;
		
		public void actionPerformed(ActionEvent arg) {
			if(arg.getSource().equals(button)){
				str = textfield.getText();
				if(str.length() > 0)
					label.setText(str);
			}
			else if(arg.getSource().equals(exit)){
				System.exit(0);
			}
			else if(arg.getSource().equals(about)){
				About aboutDialog = new About(Main.this);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Main gui = new Main();
//		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gui.setVisible(true);
//		gui.setSize(200,125);
	}

}
