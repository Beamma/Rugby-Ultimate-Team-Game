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
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

public class SetupScreen {
	

	private JFrame frmSetup;
	private GameEnviroment enviroment;
	private JTextField teamName;
	private final ButtonGroup difficulty = new ButtonGroup();
	private JSlider seasonLength;

	
	public SetupScreen(GameEnviroment enviroment){
		this.enviroment = enviroment;
		initialize();
		frmSetup.setVisible(true);
	}
	
	public void closeWindow() {
		frmSetup.dispose();
	}
	
	public void finishedWindow() {
		enviroment.closeSetupScreen(this);
	}
	

	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setTitle("Setup");
		frmSetup.setBounds(500, 300, 600, 500);
		frmSetup.getContentPane().setLayout(null);
		
		
		JButton setupSubmit = new JButton("Submit");
		setupSubmit.setBackground(new Color(144, 238, 144));
		setupSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.setName(teamName.getText());
				enviroment.setdifficulty(difficulty.getSelection().getActionCommand());
				enviroment.setSeasonLength(seasonLength.getValue());
				finishedWindow();
			}
		});
		setupSubmit.setBounds(347, 374, 127, 46);
		frmSetup.getContentPane().add(setupSubmit);
		
		teamName = new JTextField();
		teamName.setToolTipText("Team Name");
		teamName.setBounds(217, 43, 147, 54);
		frmSetup.getContentPane().add(teamName);
		teamName.setColumns(10);
		
		JRadioButton difficultyEasy = new JRadioButton("Easy");
		difficulty.add(difficultyEasy);
		difficultyEasy.setBounds(168, 132, 109, 23);
		frmSetup.getContentPane().add(difficultyEasy);
		difficultyEasy.setActionCommand("1");
		
		JRadioButton difficultyMedium = new JRadioButton("Medium");
		difficulty.add(difficultyMedium);
		difficultyMedium.setBounds(168, 158, 109, 23);
		frmSetup.getContentPane().add(difficultyMedium);
		difficultyMedium.setActionCommand("2");
		
		JRadioButton difficultyHard = new JRadioButton("Hard");
		difficulty.add(difficultyHard);
		difficultyHard.setBounds(168, 186, 109, 23);
		frmSetup.getContentPane().add(difficultyHard);
		difficultyHard.setActionCommand("3");
		
		seasonLength = new JSlider();
		seasonLength.setMajorTickSpacing(2);
		seasonLength.setForeground(new Color(0, 0, 0));
		seasonLength.setMinorTickSpacing(1);
		seasonLength.setValue(5);
		seasonLength.setPaintLabels(true);
		seasonLength.setSnapToTicks(true);
		seasonLength.setMinimum(5);
		seasonLength.setMaximum(15);
		seasonLength.setBounds(155, 216, 147, 40);
		frmSetup.getContentPane().add(seasonLength);
		
//		random = new JTextField();
//		random.setBounds(147, 279, 86, 20);
//		frame.getContentPane().add(random);
//		random.setColumns(10);
//		
	}
}
