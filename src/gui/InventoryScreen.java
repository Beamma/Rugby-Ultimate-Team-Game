package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;


import rugby.Athlete;
import rugby.GameEnviroment;
import rugby.Item;

import javax.swing.SwingConstants;
import java.awt.Font;

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
	
	public void goAthlete(Athlete athlete) {
		enviroment.closeInventoryScreen(this, athlete);
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		
		JButton viewTeam = new JButton("View team:");
		viewTeam.setBounds(231, 404, 132, 23);
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
		athleteTitle.setBounds(10, 67, 258, 14);
		frame.getContentPane().add(athleteTitle);
		
		JList<Athlete> athleteStats = new JList<Athlete>();
		athleteStats.setFont(new Font("Tahoma", Font.BOLD, 10));
		athleteStats.setBounds(10, 80, 270, 292);
		frame.getContentPane().add(athleteStats);
		athleteStats.setModel(athleteListModel);
		
		
		JList<Athlete> athletes = new JList<Athlete>(athleteListModel);
		frame.getContentPane().add(athleteStats);
		
		
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		itemListModel.addAll(enviroment.club.items);
		
		JList<Item> ownedItems = new JList<Item>(itemListModel);
		ownedItems.setFont(new Font("Tahoma", Font.BOLD, 10));
		ownedItems.setBounds(304, 80, 270, 293);
		frame.getContentPane().add(ownedItems);
		
		
		
		JLabel ownedTitle = new JLabel("Owened items", SwingConstants.CENTER);
		ownedTitle.setBounds(316, 67, 258, 14);
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
		useItemButton.setBounds(418, 384, 111, 23);
		frame.getContentPane().add(useItemButton);
		
		JButton sellAthleteButton = new JButton("Sell athlete");
		sellAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = athleteStats.getSelectedValue();
				if (athlete1 != null) {
					enviroment.addMoney(athlete1.getSellPrice());
					enviroment.club.removePlayer(athlete1);
					JOptionPane.showMessageDialog(frame, athlete1.getName() + " sold for " + String.valueOf(athlete1.getSellPrice()));
					refreshWindow();
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from list");
				}
			}
		});
		sellAthleteButton.setBounds(65, 383, 111, 23);
		frame.getContentPane().add(sellAthleteButton);
		
		JButton sellItemButton = new JButton("sell items");
		sellItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item1 = ownedItems.getSelectedValue();
				if (item1 != null) {
					enviroment.addMoney(item1.getSellPrice());
					enviroment.club.removeItem(item1);
					JOptionPane.showMessageDialog(frame, item1.getName() + " sold for " + String.valueOf(item1.getSellPrice()));
					refreshWindow();
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from list");
				}
			}
		});
		sellItemButton.setBounds(393, 418, 156, 23);
		frame.getContentPane().add(sellItemButton);
		
		JButton selectAthlete = new JButton("Select Athlete");
		selectAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete viewAthlete = athleteStats.getSelectedValue();
				if (viewAthlete != null) {
					goAthlete(viewAthlete);
				}else{
					JOptionPane.showMessageDialog(frame,"Please select a athlete from list");
				}
			}
		});
		selectAthlete.setBounds(44, 418, 156, 23);
		frame.getContentPane().add(selectAthlete);
		
		
		athletes.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		athletes.setBackground(new Color(153, 50, 204));
	}
}
