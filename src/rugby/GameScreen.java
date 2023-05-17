package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.GameEnviroment;

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

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(262, 413, 59, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		lblNewLabel = new JLabel("Game");
		lblNewLabel.setBounds(244, -11, 42, 46);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton playMatchButton = new JButton("vs");
		playMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.club.team.checkReady() == true) {
				int gameResult = enviroment.getMatchResult(enviroment.club.team, opposition);
				if (gameResult > 0) {
					enviroment.updateWeek();
					enviroment.addMoney(20000);
					enviroment.winloss[0] += 1;
					JOptionPane.showMessageDialog(frame, "Won by " + enviroment.getMatchResult(enviroment.club.team, opposition));
					goHome();
				}else if (gameResult < 0) {
					enviroment.updateWeek();
					enviroment.addMoney(10000);
					enviroment.winloss[2] += 1;
					JOptionPane.showMessageDialog(frame, "Lost by " + enviroment.getMatchResult(enviroment.club.team, opposition));
					goHome();
				}else if (gameResult == 0){
					enviroment.updateWeek();
					enviroment.addMoney(5000);
					enviroment.winloss[1] += 1;
					JOptionPane.showMessageDialog(frame, "Drew");
					goHome();
					
				}else {
					JOptionPane.showMessageDialog(frame, "cannot play because of lack of player stamina");
				}
				}else {
					JOptionPane.showMessageDialog(frame, "cannot play because of lack of eligible players");
				}
				//enviroment.getMatchResult(enviroment.club.team, opposition);
			}
		});
		

		playMatchButton.setBounds(233, 202, 89, 23);
		frame.getContentPane().add(playMatchButton);
		
		DefaultListModel<Athlete> MyTeam = new DefaultListModel<Athlete>();
		MyTeam.addAll(enviroment.club.team.getAthletes());
		
		JList<Athlete> list = new JList<Athlete>();
		list.setBounds(30, 77, 175, 339);
		list.setModel(MyTeam);
		frame.getContentPane().add(list);
		
		DefaultListModel<Athlete> opposition = new DefaultListModel<Athlete>();
		opposition.addAll(this.opposition.getAthletes());
		
		JList<Athlete> list2 = new JList<Athlete>();
		list2.setBounds(368, 77, 175, 339);
		list2.setModel(opposition);
		frame.getContentPane().add(list2);
		
		JLabel teamLabel = new JLabel(enviroment.teamName);
		teamLabel.setBounds(90, 52, 46, 14);
		frame.getContentPane().add(teamLabel);
		
		JLabel oppositionLabel = new JLabel(this.opposition.teamName);
		oppositionLabel.setBounds(443, 52, 46, 14);
		frame.getContentPane().add(oppositionLabel);

	}
}