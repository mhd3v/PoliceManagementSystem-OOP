package GUI;

import Model.Case;
import Model.Criminal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchPrisoner extends JFrame {

	private JButton search;
	private JLabel searchL;
	private JTextField searchF;
	private JButton back;

	SearchPrisoner() {
		super("Search Prisoner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1366, 768);

		searchL = new JLabel("Enter Name:");
		search = new JButton("Search");
		searchF = new JTextField();

		searchL.setBounds(500, 150, 140, 30);
		searchL.setForeground(Color.RED);
		searchL.setFont(new Font("Times new Roman",Font.BOLD,15));
		add(searchL);

		searchF.setBounds(650, 150, 100, 30);
		add(searchF);

		search.setBounds(650, 200, 100, 30);
		SearchClickListener scl = new SearchClickListener();
		search.addActionListener(scl);

		back = new JButton("Back");
		back.setBounds(650, 250, 100, 30);
		add(back);
		backListener bl = new backListener();
		back.addActionListener(bl);

		add(search);

		setVisible(true);

		validate();
	}

	private class SearchClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == search) {

				Criminal c;
				int y =0;
				
				try {

					ObjectInputStream x = new ObjectInputStream(new FileInputStream("crim.ser"));
					while (true) {
						c = (Criminal) x.readObject();
						if (c.getName().equals(searchF.getText())) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Name : " + c.getName() + " \nGender : " + c.getGender() + " \nAge : " + c.getAge()
											+ " \nLocation of Event: " + " \nHouse Number: "
											+ c.getAddress().getHouseNo() + " \t, Street Number: "
											+ c.getAddress().getStreetNo() + " \t, Town: " + c.getAddress().getTown()
											+ "\t , City: " + c.getAddress().getCity() + "\nCNIC: " + "\t" + c.getCnic()
											+ "\nSevering Time:" + c.getServingTime());
							y = 1;
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
			
			PrisonerMainFrame c = null;
			if (arg0.getSource() == back) {
				c = new PrisonerMainFrame();
				c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

		}
	}

}