package GUI;

import Model.Case;
import Model.Address;
import Model.Date;
import Model.InvalidInputException;
import Model.Time;
import Model.Date;

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

public class CaseFrame extends JFrame {

	JLabel idL;
	JLabel locationL;
	JLabel timeL;
	JLabel descL;

	JLabel nameL;
	JTextField nameF;
	JLabel genderL;
	JTextField genderF;

	JTextField idF;
	JLabel locationF;
	JTextField descF;

	private JLabel houseNoL;
	private JLabel streetNoL;
	private JLabel townL;
	private JLabel cityL;

	private JTextField houseNoF;
	private JTextField streetNoF;
	private JTextField townF;
	private JTextField cityF;

	private JLabel hL;
	private JLabel mL;

	private JTextField hF;
	private JTextField mF;

	private JLabel dL;
	private JTextField day;
	private JTextField month;
	private JTextField year;

	private JButton save;
	private JButton back;

	CaseFrame() {
		super("New Case");
		setSize(1366, 768);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		idL = new JLabel("Case ID:");
		idL.setBounds(500, 30, 100, 30);
		add(idL);

		idF = new JTextField();
		idF.setBounds(740, 30, 100, 30);
		add(idF);

		// Name

		nameL = new JLabel("Suspect Name: ");
		nameF = new JTextField();

		nameL.setBounds(500, 70, 100, 30);
		add(nameL);
		nameF.setBounds(740, 70, 300, 30);
		add(nameF);

		// Gender

		genderL = new JLabel("Suspect Gender:");
		genderF = new JTextField();
		genderL.setBounds(500, 110, 100, 30);
		add(genderL);
		genderF.setBounds(740, 110, 100, 30);
		add(genderF);

		// Address

		locationL = new JLabel("Location:");
		locationL.setBounds(500, 150, 100, 30);
		add(locationL);

		houseNoL = new JLabel("a. Enter House Number:");
		streetNoL = new JLabel("b. Enter Street Number:");
		townL = new JLabel("c. Enter Town Name:");
		cityL = new JLabel("d. Enter City Name:");

		houseNoF = new JTextField();
		streetNoF = new JTextField();
		townF = new JTextField();
		cityF = new JTextField();

		houseNoL.setBounds(540, 180, 150, 30);
		add(houseNoL);
		houseNoF.setBounds(740, 180, 100, 30);
		add(houseNoF);

		streetNoL.setBounds(540, 220, 150, 30);
		add(streetNoL);
		streetNoF.setBounds(740, 220, 100, 30);
		add(streetNoF);

		townL.setBounds(540, 260, 150, 30);
		add(townL);
		townF.setBounds(740, 260, 100, 30);
		add(townF);

		cityL.setBounds(540, 300, 150, 30);
		add(cityL);
		cityF.setBounds(740, 300, 100, 30);
		add(cityF);

		// time

		timeL = new JLabel("Time:");
		timeL.setBounds(500, 350, 100, 30);
		add(timeL);

		hL = new JLabel("a. Enter Hours:");
		mL = new JLabel("b. Enter Minutes:");

		hF = new JTextField();
		mF = new JTextField();

		hL.setBounds(540, 370, 150, 30);
		add(hL);
		hF.setBounds(740, 370, 100, 30);
		add(hF);

		mL.setBounds(540, 410, 150, 30);
		add(mL);
		mF.setBounds(740, 410, 100, 30);
		add(mF);

		// Date

		dL = new JLabel("Date (D/M/Y): ");
		dL.setBounds(500, 450, 100, 30);
		add(dL);

		day = new JTextField();
		day.setBounds(740, 450, 40, 30);
		add(day);

		month = new JTextField();
		month.setBounds(780, 450, 40, 30);
		add(month);

		year = new JTextField();
		year.setBounds(820, 450, 70, 30);
		add(year);

		// Description

		descL = new JLabel("Description:");
		descL.setBounds(500, 490, 100, 30);
		add(descL);

		descF = new JTextField();
		descF.setBounds(740, 490, 370, 160);
		add(descF);

		save = new JButton("Save");
		save.setBounds(1200, 250, 100, 50);
		add(save);

		back = new JButton("Back");
		back.setBounds(1200, 350, 100, 50);
		add(back);

		backListener bl = new backListener();
		SaveClickListener sc = new SaveClickListener();

		save.addActionListener(sc);
		back.addActionListener(bl);

		validate();

	}

	public class SaveClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == save) {
				Case c = null;

				c = new Case(nameF.getText(), genderF.getText(), idF.getText(),
						new Address(houseNoF.getText(), streetNoF.getText(), townF.getText(), cityF.getText()),
						new Time(Integer.parseInt(hF.getText()), Integer.parseInt(mF.getText())),
						new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()),
								Integer.parseInt(year.getText())),
						descF.getText());

				ObjectOutputStream oos = null;

				try {
					ArrayList<Case> cList = readCase();

					cList.add(c);

					oos = new ObjectOutputStream(new FileOutputStream("case.ser"));

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

	public ArrayList<Case> readCase() {

		ArrayList<Case> cList = new ArrayList<Case>(0);

		ObjectInputStream ois = null;
		try {

			ois = new ObjectInputStream(new FileInputStream("case.ser"));

			boolean EOF = false;

			while (!EOF) {
				try {

					Case myObj = (Case) ois.readObject();

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
			CaseMainFrame c = null;

			if (arg0.getSource() == back)
				c = new CaseMainFrame();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

}
