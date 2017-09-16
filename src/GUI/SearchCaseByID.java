package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Case;

public class SearchCaseByID extends JFrame {

	private JButton search;
	private JLabel searchL;
	private JTextField searchF;
	private JButton back;
	private JPanel bgPanel;
	private JLabel bgImage;

	SearchCaseByID() {
		super("Search Case By ID");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1366, 768);

		searchL = new JLabel("Enter Case ID:");
		search = new JButton("Search");
		searchF = new JTextField();
		back = new JButton("Back");

		bgPanel = new JPanel();
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 0, 1366, 768);

		searchL.setForeground(Color.RED);
		searchL.setFont(new Font("Times new Roman",Font.BOLD,15));
		
		bgImage = new JLabel();
		bgImage.setBounds(0, 0, 1366, 768);
	//	bgImage.setIcon(new ImageIcon(getClass().getResource("COD.jpg")));
		
		

		bgPanel.add(searchL).setBounds(500, 150, 100, 30);
		bgPanel.add(searchF).setBounds(670, 150, 100, 30);

		bgPanel.add(search).setBounds(670, 200, 100, 30);
		bgPanel.add(back).setBounds(670, 250, 100, 30);

		add(bgPanel);

		SearchClickListener scl = new SearchClickListener();
		search.addActionListener(scl);

		backListener bl = new backListener();
		back.addActionListener(bl);
		bgPanel.add(bgImage).setBounds(0, 0, 1366, 768);
		
		setVisible(true);

		validate();
	}

	private class SearchClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == search) {
				int y = 0;
				Case c;
				try {

					ObjectInputStream x = new ObjectInputStream(new FileInputStream("case.ser"));
					while (true) {
						c = (Case) x.readObject();
						if (c.getId().equals(searchF.getText())) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Name : " + c.getName() + " \nGender : " + c.getGender() + " \nCase ID : "
											+ c.getId() + " \nLocation of Event: " + " \nHouse Number: "
											+ c.getLocation().getHouseNo() + " \t, Street Number: "
											+ c.getLocation().getStreetNo() + " \t, Town: " + c.getLocation().getTown()
											+ "\t , City: " + c.getLocation().getCity() + "\nTime: " + "\n"
											+ c.getT().getHours() + "\t:" + c.getT().getMinutes() + "\nCase Description: " + 
											c.getDescription());
						y =1;
						} 
					}
				}

				catch (Exception e) {
					return;
				}
				
				finally{
					if(y == 0)
					JOptionPane.showMessageDialog(null, "No record found!");	
				}

			}
		}

	}

	private class backListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			CaseMainFrame c = null;
			if (arg0.getSource() == back)
				c = new CaseMainFrame();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}
}
