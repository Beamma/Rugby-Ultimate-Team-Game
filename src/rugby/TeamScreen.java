package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import rugby.GameEnviroment;

import javax.swing.JPanel;
import javax.swing.JTextField;
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
	
	public void goAthlete(Athlete athlete) {
		enviroment.closeTeamScreen(this, athlete);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(262, 413, 59, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel("team");
		lblNewLabel.setBounds(244, -11, 42, 46);
		frame.getContentPane().add(lblNewLabel);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(this.enviroment.getTeam());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "wow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(338, 185, 131, -168);

		frame.getContentPane().add(panel);

		
		JList<Athlete> tester = new JList<Athlete>();
		tester.setBounds(46, 28, 493, 318);
		frame.getContentPane().add(tester);
		tester.setModel(athleteListModel);
		Athlete ed = GameEnviroment.generatePlayer();
		
		JButton btnNewButton_1 = new JButton("select athlete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goAthlete(tester.getSelectedValue());
			}
		});
		btnNewButton_1.setBounds(232, 357, 120, 23);
		frame.getContentPane().add(btnNewButton_1);


	}
}
