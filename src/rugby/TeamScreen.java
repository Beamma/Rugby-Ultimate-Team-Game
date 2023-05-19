package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
		btnNewButton.setBounds(262, 413, 69, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel("active team");
		lblNewLabel.setBounds(93, 11, 77, 46);
		frame.getContentPane().add(lblNewLabel);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(this.enviroment.getTeam());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "wow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(338, 185, 131, -168);

		frame.getContentPane().add(panel);

		
		JList<Athlete> activePlayerList = new JList<Athlete>();
		activePlayerList.setBounds(46, 49, 172, 285);
		frame.getContentPane().add(activePlayerList);
		activePlayerList.setModel(athleteListModel);
		Athlete ed = GameEnviroment.generatePlayer();
		
		JButton btnNewButton_1 = new JButton("select athlete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = activePlayerList.getSelectedValue(); 	
				if (athlete1 != null) {
					goAthlete(activePlayerList.getSelectedValue());
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from active team");
				}
			}
		});
		btnNewButton_1.setBounds(46, 372, 120, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Reserve team");
		lblNewLabel_1.setBounds(421, 27, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		DefaultListModel<Athlete> reserveModelList = new DefaultListModel<Athlete>();
		reserveModelList.addAll(enviroment.club.players);
		
		
		JList<Athlete> reserveList = new JList<Athlete>();
		reserveList.setBounds(386, 49, 148, 285);
		frame.getContentPane().add(reserveList);
		reserveList.setModel(reserveModelList);
		
		JButton btnNewButton_2 = new JButton("select reserve athlete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = reserveList.getSelectedValue(); 	
				if (athlete1 != null) {
					goAthlete(reserveList.getSelectedValue());
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from reserve");
				}
			}
		});
		btnNewButton_2.setBounds(386, 372, 148, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("swap");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = reserveList.getSelectedValue(); 	
				Athlete athlete2 = activePlayerList.getSelectedValue();
				if (athlete1 == null | athlete2 == null) {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from both");
				}else {
					enviroment.club.swapPlayer(athlete2, athlete1);
					JOptionPane.showMessageDialog(frame,"swapped " + athlete2.name + " with " + athlete1.name);
					goHome();
				}
				
			}
		});
		btnNewButton_3.setBounds(242, 198, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

	}
}
