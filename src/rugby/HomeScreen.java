package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class HomeScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public HomeScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goSetup() {
		enviroment.closeHomeScreen(this, 1);
	}
	
	public void goInventory() {
		enviroment.closeHomeScreen(this, 2);
	}
	
	public void goMarket() {
		enviroment.closeHomeScreen(this, 3);
	}
	
	public void goMatch() {
		enviroment.closeHomeScreen(this, 5);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 500, 500, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("go to setup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goSetup();
			}
		});
		
		btnNewButton.setBounds(200, 414, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("got to inventory");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goInventory();
			}
		});
		btnNewButton_1.setBounds(335, 60, 122, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("home");
		lblNewLabel.setBounds(215, 228, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("go to market");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMarket();
			}
		});
		btnNewButton_2.setBounds(30, 60, 112, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("match");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMatch();
			}
		});
		btnNewButton_3.setBounds(30, 238, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
