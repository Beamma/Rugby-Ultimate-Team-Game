package gui;



import javax.swing.JFrame;
import javax.swing.JLabel;


import rugby.Athlete;
import rugby.GameEnviroment;


import javax.swing.SwingConstants;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketAthleteScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;

	private JLabel defenceLabel;
	private JLabel fitnessLabel;
	private JLabel paceLabel;
	private JLabel tacklingLabel;
	private JLabel offenceLabel;
	private JLabel passingLabel;
	private JLabel nameLabel;
	private Athlete athlete;


	
	public MarketAthleteScreen(GameEnviroment enviroment, Athlete athlete){
		this.enviroment = enviroment;
		this.athlete = athlete;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeMarketAthleteScreen(this);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(248, 427, 84, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		nameLabel = new JLabel(athlete.getName(), SwingConstants.CENTER);
		nameLabel.setBounds(237, 24, 109, 46);
		frame.getContentPane().add(nameLabel);

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
		
		offenceLabel = new JLabel(athlete.attributes[4] +  ": " + athlete.stats.get(athlete.attributes[4]));
		offenceLabel.setBounds(135, 222, 117, 23);
		frame.getContentPane().add(offenceLabel);

		
		tacklingLabel = new JLabel(athlete.attributes[3] +  ": " + athlete.stats.get(athlete.attributes[3]));
		tacklingLabel.setBounds(312, 222, 117, 23);
		frame.getContentPane().add(tacklingLabel);

		paceLabel = new JLabel(athlete.attributes[0] +  ": " + athlete.stats.get(athlete.attributes[0]));
		paceLabel.setBounds(135, 266, 117, 23);
		frame.getContentPane().add(paceLabel);

		fitnessLabel = new JLabel(athlete.attributes[5] +  ": " + athlete.stats.get(athlete.attributes[5]));
		fitnessLabel.setBounds(312, 266, 117, 23);
		frame.getContentPane().add(fitnessLabel);

		defenceLabel = new JLabel(athlete.attributes[2]+  ": " + athlete.stats.get(athlete.attributes[3]));
		defenceLabel.setBounds(135, 173, 117, 23);
		frame.getContentPane().add(defenceLabel);

		JLabel sellPrice = new JLabel(String.valueOf(athlete.getSellPrice()), SwingConstants.CENTER);
		sellPrice.setBounds(70, 102, 67, 14);
		frame.getContentPane().add(sellPrice);
		
		JLabel sellPriceLabel = new JLabel("Sell Price", SwingConstants.CENTER);
		sellPriceLabel.setBounds(70, 77, 67, 14);
		frame.getContentPane().add(sellPriceLabel);
		
		JLabel injuryLabel = new JLabel("Injured", SwingConstants.CENTER);
		injuryLabel.setBounds(192, 77, 59, 14);
		frame.getContentPane().add(injuryLabel);
		
		JLabel injuryBool = new JLabel(String.valueOf(athlete.getInjury()), SwingConstants.CENTER);
		injuryBool.setBounds(192, 102, 59, 14);
		frame.getContentPane().add(injuryBool);
		
		JLabel wageLabel = new JLabel("Wage", SwingConstants.CENTER);
		wageLabel.setBounds(323, 77, 67, 14);
		frame.getContentPane().add(wageLabel);
		
		JLabel wageAmount = new JLabel("$" + String.valueOf(athlete.getWage()), SwingConstants.CENTER);
		wageAmount.setBounds(323, 102, 67, 14);
		frame.getContentPane().add(wageAmount);
		
		JLabel positionLabel = new JLabel("Position");
		positionLabel.setBounds(468, 77, 59, 14);
		frame.getContentPane().add(positionLabel);
		
		JLabel positionValue = new JLabel(String.valueOf(athlete.getPosition()), SwingConstants.CENTER);
		positionValue.setBounds(468, 102, 59, 14);
		frame.getContentPane().add(positionValue);
		
	}
}