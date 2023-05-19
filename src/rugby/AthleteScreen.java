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
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;

public class AthleteScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel lblNewLabel;
	private Athlete athlete;
	private JLabel lblNewLabel_1;
	private final ButtonGroup statsTrain = new ButtonGroup();

	
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
		frame.setResizable(false);
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

		lblNewLabel = new JLabel(athlete.name);
		lblNewLabel.setBounds(250, 24, 169, 46);
		frame.getContentPane().add(lblNewLabel);

		DefaultListModel<Integer> athleteListModel = new DefaultListModel<Integer>();
		athleteListModel.add(0, athlete.stats.get("Pace"));
		athleteListModel.add(1, athlete.stats.get("Passing"));
		athleteListModel.add(2, athlete.stats.get("Defence"));
		athleteListModel.add(3, athlete.stats.get("Tacking"));
		athleteListModel.add(4, athlete.stats.get("Ofense"));
		athleteListModel.add(5, athlete.stats.get("Fitness"));
		
		JButton btnNewButton_1 = new JButton("train attribute");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int statChange = Integer.valueOf(statsTrain.getSelection().getActionCommand());
				int beforeStat = athlete.stats.get(athlete.attributes[statChange]);
				if (beforeStat == 99) {
					JOptionPane.showMessageDialog(frame, "stat max rn");
				}else {
					athlete.train(athlete.attributes[statChange]);
					JOptionPane.showMessageDialog(frame, athlete.attributes[statChange] + " increased from " + beforeStat + " to " + athlete.stats.get(athlete.attributes[statChange]));
					goHome();
				}
			}
		});
		btnNewButton_1.setBounds(229, 345, 117, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JRadioButton passingButton = new JRadioButton(athlete.attributes[2] +  ": " + athlete.stats.get(athlete.attributes[2]));
		passingButton.setBounds(237, 121, 109, 23);
		frame.getContentPane().add(passingButton);
		passingButton.setActionCommand("2");
		statsTrain.add(passingButton);
		
		JRadioButton offenseButton = new JRadioButton(athlete.attributes[5] +  ": " + athlete.stats.get(athlete.attributes[5]));
		offenseButton.setBounds(237, 164, 109, 23);
		frame.getContentPane().add(offenseButton);
		offenseButton.setActionCommand("5");
		statsTrain.add(offenseButton);
		
		JRadioButton tacklingButton = new JRadioButton(athlete.attributes[4] +  ": " + athlete.stats.get(athlete.attributes[4]));
		tacklingButton.setBounds(237, 207, 109, 23);
		frame.getContentPane().add(tacklingButton);
		tacklingButton.setActionCommand("4");
		statsTrain.add(tacklingButton);
		
		JRadioButton fitnessButton = new JRadioButton(athlete.attributes[0] +  ": " + athlete.stats.get(athlete.attributes[0]));
		fitnessButton.setBounds(237, 251, 109, 23);
		frame.getContentPane().add(fitnessButton);
		fitnessButton.setActionCommand("0");
		statsTrain.add(fitnessButton);
		
		JRadioButton paceButton = new JRadioButton(athlete.attributes[1] +  ": " + athlete.stats.get(athlete.attributes[1]));
		paceButton.setBounds(237, 290, 109, 23);
		frame.getContentPane().add(paceButton);
		paceButton.setActionCommand("1");
		statsTrain.add(paceButton);
		
		JRadioButton defenseButton = new JRadioButton(athlete.attributes[3]+  ": " + athlete.stats.get(athlete.attributes[3]));
		defenseButton.setBounds(237, 77, 109, 23);
		frame.getContentPane().add(defenseButton);
		defenseButton.setActionCommand("3");
		statsTrain.add(defenseButton);
		

	}
}