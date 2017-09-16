package GUI;

import Model.Address;
import Model.Criminal;
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

public class AddPrisoner extends JFrame {

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
	private JTextField t7;
	private JLabel l7;
	private JTextField t8;
	private JLabel l8;
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

	private JButton save;
	private JButton searchByName;
	private JButton searchByCaseId;
	private JButton back;

	AddPrisoner() {
		super("Add Prisoner");
		setVisible(true);
		setLayout(null);
		setSize(1366, 768);

		l1 = new JLabel("Name");
		l1.setBounds(500, 60, 100, 25);
		add(l1);

		t1 = new JTextField();
		t1.setBounds(700, 60, 200, 30);
		add(t1);

		genderL = new JLabel("Prisoner Gender:");
		genderF = new JTextField();
		genderL.setBounds(500, 120, 100, 30);
		add(genderL);
		genderF.setBounds(700, 120, 100, 30);
		add(genderF);

		l2 = new JLabel("Age");
		l2.setBounds(500, 180, 100, 25);
		add(l2);
		t2 = new JTextField();
		t2.setBounds(700, 180, 100, 30);
		add(t2);

		houseNoL = new JLabel("a. Enter House Number:");
		streetNoL = new JLabel("b. Enter Street Number:");
		townL = new JLabel("c. Enter Town Name:");
		cityL = new JLabel("d. Enter City Name:");
		address = new JLabel("Address");

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

		save = new JButton("Save");
		save.setBounds(650, 650, 75, 30);
		add(save);

		back = new JButton("Back");
		back.setBounds(750, 650, 75, 30);
		add(back);
		backListener bl = new backListener();
		back.addActionListener(bl);

		SaveClickListener sc = new SaveClickListener();

		save.addActionListener(sc);

		validate();
	}

	public class SaveClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == save) {
				Criminal c = new Criminal(t1.getText(), (t2.getText()), genderF.getText(),
						new Address(houseNoF.getText(), streetNoF.getText(), townF.getText(), cityF.getText()),
						cnicF.getText(), servingF.getText());

				ObjectOutputStream oos = null;

				try {
					ArrayList<Criminal> cList = readCriminals();

					cList.add(c);

					oos = new ObjectOutputStream(new FileOutputStream("crim.ser"));

					for (int i = 0; i < cList.size(); i++) {

						oos.writeObject(cList.get(i));

					}

					JOptionPane.showMessageDialog(null, "Your data is successfully saved!");

				}

				catch (Exception e) {
					System.out.println("IO exception");
				}

				finally {
					try {
						if (oos != null) {
							oos.close();
						}

					} catch (Exception e) {
						System.out.println("IO exception");
					}
				}

			}

		}

	}

	public ArrayList<Criminal> readCriminals() {

		ArrayList<Criminal> cList = new ArrayList<Criminal>(0);

		ObjectInputStream ois = null;
		try {

			ois = new ObjectInputStream(new FileInputStream("crim.ser"));

			boolean EOF = false;

			while (!EOF) {
				try {

					Criminal myObj = (Criminal) ois.readObject();

					cList.add(myObj);

				} catch (ClassNotFoundException e) {

				} catch (EOFException end) {

					EOF = true;
				}
			}
		}

		catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

		finally {

			try {
				if (ois != null)
					ois.close();
			}

			catch (IOException e) {

				System.out.println("IO Exception");
			}
		}
		return cList;
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
