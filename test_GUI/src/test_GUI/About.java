package test_GUI;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JDialog {
	private JLabel label;
	
	public About(JFrame frame){
		super(frame, "About Window", true);
		setLayout(new FlowLayout());
		
		label = new JLabel("we can say nothing about nothing ...");
		add(label);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.pack();
		this.setSize(300,325);
		this.setLocation(400,400);
		this.setVisible(true);
	}
}
