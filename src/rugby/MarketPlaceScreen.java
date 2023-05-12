package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MarketPlaceScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public MarketPlaceScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		enviroment.closeMarketPlaceScreen(this);
	}
	public void goTeam() {
		enviroment.closeHomeScreen(this, 4);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 500, 500, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("got home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton_1.setBounds(157, 186, 139, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("market");
		lblNewLabel.setBounds(203, 62, 46, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
