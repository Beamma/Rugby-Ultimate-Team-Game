package gui;

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

import rugby.Athlete;
import rugby.GameEnviroment;
import rugby.Item;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

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
	
	public void refreshWindow() {
		enviroment.refreshMarketPlaceScreen(this);
	}
	
	public void goAthlete(Athlete athlete) {
		enviroment.closeTeamScreen(this, athlete);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		JButton homeButton = new JButton("go home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		JPanel playersForSalePanel = new JPanel();
		playersForSalePanel.setBounds(10, 68, 300, 321);
		frame.getContentPane().add(playersForSalePanel);
		
		JScrollPane athletesScroll = new JScrollPane();
		athletesScroll.setBounds(328, 358, -90, -268);
		playersForSalePanel.add(athletesScroll);
		
		JList<Object> athletesList = new JList<Object>();
		athletesScroll.setViewportView(athletesList);
		athletesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		athletesList.setModel(new AbstractListModel<Object>() {
			String[] players = enviroment.market.returnPlayerArray();
			public int getSize() {
				return players.length;
			}
			public Object getElementAt(int index) {
				return players[index];
			}
		});
		athletesList.setSelectedIndex(0);
		athletesList.setToolTipText("");
		
		JButton buyAthleteButton = new JButton("Buy Athlete");
		buyAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = enviroment.market.buyAthlete(athletesList.getSelectedIndex());
				if (result == "Bought") {
					JOptionPane.showMessageDialog(frame, "Succesfully Bought");
					refreshWindow();
				} else {
					JOptionPane.showMessageDialog(frame, result);
				}
			}
		});
		playersForSalePanel.add(buyAthleteButton);
		
		homeButton.setBounds(245, 400, 89, 30);
		frame.getContentPane().add(homeButton);
		
		JLabel marketPlaceTitle = new JLabel("MarketPlace");
		marketPlaceTitle.setBounds(262, 43, 72, 14);
		frame.getContentPane().add(marketPlaceTitle);
		
//		DefaultListModel<Athlete> athleteMarketModel = new DefaultListModel<Athlete>();
//		athleteMarketModel.addAll(enviroment.market.playersForSale);
//		
//		JList<Athlete> listAthleteMarket = new JList<Athlete>();
//		listAthleteMarket.setBounds(47, 87, 173, 275);
//		frame.getContentPane().add(listAthleteMarket);
//		listAthleteMarket.setModel(athleteMarketModel);
//		
//		
//		final  JButton buyAthleteButton = new JButton("buy athlete");
//		buyAthleteButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Athlete athleteBuy = listAthleteMarket.getSelectedValue();
//				if (athleteBuy != null) {
//					if (athleteBuy.buyPrice > enviroment.money) {
//						JOptionPane.showMessageDialog(frame, "no money");
//					}else if (enviroment.club.players.size() < 5) {
//						if (enviroment.club.team.addPlayer(athleteBuy) == false ){
//							JOptionPane.showMessageDialog(frame, "brought");
//							enviroment.market.removeMarketPlayer(athleteBuy);
//							enviroment.minusMoney(athleteBuy.buyPrice);
//							enviroment.club.addPlayer(athleteBuy);
//							enviroment.market.removeMarketPlayer(athleteBuy);
//							refreshWindow();
//						}else {
//							enviroment.minusMoney(athleteBuy.buyPrice);
//							enviroment.market.removeMarketPlayer(athleteBuy); 	
//							JOptionPane.showMessageDialog(frame, "brought");
//							refreshWindow();
//							
//						}
//					}else {
//						JOptionPane.showMessageDialog(frame, "Club full");
//					}
//				}else {
//					JOptionPane.showMessageDialog(frame, "please select a athlete");
//				}
//			}
//		});
//		
//		
//		buyAthleteButton.setBounds(47, 373, 173, 23);
//		frame.getContentPane().add(buyAthleteButton);
//		
//		DefaultListModel<Item> itemMarketModel = new DefaultListModel<Item>();
//		itemMarketModel.addAll(enviroment.market.itemsForSale);
//		
//		JList<Item> itemList = new JList<Item>();
//		itemList.setBounds(358, 87, 173, 275);
//		frame.getContentPane().add(itemList);
//		itemList.setModel(itemMarketModel);
//		
//		JButton buyItemButton = new JButton("buy item");
//		buyItemButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Item itemBuy = itemList.getSelectedValue();
//				if (itemBuy != null) {
//					if (enviroment.club.items.size() < 5) {
//						if (enviroment.money >= itemBuy.price) {
//							enviroment.club.addItem(itemBuy);
//							enviroment.market.removeMarketItem(itemBuy);
//							enviroment.money -= itemBuy.price;
//							JOptionPane.showMessageDialog(frame, "brought ");
//							refreshWindow();
//						} else {
//							JOptionPane.showMessageDialog(frame, "Not Enough Money");
//						}
//					}else {
//						JOptionPane.showMessageDialog(frame, "Inventory full");
//					}
//				}else {
//					JOptionPane.showMessageDialog(frame, "Please select item");
//				}
//			}
//		});
//		buyItemButton.setBounds(358, 373, 173, 23);
//		frame.getContentPane().add(buyItemButton);
		
		JLabel moneyLabel = new JLabel(String.valueOf(enviroment.money));
		moneyLabel.setBounds(490, 43, 46, 14);
		frame.getContentPane().add(moneyLabel);
		
//		JButton inspectAthleteButton = new JButton("Inspect athlete");
//		inspectAthleteButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Athlete athleteBuy = listAthleteMarket.getSelectedValue();
//				if (athleteBuy != null) {
//					goAthlete(athleteBuy);
//				}else {
//					JOptionPane.showMessageDialog(frame, "please select a athlete");
//				}
//			}
//		});
//		inspectAthleteButton.setBounds(47, 57, 173, 23);
//		frame.getContentPane().add(inspectAthleteButton);
		
	}
}
