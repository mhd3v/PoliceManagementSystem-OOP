package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.SearchCaseByID;
import GUI.SearchCaseByName;

import GUI.CaseFrame;

public class EmployeeMainFrame extends JFrame {

	private JButton NewEmployee;
	private JButton SearchByCNIC;
	private JButton back;
	private JButton modify;
	private JButton deleteEmployee;

	private JPanel bgPanel;
	private JLabel bgImage;

	EmployeeMainFrame() {

		super("Employee");
		
		Icon icon = new ImageIcon(getClass().getResource("addE.png"));
		Icon icon1 = new ImageIcon(getClass().getResource("sbn.png"));
		Icon icon2 = new ImageIcon(getClass().getResource("dE.png"));
		Icon icon3 = new ImageIcon(getClass().getResource("back.png"));
		Icon icon4 = new ImageIcon(getClass().getResource("modify.png"));

		NewEmployee = new JButton(icon);
		SearchByCNIC = new JButton(icon1);
		deleteEmployee = new JButton(icon2);
		back = new JButton(icon3);
		modify = new JButton(icon4);

		bgPanel = new JPanel();
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 0, 1366, 768);

		bgImage = new JLabel();
		bgImage.setBounds(0, 0, 1366, 768);
		bgImage.setIcon(new ImageIcon(getClass().getResource("EF.jpg")));

		setLayout(null);
		setVisible(true);
		setSize(1366, 768);

		bgPanel.add(NewEmployee).setBounds(600, 100, 200, 45);
		NewEmployee.setContentAreaFilled(false);
		NewEmployee.setBorder(null);

		bgPanel.add(SearchByCNIC).setBounds(600, 200, 200, 45);
		SearchByCNIC.setContentAreaFilled(false);
		SearchByCNIC.setBorder(null);

		bgPanel.add(deleteEmployee).setBounds(600, 300, 200, 45);
		deleteEmployee.setContentAreaFilled(false);
		deleteEmployee.setBorder(null);
		

		bgPanel.add(modify).setBounds(600, 400, 200, 45);
		modify.setContentAreaFilled(false);
		modify.setBorder(null);
		

		bgPanel.add(back).setBounds(600, 500, 200, 45);
		back.setContentAreaFilled(false);
		back.setBorder(null);
	
		add(bgPanel);
		bgPanel.add(bgImage).setBounds(0, 0, 1366, 768);
		

		eListener el = new eListener();
		SListener sl = new SListener();
		backListener bl = new backListener();
		deleteListener dl = new deleteListener();
		modifyListener mL = new modifyListener();

		NewEmployee.addActionListener(el);
		SearchByCNIC.addActionListener(sl);
		deleteEmployee.addActionListener(dl);
		modify.addActionListener(mL);
		back.addActionListener(bl);
	}

	private class eListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AddEmployee c1 = null;
			setVisible(false);
			if (arg0.getSource() == NewEmployee)
				c1 = new AddEmployee();
			c1.setExtendedState(c1.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}

	}

	private class backListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainFrame c = null;

			if (arg0.getSource() == back)
				c = new MainFrame();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class SListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SearchEmployeeByName e = null;

			if (arg0.getSource() == SearchByCNIC)
				e = new SearchEmployeeByName();
			e.setExtendedState(e.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DeleteEmployee c = null;

			if (arg0.getSource() == deleteEmployee)
				c = new DeleteEmployee();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class modifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ModifyEmployee c = null;

			if (arg0.getSource() == modify)
				c = new ModifyEmployee();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

}