package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import rugby.Athlete;
import rugby.GameEnviroment;
import rugby.RandomEvent;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

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
	
	public void goTrain() {
		enviroment.closeHomeScreen(this, 1);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		
		JButton goInventoryButton = new JButton("Inventory");
		goInventoryButton.setBackground(new Color(192, 192, 192));
		goInventoryButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		goInventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goInventory();
			}
		});
		goInventoryButton.setBounds(303, 341, 122, 71);
		frame.getContentPane().add(goInventoryButton);
		
		JButton goMarketButton = new JButton("Market");
		goMarketButton.setForeground(new Color(0, 0, 0));
		goMarketButton.setBackground(new Color(192, 192, 192));
		goMarketButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		goMarketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMarket();
			}
		});
		goMarketButton.setBounds(10, 341, 122, 71);
		frame.getContentPane().add(goMarketButton);
		
		JButton goMatchButton = new JButton("Match");
		goMatchButton.setBackground(new Color(192, 192, 192));
		goMatchButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		goMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goMatch();
			}
		});
		
		JLabel homeLabel = new JLabel(enviroment.teamName + " Rugby Club", SwingConstants.CENTER);
		homeLabel.setForeground(new Color(255, 255, 255));
		homeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		homeLabel.setBounds(10, 128, 564, 129);
		frame.getContentPane().add(homeLabel);
		
		goMatchButton.setBounds(157, 341, 122, 71);
		frame.getContentPane().add(goMatchButton);
		
		JLabel moneyCountLabel = new JLabel("$" + String.valueOf(enviroment.money));
		moneyCountLabel.setBounds(528, 27, 46, 14);
		frame.getContentPane().add(moneyCountLabel);
		
		JButton byeLabel = new JButton("Take a Bye");
		byeLabel.setBackground(new Color(192, 192, 192));
		byeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		byeLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.club.getPlayerWages() > enviroment.money) {
					JOptionPane.showMessageDialog(frame, "dont have enough money to wages");
				}else {
					enviroment.updateWeek();
					enviroment.club.team.maxStamina();
					if (RandomEvent.playerTrained(enviroment.randomness)) {
						if (enviroment.club.players.size() != 0 ) {
							Athlete randomTrain = RandomEvent.getRandomPlayer(enviroment.club);
							randomTrain.trainAll();
							randomTrain.updateRating();
							JOptionPane.showMessageDialog(frame, "player had been trained");
						}
					}
					JOptionPane.showMessageDialog(frame, "Taken a bye all players now fully rested");
					goTrain();
				}
			}
		});
		
		byeLabel.setBounds(452, 341, 122, 71);
		frame.getContentPane().add(byeLabel);
		
		JLabel weekCountLabel = new JLabel(String.valueOf(enviroment.week + " of " + enviroment.seasonLength));
		weekCountLabel.setBounds(10, 27, 46, 14);
		frame.getContentPane().add(weekCountLabel);
		
		JLabel winsCountLabel = new JLabel(String.valueOf(enviroment.winloss[0]));
		winsCountLabel.setBounds(360, 27, 46, 14);
		frame.getContentPane().add(winsCountLabel);
		
		JLabel lossesCountLabel = new JLabel(String.valueOf(enviroment.winloss[2]));
		lossesCountLabel.setBounds(472, 27, 46, 14);
		frame.getContentPane().add(lossesCountLabel);
		
		JLabel winsLabel = new JLabel("Win");
		winsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		winsLabel.setBounds(360, 11, 46, 14);
		frame.getContentPane().add(winsLabel);
		
		JLabel lossesLabel = new JLabel("Loss");
		lossesLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lossesLabel.setBounds(472, 11, 46, 14);
		frame.getContentPane().add(lossesLabel);
		
		JLabel weekLabel = new JLabel("Week");
		weekLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		weekLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(weekLabel);
		
		JLabel moneyLabel = new JLabel("Money");
		moneyLabel.setForeground(new Color(0, 255, 64));
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		moneyLabel.setBounds(528, 12, 46, 14);
		frame.getContentPane().add(moneyLabel);
		
		JLabel stadiumBackground = new JLabel("");
		stadiumBackground.setForeground(new Color(255, 255, 255));
		stadiumBackground.setIcon(new ImageIcon(HomeScreen.class.getResource("/img/new.jpg")));
		stadiumBackground.setBounds(0, 49, 584, 412);
		frame.getContentPane().add(stadiumBackground);
		
		JLabel drawLabel = new JLabel("Draw");
		drawLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		drawLabel.setBounds(416, 12, 46, 14);
		frame.getContentPane().add(drawLabel);
		
		JLabel drawsCountLabel = new JLabel(String.valueOf(enviroment.winloss[1]));
		drawsCountLabel.setBounds(416, 27, 46, 14);
		frame.getContentPane().add(drawsCountLabel);
	}
}
