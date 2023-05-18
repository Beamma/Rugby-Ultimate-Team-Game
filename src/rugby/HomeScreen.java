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
		
		
		JButton goInventoryButton = new JButton("got to inventory");
		goInventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goInventory();
			}
		});
		goInventoryButton.setBounds(312, 265, 122, 147);
		frame.getContentPane().add(goInventoryButton);
		
		JLabel homeLabel = new JLabel(enviroment.teamName + "'s home", SwingConstants.CENTER);
		homeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		homeLabel.setBounds(211, 36, 150, 43);
		frame.getContentPane().add(homeLabel);
		
		JButton goMarketButton = new JButton("Market");
		goMarketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMarket();
			}
		});
		goMarketButton.setBounds(10, 265, 122, 147);
		frame.getContentPane().add(goMarketButton);
		
		JButton goMatchButton = new JButton("Match");
		goMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMatch();
			}
		});
		
		goMatchButton.setBounds(164, 265, 122, 147);
		frame.getContentPane().add(goMatchButton);
		
		JLabel moneyCountLabel = new JLabel(String.valueOf(enviroment.money));
		moneyCountLabel.setBounds(506, 27, 46, 14);
		frame.getContentPane().add(moneyCountLabel);
		
		JButton byeLabel = new JButton("Take a Bye");
		byeLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.updateWeek();
				enviroment.money += 5000;
				enviroment.club.team.maxStamina();
				goInventory();
			}
		});
		
		byeLabel.setBounds(452, 265, 122, 147);
		frame.getContentPane().add(byeLabel);
		
		JLabel weekCountLabel = new JLabel(String.valueOf(enviroment.week));
		weekCountLabel.setBounds(68, 27, 46, 14);
		frame.getContentPane().add(weekCountLabel);
		
		JLabel winsCountLabel = new JLabel(String.valueOf(enviroment.winloss[0]));
		winsCountLabel.setBounds(315, 27, 46, 14);
		frame.getContentPane().add(winsCountLabel);
		
		JLabel lossesCountLabel = new JLabel(String.valueOf(enviroment.winloss[2]));
		lossesCountLabel.setBounds(388, 27, 46, 14);
		frame.getContentPane().add(lossesCountLabel);
		
		JLabel winsLabel = new JLabel("win");
		winsLabel.setBounds(315, 11, 46, 14);
		frame.getContentPane().add(winsLabel);
		
		JLabel lossesLabel = new JLabel("loss");
		lossesLabel.setBounds(388, 11, 46, 14);
		frame.getContentPane().add(lossesLabel);
		
		JLabel weekLabel = new JLabel("week");
		weekLabel.setBounds(68, 11, 46, 14);
		frame.getContentPane().add(weekLabel);
		
		JLabel moneyLabel = new JLabel("money");
		moneyLabel.setBounds(506, 11, 46, 14);
		frame.getContentPane().add(moneyLabel);
	}
}
