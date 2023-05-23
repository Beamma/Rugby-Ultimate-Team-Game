package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import rugby.GameEnviroment;

public class EndGameScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public EndGameScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel seasonOverLabel = new JLabel(enviroment.getName() + " seasons over");
		seasonOverLabel.setBounds(230, 99, 104, 51);
		frame.getContentPane().add(seasonOverLabel);
		
		JLabel statsLabel = new JLabel("Your team finished with:", SwingConstants.CENTER);
		statsLabel.setBounds(99, 171, 367, 14);
		frame.getContentPane().add(statsLabel);
		
		JLabel winsLabel = new JLabel(String.valueOf(enviroment.winloss[0]));
		winsLabel.setBounds(99, 236, 46, 14);
		frame.getContentPane().add(winsLabel);
		
		JLabel lossesLabel = new JLabel(String.valueOf(enviroment.winloss[2]));
		lossesLabel.setBounds(276, 236, 73, 14);
		frame.getContentPane().add(lossesLabel);
		
		JLabel drawAmount = new JLabel(String.valueOf(enviroment.winloss[1]));
		drawAmount.setBounds(179, 236, 56, 14);
		frame.getContentPane().add(drawAmount);
		
		JLabel winAmountLabel = new JLabel("wins");
		winAmountLabel.setBounds(88, 211, 46, 14);
		frame.getContentPane().add(winAmountLabel);
		
		JLabel drawAmountLabel = new JLabel("draws");
		drawAmountLabel.setBounds(179, 211, 46, 14);
		frame.getContentPane().add(drawAmountLabel);
		
		JLabel lossAmountLabel = new JLabel("losses");
		lossAmountLabel.setBounds(276, 211, 46, 14);
		frame.getContentPane().add(lossAmountLabel);
		
		JLabel byeAmountLabel = new JLabel("byes");
		byeAmountLabel.setBounds(387, 211, 46, 14);
		frame.getContentPane().add(byeAmountLabel);
		
		JLabel byeLabel = new JLabel(String.valueOf( enviroment.getSeasonLength() - (enviroment.winloss[2] + enviroment.winloss[1] + enviroment.winloss[0])));
		byeLabel.setBounds(387, 236, 46, 14);
		frame.getContentPane().add(byeLabel);
		
		JLabel amountOfGames = new JLabel("out of " + enviroment.getSeasonLength() + " games.", SwingConstants.CENTER);
		amountOfGames.setBounds(193, 286, 183, 14);
		frame.getContentPane().add(amountOfGames);

	}
}
