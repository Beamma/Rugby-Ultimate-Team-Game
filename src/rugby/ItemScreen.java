package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.GameEnviroment;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;

public class ItemScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel itemTitle;
	private Item item;
	private JLabel lblNewLabel_1;
	private JLabel paceLabel;
	private JLabel passingLabel;
	private JLabel defenceLabel;
	private JLabel tacklingLbel;
	private JLabel offenseLabel;
	private JLabel fitnessLabel;
	private JLabel paceAmount;
	private JLabel passingAmount;
	private JLabel defenceAmount;
	private JLabel tacklingAmount;
	private JLabel offenseAmount;
	private JLabel fitnessAmount;
	private JButton useItemButton;
	private JList list;
	

	
	public ItemScreen(GameEnviroment enviroment, Item item){
		this.enviroment = enviroment;
		this.item = item;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeItemScreen(this);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(231, 412, 90, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		itemTitle = new JLabel("item", SwingConstants.CENTER);
		itemTitle.setBounds(231, 14, 90, 46);
		frame.getContentPane().add(itemTitle);
		
		paceLabel = new JLabel(item.attributes[0]);
		paceLabel.setBounds(46, 71, 46, 14);
		frame.getContentPane().add(paceLabel);
		
		passingLabel = new JLabel(item.attributes[1]);
		passingLabel.setBounds(132, 71, 46, 14);
		frame.getContentPane().add(passingLabel);
		
		defenceLabel = new JLabel(item.attributes[2]);
		defenceLabel.setBounds(220, 71, 46, 14);
		frame.getContentPane().add(defenceLabel);
		
		tacklingLbel = new JLabel(item.attributes[3]);
		tacklingLbel.setBounds(288, 71, 46, 14);
		frame.getContentPane().add(tacklingLbel);
		
		offenseLabel = new JLabel(item.attributes[4]);
		offenseLabel.setBounds(372, 71, 46, 14);
		frame.getContentPane().add(offenseLabel);
	
		fitnessLabel = new JLabel(item.attributes[5]);
		fitnessLabel.setBounds(470, 71, 46, 14);
		frame.getContentPane().add(fitnessLabel);
		
		paceAmount = new JLabel(String.valueOf(item.stats.get(item.attributes[0])));
		paceAmount.setBounds(46, 96, 46, 14);
		frame.getContentPane().add(paceAmount);
		
		passingAmount = new JLabel(String.valueOf(item.stats.get(item.attributes[1])));
		passingAmount.setBounds(132, 96, 46, 14);
		frame.getContentPane().add(passingAmount);
		
		defenceAmount = new JLabel(String.valueOf(item.stats.get(item.attributes[2])));
		defenceAmount.setBounds(220, 96, 46, 14);
		frame.getContentPane().add(defenceAmount);
		
		tacklingAmount = new JLabel(String.valueOf(item.stats.get(item.attributes[3])));
		tacklingAmount.setBounds(288, 96, 46, 14);
		frame.getContentPane().add(tacklingAmount);
		
		offenseAmount = new JLabel(String.valueOf(item.stats.get(item.attributes[4])));
		offenseAmount.setBounds(372, 96, 46, 14);
		frame.getContentPane().add(offenseAmount);
		
		fitnessAmount = new JLabel(String.valueOf(item.stats.get(item.attributes[5])));
		fitnessAmount.setBounds(470, 96, 46, 14);
		frame.getContentPane().add(fitnessAmount);

	
		DefaultListModel<Athlete> reserveModelList = new DefaultListModel<Athlete>();
		reserveModelList.addAll(enviroment.club.players);
		reserveModelList.addAll(enviroment.getTeam());
		
		JList<Athlete> reserveList = new JList<Athlete>();
		reserveList.setBounds(164, 132, 233, 204);
		reserveList.setModel(reserveModelList);
	
		
		frame.getContentPane().add(reserveList);
		
		useItemButton = new JButton("Use item on selected player");
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete itemUser = reserveList.getSelectedValue();			
				item.useItem(itemUser, item);
				itemUser.updateRating();
				JOptionPane.showMessageDialog(frame,"used item");
				enviroment.club.removeItem(item);
				goHome();
			}
		});
		
		useItemButton.setBounds(164, 358, 233, 23);
		frame.getContentPane().add(useItemButton);
		


		
	}
}