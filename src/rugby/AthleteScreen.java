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
		btnNewButton.setBounds(248, 427, 84, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel(athlete.name, SwingConstants.CENTER);
		lblNewLabel.setBounds(237, 24, 109, 46);
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
		
		btnNewButton_1.setBounds(229, 334, 117, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JRadioButton passingButton = new JRadioButton(athlete.attributes[1] +  ": " + athlete.stats.get(athlete.attributes[1]));
		passingButton.setBounds(312, 173, 117, 23);
		frame.getContentPane().add(passingButton);
		passingButton.setActionCommand("2");
		statsTrain.add(passingButton);
		
		JRadioButton offenseButton = new JRadioButton(athlete.attributes[4] +  ": " + athlete.stats.get(athlete.attributes[4]));
		offenseButton.setBounds(135, 222, 117, 23);
		frame.getContentPane().add(offenseButton);
		offenseButton.setActionCommand("5");
		statsTrain.add(offenseButton);
		
		JRadioButton tacklingButton = new JRadioButton(athlete.attributes[3] +  ": " + athlete.stats.get(athlete.attributes[3]));
		tacklingButton.setBounds(312, 222, 117, 23);
		frame.getContentPane().add(tacklingButton);
		tacklingButton.setActionCommand("4");
		statsTrain.add(tacklingButton);
		
		JRadioButton paceButton = new JRadioButton(athlete.attributes[0] +  ": " + athlete.stats.get(athlete.attributes[0]));
		paceButton.setBounds(135, 266, 117, 23);
		frame.getContentPane().add(paceButton);
		paceButton.setActionCommand("0");
		statsTrain.add(paceButton);
		
		JRadioButton fitnessButton = new JRadioButton(athlete.attributes[5] +  ": " + athlete.stats.get(athlete.attributes[5]));
		fitnessButton.setBounds(312, 266, 117, 23);
		frame.getContentPane().add(fitnessButton);
		fitnessButton.setActionCommand("1");
		statsTrain.add(fitnessButton);
		
		JRadioButton defenseButton = new JRadioButton(athlete.attributes[2]+  ": " + athlete.stats.get(athlete.attributes[3]));
		defenseButton.setBounds(135, 173, 117, 23);
		frame.getContentPane().add(defenseButton);
		defenseButton.setActionCommand("3");
		defenseButton.setSelected(true);
		statsTrain.add(defenseButton);
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(athlete.sellPrice), SwingConstants.CENTER);
		lblNewLabel_2.setBounds(70, 102, 67, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sell Price", SwingConstants.CENTER);
		lblNewLabel_3.setBounds(70, 77, 67, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Injured", SwingConstants.CENTER);
		lblNewLabel_4.setBounds(192, 77, 59, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(athlete.injured), SwingConstants.CENTER);
		lblNewLabel_5.setBounds(192, 102, 59, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Wage", SwingConstants.CENTER);
		lblNewLabel_6.setBounds(323, 77, 67, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("$" + String.valueOf(athlete.wage), SwingConstants.CENTER);
		lblNewLabel_7.setBounds(323, 102, 67, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Position");
		lblNewLabel_8.setBounds(468, 77, 59, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(String.valueOf(athlete.position), SwingConstants.CENTER);
		lblNewLabel_9.setBounds(468, 102, 59, 14);
		frame.getContentPane().add(lblNewLabel_9);
		

	}
}