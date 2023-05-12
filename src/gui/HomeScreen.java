package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import rugby.GameEnviroment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeScreen {
	
	private JFrame window;
	private JFrame frame;
	private GameEnviroment envior;

	/**
	 * Launch the application.
	 * @return 
	 */
	public HomeScreen(GameEnviroment enviroment) {
		enviroment = enviroment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		envior.closeMainScreen(this);
	}
	


	private void initialize() {
		window = new JFrame();
		window.setBounds(50, 500, 500, 500);
		window.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(177, 290, 89, 23);
		window.getContentPane().add(btnNewButton);
	}
}
