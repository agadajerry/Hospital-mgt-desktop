package hospital_mgt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginDialog extends JDialog{

	private JLabel userNameLabel, passwordLabel;
	private JButton loginB, cancelB;
	private JTextField passField, userField;
	private String user;
	
	public LoginDialog(String user) {
		setSize(new Dimension(400,220));
		
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0, 118, 255)));

		//this.setTitle();
		this.setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		setModal(true);
		initialiseUi(user);
	}

	private void initialiseUi(String user) {
		
		
		JLabel loginAs = new JLabel("Login As: "+user);
		loginAs.setBounds(20, 10, 200, 20);
		add(loginAs);
		//
		userNameLabel = new JLabel("User Name:");
		userField = new JTextField();
		userNameLabel.setBounds(20, 40, 100, 30);
		userField.setBounds(105, 40, 200, 30);
		userField.setBorder(new LineBorder(Color.BLACK,2));
		add(userNameLabel);
		add(userField);
		//
		passwordLabel = new JLabel("Password:");
		passField = new JTextField();
		
		passwordLabel.setBounds(20, 85, 100, 30);
		passField.setBounds(105, 85, 200, 30);
		passField.setBorder(new LineBorder(Color.BLACK,2));
		add(passwordLabel);
		add(passField);
		//
	
		loginB = new JButton("Login");
		cancelB = new JButton("Back");
		
		loginB.setBounds(30, 150, 100, 30);
		
		loginB.setForeground(Color.WHITE);
		loginB.setBackground(new Color(0,194,255));
		loginB.setFont(new Font("David",1, 20));
		
		
		cancelB.setBounds(250, 150, 100, 30);
		cancelB.setForeground(Color.WHITE);
		cancelB.setBackground(new Color(0,194,255));
		cancelB.setFont(new Font("David",1, 20));
		add(cancelB);
		add(loginB);
		
		loginB.addActionListener(new UserLoginListener());
		cancelB.addActionListener(new CanncelOperation());

		
		
		
		
		
	}//end of initialised Ui method
	
	private class UserLoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(userField.getText().equals("Admin")) {
				AdminPanel adminP = new AdminPanel();
				adminP.setVisible(true);
				dispose();
			}
			
		}
		
	}
	private class CanncelOperation implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
				
			HospitalHomePage ld = new HospitalHomePage();
			ld.setVisible(true);
			dispose(); // dispose login dialog
		}
		
	}
}
