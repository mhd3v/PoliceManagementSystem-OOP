package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.CaseMainFrame;

public class MainFrame extends JFrame {

	private JButton Case;
	private JButton Employee;
	private JButton Prisoner;
	private JButton Exit;

	private JPanel bgPanel;
	private JLabel bgImage;

	MainFrame() {
		super("MAIN FRAME");

		Icon icon = new ImageIcon(getClass().getResource("case.png"));
		Icon icon1 = new ImageIcon(getClass().getResource("employee.png"));
		Icon icon2 = new ImageIcon(getClass().getResource("prisoner.png"));
		Icon icon3 = new ImageIcon(getClass().getResource("exit.png"));

		Case = new JButton(icon);
		Employee = new JButton(icon1);
		Prisoner = new JButton(icon2);
		Exit = new JButton(icon3);

		bgPanel = new JPanel();
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 0, 1366, 768);

		bgImage = new JLabel();
		bgImage.setBounds(0, 0, 1366, 768);
		bgImage.setIcon(new ImageIcon(getClass().getResource("p.jpg")));

		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1366, 768);

		bgPanel.add(Case).setBounds(600, 200, 150, 45);
		Case.setContentAreaFilled(false);
		Case.setBorder(null);

		bgPanel.add(Employee).setBounds(600, 300, 150, 45);
		Employee.setContentAreaFilled(false);
		Employee.setBorder(null);

		bgPanel.add(Prisoner).setBounds(600, 400, 150, 45);
		Prisoner.setContentAreaFilled(false);
		Prisoner.setBorder(null);

		bgPanel.add(Exit).setBounds(600, 500, 150, 45);
		Exit.setContentAreaFilled(false);
		Exit.setBorder(null);

		add(bgPanel);
		bgPanel.add(bgImage).setBounds(0, 0, 1366, 768);

		caseListener cl = new caseListener();
		employeeListener el = new employeeListener();
		prisonerListener pl = new prisonerListener();
		exitListener eL = new exitListener();

		Case.addActionListener(cl);
		Employee.addActionListener(el);
		Prisoner.addActionListener(pl);
		Exit.addActionListener(eL);
	}

	private class caseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CaseMainFrame c = null;

			if (arg0.getSource() == Case)
				c = new CaseMainFrame();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class employeeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			EmployeeMainFrame e = null;

			if (arg0.getSource() == Employee)
				e = new EmployeeMainFrame();
			e.setExtendedState(e.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class prisonerListener implements ActionListener {

		@Override

		public void actionPerformed(ActionEvent arg0) {

			PrisonerMainFrame p = null;
			if (arg0.getSource() == Prisoner)
				p = new PrisonerMainFrame();
			p.setExtendedState(p.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}
	}

	private class exitListener implements ActionListener {

		@Override

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == Exit)
				dispose();
		}
	}

}
