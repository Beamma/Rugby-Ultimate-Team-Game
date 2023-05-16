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
		btnNewButton_1.setBounds(312, 265, 122, 147);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel(enviroment.teamName + "'s home", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(211, 36, 150, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Market");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMarket();
			}
		});
		btnNewButton_2.setBounds(10, 265, 122, 147);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Match");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMatch();
			}
		});
		
		btnNewButton_3.setBounds(164, 265, 122, 147);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(enviroment.money));
		lblNewLabel_1.setBounds(506, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Take a Bye");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.updateWeek();
				enviroment.club.team.maxStamina();
				goInventory();
			}
		});
		
		btnNewButton.setBounds(452, 265, 122, 147);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(enviroment.week));
		lblNewLabel_2.setBounds(68, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(String.valueOf(enviroment.winloss[0]));
		lblNewLabel_3.setBounds(315, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(enviroment.winloss[2]));
		lblNewLabel_5.setBounds(388, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("win");
		lblNewLabel_6.setBounds(315, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("loss");
		lblNewLabel_4.setBounds(388, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("week");
		lblNewLabel_7.setBounds(68, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("money");
		lblNewLabel_8.setBounds(506, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
	}
}
