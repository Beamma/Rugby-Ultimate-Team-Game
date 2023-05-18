package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.GameEnviroment;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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

public class AthleteScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel lblNewLabel;
	private Athlete athlete;
	private JLabel lblNewLabel_1;

	
	public AthleteScreen(GameEnviroment enviroment, Athlete athlete){
		this.enviroment = enviroment;
		this.athlete = athlete;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeAthleteScreen(this);
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

		lblNewLabel = new JLabel("athlete");
		lblNewLabel.setBounds(244, -11, 42, 46);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel(athlete.name);
		lblNewLabel_1.setBounds(240, 117, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		DefaultListModel<Integer> athleteListModel = new DefaultListModel<Integer>();
		athleteListModel.add(0, athlete.stats.get("Pace"));
		athleteListModel.add(1, athlete.stats.get("Passing"));
		athleteListModel.add(2, athlete.stats.get("Defence"));
		athleteListModel.add(3, athlete.stats.get("Tacking"));
		athleteListModel.add(4, athlete.stats.get("Ofense"));
		athleteListModel.add(5, athlete.stats.get("Fitness"));
		
		JList<Integer> athleteStats = new JList<Integer>();
		athleteStats.setBounds(170, 142, 227, 184);
		frame.getContentPane().add(athleteStats);
		athleteStats.setModel(athleteListModel);
		
		JButton btnNewButton_1 = new JButton("train attribute");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int previousStat = athleteStats.getSelectedValue();
				int increaseStat = athleteStats.getSelectedIndex();
				athlete.train(athlete.attributes[increaseStat]);
				JOptionPane.showMessageDialog(frame, athlete.attributes[increaseStat] + " increased from " + previousStat + " to " + athlete.stats.get(athlete.attributes[increaseStat]));
				goHome();
			}
		});
		btnNewButton_1.setBounds(242, 350, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		

	}
}