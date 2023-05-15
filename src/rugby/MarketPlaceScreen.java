package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("got home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		Athlete ed = GameEnviroment.generatePlayer();
		JButton holder = new JButton(String.valueOf(ed.buyPrice));
		holder.setBounds(177, 130, 197, 119);
		frame.getContentPane().add(holder);
		holder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.money >= ed.buyPrice) {
					enviroment.minusMoney(ed.buyPrice);
					enviroment.addPlayerTeam(ed);
				}
				else{
					JOptionPane.showMessageDialog(frame, "no money");
				}
			}
		});
		btnNewButton_1.setBounds(235, 305, 139, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("market");
		lblNewLabel.setBounds(203, 62, 46, 14);
		frame.getContentPane().add(lblNewLabel);

	}
}
