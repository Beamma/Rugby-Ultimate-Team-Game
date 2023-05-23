package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import rugby.GameEnviroment;
import rugby.Team;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class MatchScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JLabel gameTitle;

	
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
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		
		JButton goHomeButton = new JButton("Home");
		goHomeButton.setBackground(new Color(192, 192, 192));
		goHomeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		goHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		
		goHomeButton.setBounds(10, 11, 99, 30);
		frame.getContentPane().add(goHomeButton);
		
		
		gameTitle = new JLabel("Pick A Match To Play");
		gameTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		gameTitle.setBounds(141, 101, 284, 30);
		frame.getContentPane().add(gameTitle);
		
		JButton team1 = new JButton(enviroment.oposition.get(0).getTeamName() + " rated: " + enviroment.oposition.get(0).teamRating(enviroment.oposition.get(0)));
		team1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		team1.setBackground(new Color(192, 192, 192));
		team1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.club.getPlayerWages() > enviroment.getMoney()) {
					JOptionPane.showMessageDialog(frame, "dont have enough money to pay next weeks wages");
				}else {
					goGame(enviroment.oposition.get(0));
				}
			}
		});
		
		team1.setBounds(141, 158, 284, 61);
		frame.getContentPane().add(team1);
		
		JButton team2 = new JButton(enviroment.oposition.get(1).getTeamName() + " rated: " + enviroment.oposition.get(1).teamRating(enviroment.oposition.get(1)));
		team2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		team2.setBackground(new Color(192, 192, 192));
		team2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.club.getPlayerWages() > enviroment.getMoney()) {
					JOptionPane.showMessageDialog(frame, "dont have enough money to pay next weeks wages");
				}else {
					goGame(enviroment.oposition.get(1));
				}
			}
		});
		
		team2.setBounds(141, 230, 284, 61);
		frame.getContentPane().add(team2);
		
		JButton team3 = new JButton(enviroment.oposition.get(2).getTeamName() + " rated: " + enviroment.oposition.get(2).teamRating(enviroment.oposition.get(2)));
		team3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		team3.setBackground(new Color(192, 192, 192));
		team3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.club.getPlayerWages() > enviroment.getMoney()) {
					JOptionPane.showMessageDialog(frame, "dont have enough money to pay next weeks wages");
				}else {
					goGame(enviroment.oposition.get(2));
				}
			}
		});
		team3.setBounds(141, 302, 284, 61);
		frame.getContentPane().add(team3);

	}
}
