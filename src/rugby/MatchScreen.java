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
	
	public void goHome() {
		enviroment.closeMatchScreen(this);
	}
	
	public void goGame(Team team) {
		enviroment.closeMatchScreen(this, team);
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		
		btnNewButton.setBounds(238, 386, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		lblNewLabel = new JLabel("next three matches");
		lblNewLabel.setBounds(198, 30, 123, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton team1 = new JButton(enviroment.oposition.get(0).teamName + " " + enviroment.getTeamRating(enviroment.oposition.get(0)));
		team1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goGame(enviroment.oposition.get(0));
			}
		});
		
		team1.setBounds(238, 107, 89, 23);
		frame.getContentPane().add(team1);
		
		JButton team2 = new JButton(enviroment.oposition.get(1).teamName + " " + enviroment.getTeamRating(enviroment.oposition.get(1)));
		team2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goGame(enviroment.oposition.get(1));
			}
		});
		
		team2.setBounds(238, 174, 89, 23);
		frame.getContentPane().add(team2);
		
		JButton team3 = new JButton(enviroment.oposition.get(2).teamName + " " + enviroment.getTeamRating(enviroment.oposition.get(2)));
		team3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goGame(enviroment.oposition.get(2));
			}
		});
		team3.setBounds(238, 253, 89, 23);
		frame.getContentPane().add(team3);
		
//		random = new JTextField();
//		random.setBounds(147, 279, 86, 20);
//		frame.getContentPane().add(random);
//		random.setColumns(10);
//		
	}
}
