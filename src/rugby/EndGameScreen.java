package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

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
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel seasonOverLabel = new JLabel("season over");
		seasonOverLabel.setBounds(239, 99, 104, 51);
		frame.getContentPane().add(seasonOverLabel);
		
		JLabel statsLabel = new JLabel("Your team finished with:");
		statsLabel.setBounds(212, 171, 155, 14);
		frame.getContentPane().add(statsLabel);
		
		JLabel winsLabel = new JLabel(String.valueOf(enviroment.winloss[0]));
		winsLabel.setBounds(158, 236, 46, 14);
		frame.getContentPane().add(winsLabel);
		
		JLabel lossesLabel = new JLabel(String.valueOf(enviroment.winloss[2]));
		lossesLabel.setBounds(320, 236, 46, 14);
		frame.getContentPane().add(lossesLabel);

	}
}
