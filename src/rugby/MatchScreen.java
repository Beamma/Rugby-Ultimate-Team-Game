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

public class MatchScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel lblNewLabel;

	
	public MatchScreen(GameEnviroment enviroment){
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		enviroment.closeMatchScreen(this);
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 500, 500, 500);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton.setBounds(168, 161, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		lblNewLabel = new JLabel("Match");
		lblNewLabel.setBounds(107, 390, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
//		random = new JTextField();
//		random.setBounds(147, 279, 86, 20);
//		frame.getContentPane().add(random);
//		random.setColumns(10);
//		
	}
}
