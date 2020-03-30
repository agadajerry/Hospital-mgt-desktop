package hospital_mgt;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class AdminPanel extends JFrame{
	
	private JButton [] adminButton = new JButton[6];
	private JLabel []adminLabel = new JLabel[6];
	private JButton cancelB, logOutB;
	private CardLayout cLayout;
	private JPanel regPanel, patientPanel,centerPanel;
	
	public AdminPanel() {
		setSize(new Dimension(800,600));
		
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		initialiseUi();
		
	}

	private void initialiseUi() {

		Container mainContainer = this.getContentPane();
		// mainContainer.setLayout(new BorderLayout(6, 8));
		mainContainer.setBackground(Color.WHITE);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0, 118, 255)));

		JPanel northPanel  = new JPanel();
		northPanel.setBackground(Color.WHITE);
		northPanel.setPreferredSize(new Dimension(1308,246));
		ImageIcon northBgIcon = new ImageIcon(getClass().getResource
				("/all/images/adminbg.PNG"));
		JLabel northLabel = new JLabel("", northBgIcon, JLabel.CENTER);
		
		northPanel.add(northLabel);
		add(northPanel,BorderLayout.NORTH);
		
		// all panels showing in the center panel
		ImageIcon centerbgIcon = new ImageIcon(getClass().getResource
				("/all/images/adminpanel.PNG"));
		JPanel bgPanel = new JPanel();
		regPanel = new JPanel();
		regPanel.add(new JLabel("Hello"));
		patientPanel = new JPanel();
		bgPanel.add(new JLabel("",centerbgIcon, JLabel.CENTER));
		centerPanel = new JPanel();

		cLayout = new CardLayout();
		centerPanel.setLayout(cLayout);
		centerPanel.add(bgPanel,"backgr");
		centerPanel.add(new RegPanel(),"regPanel");
		centerPanel.add(new PatientPanel(),"patientPanel");
		
		cLayout.show(centerPanel, "backgr");
		
		
		mainContainer.add(centerPanel,BorderLayout.CENTER);
		// West panel holding buttons
		JPanel westPanel = new JPanel(new GridLayout(0,1,10,10));
		westPanel.setBorder(new EmptyBorder(10,10,10,10));
		for(int i=0; i<adminButton.length;i++) {
			adminButton[i] = new  JButton();
			westPanel.add(adminButton[i]);
			
			adminButton[i].setForeground(Color.WHITE);
			adminButton[i].setBackground(new Color(0,194,255));
			adminButton[i].setFont(new Font("David",1, 20));
			adminButton[i].addActionListener(new ButtOnClickedListener());
			
		}
		adminButton[0].setText("Patient Registration");
		adminButton[1].setText("Patient Information");
		adminButton[2].setText("Staff Information");
		adminButton[3].setText("User Information");
		adminButton[4].setText("Add New User");
		adminButton[5].setText("Room Information");


		add(westPanel,BorderLayout.WEST);
		
		
		// bottom panel at southern region
		JPanel	bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.WHITE);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		// bottomPanel.setBorder(new EmptyBorder(20,20,20,20));
		logOutB= new JButton("LogOut");
		cancelB = new JButton("Cancel");
		
		logOutB.addActionListener(new LogoutListener());
		logOutB.setPreferredSize(new Dimension(120, 50));
		logOutB.setForeground(Color.WHITE);
		logOutB.setBackground(new Color(0,194,255));
		logOutB.setFont(new Font("David",1, 20));

		
		cancelB.setPreferredSize(new Dimension(100, 50));
		cancelB.setForeground(Color.WHITE);
		cancelB.setBackground(new Color(0,194,255));
		cancelB.setFont(new Font("David",1, 20));

		bottomPanel.add(logOutB);
		bottomPanel.add(cancelB);
		bottomPanel.setBorder(new EmptyBorder(10,10,10,10));
		add(bottomPanel, BorderLayout.SOUTH);
		
	}


	private class ButtOnClickedListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			
			JButton btn = (JButton)ev.getSource();
			if(btn.getActionCommand().equals("Patient Registration")) {
				cLayout.show(centerPanel, "regPanel");
			}		
			
			if(btn.getActionCommand().equals("Patient Information")) {
				cLayout.show(centerPanel, "patientPanel");//patient info panel
			}		
		}
		
	}
	private class LogoutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			HospitalHomePage adminP = new HospitalHomePage();
			adminP.setVisible(true);
			dispose();			
		}
		
	}
}
