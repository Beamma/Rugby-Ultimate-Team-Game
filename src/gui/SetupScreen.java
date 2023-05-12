package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import rugby.GameEnviroment;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		window.setBounds(50, 500, 500, 500);
		window.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(168, 161, 89, 23);
		window.getContentPane().add(btnNewButton);
		
	}
}
