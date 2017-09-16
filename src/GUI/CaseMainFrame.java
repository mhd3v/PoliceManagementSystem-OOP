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

public class CaseMainFrame extends JFrame {

	private JButton NewCase;
	private JButton SearchByID;
	private JButton SearchByName;
	private JButton back;
	private JButton modify;

	private JPanel bgPanel;
	private JLabel bgImage;

	CaseMainFrame() {
		super("Case");

		Icon icon = new ImageIcon(getClass().getResource("newcase.png"));
		Icon icon1 = new ImageIcon(getClass().getResource("sbn.png"));
		Icon icon2 = new ImageIcon(getClass().getResource("sbi.png"));
		Icon icon3 = new ImageIcon(getClass().getResource("back.png"));
		Icon icon4 = new ImageIcon(getClass().getResource("modify.png"));

		NewCase = new JButton(icon);
		SearchByID = new JButton(icon2);
		SearchByName = new JButton(icon1);
		back = new JButton(icon3);
		modify = new JButton(icon4);

		bgPanel = new JPanel();
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 0, 1366, 768);

		bgImage = new JLabel();
		bgImage.setBounds(0, 0, 1366, 768);
		bgImage.setIcon(new ImageIcon(getClass().getResource("CF.jpg")));

		setLayout(null);
		setVisible(true);

		setSize(1366, 768);

		bgPanel.add(NewCase).setBounds(600, 100, 200, 45);
		NewCase.setContentAreaFilled(false);
		NewCase.setBorder(null);
		

		bgPanel.add(SearchByID).setBounds(600, 200, 200, 45);
		SearchByID.setContentAreaFilled(false);
		SearchByID.setBorder(null);
		

		bgPanel.add(SearchByName).setBounds(600, 300, 200, 45);
		SearchByName.setContentAreaFilled(false);
		SearchByName.setBorder(null);
		

		bgPanel.add(back).setBounds(600, 500, 200, 45);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		

		bgPanel.add(modify).setBounds(600, 400, 200, 45);
		modify.setContentAreaFilled(false);
		modify.setBorder(null);
		
		add(bgPanel);
		bgPanel.add(bgImage).setBounds(0, 0, 1366, 768);

		NewCaseListener cl = new NewCaseListener();
		idSListener el = new idSListener();
		nSListener pl = new nSListener();
		bListener bl = new bListener();
		modifyListener mL = new modifyListener();

		NewCase.addActionListener(cl);
		SearchByID.addActionListener(el);
		SearchByName.addActionListener(pl);
		modify.addActionListener(mL);
		back.addActionListener(bl);
	}

	private class NewCaseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			CaseFrame c = null;
			if (arg0.getSource() == NewCase)
				c = new CaseFrame();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class idSListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			SearchCaseByID c1 = null;
			if (arg0.getSource() == SearchByID)
				c1 = new SearchCaseByID();
			dispose();
			c1.setExtendedState(c1.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}

	}

	private class nSListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			SearchCaseByName c2 = null;
			if (arg0.getSource() == SearchByName)
				c2 = new SearchCaseByName();

			setVisible(false);
			c2.setExtendedState(c2.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}
	}

	private class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainFrame c = null;

			if (arg0.getSource() == back)
				;
			{
				c = new MainFrame();
				setVisible(false);
				c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		}
	}

	private class modifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ModifyCase c = null;

			if (arg0.getSource() == modify)
				c = new ModifyCase();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}
}
