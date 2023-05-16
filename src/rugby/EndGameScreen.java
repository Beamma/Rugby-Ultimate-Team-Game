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
		
		JLabel lblNewLabel = new JLabel("season over");
		lblNewLabel.setBounds(239, 99, 104, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your team finished with:");
		lblNewLabel_1.setBounds(212, 171, 155, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(enviroment.winloss[0]));
		lblNewLabel_2.setBounds(158, 236, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel(String.valueOf(enviroment.winloss[2]));
		lblNewLabel_4.setBounds(320, 236, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

	}
}
