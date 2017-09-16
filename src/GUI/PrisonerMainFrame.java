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

public class PrisonerMainFrame extends JFrame {

	private JButton NewPrisoner;
	private JButton SearchByName;
	private JButton deletePrisoner;
	private JButton modify;
	private JButton back;

	private JPanel bgPanel;
	private JLabel bgImage;

	PrisonerMainFrame() {

		super("Prisoner");
		Icon icon1 = new ImageIcon(getClass().getResource("sbn.png"));
		Icon icon2 = new ImageIcon(getClass().getResource("addP.png"));
		Icon icon3 = new ImageIcon(getClass().getResource("dP.png"));
		Icon icon4 = new ImageIcon(getClass().getResource("modify.png"));
		Icon icon5 = new ImageIcon(getClass().getResource("back.png"));

		NewPrisoner = new JButton(icon2);
		SearchByName = new JButton(icon1);
		deletePrisoner = new JButton(icon3);
		modify = new JButton(icon4);
		back = new JButton(icon5);

		bgPanel = new JPanel();
		bgPanel.setLayout(null);
		bgPanel.setBounds(0, 0, 1366, 768);

		bgImage = new JLabel();
		bgImage.setBounds(0, 0, 1366, 768);
		bgImage.setIcon(new ImageIcon(getClass().getResource("EF.jpg")));

		setLayout(null);
		setVisible(true);
		setSize(1366, 768);

		bgPanel.add(NewPrisoner).setBounds(600, 100, 200, 50);
		NewPrisoner.setContentAreaFilled(false);
		NewPrisoner.setBorder(null);

		bgPanel.add(SearchByName).setBounds(600, 200, 200, 50);
		SearchByName.setContentAreaFilled(false);
		SearchByName.setBorder(null);

		bgPanel.add(deletePrisoner).setBounds(600, 300, 200, 50);
		deletePrisoner.setContentAreaFilled(false);
		deletePrisoner.setBorder(null);

		bgPanel.add(back).setBounds(600, 500, 200, 50);
		back.setContentAreaFilled(false);
		back.setBorder(null);

		bgPanel.add(modify).setBounds(600, 400, 200, 50);
		modify.setContentAreaFilled(false);
		modify.setBorder(null);

		NewPListener cl = new NewPListener();
		SListener el = new SListener();
		deleteListener dl = new deleteListener();
		bListener bl = new bListener();
		modifyListener mL = new modifyListener();

		add(bgPanel);
		bgPanel.add(bgImage).setBounds(0, 0, 1366, 768);
		
		
		NewPrisoner.addActionListener(cl);
		SearchByName.addActionListener(el);
		deletePrisoner.addActionListener(dl);
		modify.addActionListener(mL);
		back.addActionListener(bl);
	}

	private class NewPListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AddPrisoner c = null;

			if (arg0.getSource() == NewPrisoner)
				c = new AddPrisoner();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class SListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SearchPrisoner c1 = null;

			if (arg0.getSource() == SearchByName)
				c1 = new SearchPrisoner();
			c1.setExtendedState(c1.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

	private class nSListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SearchCaseByName c2 = null;

			if (arg0.getSource() == SearchByName)
				c2 = new SearchCaseByName();
			c2.setExtendedState(c2.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}
	}

	private class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DeletePrisoner c = null;

			if (arg0.getSource() == deletePrisoner)
				c = new DeletePrisoner();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
				c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

		}
	}

	private class modifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ModifyPrisoner c = null;

			if (arg0.getSource() == modify)
				c = new ModifyPrisoner();
			c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

	}

}
