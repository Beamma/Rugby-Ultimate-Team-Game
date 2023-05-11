package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import rugby.GameEnviroment;

public class HomeScreen {
	
	private JFrame window;
	private JFrame frame;
	private GameEnviroment envior;

	/**
	 * Launch the application.
	 * @return 
	 */
	public HomeScreen(GameEnviroment envior) {
		envior = envior;
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
	}
}
