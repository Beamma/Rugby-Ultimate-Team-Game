package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;

import rugby.GameEnviroment;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel lblNewLabel;

	
	public TeamScreen(GameEnviroment enviroment){
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeTeamScreen(this);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 500, 500, 500);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		btnNewButton.setBounds(168, 161, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		random = new JTextField();
		random.setBounds(125, 42, 168, 55);
		frame.getContentPane().add(random);
		random.setColumns(10);
		
		lblNewLabel = new JLabel("team");
		lblNewLabel.setBounds(107, 390, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
//		random = new JTextField();
//		random.setBounds(147, 279, 86, 20);
//		frame.getContentPane().add(random);
//		random.setColumns(10);
//		
	}
}
