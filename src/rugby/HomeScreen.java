package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

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
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("got to inventory");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goInventory();
			}
		});
		btnNewButton_1.setBounds(397, 72, 122, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("home", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(193, 11, 150, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("go to market");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMarket();
			}
		});
		btnNewButton_2.setBounds(30, 72, 112, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton(enviroment.teamName);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMatch();
			}
		});
		btnNewButton_3.setBounds(53, 369, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(enviroment.money));
		lblNewLabel_1.setBounds(506, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
