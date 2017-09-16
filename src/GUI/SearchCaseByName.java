package GUI;

import Model.Case;

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


public class SearchCaseByName extends JFrame {

	private JButton search;
	private JLabel searchL;
	private JTextField searchF;
	private JButton back;
	
	SearchCaseByName(){
		super("Search Case By Name");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1366,768);
		
		searchL = new JLabel("Enter Name:");
		search = new JButton("Search");
		searchF = new JTextField();
		back = new JButton("Back");
		
		searchL.setBounds(600, 150, 120, 30);
		searchL.setForeground(Color.RED);
		searchL.setFont(new Font("Times new Roman",Font.BOLD,15));
		add(searchL);
		
		searchF.setBounds(750, 150, 100, 30);
		add(searchF);
		
		search.setBounds(750, 200, 100, 30);
		SearchClickListener scl= new SearchClickListener();
		search.addActionListener(scl);
		
		add(search);
		
		back.setBounds(750, 250, 100, 30);
		add(back);
		backListener bl = new backListener();
		back.addActionListener(bl);
		
		setVisible(true);
		
		validate();
	}
	
	private class SearchClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (arg0.getSource() == search) {
					int y = 0;
					Case c;
					try {
						
						ObjectInputStream x = new ObjectInputStream(new FileInputStream("case.ser"));
						while (true) {
							c = (Case) x.readObject();
							if (c.getName().equals(searchF.getText())) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Name : " + c.getName() + " \nGender : " + c.getGender() + " \nCase ID : " + c.getId()
												+ " \nLocation of Event: " +" \nHouse Number: "+ c.getLocation().getHouseNo() +
												" \t, Street Number: " + c.getLocation().getStreetNo() + " \t, Town: "
												+ c.getLocation().getTown() + "\t , City: " + c.getLocation().getCity() + "\nTime: "
												+ "\n" + c.getT().getHours() + "\t:" + c.getT().getMinutes()+ "\nCase Description: " + 
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





	private class   backListener   implements ActionListener {

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