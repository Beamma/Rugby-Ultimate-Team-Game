package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import rugby.Athlete;
import rugby.GameEnviroment;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AthleteScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JLabel defenseLabel;
	private JLabel fitnessLabel;
	private JLabel paceLabel;
	private JLabel tacklingLabel;
	private JLabel offenseLabel;
	private JLabel passingLabel;
	private JLabel athleteName;
	private Athlete athlete;
	private JTextField newNickName;

	
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
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(237, 427, 99, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		athleteName = new JLabel(athlete.getName(), SwingConstants.CENTER);
		athleteName.setBounds(237, 24, 109, 46);
		frame.getContentPane().add(athleteName);

		DefaultListModel<Integer> athleteListModel = new DefaultListModel<Integer>();
		athleteListModel.add(0, athlete.stats.get("Pace"));
		athleteListModel.add(1, athlete.stats.get("Passing"));
		athleteListModel.add(2, athlete.stats.get("Defence"));
		athleteListModel.add(3, athlete.stats.get("Tacking"));
		athleteListModel.add(4, athlete.stats.get("Ofense"));
		athleteListModel.add(5, athlete.stats.get("Fitness"));

		
		passingLabel = new JLabel(athlete.attributes[1] +  ": " + athlete.stats.get(athlete.attributes[1]));
		passingLabel.setBounds(312, 173, 117, 23);
		frame.getContentPane().add(passingLabel);
		
		offenseLabel = new JLabel(athlete.attributes[4] +  ": " + athlete.stats.get(athlete.attributes[4]));
		offenseLabel.setBounds(135, 222, 117, 23);
		frame.getContentPane().add(offenseLabel);

		
		tacklingLabel = new JLabel(athlete.attributes[3] +  ": " + athlete.stats.get(athlete.attributes[3]));
		tacklingLabel.setBounds(312, 222, 117, 23);
		frame.getContentPane().add(tacklingLabel);

		paceLabel = new JLabel(athlete.attributes[0] +  ": " + athlete.stats.get(athlete.attributes[0]));
		paceLabel.setBounds(135, 266, 117, 23);
		frame.getContentPane().add(paceLabel);

		fitnessLabel = new JLabel(athlete.attributes[5] +  ": " + athlete.stats.get(athlete.attributes[5]));
		fitnessLabel.setBounds(312, 266, 117, 23);
		frame.getContentPane().add(fitnessLabel);

		defenseLabel = new JLabel(athlete.attributes[2]+  ": " + athlete.stats.get(athlete.attributes[3]));
		defenseLabel.setBounds(135, 173, 117, 23);
		frame.getContentPane().add(defenseLabel);

		JLabel sellPriceAmount = new JLabel(String.valueOf(athlete.getSellPrice()), SwingConstants.CENTER);
		sellPriceAmount.setBounds(70, 102, 67, 14);
		frame.getContentPane().add(sellPriceAmount);
		
		JLabel sellPriceLabel = new JLabel("Sell Price", SwingConstants.CENTER);
		sellPriceLabel.setBounds(70, 77, 67, 14);
		frame.getContentPane().add(sellPriceLabel);
		
		JLabel injuredLabel = new JLabel("Injured", SwingConstants.CENTER);
		injuredLabel.setBounds(192, 77, 59, 14);
		frame.getContentPane().add(injuredLabel);
		
		JLabel injuredBool = new JLabel(String.valueOf(athlete.getInjury()), SwingConstants.CENTER);
		injuredBool.setBounds(192, 102, 59, 14);
		frame.getContentPane().add(injuredBool);
		
		JLabel wageLabel = new JLabel("Wage", SwingConstants.CENTER);
		wageLabel.setBounds(323, 77, 67, 14);
		frame.getContentPane().add(wageLabel);
		
		JLabel wageAmount = new JLabel("$" + String.valueOf(athlete.getWage()), SwingConstants.CENTER);
		wageAmount.setBounds(323, 102, 67, 14);
		frame.getContentPane().add(wageAmount);
		
		JLabel positionLabel = new JLabel("Position");
		positionLabel.setBounds(468, 77, 59, 14);
		frame.getContentPane().add(positionLabel);
		
		JLabel positionEffect = new JLabel(String.valueOf(athlete.getPosition()), SwingConstants.CENTER);
		positionEffect.setBounds(468, 102, 59, 14);
		frame.getContentPane().add(positionEffect);
		
		newNickName = new JTextField();
		newNickName.setBounds(153, 346, 117, 36);
		frame.getContentPane().add(newNickName);
		newNickName.setColumns(10);
		
		JButton changeNickName = new JButton("Change Nickname");
		changeNickName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newNickName.getText().length() < 15 ) {
					athlete.changeNickName(newNickName.getText());
					JOptionPane.showMessageDialog(frame, "Nickname Succesfully changed to: " + newNickName.getText());
				}else {
					JOptionPane.showMessageDialog(frame, "Too long of a name");
				}
			}
		});
		
		changeNickName.setBounds(297, 353, 149, 23);
		frame.getContentPane().add(changeNickName);
		
		JButton sellAthlete = new JButton("Sell");
		sellAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.addMoney(athlete.getSellPrice());
				enviroment.club.removePlayer(athlete);
				JOptionPane.showMessageDialog(frame, athlete.getName() + " sold for " + String.valueOf(athlete.getSellPrice()));
				goHome();
				
			}
		});
		sellAthlete.setBounds(237, 393, 99, 23);
		frame.getContentPane().add(sellAthlete);
		

	}
}