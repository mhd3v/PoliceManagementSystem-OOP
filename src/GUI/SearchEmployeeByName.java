package GUI;

import Model.Case;
import Model.Criminal;
import Model.Date;
import Model.Employee;

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

public class SearchEmployeeByName extends JFrame {

	private JButton search;
	private JLabel searchL;
	private JTextField searchF;
	private JButton back;

	SearchEmployeeByName() {
		super("Search Employee By Name");
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
				int a = 0;
				Employee e;
				try {

					ObjectInputStream y = new ObjectInputStream(new FileInputStream("employee.ser"));
					while (true) {
						e = (Employee) y.readObject();
						if (e.getName().equals(searchF.getText())) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Name : " + e.getName() + " \nGender : " + e.getGender() + " \nAge : " + e.getAge()
											+ " \nAddress: " + " \nHouse Number: " + e.getAddress().getHouseNo()
											+ " \t, Street Number: " + e.getAddress().getStreetNo() + " \t, Town: "
											+ e.getAddress().getTown() + "\t , City: " + e.getAddress().getCity()
											+ "\nCNIC: " + "\t" + e.getCnic() + "\n Hire Date" + "\nDay:"
											+ e.getHireDate().getDay() + "\tMonth:" + e.getHireDate().getMonth()
											+ "\tYear:" + e.getHireDate().getYear() + "\nWorking Hours:"
											+ e.getWorkingHours() + "\nSalary" + e.getSalary() + "\nRank"
											+ e.getRank());
							a = 1;
						} 
						

					}
				}

				catch (Exception ex) {
					return;
				}
				
				finally{
					if(a == 0)
					JOptionPane.showMessageDialog(null, "No record found!");	
				}

			}
		}
	}

	private class backListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			EmployeeMainFrame c = null;
			if (arg0.getSource() == back) {
				c = new EmployeeMainFrame();
				c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

		}
	}

}