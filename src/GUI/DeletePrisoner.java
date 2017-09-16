package GUI;

import Model.Person;
import Model.Criminal;

import java.awt.Color;
import java.awt.Font;
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

import Model.Case;
import Model.Criminal;

public class DeletePrisoner extends JFrame {

	private JTextField nameT;
	private JButton deleteP;
	private JLabel nameL;
	private JButton back;

	DeletePrisoner() {
		super("DELETE PRISONER");
		setSize(1366, 768);
		setVisible(true);
		setLayout(null);

		nameT = new JTextField();
		deleteP = new JButton("Delete");
		nameL = new JLabel("Enter Name");
		back = new JButton("Back");

		nameL.setBounds(500, 150, 120, 30);
		nameL.setForeground(Color.RED);
		nameL.setFont(new Font("Times new Roman", Font.BOLD, 15));
		
		
		nameT.setBounds(650, 150, 120, 30);
		deleteP.setBounds(650, 200, 120, 30);
		back.setBounds(650, 250, 120, 30);

		add(back);
		add(nameL);
		add(nameT);
		add(deleteP);
		add(back);

		deleteListener dl = new deleteListener();
		backListener bl = new backListener();

		back.addActionListener(bl);
		deleteP.addActionListener(dl);
	}

	public class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int  y = 0;

			if (arg0.getSource() == deleteP) {
				Criminal P;
				ArrayList<Criminal> CriminalList = readCriminals();

				for (int i = 0; i < CriminalList.size(); i++) {
					if (CriminalList.get(i).getName().equals(nameT.getText())) {
						CriminalList.remove(i);
						JOptionPane.showMessageDialog(null, "Data has been deleted from system.");
						y = 1;
						break;
					}
				}

				try {
					ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream("crim.ser"));

					for (int i = 0; i < CriminalList.size(); i++) {
						x.writeObject(CriminalList.get(i));
					}

				}

				catch (EOFException e1) {
					return;
				} catch (Exception e) {
					return;
				}
				finally{
					if(y == 0)
						JOptionPane.showMessageDialog(null, "No record by this name!");
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
		}}
	}
}