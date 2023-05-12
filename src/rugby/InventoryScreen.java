package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class InventoryScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public InventoryScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeInventoryScreen(this, 1);
	}
	
	public void goTeam() {
		enviroment.closeInventoryScreen(this, 2);
	}
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 500, 500, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("got home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		btnNewButton_1.setBounds(160, 352, 139, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("inv");
		lblNewLabel.setBounds(203, 62, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("go to Team");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goTeam();
			}
		});
		btnNewButton.setBounds(184, 255, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
