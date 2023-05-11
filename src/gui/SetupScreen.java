package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import rugby.GameEnviroment;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SetupScreen {
	

	private JFrame window;
	private JFrame frmClass;
	private GameEnviroment envior;

	
	public SetupScreen(GameEnviroment envior){
		envior = envior;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		envior.closeSetupScreen(this);
	}

	private void initialize() {
		window = new JFrame();
		
	}
}
