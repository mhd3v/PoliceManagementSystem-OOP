package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{

	private JLabel uNameLabel;
	private JLabel passLabel;
	
	private JTextField uNameText;
	private JPasswordField passText;
	
	private JButton login;
	
	private JPanel fieldPanel;
	private JPanel bPanel;
	
	LoginFrame (){
		
		super("Login");
		setLayout(new BorderLayout());
		setSize(400	,200);
		
		fieldPanel= new JPanel();
		fieldPanel.setLayout(new GridLayout(2,1));
		
		uNameLabel= new JLabel("User Name:");
		uNameLabel.setSize(getPreferredSize());
		fieldPanel.add(uNameLabel);
		
		uNameText= new JTextField();
		fieldPanel.add(uNameText);
		
		passLabel= new JLabel("Password:");
		fieldPanel.add(passLabel);
		
		passText= new JPasswordField();
		fieldPanel.add(passText);
		
		add(fieldPanel, BorderLayout.CENTER);
		
		bPanel = new JPanel();
		bPanel.setLayout(new FlowLayout());
		
		login = new JButton("Login");
		login.setSize(10, 10);
		bPanel.add(login);
		
		add(bPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		validate();
		
		SaveListener sl = new SaveListener();
		login.addActionListener(sl);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			MainFrame m = null;
			
			if(arg0.getSource() == login){
				
				if(passText.getText().equals("admin")&&uNameText.getText().equals("admin"))
				{	m = new MainFrame();
				m.setExtendedState(m.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
				}
				else 
					JOptionPane.showMessageDialog(null, "Invalid username or password" );
			}
			
		}
		
	}
	
	
	}


