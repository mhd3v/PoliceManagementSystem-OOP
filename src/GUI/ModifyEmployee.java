package GUI;

import javax.swing.*;

import Model.Address;
import Model.Date;
import Model.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ModifyEmployee extends JFrame {

	
	private JLabel mForm;
	private JButton Modify;
	private JButton Back;
	private Employee d;
	private JTextField t1;
	private JLabel l1;
	private JTextField t2;
	private JLabel l2;
	private JTextField t3;
	private JLabel l3;
	private JTextField t4;
	private JLabel l4;
	private JTextField t5;
	private JLabel l5;
	private JTextField t6;
	private JLabel l6;
	
	private JLabel dL;
	private JTextField day;
	private JTextField month;
	private JTextField year;
	
	private JLabel salaryL;
	private JTextField salaryF;
	
	private JLabel workingHoursL;
	private JTextField workingHoursF;
	
	private Employee e;
	
	private JButton save;
	

	private JLabel houseNoL;
	private JLabel streetNoL;
	private JLabel townL;
	private JLabel cityL;

	private JTextField houseNoF;
	private JTextField streetNoF;
	private JTextField townF;
	private JTextField cityF;
	
	public ModifyEmployee() {
		super("Employee Data Modify");
		setVisible(true);
		setLayout(null);
		setSize(1366,768);

		mForm = new JLabel("Modification Form");
		mForm.setBounds(700,10, 200, 30);
		add(mForm);
		
		t1 = new JTextField();
		t1.setBounds(700, 60, 200, 30);
		add(t1);

		l1 = new JLabel("Name (to Modify):");
		l1.setBounds(600, 60, 150, 25);
		add(l1);

		t2 = new JTextField();
		t2.setBounds(700, 110, 100, 30);
		add(t2);

		l2 = new JLabel("Age:");
		l2.setBounds(600, 110, 100, 25);
		add(l2);

		t3 = new JTextField();
		t3.setBounds(700, 160, 100, 30);
		add(t3);

		l3 = new JLabel("Gender:");
		l3.setBounds(600, 160, 100, 25);
		add(l3);

		t4 = new JTextField();
		t4.setBounds(700, 210, 200, 30);
		add(t4);

		l4 = new JLabel("CNIC:");
		l4.setBounds(600, 210, 100, 25);
		add(l4);

		l5 = new JLabel("Rank:");
		l5.setBounds(600, 260, 100, 25);
		add(l5);

		t5 = new JTextField();
		t5.setBounds(700, 260, 200, 30);
		add(t5);

		l6 = new JLabel("Address:");
		l6.setBounds(600, 310, 100, 25);
		add(l6);

		houseNoL = new JLabel("a. House #: ");
		houseNoL.setBounds(700, 330, 100, 25);
		add(houseNoL);

		streetNoL = new JLabel("b. Street #: ");
		streetNoL.setBounds(700, 360, 100, 25);
		add(streetNoL);

		townL = new JLabel("c. Town: ");
		townL.setBounds(700, 390, 100, 25);
		add(townL);

		cityL = new JLabel("d. City: ");
		cityL.setBounds(700, 420, 100, 25);
		add(cityL);

		houseNoF = new JTextField();
		houseNoF.setBounds(800, 330, 50, 30);
		add(houseNoF);

		streetNoF = new JTextField();
		streetNoF.setBounds(800, 360, 50, 30);
		add(streetNoF);

		townF = new JTextField();
		townF.setBounds(800, 390, 150, 30);
		add(townF);

		cityF = new JTextField();
		cityF.setBounds(800, 420, 100, 30);
		add(cityF);

		salaryL = new JLabel("Salary:");
		salaryL.setBounds(600, 490, 200, 30);
		salaryF = new JTextField();
		salaryF.setBounds(700, 490, 200, 30);
		
		add(salaryL);
		add(salaryF);
		
		workingHoursL = new JLabel("Working Hours:");
		workingHoursF= new JTextField();
		
		workingHoursL.setBounds(600, 540, 200, 30);
		workingHoursF.setBounds(700, 540, 200, 30);
		add(workingHoursL);
		add(workingHoursF);
		
		dL = new JLabel("Hire Date (D/M/Y): ");
		dL.setBounds(600, 580, 100, 30);
		add(dL);

		day = new JTextField();
		day.setBounds(740, 580, 40, 30);
		add(day);

		month = new JTextField();
		month.setBounds(780, 580, 40, 30);
		add(month);

		year = new JTextField();
		year.setBounds(820, 580, 70, 30);
		add(year);
		
		ModifyListener a = new ModifyListener();
		BackListener b1 = new BackListener();
		
		Back = new JButton("Back");
		Back.setBounds(670, 650, 75, 30);
		add(Back);

		Modify = new JButton("Modify");
		Modify.setBounds(750, 650, 75, 30);
		add(Modify);
		
		Modify.addActionListener(a);
		Back.addActionListener(b1);

		setVisible(true);

		validate();
	}


	private class ModifyListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == Back) {
				new SearchEmployeeByName();
				dispose();
			}

			if (ae.getSource() == Modify) {
				 e = new Employee(t1.getText(), (t2.getText()), t4.getText(),
						new Address(houseNoF.getText(), streetNoF.getText(), townF.getText(), cityF.getText()),
						l4.getText(), new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()),
								Integer.parseInt(year.getText())),salaryF.getText(),t5.getText(),
								workingHoursF.getText());

				ObjectOutputStream outputStream = null;

				try {
					
					ArrayList<Employee> EmployeeList = readAllData();
					
					for (int i = 0; i < EmployeeList.size(); i++) {
						if (EmployeeList.get(i).getName().equals(t1.getText())) {
							EmployeeList.remove(i);
							EmployeeList.add(i, e);
							JOptionPane.showMessageDialog(null, "Employee " + e.getName() + "'s" + " data modified!");
							break;
						}
						else
							JOptionPane.showMessageDialog(null, "No record by this name!");
					}
					
					outputStream = new ObjectOutputStream(new FileOutputStream("employee.ser"));

					for (int i = 0; i < EmployeeList.size(); i++) {
						outputStream.writeObject(EmployeeList.get(i));

					}
					
				} catch (IOException ee) {
					System.out.println("IO Exception while opening file");
				} finally { 
					try {
						if (outputStream != null) {
							outputStream.close();
						}
					} catch (IOException ee) {
						System.out.println("IO Exception while closing file");
					}
				}

			}

		}
	}

	public ArrayList<Employee> readAllData() {
		
		ArrayList<Employee> EmployeeList = new ArrayList<Employee>(0);
		
		ObjectInputStream inputStream = null;
		try {
			
			inputStream = new ObjectInputStream(new FileInputStream("employee.ser"));
			
			boolean EOF = false;
			
			while (!EOF) {
				try {
					
					Employee myObj = (Employee) inputStream.readObject();
					
					EmployeeList.add(myObj);
					
				} catch (ClassNotFoundException e) {
					
				} catch (EOFException end) {
					
					EOF = true;
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally { 
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
			
				System.out.println("IO Exception while closing file");
			}
		}
		return EmployeeList;
	}
	
	
	private class BackListener implements ActionListener{
		
		EmployeeMainFrame a;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == Back){
				
				a = new EmployeeMainFrame();
				a.setExtendedState(a.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

		}
	}

}