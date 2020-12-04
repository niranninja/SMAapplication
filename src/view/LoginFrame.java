package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame{
	Container container;
	JLabel lUserId,lpassword, lMessage;
	JTextField tUserId,tpassword;
	JButton bLogin,bRegister;
	JCheckBox cShowPassword;
	public LoginFrame(){
		container=getContentPane();
		lUserId=new JLabel("Username");
		lpassword= new JLabel("Password");
		tUserId=new JTextField();
		tpassword=new JTextField();
		bLogin=new JButton("Login");
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String UserId,Password;
				UserId=tUserId.getText();
				Password=tpassword.getpassword().toString();
				//System.out.println(UserId+" "+Password);
				
				Employee emp=empController.checkLogin(UserId, Password);
				if(emp==null) {
					
				emp.getActive().equals("Active") {
					if(emp.getRole().equals("HRA")) {
						new HRAHome();
				}
				else if(emp.getRole().equals("PME")) {
						new PMEHome();
				}
				  else {
						new EMPHome(emp);
					}
				}
				else {
					lMessage.setText("You are not authorized user! Retry or Register!");
				}
			}
		});
		bRegister=new JButton("Register");
		//Event handling for Register button
		bRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RegistrationFrame();
			}
		});
		cShowPassword=new JCheckBox("Show Password");
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Login Form");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	public void setLayoutManager() {
		container.setLayout(null);
		}
	public void setLocationAndSize() {
		lUserId.setBounds(50, 150, 100, 30);
		lpassword.setBounds(50, 250, 100, 30);
		tUserId.setBounds(250, 150, 150, 30);
		tpassword.setBounds(250, 250, 150, 30);
		cShowPassword.setBounds(250, 300, 150, 30);
		bLogin.setBounds(100, 400, 100, 30);
		bRegister.setBounds(200, 400, 100, 30);
	}
	public void addComponentsToContainer() {
		container.add(lUserId);
		container.add(tUserId);
		container.add(lpassword);
		container.add(tpassword);
		container.add(cShowPassword);
		container.add(bLogin);
		container.add(bRegister);
	}

}
