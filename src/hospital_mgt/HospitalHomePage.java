package hospital_mgt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HospitalHomePage extends JFrame implements ActionListener{
	
	private JLabel hospitalBackgr, adminLabel, cashierLabel, receptionLabel, drugLabel;
	private JButton adminButton, cashierButton, drugButton,receptionButton;
	
	public HospitalHomePage() {
	setSize(new Dimension(1000,700));
		
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		
		JPanel northPanel  = new JPanel();
		northPanel.setBackground(Color.WHITE);
		northPanel.setPreferredSize(new Dimension(1308,246));
		ImageIcon northBgIcon = new ImageIcon(getClass().getResource
				("/all/images/backgroundHeader.PNG"));
		JLabel northLabel = new JLabel("", northBgIcon, JLabel.CENTER);
		
		northPanel.add(northLabel);
		add(northPanel,BorderLayout.NORTH);
		//
		
		
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets= new Insets(10,10,10,10);
		
		
		ImageIcon Adminicon = new ImageIcon(getClass().getResource
				("/all/images/admin.png"));
		adminLabel = new JLabel(Adminicon);

		
		adminButton = new JButton("Admin");
		adminButton.setForeground(Color.WHITE);
		adminButton.setBackground(new Color(0,194,255));
		adminButton.setFont(new Font("David",1, 20));
		adminButton.addActionListener(this);
		gbc.gridx =0;
		gbc.gridy =0;
		centerPanel.add(adminLabel,gbc);
		gbc.gridx =0;
		gbc.gridy =1;
		centerPanel.add(adminButton,gbc);
		//
		
		ImageIcon cashiericon = new ImageIcon(getClass().getResource
				("/all/images/doctor.png"));
		cashierLabel = new JLabel(cashiericon);
		cashierButton = new JButton("Cashier");
		
		cashierButton.setForeground(Color.WHITE);
		cashierButton.setBackground(new Color(0,194,255));
		cashierButton.setFont(new Font("David",1, 20));
		cashierButton.addActionListener(this);
		
		gbc.gridx =1;
		gbc.gridy =0;
		centerPanel.add(cashierLabel,gbc);
		
		gbc.gridx =1;
		gbc.gridy =1;
		centerPanel.add(cashierButton,gbc);

		
		gbc.gridx =2;
		gbc.gridy =0;
		
		ImageIcon iconpharm = new ImageIcon(getClass().getResource
				("/all/images/pharmacy.png"));
		drugLabel = new JLabel(iconpharm);
		centerPanel.add(drugLabel,gbc);
		
		gbc.gridx =2;
		gbc.gridy =1;
		drugButton = new JButton("Pharmacy");
		
		drugButton.setForeground(Color.WHITE);
		drugButton.setBackground(new Color(0,194,255));
		drugButton.setFont(new Font("David",1, 20));
		drugButton.addActionListener(this);

		centerPanel.add(drugButton, gbc);
		

		ImageIcon iconRecp = new ImageIcon(getClass().getResource
				("/all/images/receptionist.png"));
		receptionLabel = new JLabel(iconRecp);
		
		gbc.gridx =3;
		gbc.gridy =0;
		centerPanel.add(receptionLabel,gbc);
		
		receptionButton = new JButton("Receptionist");
		gbc.gridx =3;
		gbc.gridy =1;
		centerPanel.add(receptionButton,gbc);
		
		receptionButton.setForeground(Color.WHITE);
		receptionButton.setBackground(new Color(0,194,255));
		receptionButton.setFont(new Font("David",1, 20));
		receptionButton.addActionListener(this);

		add(centerPanel,BorderLayout.CENTER);
		
		
		
		
		
		setVisible(true);

	}


@Override
public void actionPerformed(ActionEvent ev) {
	
	JButton btn =(JButton)ev.getSource();
	if(btn.getActionCommand().equals("Admin")) {
		LoginDialog loginD = new LoginDialog("Admin");
		loginD.setVisible(true);
		dispose();
	}
	if(btn.getActionCommand().equals("Cashier")) {
		
			LoginDialog loginD = new LoginDialog("Cashier");
			loginD.setVisible(true);
			dispose();
	}
		if(btn.getActionCommand().equals("Receptionist")) {
		
				LoginDialog loginD = new LoginDialog("Receptionist");
				loginD.setVisible(true);
				dispose();
		}
		
		if(btn.getActionCommand().equals("Pharmacy")) {
			
			LoginDialog loginD = new LoginDialog("Pharmacy");
			loginD.setVisible(true);
			dispose();
	}
}
}
