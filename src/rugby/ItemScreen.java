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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JButton btnNewButton_1;
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
		
		lblNewLabel_2 = new JLabel(item.attributes[0]);
		lblNewLabel_2.setBounds(46, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(item.attributes[1]);
		lblNewLabel_3.setBounds(132, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel(item.attributes[2]);
		lblNewLabel_4.setBounds(220, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel(item.attributes[3]);
		lblNewLabel_5.setBounds(288, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel(item.attributes[4]);
		lblNewLabel_6.setBounds(372, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
	
		lblNewLabel_7 = new JLabel(item.attributes[5]);
		lblNewLabel_7.setBounds(470, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel(String.valueOf(item.stats.get(item.attributes[0])));
		lblNewLabel_8.setBounds(46, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel(String.valueOf(item.stats.get(item.attributes[1])));
		lblNewLabel_9.setBounds(132, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel(String.valueOf(item.stats.get(item.attributes[2])));
		lblNewLabel_10.setBounds(220, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel(String.valueOf(item.stats.get(item.attributes[3])));
		lblNewLabel_11.setBounds(288, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel(String.valueOf(item.stats.get(item.attributes[4])));
		lblNewLabel_12.setBounds(372, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel(String.valueOf(item.stats.get(item.attributes[5])));
		lblNewLabel_13.setBounds(470, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_13);

	
		DefaultListModel<Athlete> reserveModelList = new DefaultListModel<Athlete>();
		reserveModelList.addAll(enviroment.club.players);
		reserveModelList.addAll(enviroment.getTeam());
		
		JList<Athlete> reserveList = new JList<Athlete>();
		reserveList.setBounds(164, 132, 233, 204);
		reserveList.setModel(reserveModelList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(reserveList);
		
		frame.getContentPane().add(scrollPane);
		
		btnNewButton_1 = new JButton("Use item on selected player");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete itemUser = reserveList.getSelectedValue();			
				item.useItem(itemUser, item);
				JOptionPane.showMessageDialog(frame,"used item");
				enviroment.club.removeItem(item);
				goHome();
			}
		});
		
		btnNewButton_1.setBounds(164, 358, 233, 23);
		frame.getContentPane().add(btnNewButton_1);
		


		
	}
}