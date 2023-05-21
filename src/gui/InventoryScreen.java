package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import rugby.Athlete;
import rugby.GameEnviroment;
import rugby.Item;

import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

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
	
	public void goItem(Item item) {
		enviroment.closeInventoryScreen(this, item);
	}
	
	public void refreshWindow() {
		enviroment.refreshInventoryScreen(this);
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		JButton viewTeam = new JButton("View team:");
		viewTeam.setBounds(215, 403, 132, 23);
		viewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goTeam();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(viewTeam);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(enviroment.club.players);
		athleteListModel.addAll(enviroment.getTeam());
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(10, 11, 77, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().add(homeButton);
		
		JLabel athleteTitle = new JLabel("Athletes", SwingConstants.CENTER);
		athleteTitle.setBounds(68, 67, 149, 14);
		frame.getContentPane().add(athleteTitle);
		
		JList<Athlete> athleteStats = new JList<Athlete>();
		athleteStats.setBounds(68, 80, 149, 292);
		frame.getContentPane().add(athleteStats);
		athleteStats.setModel(athleteListModel);
		
		
		JList<Athlete> athletes = new JList<Athlete>(athleteListModel);
		frame.getContentPane().add(athleteStats);
		
		
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		itemListModel.addAll(enviroment.club.items);
		
		JList<Item> ownedItems = new JList<Item>(itemListModel);
		ownedItems.setBounds(346, 80, 149, 293);
		frame.getContentPane().add(ownedItems);
		
		
		
		JLabel ownedTitle = new JLabel("Owened items", SwingConstants.CENTER);
		ownedTitle.setBounds(346, 67, 149, 14);
		frame.getContentPane().add(ownedTitle);
		
		JButton useItemButton = new JButton("use item");
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item useItem = ownedItems.getSelectedValue();
				if (useItem != null) {
					goItem(useItem);
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a item from list");
				}
			}
		});
		useItemButton.setBounds(385, 384, 89, 23);
		frame.getContentPane().add(useItemButton);
		
		JButton sellAthleteButton = new JButton("Sell athlete");
		sellAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = athleteStats.getSelectedValue();
				if (athlete1 != null) {
					enviroment.addMoney(athlete1.sellPrice);
					if (enviroment.club.players.contains(athlete1)) {
						enviroment.club.removePlayer(athlete1);
					}else {
						enviroment.club.team.removePlayer(athlete1);
					}
					JOptionPane.showMessageDialog(frame, athlete1.name + " sold for " + String.valueOf(athlete1.sellPrice));
					refreshWindow();
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from list");
				}
			}
		});
		sellAthleteButton.setBounds(68, 403, 89, 23);
		frame.getContentPane().add(sellAthleteButton);
		
		JButton sellItemButton = new JButton("sell items");
		sellItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item1 = ownedItems.getSelectedValue();
				if (item1 != null) {
					enviroment.addMoney(item1.price);
					enviroment.club.removeItem(item1);
					JOptionPane.showMessageDialog(frame, item1.item + " sold for " + String.valueOf(item1.price));
					refreshWindow();
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from list");
				}
			}
		});
		sellItemButton.setBounds(385, 418, 89, 23);
		frame.getContentPane().add(sellItemButton);
		
		
		athletes.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		athletes.setBackground(new Color(153, 50, 204));
	}
}
