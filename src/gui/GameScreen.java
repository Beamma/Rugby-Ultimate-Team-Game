package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.Athlete;
import rugby.GameEnviroment;
import rugby.RandomEvent;
import rugby.Team;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class GameScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel lblNewLabel;
	private Team opposition;

	
	public GameScreen(GameEnviroment enviroment ,Team opposition){
		this.enviroment = enviroment;
		this.opposition = opposition;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeGameScreen(this);
	}
	
	public void goTeam() {
		enviroment.closeGameScreen(this, 1);
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBackground(new Color(192, 192, 192));
		homeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		homeButton.setBounds(30, 12, 81, 29);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		lblNewLabel = new JLabel("Versus");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(204, 64, 175, 46);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton playMatchButton = new JButton("Play!");
		playMatchButton.setBackground(new Color(192, 192, 192));
		playMatchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		playMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.club.team.checkReady() == true) {
				int gameResult = enviroment.getMatchResult(enviroment.club.team, opposition, enviroment.club);
				int randomDecider = RandomEvent.randomEvents(enviroment.randomness, enviroment.club);
				if (randomDecider < 2) {
					if (randomDecider == 2) {
						JOptionPane.showMessageDialog(frame, "player gone");
					}else if (randomDecider == 1) {
						JOptionPane.showMessageDialog(frame, "new player");
					}else {
						JOptionPane.showMessageDialog(frame, "player got injured");
					}
				}
				enviroment.club.team.reduceStamina();
				if (gameResult > 0) {
					enviroment.updateWeek();
					enviroment.addMoney(10000 * (4-enviroment.difficulty));
					enviroment.winloss[0] += 1;
					JOptionPane.showMessageDialog(frame, "Won by " + gameResult);
					goTeam();
				}else if (gameResult < 0) {
					enviroment.updateWeek();
					enviroment.addMoney(2500 * (4-enviroment.difficulty));
					enviroment.winloss[2] += 1;
					JOptionPane.showMessageDialog(frame, "Lost by " + gameResult);
					goTeam();
				}else if (gameResult == 0){
					enviroment.updateWeek();
					enviroment.addMoney(5000* (4-enviroment.difficulty));
					enviroment.winloss[1] += 1;
					JOptionPane.showMessageDialog(frame, "Drew");
					goTeam();
					
				}else {
					JOptionPane.showMessageDialog(frame, "cannot play because of lack of player stamina");
				}
				}else {
					JOptionPane.showMessageDialog(frame, "cannot play because of lack of eligible players");
				}
				//enviroment.getMatchResult(enviroment.club.team, opposition);
			}
		});
		

		playMatchButton.setBounds(250, 240, 89, 23);
		frame.getContentPane().add(playMatchButton);
		
		DefaultListModel<Athlete> MyTeam = new DefaultListModel<Athlete>();
		MyTeam.addAll(enviroment.club.team.getAthletes());
		
		JList<Athlete> list = new JList<Athlete>();
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(30, 104, 175, 312);
		list.setModel(MyTeam);
		frame.getContentPane().add(list);
		
		DefaultListModel<Athlete> opposition = new DefaultListModel<Athlete>();
		opposition.addAll(this.opposition.getAthletes());
		
		JList<Athlete> list2 = new JList<Athlete>();
		list2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list2.setBounds(378, 104, 175, 312);
		list2.setModel(opposition);
		frame.getContentPane().add(list2);
		
		JLabel teamLabel = new JLabel(enviroment.teamName);
		teamLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(30, 71, 175, 29);
		frame.getContentPane().add(teamLabel);
		
		JLabel oppositionLabel = new JLabel(this.opposition.teamName);
		oppositionLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		oppositionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oppositionLabel.setBounds(378, 71, 175, 29);
		frame.getContentPane().add(oppositionLabel);
		
		JLabel titleLabel = new JLabel("Game Day");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(204, 6, 175, 37);
		frame.getContentPane().add(titleLabel);

	}
}