package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;

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
	
	public void goAthlete(Athlete athlete) {
		enviroment.closeTeamScreen(this, athlete);
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

		btnNewButton_1.setBounds(245, 400, 89, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("MarketPlace");
		lblNewLabel.setBounds(262, 43, 72, 14);
		frame.getContentPane().add(lblNewLabel);
		
		DefaultListModel<Athlete> athleteMarketModel = new DefaultListModel<Athlete>();
		athleteMarketModel.addAll(enviroment.market.playersForSale);
		
		JList<Athlete> listAthleteMarket = new JList<Athlete>();
		listAthleteMarket.setBounds(47, 87, 173, 252);
		frame.getContentPane().add(listAthleteMarket);
		listAthleteMarket.setModel(athleteMarketModel);
		
		JButton btnNewButton = new JButton("buy athlete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athleteBuy = listAthleteMarket.getSelectedValue();
				if (athleteBuy != null) {
					if (athleteBuy.buyPrice > enviroment.money) {
						JOptionPane.showMessageDialog(frame, "no money");
					}else if (enviroment.club.players.size() < 6) {
						if (enviroment.club.team.addPlayer(athleteBuy) == false ){
							JOptionPane.showMessageDialog(frame, "brought");
							enviroment.minusMoney(athleteBuy.buyPrice);
							enviroment.club.addPlayer(athleteBuy);
						}else {
							enviroment.minusMoney(athleteBuy.buyPrice);
							JOptionPane.showMessageDialog(frame, "brought");
						}
					}else {
						JOptionPane.showMessageDialog(frame, "Club full");
					}
				}else {
					JOptionPane.showMessageDialog(frame, "please select a athlete");
				}
			}
		});
		
		btnNewButton.setBounds(47, 359, 173, 23);
		frame.getContentPane().add(btnNewButton);
		
		DefaultListModel<Item> itemMarketModel = new DefaultListModel<Item>();
		itemMarketModel.addAll(enviroment.market.itemsForSale);
		
		JList<Item> list = new JList<Item>();
		list.setBounds(358, 87, 173, 252);
		frame.getContentPane().add(list);
		list.setModel(itemMarketModel);
		
		JButton btnNewButton_2 = new JButton("buy item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item itemBuy = list.getSelectedValue();
				enviroment.club.addItem(itemBuy);
			}
		});
		btnNewButton_2.setBounds(358, 359, 173, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(enviroment.money));
		lblNewLabel_1.setBounds(490, 43, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Inspect athlete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athleteBuy = listAthleteMarket.getSelectedValue();
				if (athleteBuy != null) {
					goAthlete(athleteBuy);
				}else {
					JOptionPane.showMessageDialog(frame, "please select a athlete");
				}
			}
		});
		btnNewButton_3.setBounds(47, 57, 173, 23);
		frame.getContentPane().add(btnNewButton_3);

	}
}
