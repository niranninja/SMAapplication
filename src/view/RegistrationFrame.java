package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationFrame extends JFrame {
	Container container=null;
	public RegistrationFrame() {
		container=getContentPane();
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

}
