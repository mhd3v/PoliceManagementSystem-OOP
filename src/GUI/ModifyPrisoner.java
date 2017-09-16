
package GUI;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Address;
import Model.Criminal;

public class ModifyPrisoner extends JFrame {

	private JLabel mForm;

	private JTextField t1;
	private JLabel l1;
	private JTextField t2;
	private JLabel l2;

	private JLabel genderL;
	private JTextField genderF;

	private JLabel address;

	private JLabel houseNoL;
	private JLabel streetNoL;
	private JLabel townL;
	private JLabel cityL;

	private JTextField houseNoF;
	private JTextField streetNoF;
	private JTextField townF;
	private JTextField cityF;

	private JLabel cnic;
	private JTextField cnicF;

	private JLabel servingL;
	private JTextField servingF;

	JButton Modify;
	JButton Back;

	private Criminal c;

	ModifyPrisoner() {
		super("Modify Prisoner Data");
		setVisible(true);
		setLayout(null);
		setSize(1366, 768);

		mForm = new JLabel("Prisoner Modify Form");
		mForm.setBounds(700, 10, 200, 30);
		add(mForm);

		l1 = new JLabel("Name (to Modify):");
		l1.setBounds(500, 60, 100, 25);
		add(l1);

		t1 = new JTextField();
		t1.setBounds(700, 60, 200, 30);
		add(t1);

		genderL = new JLabel("Gender:");
		genderF = new JTextField();
		genderL.setBounds(500, 120, 100, 30);
		add(genderL);
		genderF.setBounds(700, 120, 100, 30);
		add(genderF);

		l2 = new JLabel("Age:");
		l2.setBounds(500, 180, 100, 25);
		add(l2);
		t2 = new JTextField();
		t2.setBounds(700, 180, 100, 30);
		add(t2);

		houseNoL = new JLabel("a. Enter House Number:");
		streetNoL = new JLabel("b. Enter Street Number:");
		townL = new JLabel("c. Enter Town Name:");
		cityL = new JLabel("d. Enter City Name:");
		address = new JLabel("Address:");

		houseNoF = new JTextField();
		streetNoF = new JTextField();
		townF = new JTextField();
		cityF = new JTextField();

		address.setBounds(500, 240, 150, 30);
		add(address);

		houseNoL.setBounds(540, 300, 150, 30);
		add(houseNoL);
		houseNoF.setBounds(740, 300, 100, 30);
		add(houseNoF);

		streetNoL.setBounds(540, 360, 150, 30);
		add(streetNoL);
		streetNoF.setBounds(740, 360, 100, 30);
		add(streetNoF);

		townL.setBounds(540, 420, 150, 30);
		add(townL);
		townF.setBounds(740, 420, 100, 30);
		add(townF);

		cityL.setBounds(540, 480, 150, 30);
		add(cityL);
		cityF.setBounds(740, 480, 100, 30);
		add(cityF);

		cnic = new JLabel("CNIC:");
		cnic.setBounds(500, 540, 150, 30);
		add(cnic);

		cnicF = new JTextField();
		cnicF.setBounds(700, 540, 150, 30);
		add(cnicF);

		servingF = new JTextField();
		servingL = new JLabel("Serving Time:");

		servingL.setBounds(500, 600, 150, 30);
		add(servingL);

		servingF.setBounds(700, 600, 200, 30);
		add(servingF);

		ModifyListener ml = new ModifyListener();
		BackListener bl = new BackListener();

		Modify = new JButton("Modify");
		Modify.setBounds(740, 660, 75, 30);
		add(Modify);
		Modify.addActionListener(ml);
		
		Back = new JButton("Back");
		Back.setBounds(650, 660, 75, 30);
		add(Back);
		Back.addActionListener(bl);

		validate();
	}

	private class ModifyListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (ae.getSource() == Modify) {
				c = new Criminal(t1.getText(), (t2.getText()), genderF.getText(),
						new Address(houseNoF.getText(), streetNoF.getText(), townF.getText(), cityF.getText()),
						cnicF.getText(), servingF.getText());

				ObjectOutputStream outputStream = null;

				try {

					ArrayList<Criminal> CList = readAllData();

					for (int i = 0; i < CList.size(); i++) {
						if (CList.get(i).getName().equals(t1.getText())) {
							CList.remove(i);
							CList.add(i, c);

							break;
						}
					}

					outputStream = new ObjectOutputStream(new FileOutputStream("crim.ser"));

					for (int i = 0; i < CList.size(); i++) {
						outputStream.writeObject(CList.get(i));

					}
					JOptionPane.showMessageDialog(null, "Criminal  " + c.getName() + "'s data modified!");
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

	public ArrayList<Criminal> readAllData() {

		ArrayList<Criminal> CList = new ArrayList<Criminal>(0);

		ObjectInputStream inputStream = null;
		try {

			inputStream = new ObjectInputStream(new FileInputStream("crim.ser"));

			boolean EOF = false;

			while (!EOF) {
				try {

					Criminal myObj = (Criminal) inputStream.readObject();

					CList.add(myObj);

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
		return CList;
	}

	private class BackListener implements ActionListener {

		EmployeeMainFrame a;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == Back) {

				a = new EmployeeMainFrame();
				a.setExtendedState(a.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

		}
	}
}
