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
		
		
		JButton goHomeButton = new JButton("home");
		goHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		
		goHomeButton.setBounds(238, 386, 89, 23);
		frame.getContentPane().add(goHomeButton);
		
		
		lblNewLabel = new JLabel("next three matches");
		lblNewLabel.setBounds(238, 31, 123, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton team1 = new JButton(enviroment.oposition.get(0).teamName + " rated: " + enviroment.getTeamRating(enviroment.oposition.get(0)) + " overall.");
		team1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goGame(enviroment.oposition.get(0));
			}
		});
		
		team1.setBounds(194, 142, 186, 23);
		frame.getContentPane().add(team1);
		
		JButton team2 = new JButton(enviroment.oposition.get(1).teamName + " rated: " + enviroment.getTeamRating(enviroment.oposition.get(1)));
		team2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goGame(enviroment.oposition.get(1));
			}
		});
		
		team2.setBounds(194, 214, 186, 23);
		frame.getContentPane().add(team2);
		
		JButton team3 = new JButton(enviroment.oposition.get(2).teamName + " rated: " + enviroment.getTeamRating(enviroment.oposition.get(2)));
		team3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goGame(enviroment.oposition.get(2));
			}
		});
		team3.setBounds(194, 285, 186, 23);
		frame.getContentPane().add(team3);
		
		JLabel teamOneLabel = new JLabel("Team one:");
		teamOneLabel.setBounds(256, 95, 71, 14);
		frame.getContentPane().add(teamOneLabel);
		
		JLabel teamTwoLabel = new JLabel("Team two:");
		teamTwoLabel.setBounds(256, 189, 65, 14);
		frame.getContentPane().add(teamTwoLabel);
		
		JLabel teamThreeLabel = new JLabel("Team three:");
		teamThreeLabel.setBounds(256, 260, 71, 14);
		frame.getContentPane().add(teamThreeLabel);

	}
}
